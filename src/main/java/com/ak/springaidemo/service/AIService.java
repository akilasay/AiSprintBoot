package com.ak.springaidemo.service;

import com.ak.springaidemo.dto.movieDetails;
import org.springframework.ai.client.AiClient;
import org.springframework.ai.client.AiResponse;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    @Autowired
    AiClient aiClient;
    public String getJava(String topic){
        System.out.println("/java");
        PromptTemplate promptTemplate = new PromptTemplate("""
                Please act as a teacher and  create a question with the given {topic}? in java
               and give answers with beginner friendly and using small sentence.
               """);
        promptTemplate.add("topic", topic);
        promptTemplate.add("tone", "beginner");
        String text = this.aiClient.generate(promptTemplate.create()).getGeneration().getText();
        System.out.println(text);
        return text;

    }

    // generate output in the JSON format via Prompting
    public String getMovie(String category, String year){
        PromptTemplate promptTemplate = new PromptTemplate("""
                Please provide me best movie for the given {category} and the {year}.
                Please do provide a summary of the movie as well, the information should be 
                limited and not much in depth. Please provide the details in the JSON format
                containing this information : category, book, year, review, author, summary
                """);
        promptTemplate.add("category", category);
        promptTemplate.add("year", year);
        AiResponse generate = this.aiClient.generate(promptTemplate.create());
        return generate.getGeneration().getText();
    }

    // generate output in JSON format via mapping it to Dto
    public movieDetails getMoviesInJSON(String category, String year){
        BeanOutputParser<movieDetails> movieBeanOutputParser = new BeanOutputParser<>(movieDetails.class);
        PromptTemplate promptTemplate = new PromptTemplate("""
                Please provide me best movie for the given {category} and the {year}.
                Please do provide a summary of the movie as well, the information should be 
                limited and not much in depth. The response should be containing this information : 
                category, movie, year, review, director, summary
                {format}
                """);
        promptTemplate.add("category", category);
        promptTemplate.add("year", year);
        promptTemplate.add("format", movieBeanOutputParser.getFormat());
        promptTemplate.setOutputParser(movieBeanOutputParser);

        AiResponse response = aiClient.generate(promptTemplate.create());
        return movieBeanOutputParser.parse(response.getGeneration().getText());

    }
}
