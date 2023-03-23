package com.example.assigment_hoandmph27404.DTO;

import java.io.Serializable;

public class Bxhmusic implements Serializable {
    String song;
    String Singer;
    int picture;
    int file;

    public Bxhmusic(String song, String singer, int picture,int file) {
        this.song = song;
        Singer = singer;
        this.picture = picture;
        this.file=file;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return Singer;
    }

    public void setSinger(String singer) {
        Singer = singer;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

}
