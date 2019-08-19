package com.example.georgesamuel.dubaihotels.materialDesign.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class CustomToggleButtonBehavior extends CoordinatorLayout.Behavior<FloatingActionButton>{

    public CustomToggleButtonBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull FloatingActionButton child, @NonNull View dependency) {
        return (dependency instanceof Snackbar.SnackbarLayout);
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull FloatingActionButton child, @NonNull View dependency) {
        if(dependency instanceof Snackbar.SnackbarLayout){
            child.animate().alpha(0).setDuration(100);
            return true;
        }
        return false;
    }

    @Override
    public void onDependentViewRemoved(@NonNull CoordinatorLayout parent, @NonNull FloatingActionButton child, @NonNull View dependency) {
        super.onDependentViewRemoved(parent, child, dependency);
        if(dependency instanceof  Snackbar.SnackbarLayout) {
            child.animate().alpha(1).setDuration(500);
        }
    }
}
