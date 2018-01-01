package com.example.talb.imagesearch.dao;

import com.example.talb.imagesearch.model.ImageSearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayService {
    @GET("api")
    Call<ImageSearchResult> getImages(
            @Query("key") String key,
            @Query("image_type") String imageType,
            @Query("q") String searchQuery);
}
