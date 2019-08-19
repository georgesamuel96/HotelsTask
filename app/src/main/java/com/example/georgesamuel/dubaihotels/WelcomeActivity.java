package com.example.georgesamuel.dubaihotels;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.georgesamuel.dubaihotels.Hotels.ui.MainActivity;
import com.example.georgesamuel.dubaihotels.RxJava.RxJavaActivity;
import com.example.georgesamuel.dubaihotels.animation.ui.AnimationActivity;
import com.example.georgesamuel.dubaihotels.designPatterns.ui.DesignPatternsActivity;
import com.example.georgesamuel.dubaihotels.materialComponent.ui.MaterialComponentActivity;
import com.example.georgesamuel.dubaihotels.paging.ui.PagingActivity;
import com.example.georgesamuel.dubaihotels.workManager.ui.WorkManagerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.hotels)
    AppCompatButton hotels;
    @BindView(R.id.animation)
    AppCompatButton animation;
    @BindView(R.id.designPatterns)
    AppCompatButton designPatterns;
    @BindView(R.id.materialComponents)
    AppCompatButton materialComponents;
    @BindView(R.id.paging)
    AppCompatButton paging;
    @BindView(R.id.rxJava)
    AppCompatButton rxJava;
    @BindView(R.id.workManager)
    AppCompatButton workManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.hotels, R.id.animation, R.id.designPatterns, R.id.materialComponents, R.id.paging, R.id.rxJava,
            R.id.workManager})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hotels:
                goToActivity(MainActivity.class);
                break;
            case R.id.animation:
                goToActivity(AnimationActivity.class);
                break;
            case R.id.designPatterns:
                goToActivity(DesignPatternsActivity.class);
                break;
            case R.id.materialComponents:
                goToActivity(MaterialComponentActivity.class);
                break;
            case R.id.paging:
                goToActivity(PagingActivity.class);
                break;
            case R.id.rxJava:
                goToActivity(RxJavaActivity.class);
                break;
            case R.id.workManager:
                goToActivity(WorkManagerActivity.class);
                break;
        }
    }

    private void goToActivity(Class mainClass) {
        Intent intent = new Intent(WelcomeActivity.this, mainClass);
        startActivity(intent);
    }
}
