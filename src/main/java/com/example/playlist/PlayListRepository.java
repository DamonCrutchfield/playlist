package com.example.playlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayListRepository extends JpaRepository<PlayList, Long> {
    @Query("SELECT s FROM PlayList s WHERE s.songTitle=?1")
    Optional<PlayList> findSongByName(String songTitle);
}
