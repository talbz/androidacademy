package com.example.talb.exercise4;

public class CounterThread implements Runnable {
    private UiUpdater ui;
    private int startIndex;
    private boolean isCancelled;

    public CounterThread(UiUpdater ui, int startIndex) {
        this.ui = ui;
        this.startIndex = startIndex;
    }

    private void write(String text) {
        ui.setText(text);
    }

    @Override
    public void run() {
        for (int i = startIndex ; i < 10; i++) {
            int num = i + 1;
            write(String.valueOf(num));
            ui.saveProgress(i);
            if (isCancelled()) {
                return;
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

        ui.resetButtons();
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void cancel() {
        isCancelled = true;
    }
}
