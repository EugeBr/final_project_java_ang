package com.ironhack.final_project.controller.impl;

import com.ironhack.final_project.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api")
public class TweetController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/tweets")
    @ResponseStatus(HttpStatus.OK)
    public Tweet[] getTweets() {
        return restTemplate.getForObject("http://localhost:8083/api/tweets", Tweet[].class);
    };
}
