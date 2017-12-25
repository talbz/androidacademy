package com.example.talb.lesson1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openActivity(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        TextView muki = findViewById(R.id.muki);
        intent.putExtra("txt", muki.getText().toString());
        startActivity(intent);
    }

    public void openEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","tpobox@gmail.com", null));
        intent.putExtra(Intent.EXTRA_SUBJECT, "sub subs subject");
        TextView muki = findViewById(R.id.muki);
        intent.putExtra(Intent.EXTRA_TEXT, "text1111 " + muki.getText().toString());
        startActivity(intent);
    }
}
