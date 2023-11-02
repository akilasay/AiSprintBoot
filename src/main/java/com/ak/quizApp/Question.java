package com.ak.quizApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public Question() {}
    public Question(String questionTitle, String option1, String option2, String option3, String option4) {
        super();
        this.questionTitle=questionTitle;
        this.option1=option1;
        this.option2=option2;
        this.option3=option3;
        this.option4=option4;

    }
}
