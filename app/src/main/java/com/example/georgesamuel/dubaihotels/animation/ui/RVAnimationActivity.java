package com.example.georgesamuel.dubaihotels.animation.ui;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.animation.adapter.RVAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RVAnimationActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private List<String> list = new ArrayList<>();
    private RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvanimation);
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
                new LinearLayoutManager(RVAnimationActivity.this, RecyclerView.VERTICAL, false)
        );
        recyclerView.setHasFixedSize(true);
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(
                RVAnimationActivity.this,
                R.anim.layout_animation_fall_down
        );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutAnimation(animation);
    }
}
