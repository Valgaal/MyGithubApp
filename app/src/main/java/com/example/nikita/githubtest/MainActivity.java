package com.example.nikita.githubtest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
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
                String credits =(mLogin.getText().toString()).concat(":").concat(mPassword.getText().toString());
                String loginUrl ="https://api.github.com/user";
                new GetReposUrl(credits, loginUrl).execute();




              /*  String encodedCredits = Base64.encodeToString(credits.getBytes(), Base64.NO_WRAP);
                Request request = new Request.Builder()
                        .url("https://api.github.com/user")
                        .addHeader("Authorization", "Basic " + encodedCredits.trim())
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
                            if (!response.isSuccessful()) {
                                //answer = false;
                                throw new IOException("Unexpected code " + response);
                            }
                            String jsonData = response.body().string();
                            JSONObject jObj = new JSONObject(jsonData);
                            reposURL = jObj.getString("repos_url");


                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                });*/
                //reposURL ="https://api.github.com/users/Valgaal/repos";











                //else {
                //   Toast toast = Toast.makeText(getApplicationContext(),"Ошибка авторизации!", Toast.LENGTH_LONG);
                //   toast.show();
                //}
            }
        });
    }

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
            Intent intent = GridActivity.newIntent(MainActivity.this, credits, repos_url);
            startActivity(intent);

            String login = mLogin.getText().toString().trim();
            String password = mPassword.getText().toString().trim();

            SharedPreferences settings = getSharedPreferences("Credits",MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("Login", login);
            editor.putString("Password", password);
            editor.commit();
        }
    }
}
