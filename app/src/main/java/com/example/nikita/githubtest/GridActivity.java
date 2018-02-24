package com.example.nikita.githubtest;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.widget.RelativeLayout;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {
    private static final String CREDITS = "credits";
    private static final String NETWORK_CLASS = "NetworkUtils";

    private Context mContext;
    RelativeLayout mRelativeLayout;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    String credits;
    String url;

    ArrayList repos = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        Intent i = getIntent();
        credits = i.getStringExtra(CREDITS);
        url = i.getStringExtra(NETWORK_CLASS);

        new GetDataTask().execute();

        mContext = getApplicationContext();

        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mLayoutManager = new GridLayoutManager(mContext, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ReposAdapter(mContext, repos);
        mRecyclerView.setAdapter(mAdapter);


    }

    public static Intent newIntent(Context packageContext, String credits, String url){
        Intent intent = new Intent(packageContext, GridActivity.class);
        intent.putExtra(NETWORK_CLASS,url);
        intent.putExtra(CREDITS, credits);
        return intent;
    }
    //получение имен репозиториев, обновление адаптера. Сохранение информации для следующей активити
    class GetDataTask extends AsyncTask<Void, Void, ArrayList> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected  ArrayList doInBackground(Void... params) {
            try {
            String responseString = NetworkUtils.getResponseString(url,credits);
            JSONArray jsonarray = new JSONArray(responseString);
                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        String name = jsonobject.getString("name");
                        repos.add(name);
                    }
                SharedPreferences settings = getSharedPreferences("Description", MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("JSONForDescriptionActivity", responseString);
                editor.apply();
            } catch (JSONException je) {
                je.printStackTrace();
            }
           return repos;
        }

        @Override
        protected void onPostExecute(ArrayList result) {
            mAdapter.notifyDataSetChanged();
        }
    }
}
