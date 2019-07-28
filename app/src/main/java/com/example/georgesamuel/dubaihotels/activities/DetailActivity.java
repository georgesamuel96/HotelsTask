package com.example.georgesamuel.dubaihotels.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.georgesamuel.dubaihotels.R;

public class DetailActivity extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;
    private String hotel_image_url;
    private String hotel_name;
    private String hotel_address;
    private double hotel_high_rate;
    private double hotel_low_rate;
    private double hotel_longitude;
    private double hotel_latitude;
    private boolean fitFullScreen = false;
    private TextView hotelName, hotelAddress, highRate, lowRate;
    private ImageView hotelImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getAttributes();
        init();
        setFields();

    }

    private void setFields() {

        Glide.with(DetailActivity.this).load(hotel_image_url).into(hotelImage);
        hotelName.setText(hotel_name);
        hotelAddress.setText(hotel_address);
        highRate.setText("High rate: " + hotel_high_rate);
        lowRate.setText("Low rate: " + hotel_low_rate);
    }

    private void getAttributes() {
        hotel_image_url = getIntent().getStringExtra("url");
        hotel_name = getIntent().getStringExtra("name");
        hotel_address = getIntent().getStringExtra("address");
        hotel_high_rate = getIntent().getDoubleExtra("high", 0.0);
        hotel_low_rate = getIntent().getDoubleExtra("low", 0.0);
        hotel_longitude = getIntent().getDoubleExtra("longitude", 0.0);
        hotel_latitude = getIntent().getDoubleExtra("latitude", 0.0);
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        hotelImage = findViewById(R.id.hotelImage);
        hotelName = findViewById(R.id.hotelName);
        hotelAddress = findViewById(R.id.hotelAddress);
        highRate = findViewById(R.id.highRate);
        lowRate = findViewById(R.id.lowRate);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        AlertDialog.Builder alert = new AlertDialog.Builder(DetailActivity.this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.image_fullscreen, null);
        alert.setView(dialogView);
        AlertDialog alertDialog = alert.create();


        hotelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageView image = dialogView.findViewById(R.id.image);

                Glide.with(DetailActivity.this).load(hotel_image_url).into(image);
                alertDialog.show();

                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.cancel();
                    }
                });
            }
        });
    }


}
