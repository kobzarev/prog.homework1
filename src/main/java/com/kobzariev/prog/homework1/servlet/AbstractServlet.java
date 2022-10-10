package com.kobzariev.prog.homework1.servlet;

import com.kobzariev.prog.homework1.exception.AuthException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class AbstractServlet extends HttpServlet {
    protected HttpSession session;
    protected boolean isAuthRequired = true;

    protected void init(HttpServletRequest request) {
        session = request.getSession(true);
        if (isAuthRequired && session.getAttribute("login") == null) {
            throw new AuthException();
        }
    }
}
