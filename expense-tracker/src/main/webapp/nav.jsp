<%@ page import="model.User" %>
<nav class="navbar navbar-expand-lg bg-info">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">Expense Tracker</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

            <%--            Check if user not login then show home page(index.jsp) Signup & Signin page links--%>
            <%
                User user = (User) session.getAttribute("userData");
                if (user == null) {
            %>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.jsp"><i class="bi bi-house"></i>Home</a>
            </ul>

            <ul class="navbar-nav ms-auto mb-2 mb-lg-0 d-flex">
                <li class="nav-item d-flex">
                    <a class="nav-link active" aria - current="page" href="signup.jsp"><i
                            class="bi bi-pencil-square"></i>Signup </a>
                </li>
                <li class="nav-item d-flex">
                    <a class="nav-link active" aria - current="page" href="login.jsp"><i
                            class="bi bi-box-arrow-in-right"></i> Login </a>
                </li>
            </ul>
            <%
                }
            %>


            <%-- check if user login then show home page(home.jsp) link with add some extra links(Add Expense,View Expense,View Profile, & Logout)               --%>

            <%
                if (user != null) {
            %>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="home.jsp"><i class="bi bi-house"></i>Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="addExpense.jsp"><i
                            class="bi bi-plus-circle-dotted"></i>Add Expense</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="expenseList.jsp"><i
                            class="bi bi-list-task"></i>view Expense</a>
                </li>
            </ul>


            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria - current="page" href="editProfile.jsp"><i
                            class="bi bi-person-check"></i><%=user.getName()%>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria - current="page" href="logout"><i
                            class="bi bi-box-arrow-in-left"></i>Logout </a>
                </li>
            </ul>

            <%
                }
            %>

        </div>
    </div>
</nav>