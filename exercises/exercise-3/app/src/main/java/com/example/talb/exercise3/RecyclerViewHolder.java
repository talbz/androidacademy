package com.example.talb.exercise3;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public final TextView name, funFact;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.name);
        this.funFact = itemView.findViewById(R.id.funFact);
        this.name.setOnClickListener(v -> {});
    }
}
