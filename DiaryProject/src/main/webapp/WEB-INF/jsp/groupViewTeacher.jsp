<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: groka
  Date: 09.05.2022
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">

    <title>Title</title>
</head>
<body>
<h3>Выберите группу для просмотра списка домашних заданий</h3>
<table class="grouptable">
    <thead>
    <tr>
        <th>
            Номер группы
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="group" items="${groupList}">
        <tr onclick="window.location.href='/homeworkListByGroup=${group.id}'; return false">
            <td>${group.numberOfGroup}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>


</body>
</html>
