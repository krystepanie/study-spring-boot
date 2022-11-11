package com.tutorial.music.web;

import com.tutorial.music.dto.ApplicationUserRequestDto;
import com.tutorial.music.dto.ApplicationUserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/application-user")
public interface ApplicationUserController {

    @PostMapping
    ResponseEntity<ApplicationUserResponseDto> save(
            @Valid @RequestBody ApplicationUserRequestDto requestDto);

    @GetMapping(path = "/{applicationUserId}")
    ResponseEntity<ApplicationUserResponseDto> findById(@PathVariable(name = "applicationUserId") Integer id);

}
