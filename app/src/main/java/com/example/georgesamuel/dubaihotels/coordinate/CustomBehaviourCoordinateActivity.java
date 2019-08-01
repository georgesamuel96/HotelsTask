package com.example.georgesamuel.dubaihotels.coordinate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;

import com.example.georgesamuel.dubaihotels.R;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomBehaviourCoordinateActivity extends AppCompatActivity {

    @BindView(R.id.custom_fab)
    CustomFloatingActionButton customFloatingActionButton;

    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_behaviour_coordinate);
        ButterKnife.bind(this);

        customFloatingActionButton.setOnClickListener(view -> Snackbar.make(coordinatorLayout, R.string.error, Snackbar.LENGTH_SHORT).show());
    }
}
