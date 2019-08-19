package com.example.georgesamuel.dubaihotels.paging.remote;

import com.example.georgesamuel.dubaihotels.paging.model.UserDBResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserDataService {
    @GET("users")
    Call<UserDBResponse> getUsersWithPaging(@Query("page") long page);
}
