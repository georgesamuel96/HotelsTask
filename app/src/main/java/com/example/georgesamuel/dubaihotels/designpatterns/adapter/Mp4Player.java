package com.example.georgesamuel.dubaihotels.designpatterns.adapter;

import android.util.Log;

public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        Log.e("mp4Player","Playing mp4 file. Name: "+ fileName);
    }
}
