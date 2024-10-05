package com.whizzdreamer.QuizApp.repository;

import com.whizzdreamer.QuizApp.pojo.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(@Param("category") String category);

    @Query(value = "SELECT * FROM Question q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(@Param("category") String category,@Param("numQ") Integer numQ);
}
