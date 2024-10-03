package com.whizzdreamer.QuizApp.repository;

import com.whizzdreamer.QuizApp.pojo.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(@Param("category") String category);
}
