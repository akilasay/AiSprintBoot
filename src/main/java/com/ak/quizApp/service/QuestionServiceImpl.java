package com.ak.quizApp.service;

import com.ak.quizApp.Question;
import com.ak.quizApp.dto.QuestionInputDTO;
import com.ak.quizApp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDao questionDao;
    @Override
    public List<Question> getAllQuestions() {

        final List<Question> questions = questionDao.findAll();
        return questions;
    }

    @Override
    public Question createQuestion(final QuestionInputDTO questionInputDTO) {
        final Question question = new Question(questionInputDTO.getQuestionTitle(),questionInputDTO.getOption1(),
                questionInputDTO.getOption2(),questionInputDTO.getOption3(), questionInputDTO.getOption4());

        return questionDao.save(question);
    }

}
