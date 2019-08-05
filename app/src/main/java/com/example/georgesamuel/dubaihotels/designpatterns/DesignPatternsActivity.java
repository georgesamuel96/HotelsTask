package com.example.georgesamuel.dubaihotels.designpatterns;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.designpatterns.builder.User;
import com.example.georgesamuel.dubaihotels.designpatterns.observer.FirstFragment;
import com.example.georgesamuel.dubaihotels.designpatterns.observer.SecondFragment;
import com.example.georgesamuel.dubaihotels.designpatterns.observer.ThirdFragment;
import com.example.georgesamuel.dubaihotels.designpatterns.singleton.SingletonClass;

public class DesignPatternsActivity extends AppCompatActivity {

    private ThirdFragment thirdFragment;
    private  SecondFragment secondFragment;
    private FirstFragment firstFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_patterns);
        //example on singleton
        SingletonClass singletonClass=SingletonClass.getInstance();
        thirdFragment = new ThirdFragment();
        secondFragment = new SecondFragment();
        firstFragment = new FirstFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_parent, thirdFragment,"third");
        transaction.add(R.id.fragment_parent, secondFragment,"second");
        transaction.add(R.id.fragment_parent, firstFragment,"first");
        transaction.commit();
        thirdFragment.registerObserver(secondFragment);
        thirdFragment.registerObserver(firstFragment);
        new User.Builder()
                .setFirstName("Leonardo")
                .setLastName("da Vinci")
                .setAge(67)
                .create();    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thirdFragment.unregisterObserver(secondFragment);
        thirdFragment.unregisterObserver(firstFragment);
    }
}
