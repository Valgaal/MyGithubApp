package com.example.nikita.githubtest;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


class CommitsAdapter extends RecyclerView.Adapter<CommitsAdapter.ViewHolder> {
    private ArrayList stringForJSON;
    private Context mContext;



    public CommitsAdapter(Context context, ArrayList s) {
        stringForJSON = s;
        mContext = context;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTextView;
        private LinearLayout mLinearLayout;
        private ViewHolder(View v){
            super(v);
            mTextView = (TextView) v.findViewById(R.id.tv2);
            mLinearLayout = (LinearLayout) v.findViewById(R.id.ll2);
        }
    }

    @Override
    public CommitsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_view2,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

                holder.mTextView.setText(stringForJSON.get(position).toString());
                holder.mTextView.setBackgroundColor(Color.WHITE);
                holder.mTextView.setTextColor(Color.GRAY);

    }

    @Override
    public int getItemCount() {
        return stringForJSON.size();
    }
}
