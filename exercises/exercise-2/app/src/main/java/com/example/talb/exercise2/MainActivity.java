package com.example.talb.exercise2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

import java.util.Locale;

import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends AppCompatActivity {

    public static final String TOGGLER = "toggler";
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = findViewById(R.id.toggleLang);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            CharSequence restoredValue = savedInstanceState.getCharSequence(TOGGLER);
            if (restoredValue != null) {
                if (toggleButton != null) {
                    toggleButton.setText(restoredValue);
                } else {
                    Log.i("tag", "didnt find toggler " + restoredValue);
                }
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("tag", "msg");
        saveToggler(outState);
    }

    private void saveToggler(Bundle outState) {
        if (toggleButton != null) {
            outState.putCharSequence(TOGGLER, toggleButton.getText());
        } else {
            Log.i("tag", "didnt find toggler 222");
        }
    }


    public void openLondonsWiki(View view) {
        Intent browserIntent = new Intent(ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/London"));
        startActivity(browserIntent);
    }

    public void changeLang(View view) {
        String lang = toggleButton.getText().toString();
        lang = (lang.equals("EN")) ? "iw" : "en";

        changeLang(view.getContext(), lang);
    }

    public void changeLang(Context context, String lang) {
        Locale myLocale = new Locale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        recreate();
    }
}
