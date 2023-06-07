package com.ironhack.coffeetweetsservice.repository;

import com.ironhack.coffeetweetsservice.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {
}
