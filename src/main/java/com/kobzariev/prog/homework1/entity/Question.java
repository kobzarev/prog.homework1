package com.kobzariev.prog.homework1.entity;

public class Question {
    private String name;
    private String text;
    private String[] answers;
    private String correctAnswer;

    public Question(String name, String text, String[] answers, String correctAnswer) {
        this.name = name;
        this.text = text;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getName() {
        return name;
    }
}
