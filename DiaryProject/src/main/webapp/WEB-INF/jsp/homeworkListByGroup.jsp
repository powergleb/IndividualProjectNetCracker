<%--
  Created by IntelliJ IDEA.
  User: groka
  Date: 30.04.2022
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
</head>
<body>
<h3>Список домашних заданий группы <c:out value="${group}"/></h3>
<table class="table">

    <thead>
    <tr>
        <th>Время загрузки</th>
        <th>Описание задания</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="homework" items="${homeworkList}">
        <tr onclick="window.location.href='/homeworkViewTeacher=${homework.id}'; return false">
            <td>${homework.date.getTime()}</td>
            <td>${homework.taskText}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
