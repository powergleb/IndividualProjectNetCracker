<%--
  Created by IntelliJ IDEA.
  User: groka
  Date: 30.04.2022
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table >
    <tr>
        <th>Список домашних заданий</th>
    </tr>
    <tr>
        <th>Время загрузки</th>
        <th>Преподаватель</th>
        <th> </th>
        <th> </th>
        <th>Описание задания</th>
        <th> </th>
    </tr>
    <c:forEach var="homework" items="${homeworkList}">
        <tr onclick="window.location.href='/homework=${homework.id}'; return false">
            <td>${homework.date.getTime()}<td>
            <td>${homework.teacher.getName()}</td>
            <td>${homework.teacher.getSecondName()}</td>
            <td>${homework.teacher.getPatronymic()}</td>
            <td>${homework.taskText}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
