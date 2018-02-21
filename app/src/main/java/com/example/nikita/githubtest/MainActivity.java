package com.example.nikita.githubtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    EditText mPassword;
    EditText mLogin;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLogin = (EditText) findViewById(R.id.editTextLogin);
        mPassword = (EditText) findViewById(R.id.editTextPassword);
        TextView test = (TextView) findViewById(R.id.textView);
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String credits =(mLogin.getText().toString()).concat(":").concat(mPassword.getText().toString());
                login(Base64.encodeToString(credits.getBytes(), Base64.NO_WRAP));
            }
        });
    }

    public void login (String credits){

       Request request = new Request.Builder()
               .url("https://api.github.com/user")
               .addHeader("Authorization", "Basic " + credits.trim())
               .get()
               .build();

       client.newCall(request).enqueue(new Callback() {
           @Override
           public void onFailure(Call call, IOException e) {
               e.printStackTrace();
           }

           @Override
           public void onResponse(Call call, Response response) throws IOException {
               try (ResponseBody responseBody = response.body()) {
                   if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                   Headers responseHeaders = response.headers();
                   for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                       System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                   }

                   System.out.println(responseBody.string());
               }
           }
       });


    }
}
