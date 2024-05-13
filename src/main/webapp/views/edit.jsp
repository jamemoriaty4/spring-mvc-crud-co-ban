<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/11/2024
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<h1>Edit Student</h1>
<form action="${pageContext.request.contextPath}/studentController/update" method="post">

    <label>
        <input type="text" name="studentId" value="${students.studentId}" readonly>
    </label>
    <br>

    <label for="name">Name:</label>
    <input type="text" id="name" name="studentName" value="${students.studentName}"> <br>
    <label for="name">Name:</label>
    <input type="text" id="age" name="Age" value="${students.age}"> <br>

    <label for="active">Status</label>
    <input type="radio" id="active" name="status" value="true" checked/><label for="active">Đang học</label>
    <input type="radio" id="inActive" name="status" value="false"/><label for="inActive">Nghỉ học</label><br>

    <button type="submit">Update</button>
</form>
</body>
</html>
