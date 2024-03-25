package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder
{
    ImageView imageView;
    TextView routeNoView, ecoScoreView;
    public MyViewHolder(@NonNull View itemView)
    {
        super(itemView);
        routeNoView=itemView.findViewById(R.id.routeNo);
        ecoScoreView=itemView.findViewById(R.id.ecoScore);
        imageView=itemView.findViewById(R.id.imageview);
    }
}
