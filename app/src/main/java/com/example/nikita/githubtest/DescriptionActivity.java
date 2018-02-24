package com.example.nikita.githubtest;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class DescriptionActivity extends AppCompatActivity {
    ArrayList a = new ArrayList();
    ArrayList finalStrings = new ArrayList();
    RecyclerView.Adapter mAdapter;
    TextView mDescr;
    TextView mForks;
    TextView mWatchers;
    TextView mLogin;
    ImageView authorAva;
    RelativeLayout mRelativeLayout;
    Context mContext;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        TextView mName = (TextView) findViewById(R.id.nameTextView);
        authorAva = (ImageView) findViewById(R.id.authorAva);
        mLogin = (TextView) findViewById(R.id.loginTextView);
        mDescr = (TextView) findViewById(R.id.descriptionTextView);
        mForks = (TextView) findViewById(R.id.forksTextView);
        mWatchers = (TextView) findViewById(R.id.watchersTextView);
        String mS = getIntent().getStringExtra("name");
        mName.setText(getString(R.string.reposName, mS));


        new GetReposInfoTask().execute(mS);
        new GetCommitsData().execute(mS);

        mContext = getApplicationContext();

        mRelativeLayout = (RelativeLayout) findViewById(R.id.RelLayout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view2);

        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CommitsAdapter(mContext, finalStrings);
        mRecyclerView.setAdapter(mAdapter);
    }

    class GetReposInfoTask extends AsyncTask<String, Void, ArrayList> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ArrayList doInBackground(String... strings) {
            String mS = strings[0];
            try {
                SharedPreferences settings = getSharedPreferences("Description",MODE_PRIVATE);
                String responseString = settings.getString("JSONForDescriptionActivity","");
                JSONArray jsonarray = new JSONArray(responseString);
                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        String name = jsonobject.getString("name");
                        if (name.equals(mS)) {

                            String forks = "Forks: " + jsonobject.getString("forks");
                            String watchers = "Watchers: " + jsonobject.getString("watchers");
                            String description ="Description:\n" + jsonobject.getString("description");
                            a.add(forks);
                            a.add(watchers);
                            a.add(description);
                            JSONObject authorInfo = jsonobject.getJSONObject("owner");
                            String author = authorInfo.getString("login");
                            String authorsAvatar = authorInfo.getString("avatar_url");
                            a.add(author);
                            a.add(authorsAvatar);
                            return a;
                        }
                    }
            } catch (JSONException je) {
                je.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList a) {
            mForks.setText(a.get(0).toString());
            mWatchers.setText(a.get(1).toString());
            mDescr.setText(a.get(2).toString());
            mLogin.setText(getString(R.string.authorName, a.get(3).toString()));
            Picasso.with(DescriptionActivity.this).load(a.get(4).toString()).into(authorAva);
        }
    }

    class GetCommitsData extends AsyncTask<String, Void, ArrayList> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ArrayList doInBackground(String... strings) {
            String mS = strings[0];
            try {

                String url = "https://api.github.com/repos/" + a.get(3).toString() +"/" + mS + "/commits";
                SharedPreferences loginAndPassword = getSharedPreferences("Credits",MODE_PRIVATE);
                String credits = loginAndPassword.getString("Login","") +":" + loginAndPassword.getString("Password","");


                JSONArray mJSON = new JSONArray(NetworkUtils.getResponseString(url,credits));
                //передать Array String готовых,потому что он считает размер реальный.
                for (int i = 0; i < mJSON.length(); i++) {
                    JSONObject jsonobject = mJSON.getJSONObject(i);
                    String sha = "Sha: " + jsonobject.getString("sha") + "\n";
                    JSONObject jsonCommitObject = jsonobject.getJSONObject("commit");
                    String message = "Commit: " + jsonCommitObject.getString("message") + "\n";

                    JSONObject authorInfo = jsonCommitObject.getJSONObject("author");
                    String author = "Author: " + authorInfo.getString("name") + "\n";

                    String date = "Date: " + authorInfo.getString("date");
                    String goodDate = date.replace('Z', ' ');
                    String goodDate2 = goodDate.replace('T', ' ');

                    String finalString = sha + message + author + goodDate2;
                    finalStrings.add(finalString);
                }
                    return finalStrings;
            } catch (JSONException je) {
                je.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList a) {
            mAdapter.notifyDataSetChanged();
        }
    }
}
