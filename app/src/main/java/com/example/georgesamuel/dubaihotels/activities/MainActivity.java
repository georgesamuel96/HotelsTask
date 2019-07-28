package com.example.georgesamuel.dubaihotels.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.adapter.HotelAdapter;
import com.example.georgesamuel.dubaihotels.model.Hotel;
import com.example.georgesamuel.dubaihotels.viewModel.HotelViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private HotelViewModel hotelViewModel;
    private RecyclerView recyclerView;
    private androidx.appcompat.widget.Toolbar toolbar;

    private HotelAdapter adapter;
    private List<Hotel> hotelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        hotelViewModel = ViewModelProviders.of(MainActivity.this).get(HotelViewModel.class);
        adapter = new HotelAdapter(MainActivity.this, hotelList);
        recyclerView = findViewById(R.id.recyclerView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hotels");

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        hotelViewModel.getHotels().observe(this, new Observer<List<Hotel>>() {
            @Override
            public void onChanged(List<Hotel> hotels) {

                hotelList.clear();
                adapter.notifyDataSetChanged();

                hotelList.addAll(hotels);
                adapter.notifyDataSetChanged();
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}