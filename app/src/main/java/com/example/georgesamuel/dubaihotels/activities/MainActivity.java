package com.example.georgesamuel.dubaihotels.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
import com.example.georgesamuel.dubaihotels.model.HotelsResponse;
import com.example.georgesamuel.dubaihotels.util.CheckNetwork;
import com.example.georgesamuel.dubaihotels.util.Constants;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        hotelViewModel = ViewModelProviders.of(MainActivity.this).get(HotelViewModel.class);
        adapter = new HotelAdapter(MainActivity.this, hotelList);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.hotels));
        toolbar.setNavigationOnClickListener(view -> finish());

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
       getHotels();
        refreshList.setOnRefreshListener(() -> {

            if(!CheckNetwork.hasNetwork(getApplicationContext())){
                loading.setVisibility(View.GONE);
                Snackbar.make(mainContainer, "No Internet Connection", Snackbar.LENGTH_LONG).show();
            }
            else {
                getHotels();
            }
            refreshList.setRefreshing(false);
        });
    }

    private void getHotels(){
        hotelList.clear();
        adapter.notifyDataSetChanged();
        hotelViewModel.getHotels().observe(this, (HotelsResponse hotels) -> {
            loading.setVisibility(View.GONE);
            if (hotels.getMessage().equals(Constants.SUCCESS_MESSAGE)) {
                hotelList.clear();
                adapter.notifyDataSetChanged();
                hotelList.addAll(hotels.getHotel());
                adapter.notifyDataSetChanged();
            } else {
                Snackbar.make(mainContainer, hotels.getMessage(), Snackbar.LENGTH_LONG)
                        .setAction(getString(R.string.ok), view -> {
                        }).show();
            }

        });
    }
}