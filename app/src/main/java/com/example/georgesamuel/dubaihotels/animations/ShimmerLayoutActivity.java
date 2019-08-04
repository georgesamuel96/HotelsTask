package com.example.georgesamuel.dubaihotels.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.georgesamuel.dubaihotels.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.supercharge.shimmerlayout.ShimmerLayout;

public class ShimmerLayoutActivity extends AppCompatActivity {

    @BindView(R.id.shimmer_layout)
    ShimmerLayout shimmerText;
    @BindView(R.id.button_open_youtube_screen)
    Button btnOpenYoutubeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shimmer_layout);
        ButterKnife.bind(this);
        shimmerText.startShimmerAnimation();
    }

    @OnClick(R.id.button_open_youtube_screen)
    public void openYoutubeScreen(View view){
        Intent intent=new Intent(ShimmerLayoutActivity.this,OptionsCompatActivity.class);
        startActivity(intent);
    }
}
