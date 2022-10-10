package com.kobzariev.prog.homework1.servlet;

import com.kobzariev.prog.homework1.Storage;
import com.kobzariev.prog.homework1.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends AbstractServlet {

    public LoginServlet() {
        isAuthRequired = false;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req);
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        for (User user : Storage.users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                session.setAttribute("login", req.getParameter("login"));
                session.setAttribute("questions", Storage.questions);
                resp.sendRedirect("quiz");
                return;
            }
        }
        resp.sendRedirect("index.jsp");
    }
}
