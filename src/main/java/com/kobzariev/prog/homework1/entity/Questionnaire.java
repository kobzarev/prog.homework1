package com.kobzariev.prog.homework1.entity;

import java.util.List;

public class Questionnaire {
    private String login;
    private List<Answer> answers;

    public Questionnaire(String login, List<Answer> answers) {
        this.login = login;
        this.answers = answers;
    }

    public String getLogin() {
        return login;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
