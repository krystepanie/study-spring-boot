package com.tutorial.music.exception;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = true)
public class ResourceNotFoundException extends RuntimeException {

    private Class<?> resourceClass;
    private Serializable resourceId;

    @Override
    public String getMessage() {
        return "Could not find " + resourceClass.getSimpleName() + " with id " + resourceId;
    }
}
