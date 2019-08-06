package com.example.georgesamuel.dubaihotels.model.designPattern;

import com.example.georgesamuel.dubaihotels.adapter.MediaAdapter;
import com.example.georgesamuel.dubaihotels.interfaces.MediaPlayer;

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
