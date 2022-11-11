package com.tutorial.music.web;

import com.tutorial.music.dto.ApplicationUserRequestDto;
import com.tutorial.music.dto.ApplicationUserResponseDto;
import com.tutorial.music.service.ApplicationUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class ApplicationUserControllerImpl implements ApplicationUserController {

    private final ApplicationUserService applicationUserService;

    public ApplicationUserControllerImpl(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @Override
    public ResponseEntity<ApplicationUserResponseDto> save(
            ApplicationUserRequestDto requestDto) {
        ApplicationUserResponseDto created = applicationUserService.save(requestDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{applicationUserId}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uri).body(created);
    }

    @Override
    public ResponseEntity<ApplicationUserResponseDto> findById(Integer id) {
        return new ResponseEntity<>(applicationUserService.findById(id), HttpStatus.OK);
    }
}
