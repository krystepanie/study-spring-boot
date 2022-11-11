package com.tutorial.music.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
public class ApplicationUserRequestDto {

    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String surname;
    @NotNull
    @Email
    private String email;
    @NotNull
    @NotBlank
    private String password;
    private String passwordConfirm;
    @NotEmpty
    private Set<String> roles;

}
