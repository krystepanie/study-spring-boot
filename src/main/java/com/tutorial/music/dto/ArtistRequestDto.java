package com.tutorial.music.dto;

import com.tutorial.music.common.validation.ValidYear;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@SuperBuilder
public class ArtistRequestDto {

    @NotBlank
    private String name;
    @NotBlank
    private String nationality;
    @ValidYear
    private int yearStart;
}
