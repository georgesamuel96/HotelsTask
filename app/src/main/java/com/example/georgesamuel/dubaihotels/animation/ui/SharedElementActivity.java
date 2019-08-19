package com.example.georgesamuel.dubaihotels.animation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import com.example.georgesamuel.dubaihotels.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SharedElementActivity extends AppCompatActivity {

    @BindView(R.id.imageM)
    ImageView imageM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element);
        ButterKnife.bind(this);
    }

    public void loadNext(View view) {
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                imageM,
                "imageMain"
        );
        Intent in = new Intent(this, DetailsActivity.class);
        startActivity(in, activityOptionsCompat.toBundle());
    }

}
