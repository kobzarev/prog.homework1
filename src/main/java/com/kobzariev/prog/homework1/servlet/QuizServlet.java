package com.kobzariev.prog.homework1.servlet;

import com.kobzariev.prog.homework1.Storage;
import com.kobzariev.prog.homework1.entity.Answer;
import com.kobzariev.prog.homework1.entity.Question;
import com.kobzariev.prog.homework1.entity.Questionnaire;
import com.kobzariev.prog.homework1.entity.Stat;
import com.kobzariev.prog.homework1.exception.AuthException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "quizServlet", value = "/quiz")
public class QuizServlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        session.setAttribute("questions", Storage.questions);
        resp.sendRedirect("quiz.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            init(req);
        } catch (AuthException e) {
            resp.sendRedirect("index.jsp");
            return;
        }

        List<Answer> answers = new ArrayList<>();
        for (Question question : Storage.questions) {
            answers.add(new Answer(
                    question.getName(),
                    req.getParameter(question.getName()),
                    req.getParameter(question.getName()).equals(question.getCorrectAnswer())
            ));
            Storage.addVote(question.getName(), req.getParameter(question.getName()));
        }

        Storage.questionnaires.add(new Questionnaire((String)session.getAttribute("login"), answers));
        resp.sendRedirect("stat");
    }
}
