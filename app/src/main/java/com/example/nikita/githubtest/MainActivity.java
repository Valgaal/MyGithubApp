package com.example.nikita.githubtest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private static String loginUrl = "https://api.github.com/user";
    EditText mPassword;
    EditText mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLogin = (EditText) findViewById(R.id.editTextLogin);
        mPassword = (EditText) findViewById(R.id.editTextPassword);

        SharedPreferences settings = getSharedPreferences("Credits", MODE_PRIVATE);
        String login = settings.getString("Login","");
        String password = settings.getString("Password","");

        mLogin.setText(login);
        mPassword.setText(password);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean connectionInfo = isOnline();
                if(connectionInfo) {
                    String credits = (mLogin.getText().toString()).concat(":").concat(mPassword.getText().toString());
                    new GetReposUrl(credits, loginUrl).execute();
                }
                    else {
                      Toast toast = Toast.makeText(getApplicationContext(),"No Internet Connection!", Toast.LENGTH_LONG);
                      toast.show();
                    }
            }
        });
    }
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
    //получение ссылки на репозитории и логин с помощью логин:пароль. Сохранение правильного логина и пароля
    class GetReposUrl extends AsyncTask<Void, Void, String> {
        private String credits;
        private String url;

            GetReposUrl(String credits, String url) {
                this.credits = credits;
                this.url = url;
            }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected  String doInBackground(Void... voids) {

            try {
            JSONObject jsonObject = new JSONObject(NetworkUtils.getResponseString(url,credits));
            return jsonObject.getString("repos_url");

            } catch (JSONException je) {
                je.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String repos_url) {
            if(repos_url != null) {
                Intent intent = GridActivity.newIntent(MainActivity.this, credits, repos_url);
                startActivity(intent);

                String login = mLogin.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                SharedPreferences settings = getSharedPreferences("Credits", MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("Login", login);
                editor.putString("Password", password);
                editor.commit();
            }
            else {
                Toast toast = Toast.makeText(getApplicationContext(),"Wrong Login or Password!", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}
