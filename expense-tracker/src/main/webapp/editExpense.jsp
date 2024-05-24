<%@ page import="controller.UserController" %>
<%@ page import="model.Expense" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Edit Expense</title>
<%--    Add links--%>
    <%@include file="link.jsp" %>
</head>
<body>
<%--Check if user not login and try to fetch this page the redirect to login page--%>
<%
    User userData =(User) session.getAttribute("userData");

    if (userData==null){
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request,response);
    }

%>
<%--Add navigation bar--%>
<%@include file="nav.jsp" %>

<%--call get expense method--%>
<%
    UserController userController = new UserController();
    int edit = Integer.parseInt(request.getParameter("edit"));
    Expense expense = userController.getExpense(edit);

%>

<div class="container p-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card shadow">
                <div class="card-header">
                    <p class="text-center fs-3">Edit Expense</p>

                </div>
                <div class="card-body">
                    <form action="updateExpense" method="post">

                        <div class="mb-3">
                            <label for="title">Title</label>
                            <input type="text" name="title" id="title" class="form-control"
                                   value="<%=expense.getTitle()%>">
                        </div>

                        <div class="mb-3">
                            <label for="date">Date</label>
                            <input type="date" name="date" id="date" class="form-control" required
                                   value="<%=expense.getDate()%>">
                        </div>
                        <div class="mb-3">
                            <label for="time">time</label>
                            <input type="time" name="time" id="time" class="form-control" required
                                   value="<%=expense.getTime()%>">
                        </div>
                        <div class="mb-3">
                            <label for="description">Description</label>
                            <input type="text" name="description" id="description" class="form-control" required
                                   value="<%=expense.getDescription()%>">
                        </div>
                        <div class="mb-3">
                            <label for="price">Price</label>
                            <input type="number" name="price" id="price" class="form-control" required
                                   value="<%=expense.getPrice()%>">
                        </div>
                        <input type="hidden" value="<%=expense.getId()%>" name="id">
                        <div class="mb-3">
                            <input type="submit" value="Update Expense" class="col-md-12 btn btn-primary">
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
