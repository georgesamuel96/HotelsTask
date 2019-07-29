package com.example.georgesamuel.dubaihotels.presentation.features.items;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.entities.Hotel;
import com.example.georgesamuel.dubaihotels.entities.HotelsDetailsModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListItemsActivity extends AppCompatActivity {


    @BindView(R.id.hotel_Items_recycler_view)
    RecyclerView hotelItemsRecyclerView;

    private List<Hotel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       ButterKnife.bind(this);
        initRecycler();

        ListItemsViewModel viewModel= ViewModelProviders.of(this).get(ListItemsViewModel.class);
        viewModel.getDetails();
        viewModel.result.observe(this, new Observer<HotelsDetailsModel>() {
            @Override
            public void onChanged(HotelsDetailsModel detailsModel) {
            String name=  detailsModel.getHotel().get(0).getHotelId().toString();
                Log.e("name",name);
                fillList(detailsModel.getHotel());
            }
        });

    }

      private void fillList(List<Hotel> hotel){
        list=new ArrayList<>();
        for (int i=0;i<hotel.size();i++){
            list.add(hotel.get(i));
        }
          ItemsAdapter adapter = new ItemsAdapter(list, getApplication());
          hotelItemsRecyclerView.setAdapter(adapter);
}


    private void initRecycler(){
        hotelItemsRecyclerView.setHasFixedSize(true);
        hotelItemsRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

    }


}
