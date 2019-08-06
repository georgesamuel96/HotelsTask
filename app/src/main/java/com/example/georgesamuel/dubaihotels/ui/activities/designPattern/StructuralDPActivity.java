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

public class StructuralDPActivity extends AppCompatActivity {

    @BindView(R.id.structuralDBLV)
    ListView structuralDBLV;
    List<String> patternsList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structural_dp);
        ButterKnife.bind(this);

        initAdapter();
    }

    private void initAdapter() {
        patternsList.add(getString(R.string.adapter_design_pattern));
        adapter = new ArrayAdapter<>(this, R.layout.component_item, R.id.componentName, patternsList);
        structuralDBLV.setAdapter(adapter);
        structuralDBLV.setOnItemClickListener((adapterView, view, position, l) -> {
            switch (position) {
                case 0:
                    goToActivity(AdapterDPActivity.class);
                    break;
            }
        });
    }

    private void goToActivity(Class mainClass) {
        Intent intent = new Intent(StructuralDPActivity.this, mainClass);
        startActivity(intent);
    }
}
