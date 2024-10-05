package com.whizzdreamer.QuizApp.controller;

import com.whizzdreamer.QuizApp.pojo.QuestionWrapper;
import com.whizzdreamer.QuizApp.pojo.Response;
import com.whizzdreamer.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String>createQuiz(@RequestParam String category,@RequestParam Integer numQ,@RequestParam String title){

        return quizService.createQuiz(category,numQ,title);

        }
    @GetMapping("get/{id}")
    ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }
    @GetMapping("submit/{id}")
    ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response>responses){
        return quizService.submitQuiz(id,responses);
    }


}
