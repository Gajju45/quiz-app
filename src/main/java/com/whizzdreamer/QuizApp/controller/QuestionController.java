package com.whizzdreamer.QuizApp.controller;

import com.whizzdreamer.QuizApp.pojo.Question;
import com.whizzdreamer.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getQuestions() {
        return questionService.getAllQuestions();

    }
    @GetMapping("category/{category}")
    public List<Question>getAllQuestionByCategory(@PathVariable("category")String category){
        return questionService.getQuestionByCategory(category);
    }
}
