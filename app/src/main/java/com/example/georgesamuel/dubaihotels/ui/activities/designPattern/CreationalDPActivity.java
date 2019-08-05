package com.example.georgesamuel.dubaihotels.ui.activities.designPattern;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.georgesamuel.dubaihotels.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreationalDPActivity extends AppCompatActivity {

    @BindView(R.id.creationalDBLV)
    ListView creationalDBLV;
    List<String> patternsList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creational_dp);
        ButterKnife.bind(this);

        initAdapter();
    }

    private void initAdapter() {
        patternsList.add(getString(R.string.builder_design_pattern));
        adapter = new ArrayAdapter<>(this, R.layout.component_item, R.id.componentName, patternsList);
        creationalDBLV.setAdapter(adapter);
        creationalDBLV.setOnItemClickListener((adapterView, view, position, l) -> {
            switch (position) {
                case 0:
                    goToActivity(BuilderDPActivity.class);
                    break;
            }
        });
    }

    private void goToActivity(Class mainClass) {
        Intent intent = new Intent(CreationalDPActivity.this, mainClass);
        startActivity(intent);
    }
}
