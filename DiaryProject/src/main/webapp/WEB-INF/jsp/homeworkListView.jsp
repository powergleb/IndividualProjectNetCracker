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
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<h3>
    Список домашних заданий
</h3>
<table class="table">
    <thead>
    <tr>
        <th>Описание задания</th>
        <th>Преподаватель</th>
        <th>Время загрузки</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="homework" items="${homeworkList}">
        <tr onclick="window.location.href='/homework=${homework.id}'; return false">
            <td>${homework.taskText}</td>
            <td>${homework.teacher.getSecondName()} ${homework.teacher.getName()} ${homework.teacher.getPatronymic()}</td>
            <td>${homework.date.getTime()}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>
