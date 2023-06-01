<%@ page import="studentLeaveReview.pojo.LeaveRecord" %>
<%@ page import="static studentLeaveReview.utils.TimeUtils.timeDateProcess" %><%--
  Created by IntelliJ IDEA.
  User: tuwei
  Date: 2023/6/1
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>record edit</title>
</head>
<body>
<%
    Object recordObject = request.getAttribute("record");
    LeaveRecord leaveRecord = (recordObject != null) ? (LeaveRecord) recordObject : new LeaveRecord();
%>
<script>
    function formValidationCheck() {
        const approve_user = document.getElementById("approve_user").value;
        const start_time = document.getElementById("start_time").value;
        const end_time = document.getElementById("end_time").value;
        const status = document.getElementById("status").value;
        if (approve_user === '') {
            alert("approve user can't be empty!")
            return false
        } else if (start_time === '') {
            alert("start time can't be empty")
            return false
        } else if (end_time === '') {
            alert("end time can't be empty")
            return false
        } else if (status === '') {
            alert("status can't be empty")
            return false
        } else if(status !== '1' && status !== '2' && status !== '3') {
            alert("invalid status value")
            return false
        }
        return true
    }
</script>
<h1>edit record</h1>
<form action="${pageContext.request.contextPath}/admin/editRecordServlet" method="post" onsubmit="return formValidationCheck()">
    <label for="request_id">request id: </label><input id="request_id" name="request_id" type="text" readonly value="<%=leaveRecord.getRequestId()%>"><br/>
    <label for="apply_user">apply user: </label><input id="apply_user" type="text" readonly value="<%=leaveRecord.getApplyUser()%>"><br/>
    <label for="approve_user">approve user: </label><input id="approve_user" name="approve_user" type="text" value="<%=leaveRecord.getApproveUser()%>"><br/>
    <label for="start_time">start time: </label><input id="start_time" name="start_time" type="datetime-local" value="<%=timeDateProcess(leaveRecord.getStartTime())%>"><br/>
    <label for="end_time">end time: </label><input id="end_time" name="end_time" type="datetime-local" value="<%=timeDateProcess(leaveRecord.getEndTime())%>"><br/>
    <label for="request_time">request time: </label><input id="request_time" name="request_time" type="datetime-local" readonly value="<%=timeDateProcess(leaveRecord.getRequestTime())%>"><br/>
    <label for="status">status: </label><input id="status" name="status" type="text" value="<%=leaveRecord.getStatus()%>"><br/>
    <input type="submit">
</form>
</body>
</html>
