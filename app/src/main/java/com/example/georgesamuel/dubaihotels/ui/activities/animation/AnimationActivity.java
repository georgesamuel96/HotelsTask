package com.example.georgesamuel.dubaihotels.ui.activities.animation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.georgesamuel.dubaihotels.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimationActivity extends AppCompatActivity {

    @BindView(R.id.animationList)
    ListView lvAnimation;
    private List<String> animationsList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);

        initAdapter();
    }

    private void initAdapter() {
        animationsList.add(getString(R.string.animation_resources));
        adapter = new ArrayAdapter<>(this, R.layout.component_item, R.id.componentName, animationsList);
        lvAnimation.setAdapter(adapter);
        lvAnimation.setOnItemClickListener((adapterView, view, position, l) -> {
            switch (position) {
                case 0:
                    goToActivity(AnimationResourcesActivity.class);
                    break;
            }
        });
    }

    private void goToActivity(Class mainClass) {
        Intent intent = new Intent(AnimationActivity.this, mainClass);
        startActivity(intent);
    }
}
