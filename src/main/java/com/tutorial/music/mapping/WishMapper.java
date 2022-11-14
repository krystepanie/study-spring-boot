package com.tutorial.music.mapping;

import com.tutorial.music.document.Wish;
import com.tutorial.music.dto.WishRequestDto;
import com.tutorial.music.dto.WishResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WishMapper {

    Wish fromRequest(WishRequestDto requestDto);

    WishResponseDto toResponse(Wish wish);

}
