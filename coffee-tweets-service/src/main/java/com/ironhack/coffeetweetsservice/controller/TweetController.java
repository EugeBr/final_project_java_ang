package com.ironhack.coffeetweetsservice.controller;

import com.ironhack.coffeetweetsservice.model.Tweet;
import com.ironhack.coffeetweetsservice.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TweetController {

    @Autowired
    TweetRepository tweetRepository;

    @GetMapping("/tweets")
    @ResponseStatus(HttpStatus.OK)
    public List<Tweet> getTweets() {
      return tweetRepository.findAll();
    };
}
