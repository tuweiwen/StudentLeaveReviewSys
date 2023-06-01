<%@ page import="studentLeaveReview.pojo.User" %>
<%--
  Created by IntelliJ IDEA.
  User: tuwei
  Date: 2023/5/30
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>Home</title>
</head>
<%
    Object nameObject = session.getAttribute("username");
    Object typeObject = session.getAttribute("type");

    String name = (nameObject != null) ? (String) nameObject : "";
    short type = typeObject != null ? (short) typeObject : 0;
%>
<body>
<h1>welcome back, <%=name%>
</h1>

<h2>what do you wanna do today?</h2>
<!--for admin-->
<c:if test="${type == 1}">
    <ul>
        <li><a href="${pageContext.request.contextPath}/admin/users">edit users</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/leave">edit leave records</a></li>
    </ul>
</c:if>
<!--for teacher-->
<c:if test="${type == 2}">
    <ul>
        <li><a href="${pageContext.request.contextPath}/teacher/check">check leave records</a></li>
    </ul>
</c:if>
<!--for student-->
<c:if test="${type == 3}">
    <ul>
        <li><a href="${pageContext.request.contextPath}/student/apply">apply new leave request</a></li>
        <li><a href="${pageContext.request.contextPath}/student/check">check my leave request</a></li>
    </ul>
</c:if>
<br/>
<a href="${pageContext.request.contextPath}/logoutServlet">log out</a>
</body>
</html>
