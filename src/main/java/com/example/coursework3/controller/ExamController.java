package com.example.coursework3.controller;

import com.example.coursework3.exception.UnCorrectAmountQuestionException;
import com.example.coursework3.model.Question;
import com.example.coursework3.service.ExaminerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @ExceptionHandler(UnCorrectAmountQuestionException.class)
    public ResponseEntity<String> handlerException(){
        return ResponseEntity
                .badRequest()
                .body("В базе недостаточно вопросов");
    }
    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount){
        return examinerService.getQuestions(amount);
    }
}
