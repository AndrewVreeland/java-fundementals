package com.example.songr.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//TODO: 1. add @Entity annotation to data model
@Entity
public class Album {
//TODO: 2. add @Id and @GeneratedValue annotations
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    // properties
    private String title;
    private String artist;
    private int songCount;
    private int length;
    private int lengthInSeconds;

    private String imageUrl;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    List<Song> songs;

    //TODO: 3. create protected default constructor
    //constructor

    protected Album() {}

    public Album(String title, String artist, int songCount, int lengthInSeconds, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.lengthInSeconds = lengthInSeconds;
        this.imageUrl = imageUrl;
    }
    public Album(long id, String title, String artist, String imageUrl) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.imageUrl = imageUrl;
        this.songs = new ArrayList<>();
        this.songCount = this.songs.size();
        calculateAlbumLength();
    }

    public Album(String title, String artist, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.imageUrl = imageUrl;
        this.songs = new ArrayList<>();
        this.songCount = this.songs.size();
        calculateAlbumLength();
    }

    // methods
    public void calculateAlbumLength() {
        int total = 0;
        for(Song track : this.songs) {
            total += track.length;
        }
        this.length = total;
    }


    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", songCount=" + songCount +
                ", lengthInSeconds=" + lengthInSeconds +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }


    // getters and setters

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }
    public void addSong(Song song) {
        song.setAlbum(this);
        songs.add(song);
        this.songCount = this.songs.size();
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}

/*
@Entity
@Id
@GeneratedValue
@Autowired

 */
