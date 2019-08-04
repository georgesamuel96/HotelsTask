package com.example.georgesamuel.dubaihotels.presentation.features.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.georgesamuel.dubaihotels.presentation.features.map.MapActivity;
import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.entities.Hotel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.georgesamuel.dubaihotels.presentation.features.map.MapActivity.EXTRA_HOTEL_NAME;
import static com.example.georgesamuel.dubaihotels.presentation.features.map.MapActivity.EXTRA_LATITUDE;
import static com.example.georgesamuel.dubaihotels.presentation.features.map.MapActivity.EXTRA_LONGITUDE;

public class HotelDetailsActivity extends AppCompatActivity  {

    @BindView(R.id.text_hotel_name_details)
    TextView hotelNameTextView;
    @BindView(R.id.text_actual_price)
    TextView actualPriceTextView;
    @BindView(R.id.text_hotel_address)
    TextView addressTextView;
    @BindView(R.id.text_normal_price)
    TextView normalPriceTextView;
    @BindView(R.id.image_hotel_details)
    ImageView hotelPicImageView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.image_back)
    ImageView backImageView;
    @BindView(R.id.button_open_map)
    Button openMapButton;

    boolean isImageFitToScreen;
    private Hotel hotel;
    public static final String EXTRA_HOTEL_DETAILS=" com.example.georgesamuel.dubaihotels.details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        if (getIntent() != null) {
             hotel = (Hotel) getIntent().getSerializableExtra(EXTRA_HOTEL_DETAILS);
            setData(hotel);
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    private void setData(Hotel data) {
        String imageUrl = data.getImage().get(0).getUrl();
        String address = data.getLocation().getAddress();
        String hotelName = data.getSummary().getHotelName();
        Double actualPrice = data.getSummary().getLowRate();
        Double normalPrice = data.getSummary().getHighRate();
        Picasso.with(this).load(imageUrl).placeholder(getResources().getDrawable(R.drawable.ic_launcher_background)).into(hotelPicImageView);
        addressTextView.setText(address);
        hotelNameTextView.setText(hotelName);
        normalPriceTextView.setText(String.valueOf(normalPrice));
        actualPriceTextView.setText(String.valueOf(actualPrice));

    }

    @OnClick(R.id.image_back)
    void setBack(View view) {
        finish();
    }

    @OnClick(R.id.image_hotel_details)
    void zoomImage(View view) {
        if (isImageFitToScreen) {
            isImageFitToScreen = false;
            view.setLayoutParams(new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
            hotelPicImageView.setAdjustViewBounds(true);
            hotelPicImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            isImageFitToScreen = true;
            view.setLayoutParams(new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.MATCH_PARENT));
        }
    }

    @OnClick(R.id.button_open_map)
    void openMap(View view) {
        Intent intent=new Intent(this, MapActivity.class);
        if(hotel!=null){
            intent.putExtra(EXTRA_LONGITUDE,hotel.getLocation().getLongitude());
            intent.putExtra(EXTRA_LATITUDE,hotel.getLocation().getLatitude());
            intent.putExtra(EXTRA_HOTEL_NAME,hotel.getSummary().getHotelName());
        }
        startActivity(intent);
    }

}
