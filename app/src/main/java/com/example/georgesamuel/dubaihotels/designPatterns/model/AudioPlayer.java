package com.example.georgesamuel.dubaihotels.designPatterns.model;

import com.example.georgesamuel.dubaihotels.designPatterns.adapter.MediaAdapter;
import com.example.georgesamuel.dubaihotels.designPatterns.interfaces.MediaPlayer;

public class AudioPlayer implements MediaPlayer {

    private MediaAdapter adapter;

    @Override
    public String play(String audioType) {
        if(audioType.equals("MP3"))
            return "MP3";
        else if(audioType.equals("VLC") || audioType.equals("MP4")){
            adapter = new MediaAdapter(audioType);
            return adapter.play(audioType);
        }
        else
            return "Error format";
    }
}
