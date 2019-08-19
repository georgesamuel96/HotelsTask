package com.example.georgesamuel.dubaihotels.designPatterns.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.georgesamuel.dubaihotels.R;

public class ObserverDPActivity extends AppCompatActivity {

    AFragment fragmentA = new AFragment();
    BFragment fragmentB = new BFragment();
    CFragment fragmentC = new CFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer_dp);


        fragmentC.register(fragmentA);
        fragmentC.register(fragmentB);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragmentC, null).commit();
    }
}
