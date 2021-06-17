package com.example.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlayListService {
    private final PlayListRepository playListRepository;

    @Autowired
    public PlayListService(PlayListRepository playListRepository) {
        this.playListRepository = playListRepository;
    }

    public List<PlayList> getPlayList() {
        return playListRepository.findAll();
    }

    public void addSong(PlayList song) {
        Optional<PlayList> playListOptional = playListRepository.findSongByName(song.getSongTitle());
        if (playListOptional.isPresent()) {
            throw new IllegalStateException("Song already exists");
        }
        playListRepository.save(song);
    }

    public void deleteSong(Long songNumber) {
        if (playListRepository.existsById(songNumber)) {
            playListRepository.deleteById(songNumber);
        } else {
            throw new IllegalStateException("Song not found");
        }
    }

    @Transactional
    public void updatePlayList(Long songNumber, String playListTitle, String songTitle) {

        PlayList playList = playListRepository.findById(songNumber).orElseThrow(() -> new IllegalStateException("Song not found"));
        if (!Objects.equals(playList.getPlayListTitle(), playListTitle) && playListTitle != null) {
            playList.setPlayListTitle(playListTitle);
        } else {
            throw new IllegalStateException("Play list not found");
        }

        Optional<PlayList> playlistOptional = playListRepository.findSongByName(playList.getSongTitle());
        if (!playlistOptional.isPresent() && songTitle != null) {
            playList.setSongTitle(songTitle);
        } else {
            throw new IllegalStateException("Song title not found");
        }
    }
}
