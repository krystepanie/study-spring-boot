package com.tutorial.music.repository;

import com.tutorial.music.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

    @Query(value = "select sum(t.durationInSeconds) from Track t where t.album.id = :albumId")
    int totalDurationByAlbum(int albumId);

}
