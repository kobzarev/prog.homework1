package com.kobzariev.prog.homework1;

import com.kobzariev.prog.homework1.entity.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {
    public static List<User> users = Collections.synchronizedList(new ArrayList<>());
    public static List<Questionnaire> questionnaires = Collections.synchronizedList(new ArrayList<>());
    public static List<Question> questions = new ArrayList<>();
    public static List<Stat> statList = Collections.synchronizedList(new ArrayList<>());

    static {
        questions.add(new Question("canada", "Capital of Canada", new String[] {"Toronto", "Calgary", "Ottawa"}, "Ottawa"));
        questions.add(new Question("italy", "Capital of Italy", new String[] {"Rome", "Milan", "Genoa"}, "Rome"));
        questions.add(new Question("portugal", "Capital of Portugal", new String[] {"Lisbon", "Porto", "Braga"}, "Lisbon"));

        for (Question item : questions) {
            Option[] options = new Option[item.getAnswers().length];
            for (int i = 0; i < item.getAnswers().length; i++) {
                options[i] = new Option(item.getAnswers()[i], new AtomicInteger(0));
            }
            statList.add(new Stat(item.getName(), item.getText(), options));
        }
    }

    public static void addVote(String name, String answer) {
        for (Stat item : Storage.statList) {
            if (name.equals(item.getName())) {
                item.addVote(answer);
            }
        }
    }
}
