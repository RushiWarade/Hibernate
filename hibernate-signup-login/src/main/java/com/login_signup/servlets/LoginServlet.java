package com.login_signup.servlets;

import com.login_signup.controller.SignupController;
import com.login_signup.model.Signup;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String password = req.getParameter("password");
        String email = req.getParameter("email");

        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
//        writer.println(email);
//        writer.println(password);


        SignupController signupController = new SignupController();
        Signup login = signupController.login(email, password);
        writer.println(login);

        HttpSession session = req.getSession(true);

        if (login == null) {
            session.setAttribute("msg","Invalid Email or Password");
            resp.sendRedirect("login_signup.jsp");
        } else {
            session.setAttribute("userData",login);
            resp.sendRedirect("home.jsp");
        }
    }
}
