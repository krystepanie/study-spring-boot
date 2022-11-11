package com.tutorial.music.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@SuperBuilder
public class ArtistResponseDto extends ArtistRequestDto {

    private Integer id;

}
