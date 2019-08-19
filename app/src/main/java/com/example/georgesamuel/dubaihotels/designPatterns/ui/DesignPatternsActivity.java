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

public class DesignPatternsActivity extends AppCompatActivity {

    @BindView(R.id.designList)
    ListView designLV;
    List<String> patternsList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_patterns);
        ButterKnife.bind(this);

        initAdapter();
    }

    private void initAdapter() {
        patternsList.add(getString(R.string.creational_design_pattern));
        patternsList.add(getString(R.string.structural_design_patterns));
        patternsList.add(getString(R.string.behavioral_design_pattern));
        adapter = new ArrayAdapter<>(this, R.layout.component_item, R.id.componentName, patternsList);
        designLV.setAdapter(adapter);
        designLV.setOnItemClickListener((adapterView, view, position, l) -> {
            switch (position) {
                case 0:
                    goToActivity(CreationalDPActivity.class);
                    break;
                case 1:
                    goToActivity(StructuralDPActivity.class);
                    break;
                case 2:
                    goToActivity(BehavioralDPActivity.class);
                    break;
            }
        });
    }

    private void goToActivity(Class mainClass) {
        Intent intent = new Intent(DesignPatternsActivity.this, mainClass);
        startActivity(intent);
    }
}
