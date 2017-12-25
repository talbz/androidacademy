package com.example.talb.exercise4;

import android.os.AsyncTask;

public class AsyncTaskCounter extends AsyncTask<Integer, Integer, Long> {
    private UiUpdater ui;

    public AsyncTaskCounter(UiUpdater ui) {
        this.ui = ui;
    }

    @Override
    protected Long doInBackground(Integer... s) {
        for (int i = s[0] - 1 ; i < 10; i++) {
            int num = i + 1;
            write(String.valueOf(num));
            publishProgress(num);
            if (isCancelled()) {
                return null;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!isCancelled()) {
            write("Done!");
        }

        return null;
    }

    @Override
    protected void onPostExecute(Long aLong) {
        ui.resetButtons();
    }

    private void write(String text) {
        ui.setText(text);
    }
}
