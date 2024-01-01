package com.login_signup.servlets;

import com.login_signup.controller.SignupController;
import com.login_signup.doa.SignupDao;
import com.login_signup.model.Signup;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.io.PrintWriter;


public class SignupServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");

        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
//        writer.println(fname);
//        writer.println(lname);
//        writer.println(address);
//        writer.println(password);
//        writer.println(address);

        Signup signup = Signup.builder()
                .fname(fname)
                .lname(lname)
                .mobile(mobile)
                .address(address)
                .password(password)
                .email(email)
                .build();

//        writer.println(signup);

        SignupController signupController = new SignupController();
        boolean b = signupController.signup(signup);

        HttpSession httpSession = req.getSession();

        if (b) {
            httpSession.setAttribute("msg", "Signup Success...! You are Ready to login");
        } else {
            httpSession.setAttribute("msg", "Something Wrong...!");
        }

        resp.sendRedirect("login_signup.jsp");
    }
}
