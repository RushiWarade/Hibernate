<!--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
-->
<html>

<head>
    <title>Expense Tracker</title>
<%--    add links--%>
    <%@include file="link.jsp" %>

</head>

<body>
<%--add navigation bar--%>
<%@include file="nav.jsp" %>


<div class="container-fluid mt-3">
    <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="./images/expense-1.jpg" class="d-block w-100" alt="Image" height="650px">
            </div>
            <div class="carousel-item">
                <img src="./images/expense-2.webp" class="d-block w-100" alt="Image" height="650px">
            </div>
            <div class="carousel-item">
                <img src="./images/trackexpenses-3.jpg" class="d-block w-100" alt="Image" height="650px">
            </div>
            <div class="carousel-item">
                <img src="./images/expense-4.jpg" class="d-block w-100" alt="Image" height="650px">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying"
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying"
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>


</body>

</html>