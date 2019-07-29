package com.example.georgesamuel.dubaihotels.presentation.features.items;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.entities.HotelsDetailsModel;

import java.util.List;

public class ListItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListItemsViewModel viewModel= ViewModelProviders.of(this).get(ListItemsViewModel.class);
        viewModel.getDetails();
        viewModel.result.observe(this, new Observer<HotelsDetailsModel>() {
            @Override
            public void onChanged(HotelsDetailsModel list) {
            String name=  list.getHotel().get(0).getHotelId().toString();
                Log.e("name",name);
            }
        });

    }
}
