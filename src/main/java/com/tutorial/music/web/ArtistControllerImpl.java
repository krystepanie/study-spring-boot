package com.tutorial.music.web;

import com.tutorial.music.dto.ArtistRequestDto;
import com.tutorial.music.dto.ArtistResponseDto;
import com.tutorial.music.service.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ArtistControllerImpl implements ArtistController {

    private final ArtistService artistService;

    public ArtistControllerImpl(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Override
    public ArtistResponseDto findById(Integer artistId) {
        return artistService.findById(artistId);
    }

    @Override
    public ResponseEntity<ArtistResponseDto> save(ArtistRequestDto artistRequestDto) {
        ArtistResponseDto created = artistService.save(artistRequestDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{artistId}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uri).body(created);
    }

    @Override
    public ResponseEntity<ArtistResponseDto> update(ArtistRequestDto artistRequestDto, Integer artistId) {
        return new ResponseEntity<>(artistService.update(artistRequestDto, artistId), HttpStatus.OK);
    }

    @Override
    public void delete(int artistId) {
        artistService.deleteById(artistId);
    }

    @Override
    public List<ArtistResponseDto> findByNameContaining(String name, int page, int size, String field) {
        return artistService.findByNameContaining(name, page, size, field);
    }

    @Override
    public List<ArtistResponseDto> findByYearStart(int yearStart) {
        return artistService.findByYearStart(yearStart);
    }

    @Override
    public List<ArtistResponseDto> findByYearStartBetween(int yearStartFrom, int yearStartTo) {
        return artistService.findByYearStartBetween(yearStartFrom, yearStartTo);
    }
}
