package com.example.georgesamuel.dubaihotels.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.georgesamuel.dubaihotels.R;
import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LottieActivity extends AppCompatActivity {

   @BindView(R.id.openShared)
    MaterialButton materialButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.openShared)
    public void openShared(){
        Intent intent=new Intent(LottieActivity.this,OptionsCompatActivity.class);
        startActivity(intent);
    }
}
