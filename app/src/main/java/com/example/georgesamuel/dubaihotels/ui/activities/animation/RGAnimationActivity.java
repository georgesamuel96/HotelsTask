package com.example.georgesamuel.dubaihotels.ui.activities.animation;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.adapter.RVAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RGAnimationActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private List<String> list = new ArrayList<>();
    private RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rganimation);
        ButterKnife.bind(this);

        list.add("String 10");
        list.add("String 11");
        list.add("String 12");
        list.add("String 13");
        list.add("String 14");
        list.add("String 15");
        list.add("String 16");
        list.add("String 17");
        list.add("String 18");
        list.add("String 19");
        adapter = new RVAdapter(list);
        recyclerView.setLayoutManager(
                new GridLayoutManager(RGAnimationActivity.this, 3, RecyclerView.VERTICAL, false)
        );
        recyclerView.setHasFixedSize(true);
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(
                RGAnimationActivity.this,
                R.anim.grid_layout_animation_from_bottom
        );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutAnimation(animation);
    }
}
