package com.example.georgesamuel.dubaihotels.activities.materialDesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.georgesamuel.dubaihotels.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CoordinatorLayoutCustomBehaviorActivity extends AppCompatActivity {

    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.main_container)
    CoordinatorLayout mainContainer;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private static final String TAG = CoordinatorLayoutCustomBehaviorActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout_custom_behavior);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(TAG);

    }

    @OnClick(R.id.fab)
    public void fabClicked() {
        Snackbar.make(mainContainer, getString(R.string.custom_behavior_), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.coordinator_layout_behavior, menu);
        menu.getItem(0).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.defaultBehavior) {
            Intent intent = new Intent(CoordinatorLayoutCustomBehaviorActivity.this,
                    CoordinatorLayoutDefaultBehavior.class);
            startActivity(intent);
            finish();
        }
        return true;
    }
}
