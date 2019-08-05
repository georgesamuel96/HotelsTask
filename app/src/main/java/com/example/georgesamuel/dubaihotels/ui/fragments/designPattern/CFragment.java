package com.example.georgesamuel.dubaihotels.ui.fragments.designPattern;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.interfaces.Observer;
import com.example.georgesamuel.dubaihotels.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends Fragment implements Subject {

    @BindView(R.id.btnToggle)
    ToggleButton btnToggle;
    private List<Observer> observers;
    AFragment fragmentA = new AFragment();
    BFragment fragmentB = new BFragment();

    public CFragment() {
        observers = new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c, container, false);
        ButterKnife.bind(this, view);

        getChildFragmentManager().beginTransaction().replace(R.id.frame1, fragmentA).commit();
        getChildFragmentManager().beginTransaction().replace(R.id.frame2, fragmentB).commit();

        return view;
    }

    @Override
    public void register(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (final Observer observer : observers) {
            observer.update(btnToggle.isChecked());
        }
    }

    @OnClick(R.id.btnToggle)
    public void onBtnToggleClicked() {
        notifyObservers();
    }
}
