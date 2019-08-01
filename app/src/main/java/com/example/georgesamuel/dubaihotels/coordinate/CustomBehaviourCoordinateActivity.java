package com.example.georgesamuel.dubaihotels.coordinate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Color;
import android.os.Bundle;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.entities.Hotel;
import com.example.georgesamuel.dubaihotels.presentation.features.hotels.HotelAdapter;
import com.example.georgesamuel.dubaihotels.presentation.features.hotels.HotelViewModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomBehaviourCoordinateActivity extends AppCompatActivity {

    @BindView(R.id.custom_fab)
    CustomFloatingActionButton customFloatingActionButton;

    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.test_scroll_recycler)
    RecyclerView recyclerView;

    @BindView(R.id.material_toolbar)
    MaterialToolbar toolbar;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.material_appbar)
    AppBarLayout appBarLayout;

    private HotelViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_behaviour_coordinate);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        viewModel = ViewModelProviders.of(this).get(HotelViewModel.class);
        initHotelsRecycler();
        observeGetHotels();
        customFloatingActionButton.setOnClickListener(view -> Snackbar.make(coordinatorLayout, R.string.error, Snackbar.LENGTH_SHORT).show());
        collapsingToolbarLayout.setTitle("Title");
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
        toolbar.setTitle("Title");

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle("Title");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle("");
                    isShow = false;
                }
            }
        });

    }

    private void setUpHotelAdapter(List<Hotel> hotelsList) {
        HotelAdapter adapter = new HotelAdapter(hotelsList, CustomBehaviourCoordinateActivity.this);
        recyclerView.setAdapter(adapter);
    }


    private void initHotelsRecycler() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

    }

    private void observeGetHotels() {
        viewModel.hotelsDetailsLiveData.observe(this, hotelsDetails -> {
            setUpHotelAdapter(hotelsDetails.getHotel());
        });
    }



}
