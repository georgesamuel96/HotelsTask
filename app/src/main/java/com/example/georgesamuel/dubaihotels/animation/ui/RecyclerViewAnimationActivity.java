package com.example.georgesamuel.dubaihotels.animation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.georgesamuel.dubaihotels.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerViewAnimationActivity extends AppCompatActivity {

    @BindView(R.id.btnList)
    AppCompatButton btnList;
    @BindView(R.id.btnGrid)
    AppCompatButton btnGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_animation);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnList, R.id.btnGrid})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnList:
                Intent intent = new Intent(RecyclerViewAnimationActivity.this, RVAnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.btnGrid:
                Intent intent1 = new Intent(RecyclerViewAnimationActivity.this, RGAnimationActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
