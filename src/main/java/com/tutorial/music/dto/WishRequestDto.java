package com.tutorial.music.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
public class WishRequestDto {

    private String title;
    private String description;
    private String category;
    private Set<String> tags;

}
