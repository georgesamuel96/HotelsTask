package com.example.georgesamuel.dubaihotels.presentation.features.items;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.entities.Hotel;
import com.example.georgesamuel.dubaihotels.presentation.features.details.DetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {


    private Context context;
    private List<Hotel> list;

    public ItemsAdapter(List<Hotel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotels_list_item, parent, false);
        ItemsViewHolder holder = new ItemsViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {

        Hotel details = list.get(position);
        String imageUrl = details.getImage().get(0).getUrl();
        String hotelName = details.getSummary().getHotelName();
        holder.hotelNameTextView.setText(hotelName);

        Picasso.with(context).load(imageUrl)
                .placeholder(context.getDrawable(R.drawable.ic_launcher_background)).into(holder.hotelPicImageView);
        setUpItemClick(holder.itemView, details);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    class ItemsViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.hotel_name_text_view)
        TextView hotelNameTextView;

        @BindView(R.id.hotel_picture_image_view)
        ImageView hotelPicImageView;

        ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    private void setUpItemClick(View itemView, Hotel hotel) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("Details", hotel);
                context.startActivity(intent);            }
        });
    }
}
