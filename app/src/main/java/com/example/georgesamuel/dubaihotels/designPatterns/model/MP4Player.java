package com.example.georgesamuel.dubaihotels.designPatterns.model;

import com.example.georgesamuel.dubaihotels.designPatterns.interfaces.AdvancedMediaPlayer;

public class MP4Player implements AdvancedMediaPlayer {
    @Override
    public String playVLC() {
        return null;
    }

    @Override
    public String playMP4() {
        return "MP4";
    }
}
