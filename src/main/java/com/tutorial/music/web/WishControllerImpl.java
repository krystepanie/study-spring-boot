package com.tutorial.music.web;

import com.tutorial.music.dto.WishResponseDto;
import com.tutorial.music.service.WishService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WishControllerImpl implements WishController {

    public WishControllerImpl(WishService wishService) {
        this.wishService = wishService;
    }

    private final WishService wishService;

    @Override
    public List<WishResponseDto> findByCategory(String category) {
        return wishService.findByCategory(category);
    }
}
