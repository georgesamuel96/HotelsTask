package com.example.georgesamuel.dubaihotels.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.georgesamuel.dubaihotels.ui.activities.hotels.DetailActivity;
import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.model.hotel.Hotel;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder>{

    final private Context context;
    final private List<Hotel> hotelsList;
    public static final String EXTRA_HOTEL_NAME = "com.example.georgesamuel.dubaihotels.util.EXTRA_HOTEL_NAME";
    public static final String EXTRA_HOTEL_IMAGE_URL = "com.example.georgesamuel.dubaihotels.util.EXTRA_HOTEL_IMAGE_URL";
    public static final String EXTRA_HOTEL_ADDRESS = "com.example.georgesamuel.dubaihotels.util.EXTRA_HOTEL_ADDRESS";
    public static final String EXTRA_HOTEL_HIGH= "com.example.georgesamuel.dubaihotels.util.EXTRA_HOTEL_HIGH";
    public static final String EXTRA_HOTEL_LOW = "com.example.georgesamuel.dubaihotels.util.EXTRA_HOTEL_LOW";
    public static final String EXTRA_HOTEL_LONGITUDE = "com.example.georgesamuel.dubaihotels.util.EXTRA_HOTEL_LONGITUDE";
    public static final String EXTRA_HOTEL_LATITUDE = "com.example.georgesamuel.dubaihotels.util.EXTRA_HOTEL_LATITUDE";

    public HotelAdapter(Context context, List<Hotel> list){
        this.context = context;
        this.hotelsList = list;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item, parent, false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {

        Glide.with(context).load(hotelsList.get(position).getImage().get(0).getUrl()).into(holder.hotelImage);
        holder.hotelName.setText(hotelsList.get(position).getSummary().getHotelName());
        holder.cardView.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(EXTRA_HOTEL_IMAGE_URL, hotelsList.get(position).getImage().get(0).getUrl());
            intent.putExtra(EXTRA_HOTEL_NAME, hotelsList.get(position).getSummary().getHotelName());
            intent.putExtra(EXTRA_HOTEL_ADDRESS, hotelsList.get(position).getLocation().getAddress());
            intent.putExtra(EXTRA_HOTEL_HIGH, hotelsList.get(position).getSummary().getHighRate());
            intent.putExtra(EXTRA_HOTEL_LOW, hotelsList.get(position).getSummary().getLowRate());
            intent.putExtra(EXTRA_HOTEL_LONGITUDE, hotelsList.get(position).getLocation().getLongitude());
            intent.putExtra(EXTRA_HOTEL_LATITUDE, hotelsList.get(position).getLocation().getLatitude());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return hotelsList.size();
    }

    static class HotelViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.card)
        MaterialCardView cardView;
        @BindView(R.id.hotelImage)
        ImageView hotelImage;
        @BindView(R.id.hotelName)
        TextView hotelName;

        public HotelViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
