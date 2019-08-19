package com.example.georgesamuel.dubaihotels.remote;

import com.example.georgesamuel.dubaihotels.model.paging.UserDBResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserDataService {
    @GET("users")
    Call<UserDBResponse> getUsersWithPaging(@Query("page") long page);
}
