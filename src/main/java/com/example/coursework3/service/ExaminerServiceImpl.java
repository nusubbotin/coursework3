package com.example.coursework3.service;

import com.example.coursework3.model.Question;
import com.example.coursework3.exception.UnCorrectAmountQuestionException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionSet = new HashSet<>();
        if (questionService.getAll().size() < amount) {
            throw new UnCorrectAmountQuestionException();

        }

        while (questionSet.size() < amount){
            questionSet.add(questionService.getRandomQuestion());
        }
        return questionSet;
    }
}
