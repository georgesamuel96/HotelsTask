package com.example.georgesamuel.dubaihotels.activities;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.adapter.HotelAdapter;
import com.example.georgesamuel.dubaihotels.model.Hotel;
import com.example.georgesamuel.dubaihotels.viewModel.HotelViewModel;

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
    LinearLayout mainContainer;
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

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        hotelViewModel.getHotels(mainContainer).observe(this, (List<Hotel> hotels) -> {
            hotelList.clear();
            adapter.notifyDataSetChanged();
            hotelList.addAll(hotels);
            adapter.notifyDataSetChanged();
        });
    }
}