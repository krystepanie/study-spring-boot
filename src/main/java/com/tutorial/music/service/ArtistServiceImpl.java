package com.tutorial.music.service;

import com.tutorial.music.dto.ArtistRequestDto;
import com.tutorial.music.dto.ArtistResponseDto;
import com.tutorial.music.exception.ResourceNotFoundException;
import com.tutorial.music.mapping.ArtistMapper;
import com.tutorial.music.model.Artist;
import com.tutorial.music.repository.ArtistRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements ArtistService {

    ArtistRepository artistRepository;
    ArtistMapper artistMapper;

    public ArtistServiceImpl(
            ArtistRepository artistRepository,
            ArtistMapper artistMapper) {
        this.artistRepository = artistRepository;
        this.artistMapper = artistMapper;
    }

    @Transactional
    public ArtistResponseDto save(ArtistRequestDto artistRequestDto) {
        Artist artist = artistMapper.fromRequest(artistRequestDto);
        artistRepository.save(artist);
        return artistMapper.toResponse(artist);
    }

    @Override
    public ArtistResponseDto findById(int artistId) {
        Artist artist = artistRepository.findById(artistId).orElseThrow(() -> new ResourceNotFoundException(Artist.class, artistId));
        return artistMapper.toResponse(artist);
    }

    @Override
    public ArtistResponseDto update(
            ArtistRequestDto artistRequestDto,
            Integer artistId) {
        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new ResourceNotFoundException(Artist.class, artistId));
        artist.setName(artistRequestDto.getName());
        artist.setNationality(artistRequestDto.getNationality());
        artist.setYearStart(artistRequestDto.getYearStart());

        artistRepository.save(artist);

        return artistMapper.toResponse(artist);
    }

    @Override
    public void deleteById(int artistId) {
        artistRepository.deleteById(artistId);
    }

    @Override
    public List<ArtistResponseDto> findByNameContaining(String name, int page, int size, String field) {
        PageRequest pagination = PageRequest.of(page, size, Sort.by(field).ascending());
        return artistRepository.findByNameContainingIgnoreCase(name, pagination).stream()
                .map(artistMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArtistResponseDto> findByYearStart(int yearStart) {
        return artistRepository.findByYearStart(yearStart).stream()
                .map(artistMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArtistResponseDto> findByYearStartBetween(int from, int to) {
        return artistRepository.findByYearStartBetweenOrderByYearStartAsc(from, to).stream()
                .map(artistMapper::toResponse)
                .collect(Collectors.toList());
    }
}
