<%@ page import="controller.UserController" %>
<%@ page import="model.Expense" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Update Profile</title>
<%--    add links--%>
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
<%--add nevigation bar--%>
<%@include file="nav.jsp" %>

<%--call getUser method--%>
<%
    UserController userController = new UserController();
    int id = userData.getId();
    User u = userController.getUser(id);

%>

<div class="container p-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card shadow">
                <div class="card-header">
                    <p class="text-center fs-3">Update Profile</p>
                    <%--                    print message from session     --%>

                    <%
                        String msg = (String) session.getAttribute("expense");
                        if (msg != null) {
                    %> <p class="text-success text-center"><%=msg%>
                </p><%
                        session.removeAttribute("expense");
                    }
                %>

                </div>
                <div class="card-body">
                    <form action="profile" method="post">

                        <div class="mb-3">
                            <label for="name">Name</label>
                            <input type="text" name="name" id="name" class="form-control"
                                   value="<%=u.getName()%>">
                        </div>
                        <div class="mb-3">
                            <label for="email">Email</label>
                            <input type="email" name="email" id="email" class="form-control" readonly
                                   value="<%=u.getEmail()%>">
                        </div>
                        <div class="mb-3">
                            <label for="mobile">Mobile</label>
                            <input type="tel" name="mobile" id="mobile" class="form-control"
                                   value="<%=u.getMobile()%>">
                        </div>
                        <div class="mb-3">
                            <label for="address">Address</label>
                            <input type="text" name="address" id="address" class="form-control"
                                   value="<%=u.getAddress()%>">
                        </div>
                        <div class="mb-3">
                            <label for="password">Password</label>
                            <input type="text" name="password" id="password" class="form-control"
                                   value="<%=u.getPassword()%>">
                        </div>
                        <input type="hidden" value="<%=u.getId()%>" name="id">
                        <div class="mb-3">
                            <input type="submit" value="Update Profile" class="col-md-12 btn btn-primary">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
