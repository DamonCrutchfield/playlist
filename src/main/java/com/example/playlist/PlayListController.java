package com.example.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="api/playlist")
public class PlayListController {

    private final PlayListService playListService;

    @Autowired
    public PlayListController(PlayListService playListService) {
        this.playListService = playListService;
    }

    @GetMapping
    public List<PlayList> getAllSongs() {
        return playListService.getPlayList();
    }

    @PostMapping
    public void saveToPlaylist(@RequestBody PlayList song) {
        playListService.addSong(song);
    }

    @DeleteMapping(path="{songNumber}")
    public void removeSong(@PathVariable("songNumber") Long songNumber) {
        playListService.deleteSong(songNumber);
    }

    @PutMapping(path="{songNumber}")
    public void updatePlayList(@PathVariable("songNumber") Long songNumber, @RequestParam(required = false) String playListTitle, @RequestParam(required = false) String songTitle) {
        playListService.updatePlayList(songNumber, playListTitle, songTitle);
    }
}

