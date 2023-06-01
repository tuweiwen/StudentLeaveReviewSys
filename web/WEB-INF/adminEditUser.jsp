<%--
  Created by IntelliJ IDEA.
  User: tuwei
  Date: 2023/6/1
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user edit</title>
</head>
<body>
<script>
    function passwordValidationCheck() {
        const firstPassword = document.getElementById("password").value;
        const rePassword = document.getElementById("re_password").value;
        if (firstPassword === "" || rePassword === "") {
            alert("password can't be empty")
            return false
        }

        if (firstPassword === rePassword) {
            return true
        } else {
            alert("password and re-password must be the same!")
            return false
        }
    }
</script>
<h1>edit user</h1>
<form action="${pageContext.request.contextPath}/admin/editUserServlet" method="post" onsubmit="return passwordValidationCheck()">
    <label for="username">username: </label><input id="username" name="username" type="text" readonly value="${user.username}"><br/>
    <label for="password">password: </label><input id="password" name="password" type="password" ><br/>
    <label for="re_password">re-enter password: </label><input id="re_password" type="password" ><br/>
    <input type="submit">
</form>
<br/>
<p><a href="javascript:history.back(-1)">back</a></p>
</body>
</html>
