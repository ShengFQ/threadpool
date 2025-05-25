package com.shengfq.designpatten.adapter.demo2;

public class Mp4Player implements MediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}
