package com.tutorial.music.mapping;

import com.tutorial.music.dto.ArtistRequestDto;
import com.tutorial.music.dto.ArtistResponseDto;
import com.tutorial.music.model.Artist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

    Artist fromRequest(ArtistRequestDto requestDto);

    Artist fromResponse(ArtistResponseDto responseDto);

    ArtistResponseDto toResponse(Artist artist);

}
