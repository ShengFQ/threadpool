package com.shengfq.designpatten.adapter.demo2;

public class MainApp {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("song.mp3");      // Playing MP3 file: song.mp3
        audioPlayer.play("sound.wav");     // Playing WAV file: sound.wav
        audioPlayer.play("video.mp4");     // Playing MP4 file: video.mp4
        audioPlayer.play("document.txt");  // Unsupported file format: txt
    }
}
