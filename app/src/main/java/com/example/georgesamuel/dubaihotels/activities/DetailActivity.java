package com.example.georgesamuel.dubaihotels.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.georgesamuel.dubaihotels.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.hotelImage)
    ImageView hotelImage;
    @BindView(R.id.hotelName)
    TextView hotelName;
    @BindView(R.id.hotelAddress)
    TextView hotelAddress;
    @BindView(R.id.highRate)
    TextView highRate;
    @BindView(R.id.lowRate)
    TextView lowRate;
    @BindView(R.id.mapView)
    MapView mapView;
    private String hotel_image_url;
    private String hotel_name;
    private String hotel_address;
    private double hotel_high_rate;
    private double hotel_low_rate;
    private double hotel_longitude;
    private double hotel_latitude;
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        getAttributes();
        init(savedInstanceState);
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

    private void init(Bundle savedInstanceState) {
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

        Bundle bundle = null;
        if (savedInstanceState != null) {
            bundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(bundle);
        mapView.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.addMarker(new MarkerOptions().position(new LatLng(hotel_latitude, hotel_longitude)).title(hotel_name));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(hotel_latitude, hotel_longitude), 15f));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        Bundle bundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (bundle == null) {
            bundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, bundle);
        }

        mapView.onSaveInstanceState(bundle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @OnClick(R.id.hotelImage)
    public void onViewClicked() {

        AlertDialog.Builder alert = new AlertDialog.Builder(DetailActivity.this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.image_fullscreen, null);
        alert.setView(dialogView);
        AlertDialog alertDialog = alert.create();

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
}
