package com.shengfq.designpatten.adapter.demo2;

public class WavPlayer implements MediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing WAV file: " + fileName);
    }
}
