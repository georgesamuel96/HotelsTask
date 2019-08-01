package com.example.georgesamuel.dubaihotels.component;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.georgesamuel.dubaihotels.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MaterialComponentActivity extends AppCompatActivity {


    @BindView(R.id.bottom_sheet_layout)
    LinearLayoutCompat bottomSheetLayout;

    @BindView(R.id.bottom_fab)
    FloatingActionButton fab;

    private BottomSheetBehavior bottomSheetBehavior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_component);
        ButterKnife.bind(this);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
       // bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        //bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        //bottomSheetBehavior.setState(BottomSheetBehavior.STATE_DRAGGING);
       // bottomSheetBehavior.setState(BottomSheetBehavior.STATE_SETTLING);

       // set the peek height
        bottomSheetBehavior.setPeekHeight(340);

//
//        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//            @Override
//            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//
//                Toast.makeText(MaterialComponentActivity.this, "State Changed", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//
//            }
//        });

    }
@OnClick(R.id.bottom_fab)
    public void fabOnClick(View view){
    if (bottomSheetBehavior.getState()==bottomSheetBehavior.STATE_HIDDEN) {

        bottomSheetBehavior.setState(bottomSheetBehavior.STATE_COLLAPSED);
    }
}

}
