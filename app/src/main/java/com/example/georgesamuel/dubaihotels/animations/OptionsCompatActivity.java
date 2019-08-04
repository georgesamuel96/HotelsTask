package com.example.georgesamuel.dubaihotels.animations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.georgesamuel.dubaihotels.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OptionsCompatActivity extends AppCompatActivity {


    @BindView(R.id.image_youtube)
    ImageView imgYoutube;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_compat);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.image_youtube)
    public void loadNext(View view) {
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,imgYoutube,"imageMain");
        Intent in = new Intent(this,OptionsDetailsActivity.class);
        startActivity(in,activityOptionsCompat.toBundle());
    }
}
