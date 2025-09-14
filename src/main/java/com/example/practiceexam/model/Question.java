package com.example.practiceexam.model;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category; // aptitude, reasoning, GK
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption; // A, B, C, D

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    public Question() {}

    public Question(Exam exam, String category, String questionText, String optionA, String optionB,
                    String optionC, String optionD, String correctOption) {
        this.exam = exam;
        this.category = category;
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
    }

    // Getters
    public Long getId() { return id; }
    public String getCategory() { return category; }
    public String getQuestionText() { return questionText; }
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getOptionC() { return optionC; }
    public String getOptionD() { return optionD; }
    public String getCorrectOption() { return correctOption; }
}
