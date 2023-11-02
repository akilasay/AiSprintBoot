package com.ak.quizApp.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class QuestionInputDTO {

    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    @JsonCreator
    public QuestionInputDTO( @JsonProperty("questionTitle") String questionTitle,@JsonProperty("option1") String option1,@JsonProperty("option2") String option2,
                             @JsonProperty("option3") String option3,@JsonProperty("option4") String option4) {
        super();
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
