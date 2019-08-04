package com.example.georgesamuel.dubaihotels.presentation.features.map;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.georgesamuel.dubaihotels.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private double longitude;
    private double latitude;
    private String hotelName;
    public static final String EXTRA_LONGITUDE = "com.example.georgesamuel.dubaihotels.EXTRA_LONGITUDE";
    public static final String EXTRA_LATITUDE = "com.example.georgesamuel.dubaihotels.EXTRA_LATITUDE";
    public static final String EXTRA_HOTEL_NAME = "com.example.georgesamuel.dubaihotels.EXTRA_HOTEL_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_map);
        mapFragment.getMapAsync(this);
        if (getIntent() != null) {
            longitude = getIntent().getDoubleExtra(EXTRA_LONGITUDE, 0);
            latitude = getIntent().getDoubleExtra(EXTRA_LATITUDE, 0);
            hotelName = getIntent().getStringExtra(EXTRA_HOTEL_NAME); }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        GoogleMap mMap = googleMap;
        LatLng currentPosition = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(currentPosition).title(hotelName));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 10)); }
}

