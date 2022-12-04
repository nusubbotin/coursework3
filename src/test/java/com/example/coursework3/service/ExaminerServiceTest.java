package com.example.coursework3.service;

import com.example.coursework3.exception.UnCorrectAmountQuestionException;
import com.example.coursework3.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void getQuestionsTest(){
        List<Question> questionList = List.of(
                new Question("q1", "a1"),
                new Question("q2", "a2"),
                new Question("q3", "a3"),
                new Question("q4", "a4"),
                new Question("q5", "a5")
        );

        when(questionService.getAll()).thenReturn(questionList);
        when(questionService.getRandomQuestion()).thenReturn(
                questionList.get(1),
                questionList.get(2));

        assertThat(examinerService.getQuestions(2))
                .hasSize(2)
                //.containsExactlyElementsOf(questionList);
                .containsOnly(questionList.get(1), questionList.get(2));
    }

    @Test
    void whenAmountOfThenException(){
        when(questionService.getAll()).thenReturn(Collections.emptyList());

        assertThatThrownBy(() -> examinerService.getQuestions(10))
                .isInstanceOf(UnCorrectAmountQuestionException.class);
    }
}
