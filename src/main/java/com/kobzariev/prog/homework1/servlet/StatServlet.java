package com.kobzariev.prog.homework1.servlet;

import com.kobzariev.prog.homework1.Storage;
import com.kobzariev.prog.homework1.entity.*;
import com.kobzariev.prog.homework1.exception.AuthException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "statServlet", value = "/stat")
public class StatServlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            init(req);
        } catch (AuthException e) {
            resp.sendRedirect("index.jsp");
            return;
        }
        List<Stat> userStat = new ArrayList<>();
        for (Question item : Storage.questions) {
            Option[] options = new Option[item.getAnswers().length];
            for (int i = 0; i < item.getAnswers().length; i++) {
                options[i] = new Option(item.getAnswers()[i], new AtomicInteger(0));
            }
            userStat.add(new Stat(item.getName(), item.getText(), options));
        }

        for (Questionnaire item : Storage.questionnaires) {
            if (item.getLogin().equals(session.getAttribute("login"))) {
                for (Answer answer : item.getAnswers()) {
                    addVote(userStat, answer.getQuestionName(), answer.getAnswer());
                }
            }
        }
        session.setAttribute("result", Storage.statList);
        session.setAttribute("userStat", userStat);
        resp.sendRedirect("stat.jsp");
    }
    
    private void addVote(List<Stat> myStat, String name, String answer) {
        for (Stat item : myStat) {
            if (name.equals(item.getName())) {
                item.addVote(answer);
            }
        }
    }
}
