package servlets;

import controller.UserController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Expense;
import model.User;

import java.io.IOException;


@WebServlet("/addExpense")
public class AddExpense extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        String description = req.getParameter("description");
        int price = Integer.parseInt(req.getParameter("price"));

        HttpSession session = req.getSession();
        User userDta =(User) session.getAttribute("userData");


        Expense expense= new Expense();
        expense.setTitle(title);
        expense.setDate(date);
        expense.setTime(time);
        expense.setDescription(description);
        expense.setPrice(price);
        expense.setUser(userDta);


        UserController  userController = new UserController();

        boolean b = userController.addExpense(expense);

        if (b){
            session.setAttribute("expense","Expense Added Successfully...");
            resp.sendRedirect("expenseList.jsp");
        }else {
            session.setAttribute("expense","Something wrong.!");
            resp.sendRedirect("addExpense.jsp");
        }

    }
}
