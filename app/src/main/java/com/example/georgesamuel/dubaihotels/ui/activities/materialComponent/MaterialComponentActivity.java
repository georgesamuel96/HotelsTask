package com.example.georgesamuel.dubaihotels.ui.activities.materialComponent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.georgesamuel.dubaihotels.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MaterialComponentActivity extends AppCompatActivity {

    @BindView(R.id.componentList)
    ListView components;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private List<String> componentsList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_component);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        initToolbar();
        initAdapter();
    }

    private void initAdapter() {
        componentsList.add(getString(R.string.material_dialog));
        componentsList.add(getString(R.string.bottom_app_bar));
        adapter = new ArrayAdapter<>(this, R.layout.component_item, R.id.componentName, componentsList);
        components.setAdapter(adapter);

        components.setOnItemClickListener((adapterView, view, position, l) -> {
            switch (position) {
                case 0:
                    goToActivity(MaterialDialogActivity.class);
                    break;
                case 1:
                    goToActivity(BottomAppBarActivity.class);
                    break;
            }
        });
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.material_component));
    }

    private void goToActivity(Class mainClass) {
        Intent intent = new Intent(MaterialComponentActivity.this, mainClass);
        startActivity(intent);
    }
}
