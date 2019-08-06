package com.example.georgesamuel.dubaihotels.model.designPattern;

import com.example.georgesamuel.dubaihotels.interfaces.AdvancedMediaPlayer;

public class VLCPlayer implements AdvancedMediaPlayer {

    @Override
    public String playVLC() {
        return "VLC";
    }

    @Override
    public String playMP4() {
        return null;
    }
}
