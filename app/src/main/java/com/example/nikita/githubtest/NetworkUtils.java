package com.example.nikita.githubtest;


import android.util.Base64;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
// Класс, который общается  с сервером и возвращает результат в виде строки
class NetworkUtils {

    public  static String getResponseString(String url, String credits){
                Response response;
                String encodedCredits = Base64.encodeToString(credits.getBytes(), Base64.NO_WRAP);
                try {
                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder()
                            .url(url)
                            .addHeader("Authorization", "Basic " + encodedCredits.trim())
                            .get()
                            .build();
                    response = client.newCall(request).execute();
                    return response.body().string();
                } catch ( Exception e) {
                    e.printStackTrace();
                }
                return null;
    }

}