package com.ak.springaidemo;

import com.ak.springaidemo.dto.movieDetails;
import com.ak.springaidemo.service.AIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AIController {

    @Autowired
    AIService aiService;

    private static final Logger logger = LoggerFactory.getLogger(AIController.class);

    @GetMapping("/")
    public String getMovie(@RequestParam String category, @RequestParam String year){
        return aiService.getMovie(category, year);
    }

    @GetMapping("/movieInJSON")
    public movieDetails getMoviesInJSON(@RequestParam String category, @RequestParam String year){
        return aiService.getMoviesInJSON(category, year);
    }

    @GetMapping("/java")
    public String getJava(@RequestParam String topic){
        logger.debug("Generating a question and the answer from {} ",topic);
        String response = aiService.getJava(topic);
        logger.debug(response);
        return response;
    }
}
