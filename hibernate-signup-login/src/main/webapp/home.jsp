<%@ page import="com.login_signup.model.Signup" %><%--
  Created by IntelliJ IDEA.
  User: rushi
  Date: 13-12-2023
  Time: 09:15 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<%
Signup signup = (Signup) session.getAttribute("userData");


//signup.getFname();
//userData.getname
%>
<h1>Welcome  <%=signup.getFname()  %> <%=signup.getLname()  %> </h1>
</body>
</html>
