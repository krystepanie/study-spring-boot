package com.tutorial.music.repository;

import com.tutorial.music.model.Album;
import com.tutorial.music.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    List<Album> findByArtist(Artist artist);

}
