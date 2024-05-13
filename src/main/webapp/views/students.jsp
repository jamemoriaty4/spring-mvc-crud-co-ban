<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/9/2024
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<h3>Danh sách sinh viên</h3>
<table border="10" cellpadding="10" cellspacing="10">
    <thead>
    <tr>
        <th>Student Id</th>
        <th>Student Name</th>
        <th>Age</th>
        <th>Status</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listStudent}" var="student">
        <tr>
            <td>${student.studentId}</td>
            <td>${student.studentName}</td>
            <td>${student.age}</td>
            <td>${student.status?"Đang học":"Nghỉ học"}</td>
            <td><a href="/studentController/edit?id=${student.studentId}">Edit</a></td>
            <td><a href="/studentController/delete?id=${student.studentId}" onclick="return confirm('Bạn có chắc chăn muốn xóa ko')">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/studentController/initCreate">Create new student</a>
</body>
</html>
