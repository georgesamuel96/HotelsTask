package com.example.georgesamuel.dubaihotels.designPatterns.adapter;

import com.example.georgesamuel.dubaihotels.designPatterns.interfaces.AdvancedMediaPlayer;
import com.example.georgesamuel.dubaihotels.designPatterns.interfaces.MediaPlayer;
import com.example.georgesamuel.dubaihotels.designPatterns.model.MP4Player;
import com.example.georgesamuel.dubaihotels.designPatterns.model.VLCPlayer;

public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String type){
        if(type.equals("VLC"))
            advancedMediaPlayer = new VLCPlayer();
        else
            advancedMediaPlayer = new MP4Player();
    }

    @Override
    public String play(String audioType) {
        if(audioType.equals("VLC")){
            return advancedMediaPlayer.playVLC();
       }
        else{
            return advancedMediaPlayer.playMP4();
        }
    }
}
