package com.example.practiceexam.repository;

import com.example.practiceexam.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByExam_Id(Long examId); // Matches entity relation
    // saveAll() is inherited from JpaRepository
}
