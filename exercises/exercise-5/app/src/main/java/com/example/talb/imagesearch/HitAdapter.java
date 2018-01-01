package com.example.talb.imagesearch;


import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.talb.imagesearch.model.Hit;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class HitAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Hit> hitList;

    public HitAdapter(Context context, List<Hit> hitList) {
        this.hitList = hitList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflated = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        RecyclerViewHolder holder = new RecyclerViewHolder(inflated);
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Hit hit = hitList.get(position);
        Context context = holder.image.getContext();
        Picasso.with(context).load(hit.getPreviewURL()).into(holder.image);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return hitList.size();
    }

    public void setHits(List<Hit> hits) {
        this.hitList = hits;
    }
}
