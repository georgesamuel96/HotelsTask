package com.example.georgesamuel.dubaihotels.presentation.features.hotels;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.entities.Hotel;
import com.example.georgesamuel.dubaihotels.presentation.features.details.HotelDetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.georgesamuel.dubaihotels.presentation.features.details.HotelDetailsActivity.EXTRA_HOTEL_DETAILS;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ItemsViewHolder> {
    private Context context;
    private List<Hotel> list;

    public HotelAdapter(List<Hotel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotels_list_item, parent, false);
        return new ItemsViewHolder(v);
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

        @BindView(R.id.text_hotel_name)
        TextView hotelNameTextView;
        @BindView(R.id.image_hotel)
        ImageView hotelPicImageView;

        ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView); }
    }

    private void setUpItemClick(View itemView, Hotel hotel) {
        itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, HotelDetailsActivity.class);
            intent.putExtra(EXTRA_HOTEL_DETAILS, hotel);
            context.startActivity(intent);
        });
    }
}
