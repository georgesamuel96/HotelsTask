package com.example.georgesamuel.dubaihotels.dataSource;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.georgesamuel.dubaihotels.model.paging.User;
import com.example.georgesamuel.dubaihotels.model.paging.UserDBResponse;
import com.example.georgesamuel.dubaihotels.remote.RetrofitInstance;
import com.example.georgesamuel.dubaihotels.remote.UserDataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static kotlin.text.Typography.amp;

public class UserDataSource extends PageKeyedDataSource<Long, User> {

    private UserDataService userDataService;
    private static final String TAG = UserDataSource.class.getSimpleName();

    public UserDataSource(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Long, User> callback) {
        userDataService = RetrofitInstance.getService();
        Call<UserDBResponse> call = userDataService.getUsersWithPaging(1);
        call.enqueue(new Callback<UserDBResponse>() {
            @Override
            public void onResponse(Call<UserDBResponse> call, Response<UserDBResponse> response) {
                UserDBResponse userDBResponse = response.body();
                ArrayList<User> users = new ArrayList<>();

                if (userDBResponse != null && userDBResponse.getUsers() != null) {
                    users = (ArrayList<User>) userDBResponse.getUsers();
                    Log.d(TAG, "onResponse: " + users.size());
                    callback.onResult(users, null, (long) 2);
                }
            }

            @Override
            public void onFailure(Call<UserDBResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, User> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, User> callback) {
        userDataService = RetrofitInstance.getService();
        Call<UserDBResponse> call = userDataService.getUsersWithPaging(params.key);
        call.enqueue(new Callback<UserDBResponse>() {
            @Override
            public void onResponse(Call<UserDBResponse> call, Response<UserDBResponse> response) {
                UserDBResponse userDBResponse = response.body();
                ArrayList<User> users = new ArrayList<>();
                if (userDBResponse != null && userDBResponse.getUsers() != null) {
                    users = (ArrayList<User>) userDBResponse.getUsers();
                    Log.d(TAG, "onResponse2: " + users.size());
                    callback.onResult(users, params.key + 1);
                }
            }

            @Override
            public void onFailure(Call<UserDBResponse> call, Throwable t) {

            }
        });
    }
}
