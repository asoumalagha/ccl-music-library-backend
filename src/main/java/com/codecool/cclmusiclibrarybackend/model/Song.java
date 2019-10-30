package com.codecool.cclmusiclibrarybackend.model;

public class Song {

    private String title;
    private String album;
    private String performer;
    private double length;

    public Song(String title, String album, String performer, double length) {
        this.title = title;
        this.album = album;
        this.performer = performer;
        this.length = length;
    }

    public Song() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

    public String getPerformer() {
        return performer;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", performer='" + performer + '\'' +
                ", length=" + length +
                '}';
    }
}
