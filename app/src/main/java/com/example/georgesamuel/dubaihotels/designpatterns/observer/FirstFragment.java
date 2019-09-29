package com.example.georgesamuel.dubaihotels.designpatterns.observer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.navigation.HomeFragmentArgs;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirstFragment extends Fragment implements Observer {

    @BindView(R.id.txt_title_first)
    TextView txtTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
        String args = HomeFragmentArgs.fromBundle(getArguments()).getArg();
        Log.e("args", args);
        return view;
    }

    @Override
    public void update(boolean checked) {
        if (checked) {
            txtTitle.setText("ON");
        } else {
            txtTitle.setText("OFF");
        }
    }

}