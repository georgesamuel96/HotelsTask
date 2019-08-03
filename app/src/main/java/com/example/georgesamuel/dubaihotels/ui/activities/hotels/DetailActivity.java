package com.example.georgesamuel.dubaihotels.ui.activities.hotels;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
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

import static com.example.georgesamuel.dubaihotels.adapter.HotelAdapter.EXTRA_HOTEL_ADDRESS;
import static com.example.georgesamuel.dubaihotels.adapter.HotelAdapter.EXTRA_HOTEL_HIGH;
import static com.example.georgesamuel.dubaihotels.adapter.HotelAdapter.EXTRA_HOTEL_IMAGE_URL;
import static com.example.georgesamuel.dubaihotels.adapter.HotelAdapter.EXTRA_HOTEL_LATITUDE;
import static com.example.georgesamuel.dubaihotels.adapter.HotelAdapter.EXTRA_HOTEL_LONGITUDE;
import static com.example.georgesamuel.dubaihotels.adapter.HotelAdapter.EXTRA_HOTEL_LOW;
import static com.example.georgesamuel.dubaihotels.adapter.HotelAdapter.EXTRA_HOTEL_NAME;

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.hotelImage)
    ImageView hotelImage;
    @BindView(R.id.hotelName)
    TextView hotelNameTV;
    @BindView(R.id.hotelAddress)
    TextView hotelAddressTV;
    @BindView(R.id.highRate)
    TextView highRate;
    @BindView(R.id.lowRate)
    TextView lowRate;
    @BindView(R.id.mapView)
    MapView mapView;
    private String hotelImageUrl;
    private String hotelName;
    private String hotelAddress;
    private double hotelHighRate;
    private double hotelLowRate;
    private double hotelLongitude;
    private double hotelLatitude;
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
        Glide.with(DetailActivity.this).load(hotelImageUrl).into(hotelImage);
        hotelNameTV.setText(hotelName);
        hotelAddressTV.setText(hotelAddress);
        highRate.setText(getString(R.string.high_rate) + hotelHighRate);
        lowRate.setText(getString(R.string.row_rate) + hotelLowRate);
    }

    private void getAttributes() {
        hotelImageUrl = getIntent().getStringExtra(EXTRA_HOTEL_IMAGE_URL);
        hotelName = getIntent().getStringExtra(EXTRA_HOTEL_NAME);
        hotelAddress = getIntent().getStringExtra(EXTRA_HOTEL_ADDRESS);
        hotelHighRate = getIntent().getDoubleExtra(EXTRA_HOTEL_HIGH, 0.0);
        hotelLowRate = getIntent().getDoubleExtra(EXTRA_HOTEL_LOW, 0.0);
        hotelLongitude = getIntent().getDoubleExtra(EXTRA_HOTEL_LONGITUDE, 0.0);
        hotelLatitude = getIntent().getDoubleExtra(EXTRA_HOTEL_LATITUDE, 0.0);
    }

    private void init(Bundle savedInstanceState) {
        initToolbar();
        initMapView(savedInstanceState);
    }

    private void initMapView(Bundle savedInstanceState) {
        Bundle bundle = null;
        if (savedInstanceState != null) {
            bundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(bundle);
        mapView.getMapAsync(this);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.details));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions().position(new LatLng(hotelLatitude, hotelLongitude)).title(hotelName));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(hotelLatitude, hotelLongitude), 15f));
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
    public void onHotelImageClicked() {
        AlertDialog.Builder alert = new AlertDialog.Builder(DetailActivity.this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.image_fullscreen, null);
        alert.setView(dialogView);
        AlertDialog alertDialog = alert.create();
        ImageView image = dialogView.findViewById(R.id.image);
        Glide.with(DetailActivity.this).load(hotelImageUrl).into(image);
        alertDialog.show();
        image.setOnClickListener(view -> alertDialog.cancel());
    }
}
