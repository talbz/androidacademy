package com.example.talb.exercise3;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static com.example.talb.exercise3.Friend.generateFriendList;

public class FriendsBaseAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private final ArrayList<Friend> friends;

    public FriendsBaseAdapter(Context context, ArrayList<Friend> friends) {
        this.friends = generateFriendList();
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
        Friend friend = friends.get(position);
        holder.name.setText(friend.getName());
        holder.funFact.setText(friend.getFunFact());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }
}
