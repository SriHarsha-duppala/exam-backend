package com.example.practiceexam.controller;

import com.example.practiceexam.model.Exam;
import com.example.practiceexam.model.Question;
import com.example.practiceexam.repository.ExamRepository;
import com.example.practiceexam.repository.QuestionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/exams")
@CrossOrigin(origins = "https://sriharshapracticetest.netlify.app/")
public class ExamController {

    private final ExamRepository examRepo;
    private final QuestionRepository qRepo;

    public ExamController(ExamRepository examRepo, QuestionRepository qRepo) {
        this.examRepo = examRepo;
        this.qRepo = qRepo;
    }
@GetMapping("/questions/count")
public Map<String, Object> getQuestionCounts() {
    Map<String, Object> response = new HashMap<>();

    // Total count of questions
    long totalQuestions = qRepo.count();
    response.put("totalQuestions", totalQuestions);

    // Count by exam
    Map<Long, Long> perExam = examRepo.findAll().stream()
            .collect(Collectors.toMap(
                    Exam::getId,
                    exam -> qRepo.countByExamId(exam.getId())
            ));
    response.put("questionsPerExam", perExam);

    return response;
}
    // --- Get list of all exams ---
    @GetMapping
    public List<Exam> listExams() {
        return examRepo.findAll();
    }

    // --- Get questions for an exam ---
    @GetMapping("/{id}/questions")
    public List<Map<String, Object>> getQuestions(
            @PathVariable Long id,
            @RequestParam(defaultValue = "60") int count,
            @RequestParam(defaultValue = "false") boolean includeAnswers) {

        List<Question> questions = qRepo.findByExamId(id);

        // randomize and limit
        Collections.shuffle(questions);
        if (questions.size() > count) {
            questions = questions.subList(0, count);
        }

        return questions.stream().map(q -> {
            Map<String,Object> map = new HashMap<>();
            map.put("id", q.getId());
            map.put("category", q.getCategory());
            map.put("text", q.getQuestionText());
            List<String> options = Arrays.asList(
                    q.getOptionA(),
                    q.getOptionB(),
                    q.getOptionC(),
                    q.getOptionD()
            );
            map.put("options", options);

            // If answers should be sent to frontend:
            if (includeAnswers) {
                map.put("correctOption", q.getCorrectOption());

                // NEW: also send actual correct answer text:
                String correctText = null;
                switch (q.getCorrectOption()) {
                    case "A": correctText = q.getOptionA(); break;
                    case "B": correctText = q.getOptionB(); break;
                    case "C": correctText = q.getOptionC(); break;
                    case "D": correctText = q.getOptionD(); break;
                }
                map.put("correctText", correctText);
            }

            return map;
        }).collect(Collectors.toList());
    }
}
