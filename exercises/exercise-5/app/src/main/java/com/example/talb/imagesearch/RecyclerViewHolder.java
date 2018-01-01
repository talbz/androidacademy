package com.example.talb.imagesearch;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public final ImageView image;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        this.image = itemView.findViewById(R.id.image);
        //this.name.setOnClickListener(v -> {});
    }
}
