package com.example.georgesamuel.dubaihotels.designpatterns.observer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.georgesamuel.dubaihotels.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondFragment extends Fragment implements Observer {

    @BindView(R.id.txt_title)
    TextView txtTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        ButterKnife.bind(this, view);
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
