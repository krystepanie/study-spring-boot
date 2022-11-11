package com.tutorial.music.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@JsonIgnoreProperties({ "password", "passwordConfirm" })
@EqualsAndHashCode(callSuper = true)
public class ApplicationUserResponseDto extends ApplicationUserRequestDto {

    private Integer id;
    private LocalDateTime created;

}
