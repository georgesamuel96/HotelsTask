package com.example.georgesamuel.dubaihotels.dagger2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.adapter.HotelAdapter;
import com.example.georgesamuel.dubaihotels.dagger2.modules.HotelViewModel;
import com.example.georgesamuel.dubaihotels.model.hotel.Hotel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Dagger2Activity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private HotelViewModel viewModel;
    private static final String TAG = AppCompatActivity.class.getSimpleName();
    private HotelAdapter adapter;
    private List<Hotel> hotelsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);
        ButterKnife.bind(this);

        adapter = new HotelAdapter(this, hotelsList);
        viewModel = ViewModelProviders.of(this).get(HotelViewModel.class);
        viewModel.getHotels().observe(this, hotels -> showRecyclerView(hotels));
    }

    private void showRecyclerView(List<Hotel> hotels) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        hotelsList.addAll(hotels);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
