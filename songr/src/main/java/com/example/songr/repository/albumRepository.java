package com.example.songr.repository;

import com.example.songr.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

//TODO: 4. make a repository interface for the data object
public interface albumRepository extends JpaRepository<Album, Long> {
    //TODO 5. MAGIC that we make happen with a function name
    public Album findByArtist(String artist);
    // default -> save(), delete(), update(), findAll()
}
