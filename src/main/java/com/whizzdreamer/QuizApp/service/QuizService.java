package com.whizzdreamer.QuizApp.service;

import com.whizzdreamer.QuizApp.pojo.Question;
import com.whizzdreamer.QuizApp.pojo.QuestionWrapper;
import com.whizzdreamer.QuizApp.pojo.Quiz;
import com.whizzdreamer.QuizApp.pojo.Response;
import com.whizzdreamer.QuizApp.repository.QuestionRepository;
import com.whizzdreamer.QuizApp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
@Autowired
    QuizRepository quizRepository;
@Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category,Integer numQ,String title){
        List<Question> questions=questionRepository.findRandomQuestionByCategory(category,numQ);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionList(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz=quizRepository.findById(id);

        List<Question> questionsFromDB=quiz.get().getQuestionList();
        List<QuestionWrapper>questionForUser=new ArrayList<>();
        for (Question question:questionsFromDB)
        {
            QuestionWrapper qw=new QuestionWrapper(question.getId(),question.getQuestionTitle(),question.getOption1(),
                    question.getOption2(),
                    question.getOption3(),
                    question.getOption4());

            questionForUser.add(qw);
        }

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(Integer id , List<Response>responses) {
        Optional<Quiz> quiz=quizRepository.findById(id);
        List<Question> questionList=quiz.get().getQuestionList();
        int right=0;
        int i=0;

        for (Response response:responses){
            if (response.getResponse().equalsIgnoreCase(questionList.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
       return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
