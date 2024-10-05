package com.whizzdreamer.QuizApp.controller;

import com.whizzdreamer.QuizApp.pojo.Question;
import com.whizzdreamer.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("question")
public class QuestionController {

    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getQuestions() {
        return new ResponseEntity<>(questionService.getAllQuestions(),HttpStatus.OK);
    }

    @GetMapping("category/{category}")
    public List<Question> getAllQuestionByCategory(@PathVariable("category") String category) {
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<String>addQuestions(@RequestBody Question question) {
        questionService.addQuestions(question);
        logger.info("add questions :"+question.toString());
        return new ResponseEntity<>("Questions added successfully.", HttpStatus.CREATED);
    }
}
