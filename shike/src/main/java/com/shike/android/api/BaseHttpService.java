package com.shike.android.api;

import com.shike.android.model.repo.Classify;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BaseHttpService {

    @GET("tnfs/api/list")
    Call<Classify> getImageClassify(@Query("id") int id);

}
