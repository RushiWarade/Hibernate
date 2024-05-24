package servlets;

import controller.UserController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class DeleteExpense extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int delete = Integer.parseInt(req.getParameter("delete"));

        UserController userController = new UserController();

        boolean b = userController.deleteExpense(delete);

        HttpSession session = req.getSession();

        if (b){
            session.setAttribute("expense","Expense Deleted Successfully...");
            resp.sendRedirect("expenseList.jsp");
        }else {
            session.setAttribute("expense","Something wrong.!");
            resp.sendRedirect("expenseList.jsp");
        }
    }
}
