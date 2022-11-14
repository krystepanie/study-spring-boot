package com.tutorial.music.service;

import com.tutorial.music.dto.WishResponseDto;

import java.util.List;

public interface WishService {

    List<WishResponseDto> findByCategory(String category);

}
