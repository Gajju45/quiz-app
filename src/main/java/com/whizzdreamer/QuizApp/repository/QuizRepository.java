package com.whizzdreamer.QuizApp.repository;

import com.whizzdreamer.QuizApp.pojo.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {
}
