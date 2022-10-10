package com.kobzariev.prog.homework1.servlet;

import com.kobzariev.prog.homework1.exception.AuthException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "logoutServlet", value = "/logout")
public class LogoutServlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            init(request);
        } catch (AuthException e) {
            response.sendRedirect("index.jsp");
            return;
        }
        session.setAttribute("login", null);
        response.sendRedirect("index.jsp");
    }
}
