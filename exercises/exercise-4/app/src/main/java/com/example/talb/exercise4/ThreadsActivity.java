package com.example.talb.exercise4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThreadsActivity extends AppCompatActivity implements UiUpdater {
    private TextView tv;
    private Button cancelBtn;
    private Button startBtn;
    private Button createBtn;
    private CounterThread counterThread;
    private Thread t1;
    private int g;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads);
        tv = findViewById(R.id.textViewAT);
        cancelBtn = findViewById(R.id.cancelBtn);
        startBtn = findViewById(R.id.startBtn);
        createBtn = findViewById(R.id.createBtn);
    }

    public void start(View view) {
        t1.start();
        cancelBtn.setEnabled(true);
        startBtn.setEnabled(false);
    }

    public void cancel(View view) {
        counterThread.cancel();
        resetButtons();
    }

    public void create(View view) {
        counterThread = new CounterThread(this, i);
        t1 = new Thread(counterThread);
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
