package com.example.myapplication;


import android.content.Context;
import android.media.RouteListingPreference;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
{
    Context context;
    List<Item> items;

    public MyAdapter(Context context, List<Item> items)
    {
        this.context=context;
        this.items=items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new MyViewHolder((LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.routeNoView.setText(items.get(position).getRouteNo());
        holder.ecoScoreView.setText(" "+items.get(position).getEcoScore());
        holder.imageView.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
