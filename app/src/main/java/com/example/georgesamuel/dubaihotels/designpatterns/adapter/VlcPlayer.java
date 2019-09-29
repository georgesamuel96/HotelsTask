package com.example.georgesamuel.dubaihotels.designpatterns.adapter;

import android.util.Log;

public class VlcPlayer  implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        Log.e("vlc","Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
