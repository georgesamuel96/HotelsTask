package com.example.georgesamuel.dubaihotels.paging.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.georgesamuel.dubaihotels.paging.dataSource.UserDataSourceFactory;
import com.example.georgesamuel.dubaihotels.paging.model.User;
import com.example.georgesamuel.dubaihotels.paging.remote.RetrofitInstance;
import com.example.georgesamuel.dubaihotels.paging.remote.UserDataService;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivityViewModel extends AndroidViewModel {

    private Executor executor;
    private LiveData<PagedList<User>> usersPagedList;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        UserDataService userDataService = RetrofitInstance.getService();
        UserDataSourceFactory factory = new UserDataSourceFactory(userDataService);
        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(2)
                .setPageSize(4)
                .setPrefetchDistance(4)
                .build();
        executor = Executors.newFixedThreadPool(5);
        usersPagedList = (new LivePagedListBuilder<Long, User>(factory, config))
                .setFetchExecutor(executor)
                .build();
    }

    public LiveData<PagedList<User>> getUserPagedList() {
        return usersPagedList;
    }
}
