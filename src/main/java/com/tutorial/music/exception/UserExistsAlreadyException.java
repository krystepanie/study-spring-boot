package com.tutorial.music.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class UserExistsAlreadyException extends RuntimeException {

    private final String email;

    @Override
    public String getMessage() {
        return "User with mail " + email + " exists already";
    }
}
