package com.example.georgesamuel.dubaihotels.component;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

import com.example.georgesamuel.dubaihotels.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollapsingToolBarActivity extends AppCompatActivity {

    @BindView(R.id.collapsing_toolbar_test)
    CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_tool_bar);
        ButterKnife.bind(this);
        collapsingToolbar.setTitle("Demo");

    }
}
