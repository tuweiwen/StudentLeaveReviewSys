<%@ page import="studentLeaveReview.pojo.LeaveRecord" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: tuwei
  Date: 2023/5/30
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit leave records</title>
</head>
<%
    Object recordsObject = request.getAttribute("records");
    List<LeaveRecord> records = new ArrayList<>((Collection) recordsObject);
    System.out.println(records);
%>
<body>
<h1>leave records page</h1>
<table>
    <tr>
        <td>RequestId</td>
        <td>ApplyUser</td>
        <td>ApproveUser</td>
        <td>StartTime</td>
        <td>EndTime</td>
        <td>RequestTime</td>
        <th colspan="2">command</th>
<% for (LeaveRecord r : records) { %>
    <tr>
        <td><%=r.getRequestId()%></td>
        <td><%=r.getApplyUser()%></td>
        <td><%=r.getApproveUser()%></td>
        <td><%=r.getStartTime()%></td>
        <td><%=r.getEndTime()%></td>
        <td><%=r.getRequestTime()%></td>
        <td><p><a href="#">edit</a></p></td>
        <td><p><a href="#">delete</a></p></td>
    </tr>
<% } %>
</table>
<br/>
<p><a href="javascript:history.back(-1)">back</a></p>
</body>
</html>
