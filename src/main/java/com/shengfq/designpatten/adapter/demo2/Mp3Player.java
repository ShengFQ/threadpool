package com.shengfq.designpatten.adapter.demo2;

public class Mp3Player implements MediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing MP3 file: " + fileName);
    }
}
