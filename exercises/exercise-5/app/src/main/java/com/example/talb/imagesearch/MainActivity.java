package com.example.talb.imagesearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.talb.imagesearch.dao.PixabayService;
import com.example.talb.imagesearch.model.Hit;
import com.example.talb.imagesearch.model.ImageSearchResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText searchQueryEditText;
    private TextView statusTextView;
    private List<Hit> hits;
    private Integer total;
    private Integer totalHits;
    private HitAdapter recyclerViewAdapter;
    private PixabayService pixabayService;
    public static final String RETROFIT_KEY = "7143795-63f8097bd68601f11b7e06188";
    public static final String IMAGE_TYPE = "photo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        searchQueryEditText = findViewById(R.id.searchQuery);
        statusTextView = findViewById(R.id.status);
        recyclerView.setLayoutManager(createLinearLayoutManager());
        recyclerViewAdapter = new HitAdapter(this, hits);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://pixabay.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pixabayService = retrofit.create(PixabayService.class);
    }

    private void setRecyclerViewAdapter() {
        recyclerViewAdapter.setHits(hits);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private LinearLayoutManager createLinearLayoutManager() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(VERTICAL);
        return linearLayoutManager;
    }

    public void search(View view) {
        statusTextView.setText("Searching...");
        Call<ImageSearchResult> images = pixabayService.getImages(RETROFIT_KEY, IMAGE_TYPE, searchQueryEditText.getText().toString());

        images.enqueue(new Callback<ImageSearchResult>() {
            @Override
            public void onResponse(Call<ImageSearchResult> call, Response<ImageSearchResult> response) {
                hits = response.body().getHits();
                total = response.body().getTotal();
                totalHits = response.body().getTotalHits();
                statusTextView.setText("Displaying "  + hits.size() + " of " + totalHits + " results");
                setRecyclerViewAdapter();
            }

            @Override
            public void onFailure(Call<ImageSearchResult> call, Throwable t) {
                Log.e("ERROR", t.toString());
            }
        });
    }
}
