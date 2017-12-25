package com.example.talb.exercise4;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AsyncTaskActivity extends AppCompatActivity implements UiUpdater {

    private TextView tv;
    private AsyncTask asyncTask;
    private Button cancelBtn;
    private Button startBtn;
    private Button createBtn;
    private int g;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        tv = findViewById(R.id.textViewAT);
        cancelBtn = findViewById(R.id.cancelBtn);
        startBtn = findViewById(R.id.startBtn);
        createBtn = findViewById(R.id.createBtn);
    }

    public void start(View view) {
        asyncTask.execute(new Integer[]{i});
        cancelBtn.setEnabled(true);
        startBtn.setEnabled(false);
    }

    public void cancel(View view) {
        asyncTask.cancel(false);
        resetButtons();
    }

    public void create(View view) {
        asyncTask = new AsyncTaskCounter(this);
        createBtn.setEnabled(false);
        startBtn.setEnabled(true);
    }

    @Override
    public void setText(String text) {
        runOnUiThread(() -> tv.setText(text));
    }

    @Override
    public void resetButtons() {
        i = 0;
        runOnUiThread(() -> {
            createBtn.setEnabled(true);
            startBtn.setEnabled(false);
            cancelBtn.setEnabled(false);
        });
    }

    @Override
    public void saveProgress(int i) {
        this.i = i;
    }
}
