package com.example.assigment_hoandmph27404.DTO;

import java.io.Serializable;

public class Song implements Serializable {
    private int songID;
    private String path;
    private String songTitle;
    private String duration;

    public Song( String path, String songTitle, String duration) {
        this.path = path;
        this.songTitle = songTitle;
        this.duration = duration;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getPath() {
        return path;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

}
