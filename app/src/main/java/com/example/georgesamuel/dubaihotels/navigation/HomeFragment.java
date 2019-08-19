package com.example.georgesamuel.dubaihotels.navigation;

import android.app.PendingIntent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDeepLinkBuilder;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.georgesamuel.dubaihotels.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class HomeFragment extends Fragment {

    @BindView(R.id.navigate_destination_button)
    Button navigateButton;

    @BindView(R.id.navigate_action_button)
    Button actionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.navigate_destination_button)
     void navigateDestination(View view){
        Bundle bundle=new Bundle();
        bundle.putString("arg","shaymaa");

        PendingIntent pendingIntent = new NavDeepLinkBuilder(getContext())
                .setGraph(R.navigation.mobile_navigation)
                .setDestination(R.id.firstFragment)
                .setArguments(bundle)
                .createPendingIntent();
        Navigation.findNavController(view).navigate(R.id.action_from_home_to_first,bundle);
    }

    @OnClick(R.id.navigate_action_button)
    void navigateAction(View view){
        Bundle bundle=new Bundle();
        bundle.putString("arg","shaymaa");
        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_secondFragment,bundle);
    }
}
