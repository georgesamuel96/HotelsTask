package com.example.georgesamuel.dubaihotels.ui.activities.designPattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.ui.fragments.designPattern.AFragment;
import com.example.georgesamuel.dubaihotels.ui.fragments.designPattern.BFragment;
import com.example.georgesamuel.dubaihotels.ui.fragments.designPattern.CFragment;

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
