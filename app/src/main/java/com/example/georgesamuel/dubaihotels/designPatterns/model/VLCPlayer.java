package com.example.georgesamuel.dubaihotels.designPatterns.model;

import com.example.georgesamuel.dubaihotels.designPatterns.interfaces.AdvancedMediaPlayer;

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
