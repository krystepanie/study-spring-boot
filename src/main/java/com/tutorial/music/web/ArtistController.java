package com.tutorial.music.web;

import com.tutorial.music.common.validation.ValidYear;
import com.tutorial.music.dto.ArtistRequestDto;
import com.tutorial.music.dto.ArtistResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

@PreAuthorize(value = "")
@RequestMapping(path = "/artists")
public interface ArtistController {

    @GetMapping(path = "/{artistId}")
    ArtistResponseDto findById(@PathVariable(name = "artistId") Integer artistId);

    @PostMapping
    ResponseEntity<ArtistResponseDto> save(@Valid @RequestBody ArtistRequestDto artistRequestDto);

    @PutMapping(path = "/{artistId}")
    ResponseEntity<ArtistResponseDto> update(
            @Valid @RequestBody ArtistRequestDto artistRequestDto,
            @PathVariable(name = "artistId") Integer artistId);

    @DeleteMapping("/{artistId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable(name = "artistId") int artistId);

    @GetMapping(path = "/by-name/{name}")
    List<ArtistResponseDto> findByNameContaining(
            @PathVariable(name = "name") String name,
            @RequestParam(name = "page") int page,
            @RequestParam(name = "size") int size,
            @RequestParam(name = "field") String field);

    @GetMapping(path = "/by-year/{yearStart}")
    List<ArtistResponseDto> findByYearStart(@Valid @ValidYear @PathVariable(name = "yearStart") int yearStart);


    @GetMapping(path = "/by-year/from/{yearStartFrom}/to/{yearStartTo}")
    List<ArtistResponseDto> findByYearStartBetween(
            @Valid @ValidYear @PathVariable(name = "yearStartFrom") int yearStartFrom,
            @Valid @ValidYear @PathVariable(name = "yearStartTo") int yearStartTo);

}
