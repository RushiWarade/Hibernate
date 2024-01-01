<%@ page import="controller.UserController" %>
<%@ page import="model.Expense" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Expense List</title>
    <%--    add links--%>
    <%@include file="link.jsp" %>

</head>
<body>
<%--Check if user not login and try to fetch this page the redirect to login page--%>
<%
    User userData = (User) session.getAttribute("userData");

    if (userData == null) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);
    }

%>
<%--add navigation bar--%>
<%@include file="nav.jsp" %>

<div class="container p-5">
    <div class="row">
        <div class="col-md-8 offset-md-3">
            <div class="card shadow">
                <div class="card-header">
                    <p class="text-center fs-3">Expense List</p>
                    <%--                    print message from session     --%>

                    <%
                        String ex = (String) session.getAttribute("expense");
                        if (ex != null) {
                    %> <p class="text-success text-center"><%=ex%>
                </p><%
                        session.removeAttribute("expense");
                    }
                %>
                </div>
                <div class="card-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <%--                            <th scope="col">Sr. No</th>--%>
                            <th scope="col">Title</th>
                            <th scope="col">Date</th>
                            <th scope="col">Time</th>
                            <th scope="col">Description</th>
                            <th scope="col">Price</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%--                        call expense list method and print in table--%>
                        <%
                            UserController userController = new UserController();
                            List<Expense> expenseList = userController.expenseList(user);
                            for (Expense expense : expenseList) {
                        %>


                        <tr>
                            <%--                            <th scope="row"><%=i%>--%>
                            <%--                            </th>--%>
                            <td><%=expense.getTitle()%>
                            </td>
                            <td><%=expense.getDate()%>
                            </td>
                            <td><%=expense.getTime()%>
                            </td>
                            <td><%=expense.getDescription()%>
                            </td>
                            <td><%=expense.getPrice()%>
                            </td>
                            <td class="d-flex">
<%--                                edit and delete expense buttons--%>
                                <form method="post" action="editExpense.jsp">
                                    <input type="hidden" value="<%=expense.getId()%>" name="edit">
                                    <%--                                    <a href="editExpense.jsp?edit=<%=expense.getId()%>"--%>
                                    <%--                                       class="btn btn-sm me-1 btn-success">Edit</a>--%>
                                    <input type="submit" class="btn btn-sm me-1 btn-success" value="Edit">
                                    <%--                                    <a href="delete?delete=<%=expense.getId()%>" class="btn btn-sm me-1 btn-danger">Delete</a>--%>
                                </form>

                                <form action="delete" method="post">
                                    <input type="hidden" value="<%=expense.getId()%>" name="delete">

                                    <input type="submit" class="btn btn-sm me-1 btn-danger" value="Delete">

                                </form>
                            </td>
                        </tr>

                        <%

                            }

                        %>

                        </tbody>
                    </table>


                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
