package com.kobzariev.prog.homework1.servlet;

import com.kobzariev.prog.homework1.Storage;
import com.kobzariev.prog.homework1.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "registrationServlet", value = "/reg")
public class RegistrationServlet extends AbstractServlet {
    public RegistrationServlet() {
        isAuthRequired = false;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req);
        try {
            Storage.users.add(new User(
                    req.getParameter("firstName"),
                    req.getParameter("lastName"),
                    Integer.parseInt(req.getParameter("age")),
                    req.getParameter("login"),
                    req.getParameter("password")
            ));
        } catch (Exception e) {
            resp.sendRedirect("index.jsp");
        }
        HttpSession session = req.getSession(true);
        session.setAttribute("login", req.getParameter("login"));
        resp.sendRedirect("quiz");
    }
}
