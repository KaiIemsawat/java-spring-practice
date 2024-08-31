package com.demo.quiz.models;

import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class Question {

    private Long id;

    @NotBlank
    private String question;

    @NotBlank
    private String subject;

    @NotBlank
    private String questionType;

    @NotNull
    @ElementCollection
    private List<String> choices;

    @NotNull
    @ElementCollection
    private List<String> correctAnswers;


}
