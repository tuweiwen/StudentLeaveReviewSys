<%--
  Created by IntelliJ IDEA.
  User: tuwei
  Date: 2023/5/30
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>apply new leave request</title>
</head>
<%
    Object usernameObject = session.getAttribute("username");
    String username = (usernameObject != null) ? (String) usernameObject : "";
%>
<body>
<h1>apply new leave request page</h1>
</body>

<form action="${pageContext.request.contextPath}/student/applyServlet" method="post">
    <input type="hidden" name="apply_user" value="<%=username%>"  />
    <label for="approve_user">approve user: </label><input required id="approve_user" type="text" name="approve_user"><br/>
    <label for="start_time">start time: </label><input required id="start_time" type="datetime-local" name="start_time"><br/>
    <label for="end_time">end time: </label><input required id="end_time" type="datetime-local" name="end_time"><br/>
    <input type="submit">
</form>
<br/>
<p><a href="javascript:history.back(-1)">back</a></p>
</html>

