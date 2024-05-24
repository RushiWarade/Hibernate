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
import java.io.PrintWriter;

@WebServlet("/profile")
public class UpdateProfile extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String address = req.getParameter("address");
        String password = req.getParameter("password");

        PrintWriter writer = resp.getWriter();

        User user = User.builder().id(id).name(name).email(email).mobile(mobile).address(address).password(password).build();

        writer.println(user);


        UserController userController = new UserController();

        boolean b = userController.updateProfile(user);

        HttpSession session = req.getSession();
        if (b) {
            session.setAttribute("expense", "Profile update Successful.!");
            resp.sendRedirect("editProfile.jsp");
        } else {
            session.setAttribute("expense", "Something wrong.!");
            resp.sendRedirect("editProfile.jsp");
        }
    }
}
