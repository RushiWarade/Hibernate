<%-- Created by IntelliJ IDEA. User: rushi Date: 14-12-2023 Time: 08:04 pm To change this template use File | Settings |
  File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Signup</title>
<%--    add links--%>
    <%@include file="link.jsp" %>


</head>
<%--add nav bar--%>
<%@include file="nav.jsp" %>


<body class="bg-light">
<div class="container p-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card shadow">
                <div class="card-header">
                    <p class="text-center fs-3">Registration page</p>
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
                    <form action="registration" method="post">
                        <div class="mb-3">
                            <label for="name">Enter Full Name</label>
                            <input type="text" name="name" id="name" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="email">Enter Email</label>
                            <input type="email" name="email" id="email" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="mobile">Enter Mobile No</label>
                            <input type="tel" name="mobile" id="mobile" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="address">Enter Address</label>
                            <input type="text" name="address" id="address" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="password">Enter Password</label>
                            <input type="password" name="password" id="password" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <input type="submit" value="Register" class="col-md-12 btn btn-primary">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>