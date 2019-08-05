package com.example.georgesamuel.dubaihotels.designpatterns.observer;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

import com.example.georgesamuel.dubaihotels.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ThirdFragment extends Fragment implements Subject {

    private List<Observer> observers = new ArrayList<>();
    @BindView(R.id.toggleBtn)
    ToggleButton toggleBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(toggleBtn.isChecked());
        }
    }

    @OnClick(R.id.toggleBtn)
    public void changeState(View view) {
        notifyObservers();
    }
}
