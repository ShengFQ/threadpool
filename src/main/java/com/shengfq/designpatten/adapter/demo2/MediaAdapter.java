package com.shengfq.designpatten.adapter.demo2;

public class MediaAdapter implements MediaPlayer {
    private MediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp3")) {
            advancedMusicPlayer = new Mp3Player();
        } else if (audioType.equalsIgnoreCase("wav")) {
            advancedMusicPlayer = new WavPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String fileName) {
        String fileExtension = getFileExtension(fileName);
        if (fileExtension != null) {
            if (fileExtension.equalsIgnoreCase("mp3") ||
                fileExtension.equalsIgnoreCase("wav") ||
                fileExtension.equalsIgnoreCase("mp4")) {
                advancedMusicPlayer.play(fileName);
            } else {
                System.out.println("Unsupported file format: " + fileExtension);
            }
        } else {
            System.out.println("Invalid file name.");
        }
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        return (dotIndex == -1) ? null : fileName.substring(dotIndex + 1);
    }
}
