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

public class HotelDetailsActivity extends AppCompatActivity  {

    @BindView(R.id.hotel_name_details_text_view)
    TextView hotelNameTextView;

    @BindView(R.id.actual_price_text_view)
    TextView actualPriceTextView;

    @BindView(R.id.hotel_address_text_view)
    TextView addressTextView;

    @BindView(R.id.normal_price_text_view)
    TextView normalPriceTextView;

    @BindView(R.id.details_pic_image_view)
    ImageView hotelPicImageView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.back_image_view)
    ImageView backImageView;

    @BindView(R.id.open_map_button)
    Button openMapButton;

    boolean isImageFitToScreen;
    private Hotel hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        if (getIntent() != null) {
             hotel = (Hotel) getIntent().getSerializableExtra("Details");
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

    @OnClick(R.id.back_image_view)
    void setBack(View view) {
        finish();
    }


    @OnClick(R.id.details_pic_image_view)
    void zoomImage(View view) {
        if (isImageFitToScreen) {
            isImageFitToScreen = false;
            hotelPicImageView.setLayoutParams(new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
            hotelPicImageView.setAdjustViewBounds(true);
            hotelPicImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            isImageFitToScreen = true;
            hotelPicImageView.setLayoutParams(new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.MATCH_PARENT));
        }
    }

    @OnClick(R.id.open_map_button)
    void openMap(View view) {
        Intent intent=new Intent(this, MapActivity.class);
        if(hotel!=null){
            intent.putExtra("lang",hotel.getLocation().getLongitude());
            intent.putExtra("lat",hotel.getLocation().getLatitude());
            intent.putExtra("hotelName",hotel.getSummary().getHotelName());
        }
        startActivity(intent);
    }

}
