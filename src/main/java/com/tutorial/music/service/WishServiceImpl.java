package com.tutorial.music.service;

import com.tutorial.music.dto.WishResponseDto;
import com.tutorial.music.mapping.WishMapper;
import com.tutorial.music.repository.WishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishServiceImpl implements WishService {

    private final WishRepository wishRepository;
    private final WishMapper wishMapper;

    public WishServiceImpl(WishRepository wishRepository, WishMapper wishMapper) {
        this.wishRepository = wishRepository;
        this.wishMapper = wishMapper;
    }

    @Override
    public List<WishResponseDto> findByCategory(String category) {
        return wishRepository.findWishesByCategory(category).stream()
                .map(wishMapper::toResponse)
                .collect(Collectors.toList());
    }
}
