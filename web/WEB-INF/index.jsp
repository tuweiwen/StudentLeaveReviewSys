<%--
  Created by IntelliJ IDEA.
  User: tuwei
  Date: 2023/5/29
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<%
    Object loginErrorObject = session.getAttribute("loginError");
    String loginError = (loginErrorObject != null) ? (String) loginErrorObject : "";

    session.removeAttribute("loginError");
%>
<head>
    <title>index</title>
    <style>
        .error {
            color: orangered;
        }
    </style>
</head>
<body>
<c:if test="${!loginError.isEmpty()}">
    <p class="error">
        <%=loginError%>
    </p>
</c:if>
<form action="${pageContext.request.contextPath}/loginServlet" method="post">
    <label for="username_input">username: </label><input required id="username_input" type="text" name="username"><br/>
    <label for="password_input">password: </label><input required type="password" id="password_input" name="password"><br/>
    <input type="submit">
</form>
</body>

</html>
