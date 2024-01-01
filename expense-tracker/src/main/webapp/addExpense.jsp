<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Expense</title>
    <%--    Add links from external file--%>
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

<%--Add navigation bar--%>
<%@include file="nav.jsp" %>

<div class="container p-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card shadow">
                <div class="card-header">
                    <p class="text-center fs-3">Add Expense</p>
                    <%--                    print message from session     --%>
                    <%
                        String expense = (String) session.getAttribute("expense");
                        if (expense != null) {
                    %> <p class="text-success text-center"><%=expense%>
                </p><%
                        session.removeAttribute("expense");
                    }
                %>
                </div>
                <div class="card-body">
                    <form action="addExpense" method="post">

                        <div class="mb-3">
                            <label for="title">Title</label>
                            <input type="text" name="title" id="title" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label for="date">Date</label>
                            <input type="date" name="date" id="date" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="time">time</label>
                            <input type="time" name="time" id="time" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="description">Description</label>
                            <input type="text" name="description" id="description" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="price">Price</label>
                            <input type="number" name="price" id="price" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <input type="submit" value="Add" class="col-md-12 btn btn-primary">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
