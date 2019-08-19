package com.example.georgesamuel.dubaihotels.ui.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.adapter.UserAdapter;
import com.example.georgesamuel.dubaihotels.model.paging.User;
import com.example.georgesamuel.dubaihotels.viewModel.MainActivityViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PagingActivity extends AppCompatActivity {
    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    private PagedList<User> users;
    private MainActivityViewModel mainActivityViewModel;
    private static final String TAG = PagingActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        ButterKnife.bind(this);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        getUsers();
        swipeLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeLayout.setOnRefreshListener(() -> {
            getUsers();
            showOnRecyclerView();
        });
    }

    public void getUsers() {
        mainActivityViewModel.getUserPagedList().observe(this, usersFromLiveData -> {
            users = usersFromLiveData;
            showOnRecyclerView();
        });
    }

    private void showOnRecyclerView() {
        UserAdapter userAdapter = new UserAdapter(this);
        userAdapter.submitList(users);
        rvMovies.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rvMovies.setItemAnimator(new DefaultItemAnimator());
        rvMovies.setAdapter(userAdapter);
        userAdapter.notifyDataSetChanged();
        if (swipeLayout.isRefreshing()) {
            swipeLayout.setRefreshing(false);
        }
    }
}
