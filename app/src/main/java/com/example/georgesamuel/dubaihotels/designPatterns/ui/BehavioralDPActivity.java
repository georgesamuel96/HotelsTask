package com.example.georgesamuel.dubaihotels.designPatterns.ui;

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

public class BehavioralDPActivity extends AppCompatActivity {

    @BindView(R.id.behaviorDPLV)
    ListView behaviorDPLV;
    List<String> patternsList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavioral_dp);
        ButterKnife.bind(this);

        initAdapter();
    }

    private void initAdapter() {
        patternsList.add(getString(R.string.observer_design_pattern));
        adapter = new ArrayAdapter<>(this, R.layout.component_item, R.id.componentName, patternsList);
        behaviorDPLV.setAdapter(adapter);
        behaviorDPLV.setOnItemClickListener((adapterView, view, position, l) -> {
            switch (position) {
                case 0:
                    goToActivity(ObserverDPActivity.class);
                    break;
            }
        });
    }

    private void goToActivity(Class mainClass) {
        Intent intent = new Intent(BehavioralDPActivity.this, mainClass);
        startActivity(intent);
    }
}
