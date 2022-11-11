package com.tutorial.music.service;

import com.tutorial.music.dto.ArtistRequestDto;
import com.tutorial.music.dto.ArtistResponseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ArtistService {
    ArtistResponseDto save(ArtistRequestDto artistRequestDto);

    @Transactional(readOnly = true)
    ArtistResponseDto findById(int artistId);

    ArtistResponseDto update(ArtistRequestDto artistRequestDto, Integer artistId);

    void deleteById(int artistId);

    @Transactional(readOnly = true)
    List<ArtistResponseDto> findByNameContaining(String name, int page, int size, String field);

    @Transactional(readOnly = true)
    List<ArtistResponseDto> findByYearStart(int yearStart);

    @Transactional(readOnly = true)
    List<ArtistResponseDto> findByYearStartBetween(int from, int to);

}
