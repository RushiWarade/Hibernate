package crud.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.controller.Controller;

import java.io.IOException;
import java.io.PrintWriter;

public class AddServlet extends HttpServlet {
        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String  mobile = req.getParameter("mobile");

        PrintWriter writer = resp.getWriter();
//        writer.println(name);
//        writer.println(mobile);
//        writer.println(email);

        org.example.model.Course course = org.example.model.Course.builder()
                .name(name)
                .email(email)
                .mobile(mobile)
                .build();

            org.example.controller.Controller controller = new Controller();
            controller.add(course);

            writer.println("Course inserted Successfully...!");

//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("add");
//            requestDispatcher.include(req,resp);
        }
}
