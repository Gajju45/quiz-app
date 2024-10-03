package com.whizzdreamer.QuizApp.service;

import com.whizzdreamer.QuizApp.pojo.Question;
import com.whizzdreamer.QuizApp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
    public List<Question> getQuestionByCategory(String category){
        return questionRepository.findByCategory(category);
    }
}

