package com.example.georgesamuel.dubaihotels.component;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.georgesamuel.dubaihotels.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MaterialBottomSheetActivity extends AppCompatActivity {

     @BindView(R.id.bottom_sheet_standard)
     LinearLayout bottomSheetStandard;
     @BindView(R.id.button_open_modal_bottom_sheet)
     Button btnOpenModalBottomSheet;

    private BottomSheetBehavior bottomSheetBehavior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_bottom_sheet);
        ButterKnife.bind(this);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetStandard);
       // set the peek height
          bottomSheetBehavior.setPeekHeight(46);

    }
@OnClick(R.id.button_open_modal_bottom_sheet)
    public void modalOnClick(View view){
    AddBottomDialogFragment addBottomDialogFragment =
            AddBottomDialogFragment.newInstance();
    addBottomDialogFragment.show(getSupportFragmentManager(),
            "add_photo_dialog_fragment");
}


}
