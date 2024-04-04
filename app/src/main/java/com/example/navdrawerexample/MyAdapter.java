package com.example.navdrawerexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;

    List<Item> list;

    public MyAdapter(Context context, List<Item> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_item_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(list.get(position).getImage()).into(holder.Image);
        holder.Title.setText(list.get(position).getTitle());
        holder.Desc.setText(list.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView Image;
        TextView Title, Desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Image = itemView.findViewById(R.id.Ivimage);
            Title = itemView.findViewById(R.id.Tvtitle);
            Desc  = itemView.findViewById(R.id.Tvdescription);
        }
    }



}

