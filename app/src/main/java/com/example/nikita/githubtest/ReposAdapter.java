package com.example.nikita.githubtest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder>{
    private static ArrayList mDataSet;
    private Context mContext;

    public ReposAdapter(Context context, ArrayList DataSet){
        mDataSet = DataSet;
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public LinearLayout mLinearLayout;
        public ViewHolder(View v){
            super(v);
            mTextView = (TextView) v.findViewById(R.id.tv);
            mLinearLayout = (LinearLayout) v.findViewById(R.id.ll);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    Intent intent = new Intent(view.getContext(), DescriptionActivity.class);
                    intent.putExtra("name", mDataSet.get(pos).toString());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    @Override
    public ReposAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.mTextView.setText((mDataSet.get(position).toString()));
        holder.mTextView.setBackgroundColor(Color.parseColor("#3F51B5"));
        holder.mTextView.setTextColor(Color.WHITE);
    }

    @Override
    public int getItemCount(){
        return mDataSet.size();
    }
}