package com.example.georgesamuel.dubaihotels.presentation.features.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.entities.Hotel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

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

    boolean isImageFitToScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        if (getIntent() != null) {
            Hotel hotel = (Hotel) getIntent().getSerializableExtra("Details");
            setData(hotel);
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        backImageView.setOnClickListener(this);
        hotelPicImageView.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.back_image_view:
                finish();
                break;
            case R.id.details_pic_image_view:
                if (isImageFitToScreen) {
                    isImageFitToScreen = false;
                    hotelPicImageView.setLayoutParams(new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
                    hotelPicImageView.setAdjustViewBounds(true);
                    hotelPicImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                } else {
                    isImageFitToScreen = true;
                    hotelPicImageView.setLayoutParams(new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.MATCH_PARENT));
                }
                break;
                default:
                    break;

        }
    }
}
