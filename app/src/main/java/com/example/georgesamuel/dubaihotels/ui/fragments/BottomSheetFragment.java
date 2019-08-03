package com.example.georgesamuel.dubaihotels.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.georgesamuel.dubaihotels.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomSheetFragment extends BottomSheetDialogFragment  {

    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.close_imageview)
    ImageView closeImageview;

    public BottomSheetFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);
        ButterKnife.bind(this, view);

        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav1:
                    showMessage(getString(R.string.action_favorite));
                    break;
                case R.id.nav2:
                    showMessage(getString(R.string.action_search));
                    break;
                case R.id.nav3:
                    showMessage(getString(R.string.setting));
                    break;
            }
            return true;
        });
        return view;
    }

    private void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.close_imageview)
    public void onCloseBtnClickedClicked() {

    }
}
