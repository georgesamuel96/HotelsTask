package com.example.georgesamuel.dubaihotels.presentation.features.hotels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.entities.Hotel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotelsListActivity extends AppCompatActivity {

    @BindView(R.id.hotel_Items_recycler_view)
    RecyclerView hotelItemsRecyclerView;

    @BindView(R.id.parent_constraint_layout)
    ConstraintLayout parentConstraintLayout;

    private HotelViewModel viewModel;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        viewModel = ViewModelProviders.of(this).get(HotelViewModel.class);
        initHotelsRecycler();
        observeGetHotels();
        observeLoadingIndicator();
        observeHasError();
    }

    private void setUpHotelAdapter(List<Hotel> hotelsList) {
        HotelAdapter adapter = new HotelAdapter(hotelsList, HotelsListActivity.this);
        hotelItemsRecyclerView.setAdapter(adapter);
    }


    private void initHotelsRecycler() {
        hotelItemsRecyclerView.setHasFixedSize(true);
        hotelItemsRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

    }

    private void observeGetHotels() {
        viewModel.hotelsDetailsLiveData.observe(this, detailsModel -> {
            String name = detailsModel.getHotel().get(0).getHotelId().toString();
            Log.e("name", name);
            setUpHotelAdapter(detailsModel.getHotel());
        });
    }

    private void observeLoadingIndicator() {
        viewModel.isLoadingLiveData.observe(this, isRetrieve -> {
            if (isRetrieve) {
                progressDialog.show();
            } else {
                progressDialog.dismiss();
                Snackbar.make(parentConstraintLayout, R.string.error, Snackbar.LENGTH_SHORT)
                        .show();
            }
        });
    }
    private void observeHasError(){
        viewModel.hasErrorLiveData.observe(this, hasError -> {
            if (hasError) {
                Snackbar.make(parentConstraintLayout, R.string.error, Snackbar.LENGTH_SHORT).show();            }
        });
    }

}
