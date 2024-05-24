package servlets;

import controller.UserController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserController userController = new UserController();
        User user = userController.login( email,  password);

        HttpSession session = req.getSession();
        if (user !=null){
            session.setAttribute("msg" ,"Login Success");
            session.setAttribute("userData",user);
            resp.sendRedirect("home.jsp");
        }else {
            session.setAttribute("msg","Invalid Email or Password");
            resp.sendRedirect("login.jsp");
        }

    }
}
