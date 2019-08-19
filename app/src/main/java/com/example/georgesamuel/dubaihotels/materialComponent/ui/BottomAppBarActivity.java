package com.example.georgesamuel.dubaihotels.materialComponent.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.georgesamuel.dubaihotels.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BottomAppBarActivity extends AppCompatActivity {


    @BindView(R.id.bar)
    BottomAppBar bar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.radioType)
    RadioGroup radioType;
    private boolean isFabEnd = false;
    private boolean isScale = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_app_bar);
        ButterKnife.bind(this);

        setSupportActionBar(bar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_appbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorite:
                showMessage(getString(R.string.action_favorite));
                break;
            case R.id.search:
                showMessage(getString(R.string.action_search));
                break;
            case R.id.setting:
                showMessage(getString(R.string.setting));
                break;
            case android.R.id.home:
                showNavigationMenu();
                break;
        }
        return true;
    }

    private void showNavigationMenu() {
        BottomSheetFragment fragment = new BottomSheetFragment();
        fragment.show(getSupportFragmentManager(), fragment.getTag());
    }

    private void showMessage(String message) {
        Toast.makeText(BottomAppBarActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn)
    public void onBtnClicked() {
        if (!isFabEnd) {
            isFabEnd = true;
            bar.setNavigationIcon(null);
            getFabAnimation();
            bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
            bar.replaceMenu(R.menu.bottomappbar_menu_secondary);
            fab.setImageDrawable(getDrawable(R.drawable.ic_replay_white));
        } else {
            isFabEnd = false;
            getFabAnimation();
            bar.setNavigationIcon(getDrawable(R.drawable.ic_drawer_menu_24px));
            bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
            bar.replaceMenu(R.menu.bottomappbar_menu_primary);
            fab.setImageDrawable(getDrawable(R.drawable.ic_add));
        }
    }

    private void getFabAnimation() {
        int selectedId = radioType.getCheckedRadioButtonId();
        RadioButton radioButtonType = findViewById(selectedId);
        isScale = (radioButtonType.getText().equals(getString(R.string.scale))? true: false);
        if(isScale){
            bar.setFabAnimationMode(BottomAppBar.FAB_ANIMATION_MODE_SCALE);
        }
        else{
            bar.setFabAnimationMode(BottomAppBar.FAB_ANIMATION_MODE_SLIDE);
        }
    }

    @OnClick(R.id.fab)
    public void onFabClicked() {
        displaySnackBar();
    }

    private void displaySnackBar() {
        int marginSide = 0;
        int marginBottom = 550;
        Snackbar snackbar = Snackbar.make(coordinatorLayout, getString(R.string.message), Snackbar.LENGTH_LONG);
        View snackbarView = snackbar.getView();
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) snackbarView.getLayoutParams();
        params.setMargins(
                params.leftMargin + marginSide,
                params.topMargin,
                params.rightMargin + marginSide,
                params.bottomMargin + marginBottom
        );
        snackbarView.setLayoutParams(params);
        snackbar.show();
    }
}
