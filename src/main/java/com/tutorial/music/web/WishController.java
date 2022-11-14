package com.tutorial.music.web;

import com.tutorial.music.dto.WishResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/wish")
public interface WishController {

    @GetMapping(path = "/by-category/{category}")
    List<WishResponseDto> findByCategory(@PathVariable(name = "category") String category);

}
