package com.example.georgesamuel.dubaihotels.ui.activities.materialComponent;

import android.os.Bundle;
import android.text.Editable;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.georgesamuel.dubaihotels.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChipsActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.chip)
    Chip chipDefault;
    @BindView(R.id.chip_entry)
    Chip chipEntry;
    @BindView(R.id.singleChips)
    ChipGroup singleChips;
    @BindView(R.id.btnShowChips)
    AppCompatButton btnShowChips;
    @BindView(R.id.multiChips)
    ChipGroup multiChips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chips);
        ButterKnife.bind(this);

        chipDefault.setOnClickListener(this);
        chipEntry.setOnCloseIconClickListener(view -> chipEntry.setChecked(false));
        btnShowChips.setOnClickListener(this);
        addChipDynamic();
    }

    private void addChipDynamic() {
        Chip chip = new Chip(ChipsActivity.this);
        chip.setText(R.string.dynamic_check);
        chip.setClickable(true);
        chip.setCheckable(true);
        singleChips.addView(chip);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chip:
                Toast.makeText(ChipsActivity.this, R.string.chip_clicked, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnShowChips: {
                int checked = singleChips.getCheckedChipId();
                Chip checkChip = findViewById(checked);
                Toast.makeText(ChipsActivity.this, checkChip.getText(), Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
