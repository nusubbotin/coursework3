package com.example.coursework3.service;

import com.example.coursework3.exception.UnCorrectAmountQuestionException;
import com.example.coursework3.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;

import java.util.List;

public class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService;

    private List<Question> questions = List.of(
            new Question("q1", "a1"),
            new Question("q2", "a2"),
            new Question("q3", "a3"),
            new Question("q4", "a4"),
            new Question("q5", "a5")
    );

    @BeforeEach
    void setup(){
        javaQuestionService = new JavaQuestionService();
        questions.forEach(javaQuestionService::add);
    }

    @Test
    void addTest(){
        Question question = new Question("q", "a");
        Question actual = javaQuestionService.add(question);
        //Assertions.assertEquals(question, actual);
        Assertions.assertThat(actual).isEqualTo(question);

        Assertions.assertThat(javaQuestionService.getAll())
                .hasSize(6)
                .contains(question);
    }

    @Test
    void removeTest(){
        Question question = questions.get(0);
        Question actual = javaQuestionService.remove(question);
        Assertions.assertThat(actual).isEqualTo(question);

        Assertions.assertThat(javaQuestionService.getAll())
                .hasSize(4)
                .doesNotContain(question);
    }

    @Test
    void getRandomQuestionTest(){
        Question actual = javaQuestionService.getRandomQuestion();
        Assertions.assertThat(actual).isIn(questions);
    }

    @Test
    void getAllTest(){
        Assertions.assertThat(this.javaQuestionService.getAll())
                .hasSize(5)
                .containsAll(this.questions);
    }

    @Test
    void whenSetIsEmpty(){
        javaQuestionService = new JavaQuestionService();

        Assertions.assertThatThrownBy(() -> javaQuestionService.getRandomQuestion())
                .isInstanceOf(UnCorrectAmountQuestionException.class);
    }


}
