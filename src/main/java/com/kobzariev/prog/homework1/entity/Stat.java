package com.kobzariev.prog.homework1.entity;

public class Stat {
    private String name;
    private String questionText;
    private Option[] options;

    public Stat(String name, String questionText, Option[] options) {
        this.name = name;
        this.questionText = questionText;
        this.options = options;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Option[] getOptions() {
        return options;
    }

    public String getName() {
        return name;
    }

    public void addVote(String answer) {
        for (Option item : options) {
            if (answer.equals(item.getOption())) {
                item.addVote();
            }
        }
    }
}
