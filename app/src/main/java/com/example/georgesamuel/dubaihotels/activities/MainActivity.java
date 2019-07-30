package com.example.georgesamuel.dubaihotels.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.adapter.HotelAdapter;
import com.example.georgesamuel.dubaihotels.model.Hotel;
import com.example.georgesamuel.dubaihotels.viewModel.HotelViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.main_container)
    RelativeLayout mainContainer;
    @BindView(R.id.loading)
    ProgressBar loading;
    @BindView(R.id.refreshList)
    SwipeRefreshLayout refreshList;
    private HotelViewModel hotelViewModel;
    private HotelAdapter adapter;
    private List<Hotel> hotelList = new ArrayList<>();
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        initToolbar();
        initHotelViewModel();
        initHotelRecyclerView();
        refreshList.setOnRefreshListener(() -> {
            loading.setVisibility(View.VISIBLE);
            updateList();
            refreshList.setRefreshing(false);
        });
    }

    private void updateList() {
        hotelViewModel.updateHotels().observe(this, this::setHotels);
    }

    private void initHotelRecyclerView() {
        adapter = new HotelAdapter(MainActivity.this, hotelList);
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private void initHotelViewModel() {
        hotelViewModel = ViewModelProviders.of(MainActivity.this).get(HotelViewModel.class);
        hotelViewModel.getHotels().observe(this, this::setHotels);
        hotelViewModel.showError().observe(MainActivity.this, s -> {
            if(s != null) {
                Snackbar.make(mainContainer, s, Snackbar.LENGTH_LONG).show();
                loading.setVisibility(View.GONE);
            }
        });
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.hotels));
        toolbar.setNavigationOnClickListener(view -> finish());
    }

    private void setHotels(List<Hotel> hotels) {
        loading.setVisibility(View.GONE);
        hotelList.clear();
        hotelList.addAll(hotels);
        adapter.notifyDataSetChanged();
    }
}