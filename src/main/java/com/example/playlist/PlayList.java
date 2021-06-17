package com.example.playlist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class PlayList {
    @Id
    @GeneratedValue
    private Long id;
    private String playListTitle;
    private String songTitle;

    public PlayList(String playListTitle, String songTitle) {
        this.playListTitle = playListTitle;
        this.songTitle = songTitle;
    }

    public PlayList() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayListTitle() {
        return playListTitle;
    }

    public void setPlayListTitle(String playListTitle) {
        this.playListTitle = playListTitle;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }
}
