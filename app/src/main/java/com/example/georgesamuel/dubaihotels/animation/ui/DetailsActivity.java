package com.example.georgesamuel.dubaihotels.animation.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.georgesamuel.dubaihotels.R;

import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
    }
}
