package com.example.georgesamuel.dubaihotels.coordinate;

import android.content.Context;
import android.util.AttributeSet;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

@CoordinatorLayout.DefaultBehavior(CustomFloatingActionButtonBehavior.class)
public class CustomFloatingActionButton extends FloatingActionButton {
    public CustomFloatingActionButton(Context context) { super(context); }

    public CustomFloatingActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomFloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}