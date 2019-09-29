package com.example.georgesamuel.dubaihotels.designpatterns;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.designpatterns.adapter.AudioPlayer;
import com.example.georgesamuel.dubaihotels.designpatterns.builder.User;
import com.example.georgesamuel.dubaihotels.designpatterns.factory.Wheel;
import com.example.georgesamuel.dubaihotels.designpatterns.factory.WheelFactory;
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
        //singleton pattern
        SingletonClass singletonClass=SingletonClass.getInstance();

        //Observer Pattern
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

        //Builder Pattern
        new User.Builder()
                .setFirstName("Al Shaymaa")
                .setLastName("Mohamed")
                .setAge(67)
                .create();

        //Factory Pattern
        Wheel carWheel = WheelFactory.getWheel("Carwheel", 15, 215);
        Wheel bikeWheel = WheelFactory.getWheel("Bikewheel", 18, 245);

        Log.e("carWheel","Car wheel specifications:" + carWheel);
        Log.e("bikeWheel","Car wheel specifications:" + bikeWheel);

        //Adapter Pattern
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thirdFragment.unregisterObserver(secondFragment);
        thirdFragment.unregisterObserver(firstFragment);
    }
}
