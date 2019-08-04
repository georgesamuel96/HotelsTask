package com.example.georgesamuel.dubaihotels.ui.activities.animation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.georgesamuel.dubaihotels.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.supercharge.shimmerlayout.ShimmerLayout;

public class ShimmerAnimationActivity extends AppCompatActivity {

    @BindView(R.id.shimmer_image)
    ShimmerLayout shimmerImage;
    @BindView(R.id.shimmer_text1)
    ShimmerLayout shimmerText1;
    @BindView(R.id.shimmer_text2)
    ShimmerLayout shimmerText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shimmer_animation);
        ButterKnife.bind(this);

        shimmerImage.startShimmerAnimation();
        shimmerText1.startShimmerAnimation();
        shimmerText2.startShimmerAnimation();
    }
}
