package com.tutorial.music.service;

import com.tutorial.music.dto.ApplicationUserRequestDto;
import com.tutorial.music.dto.ApplicationUserResponseDto;

public interface ApplicationUserService {

    ApplicationUserResponseDto save(ApplicationUserRequestDto requestDto);

    ApplicationUserResponseDto findById(Integer id);

}
