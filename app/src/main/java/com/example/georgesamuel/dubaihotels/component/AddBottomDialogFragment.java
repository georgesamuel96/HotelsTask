package com.example.georgesamuel.dubaihotels.component;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.georgesamuel.dubaihotels.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddBottomDialogFragment extends BottomSheetDialogFragment {

    public static AddBottomDialogFragment newInstance() {
        return new AddBottomDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bottom_sheet_modal, container,
                false);

        // get the views and attach the listener

        return view;

    }
}
