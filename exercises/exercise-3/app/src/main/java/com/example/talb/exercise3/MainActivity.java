package com.example.talb.exercise3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;
import static android.support.v7.widget.LinearLayoutManager.VERTICAL;
import static android.widget.Toast.LENGTH_SHORT;
import static com.example.talb.exercise3.Friend.generateFriendList;
import static com.example.talb.exercise3.R.*;
import static com.example.talb.exercise3.R.id.layoutRadioGroup;
import static com.example.talb.exercise3.R.id.listView;
import static com.example.talb.exercise3.R.id.radio1;
import static com.example.talb.exercise3.R.id.radio2;
import static com.example.talb.exercise3.R.id.radio3;
import static com.example.talb.exercise3.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RadioGroup radioGroup;
    int lastChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        FriendsBaseAdapter adapter = new FriendsBaseAdapter(this, generateFriendList());
        recyclerView = findViewById(listView);
        radioGroup = findViewById(layoutRadioGroup);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            String layout = "";
            switch (checkedId) {
                case radio1:
                    recyclerView.setLayoutManager(createLinearLayoutManager());
                    recyclerView.requestLayout();
                    layout = "Linear";
                    break;

                case radio2:
                    recyclerView.setLayoutManager(createGridLayoutManager());
                    recyclerView.setAdapter(adapter);
                    layout = "Grid";
                    break;

                case radio3:
                    recyclerView.setLayoutManager(createStaggeredGridLayoutManager());
                    recyclerView.setAdapter(adapter);
                    layout = "StaggeredGrid";
                    break;
            }

            Toast toast = Toast.makeText(this, "checked " + layout, LENGTH_SHORT);
            toast.show();
        });

        recyclerView.setLayoutManager(createLinearLayoutManager());
        recyclerView.setAdapter(adapter);
    }

    @NonNull
    private GridLayoutManager createGridLayoutManager() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(VERTICAL);
        return gridLayoutManager;
    }

    @NonNull
    private StaggeredGridLayoutManager createStaggeredGridLayoutManager() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
        staggeredGridLayoutManager.setOrientation(VERTICAL);
        return staggeredGridLayoutManager;
    }

    @NonNull
    private LinearLayoutManager createLinearLayoutManager() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(VERTICAL);
        return linearLayoutManager;
    }

    public void radioGroupOnClick(View view) {
    }
}
