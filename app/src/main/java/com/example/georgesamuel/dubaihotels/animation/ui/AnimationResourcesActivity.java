package com.example.georgesamuel.dubaihotels.animation.ui;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.georgesamuel.dubaihotels.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimationResourcesActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btnAlpha)
    AppCompatButton btnAlpha;
    @BindView(R.id.btnRotate)
    AppCompatButton btnRotate;
    @BindView(R.id.btnTranslate)
    AppCompatButton btnTranslate;
    @BindView(R.id.btnScale)
    AppCompatButton btnScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_resources);
        ButterKnife.bind(this);

        btnAlpha.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnTranslate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAlpha:
                setAlphaAnimation();
                break;
            case R.id.btnRotate:
                setRotateAnimation();
                break;
            case R.id.btnTranslate:
                setTranslateAnimation();
                break;
            case R.id.btnScale:
                setScaleAnimation();
                break;
        }
    }

    private void setAlphaAnimation() {
        Animation animation = AnimationUtils.loadAnimation(AnimationResourcesActivity.this, R.anim.alpha);
        btnAlpha.startAnimation(animation);
    }

    private void setRotateAnimation() {
        Animation animation = AnimationUtils.loadAnimation(AnimationResourcesActivity.this, R.anim.rotate);
        btnRotate.startAnimation(animation);
    }

    private void setTranslateAnimation() {
        Animation animation = AnimationUtils.loadAnimation(AnimationResourcesActivity.this, R.anim.translate);
        btnTranslate.startAnimation(animation);
    }

    private void setScaleAnimation() {
        Animation animation = AnimationUtils.loadAnimation(AnimationResourcesActivity.this, R.anim.scale);
        btnScale.startAnimation(animation);
    }
}
