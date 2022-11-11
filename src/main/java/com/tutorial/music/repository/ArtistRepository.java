package com.tutorial.music.repository;

import com.tutorial.music.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

    Page<Artist> findByNameContainingIgnoreCase(String name, Pageable pageable);

    List<Artist> findByYearStart(int yearStart);

    List<Artist> findByYearStartBetweenOrderByYearStartAsc(int from, int to);

}
