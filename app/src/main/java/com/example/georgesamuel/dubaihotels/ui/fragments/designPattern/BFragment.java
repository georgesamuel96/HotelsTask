package com.example.georgesamuel.dubaihotels.ui.fragments.designPattern;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.interfaces.Observer;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment implements Observer {


    @BindView(R.id.tv)
    TextView tv;

    public BFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void update(boolean checked) {
        if (checked) {
            //tv.setText("ON");
            Log.d("Fragment B", "update: ON");
        } else {
            //tv.setText("OFF");
            Log.d("Fragment B", "update: OFF");
        }
    }
}
