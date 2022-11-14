package com.tutorial.music.repository;

import com.tutorial.music.document.Wish;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface WishRepository extends MongoRepository<Wish, String> {

    @Query("{category: ?0}")
    List<Wish> findWishesByCategory(String category);

}
