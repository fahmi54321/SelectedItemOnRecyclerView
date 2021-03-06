package com.android.a96selecteditemonrecyclerview.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.a96selecteditemonrecyclerview.Common.Common;
import com.android.a96selecteditemonrecyclerview.Interface.ItemClickListener;
import com.android.a96selecteditemonrecyclerview.Model.Item;
import com.android.a96selecteditemonrecyclerview.R;

import java.util.List;

class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView textView;
    public ImageView imageView;

    ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_view);
        imageView = itemView.findViewById(R.id.image_view);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition());
    }
}

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    List<Item> items;
    Context context;

    int row_index = 1; // default no row choose

    public CustomAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.layout_item,parent,false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.textView.setText(items.get(position).getName());
        if (!items.get(position).isChecked()){
            holder.imageView.setImageResource(R.drawable.ic_baseline_clear_24);
        }else{
            holder.imageView.setImageResource(R.drawable.ic_baseline_check_24);
        }

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                row_index = position;
                Common.cuurentItem = items.get(position);
                notifyDataSetChanged();
            }
        });

        if (row_index==position){
            holder.itemView.setBackgroundColor(Color.parseColor("#F8F8FA"));
            holder.textView.setTextColor(Color.parseColor("#c5c5c7"));
        }else{
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.textView.setTextColor(Color.parseColor("#000000"));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
