package com.kobzariev.prog.homework1.entity;

public class Answer {
    private String questionName;
    private String answer;
    private boolean isCorrect;

    public Answer(String questionName, String answer, boolean isCorrect) {
        this.questionName = questionName;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public String getQuestionName() {
        return questionName;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
