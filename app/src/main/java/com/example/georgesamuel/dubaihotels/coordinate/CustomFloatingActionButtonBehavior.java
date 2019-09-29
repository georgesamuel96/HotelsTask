package com.example.georgesamuel.dubaihotels.coordinate;


import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.snackbar.Snackbar;

public class CustomFloatingActionButtonBehavior extends CoordinatorLayout.Behavior <CustomFloatingActionButton>{


    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull CustomFloatingActionButton child, @NonNull View dependency) {
        if(dependency instanceof  Snackbar.SnackbarLayout) {
           child.setVisibility(View.GONE);
            return true;
        }
        return false;
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull CustomFloatingActionButton child, @NonNull View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public void onDependentViewRemoved(@NonNull CoordinatorLayout parent, @NonNull CustomFloatingActionButton child, @NonNull View dependency) {
        if(dependency instanceof  Snackbar.SnackbarLayout) {
            child.setVisibility(View.VISIBLE);
        }
    }
}
