<%@ page import="studentLeaveReview.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: tuwei
  Date: 2023/5/30
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit users</title>
</head>
<body>
<%
    Object usersObject = request.getAttribute("users");
    List<User> users = new ArrayList<>((Collection) usersObject);
%>
<h1>edit users</h1>
<table>
    <tr>
        <th>username</th>
        <th>type</th>
        <th colspan="2">command</th>
            <% for (User u : users) { %>
    <tr>
        <td><%=u.getUsername()%>
        </td>
        <td><%=u.getType()%>
        </td>
        <td><p><a href="${pageContext.request.contextPath}/admin/editUser?username=<%=u.getUsername()%>">edit</a></p></td>
        <td><p><a href="${pageContext.request.contextPath}/admin/deleteUserServlet?username=<%=u.getUsername()%>">delete</a></p></td>
    </tr>
    <% } %>
</table>
<br/>
<p><a href="javascript:history.back(-1)">back</a></p>
</body>
</html>
