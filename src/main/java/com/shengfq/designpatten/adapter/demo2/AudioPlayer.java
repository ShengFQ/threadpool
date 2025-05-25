package com.shengfq.designpatten.adapter.demo2;

public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String fileName) {
        String fileExtension = getFileExtension(fileName);

        if (fileExtension == null) {
            System.out.println("Invalid file name.");
            return;
        }

        switch (fileExtension.toLowerCase()) {
            case "mp3":
                mediaAdapter = new MediaAdapter("mp3");
                break;
            case "wav":
                mediaAdapter = new MediaAdapter("wav");
                break;
            case "mp4":
                mediaAdapter = new MediaAdapter("mp4");
                break;
            default:
                System.out.println("Unsupported file format: " + fileExtension);
                return;
        }

        mediaAdapter.play(fileName);
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        return (dotIndex == -1) ? null : fileName.substring(dotIndex + 1);
    }
}
