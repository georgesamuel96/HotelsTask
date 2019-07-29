package com.example.georgesamuel.dubaihotels.presentation.features.items;

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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListItemsActivity extends AppCompatActivity {


    @BindView(R.id.hotel_Items_recycler_view)
    RecyclerView hotelItemsRecyclerView;

    @BindView(R.id.parent_constraint_layout)
    ConstraintLayout parentConstraintLayout;

    private List<Hotel> list;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        initRecycler();

        ListItemsViewModel viewModel = ViewModelProviders.of(this).get(ListItemsViewModel.class);
        viewModel.getDetails();
        viewModel.result.observe(this, detailsModel -> {
            String name = detailsModel.getHotel().get(0).getHotelId().toString();
            Log.e("name", name);
            fillList(detailsModel.getHotel());
        });
        viewModel.retrieving.observe(this, isRetrieve -> {
            if (isRetrieve) {
                progressDialog.show();
            } else {
                progressDialog.dismiss();
                Snackbar.make(parentConstraintLayout, R.string.error, Snackbar.LENGTH_SHORT)
                        .show();
            }
        });


    }

    private void fillList(List<Hotel> hotel) {
        list = new ArrayList<>();
        for (int i = 0; i < hotel.size(); i++) {
            list.add(hotel.get(i));
        }
        ItemsAdapter adapter = new ItemsAdapter(list, getApplication());
        hotelItemsRecyclerView.setAdapter(adapter);
    }


    private void initRecycler() {
        hotelItemsRecyclerView.setHasFixedSize(true);
        hotelItemsRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

    }


}
