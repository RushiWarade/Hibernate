<%-- Created by IntelliJ IDEA. User: rushi Date: 14-12-2023 Time: 08:04 pm To change this template use File | Settings |
  File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <title>Login</title>
<%--    add links--%>
    <%@include file="link.jsp" %>

</head>
<%--add navigation bar--%>
<%@include file="nav.jsp" %>

<body>
<div class="container p-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card shadow">
                <div class="card-header">
                    <p class="text-center fs-3">Login page</p>
                    <%--                    print message from session     --%>

                    <%
                        String msg = (String) session.getAttribute("msg");
                        if (msg != null) {
                    %> <p class="text-success text-center"><%=msg%>
                </p><%
                        session.removeAttribute("msg");
                    }
                    %>
                </div>
                <div class="card-body">
                    <form action="login" method="post">

                        <div class="mb-3">
                            <label for="email">Enter Email</label>
                            <input type="email" name="email" id="email" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label for="password">Enter Password</label>
                            <input type="password" name="password" id="password" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <input type="submit" value="Login" class="col-md-12 btn btn-primary"required>
                        </div>
                        <div class="text-center mt-2">
                            Don't have account <a href="signup.jsp">create one</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>