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
import com.example.georgesamuel.dubaihotels.activities.DetailActivity;
import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.model.Hotel;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder>{

    private Context context;
    private List<Hotel> hotelsList = new ArrayList<>();

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


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("url", hotelsList.get(position).getImage().get(0).getUrl());
                intent.putExtra("name", hotelsList.get(position).getSummary().getHotelName());
                intent.putExtra("address", hotelsList.get(position).getLocation().getAddress());
                intent.putExtra("high", hotelsList.get(position).getSummary().getHighRate());
                intent.putExtra("low", hotelsList.get(position).getSummary().getLowRate());
                intent.putExtra("longitude", hotelsList.get(position).getLocation().getLongitude());
                intent.putExtra("latitude", hotelsList.get(position).getLocation().getLatitude());
                context.startActivity(intent);
            }
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
