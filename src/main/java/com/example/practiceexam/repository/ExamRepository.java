package com.example.practiceexam.repository;

import com.example.practiceexam.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {}
