package com.example.news;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    // modal array receive the data from fragment
    ArrayList<Modal> modalArrayList;

    public Adapter(Context context, ArrayList<Modal> modalArrayList) {
        this.context = context;
        this.modalArrayList = modalArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //set the data on accroding to item position
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, webView.class);
                //pass the url to open new activity
                intent.putExtra("url", modalArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        holder.tv_time.setText("Published At:-" + modalArrayList.get(position).getPublishedAt());
        holder.tv_author.setText(modalArrayList.get(position).getAuthor());
        holder.tv_heading.setText(modalArrayList.get(position).getTitle());
        holder.tv_content.setText(modalArrayList.get(position).getDescription());
        Glide.with(context).load(modalArrayList.get(position).getUrltoImage()).into(holder.iv_pic);
    }

    @Override
    public int getItemCount() {
        return modalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // itemlayout variables
        TextView tv_heading, tv_content, tv_author, tv_time;
        ImageView iv_pic;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_heading = itemView.findViewById(R.id.tv_heading);
            tv_content = itemView.findViewById(R.id.tv_content);
            tv_author = itemView.findViewById(R.id.tv_author);
            tv_time = itemView.findViewById(R.id.tv_time);
            iv_pic = itemView.findViewById(R.id.iv_pic);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
