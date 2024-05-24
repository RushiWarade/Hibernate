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
import java.io.PrintWriter;

@WebServlet("/updateExpense")
public class updateExpense extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
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
        expense.setId(id);

        PrintWriter writer = resp.getWriter();

//        writer.println(expense);
        UserController  userController = new UserController();

        boolean b = userController.updateExpense(expense);

        if (b){
            session.setAttribute("expense","Expense Updated Successfully...");
            resp.sendRedirect("expenseList.jsp");
        }else {
            session.setAttribute("expense","Something wrong.!");
            resp.sendRedirect("expenseList.jsp");
        }

    }
}
