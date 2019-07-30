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

    private GoogleMap mMap;
    private double longitude;
    private double latitude;
    private String hotelName;
    public static final String LONGITUDE_CONSTANT ="lang";
    public static final String LATITUDE_CONSTANT ="lat";
    public static final String HOTEL_NAME_CONSTANT ="hotelName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        if(getIntent()!=null){
            longitude =getIntent().getDoubleExtra(LONGITUDE_CONSTANT,0);
            latitude=getIntent().getDoubleExtra(LATITUDE_CONSTANT,0);
            hotelName=getIntent().getStringExtra(HOTEL_NAME_CONSTANT);

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng currentPosition = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(currentPosition).title(hotelName));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 10));

    }
}

