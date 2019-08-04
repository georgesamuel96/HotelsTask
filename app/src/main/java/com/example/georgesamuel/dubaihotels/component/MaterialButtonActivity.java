package com.example.georgesamuel.dubaihotels.component;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.georgesamuel.dubaihotels.R;
import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MaterialButtonActivity extends AppCompatActivity {

    @BindView(R.id.button_open_collapse)
    MaterialButton btnOpenCollapse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_button);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_open_collapse)
    public void openCollapseScreen(View view){
        Intent intent=new Intent(MaterialButtonActivity.this, MaterialBottomSheetActivity.class);
        startActivity(intent);
    }
}
