package com.example.music;

public class song {
    private int songId;
    private String songTitle;
    private String songArtist;

    public song(int songId, String songTitle, String songArtist) {
        this.songId = songId;
        this.songTitle = songTitle;
        this.songArtist = songArtist;
    }

    public int getSongId() {
        return songId;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getSongArtist() {
        return songArtist;
    }
}
