package com.ak.quizApp.service;

import com.ak.quizApp.Question;
import com.ak.quizApp.dto.QuestionInputDTO;

import java.util.List;

public interface QuestionService {

    List<Question> getAllQuestions();

    Question createQuestion(final QuestionInputDTO questionInputDTO);
}


