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
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Выберите группу для просмотра списка домашних заданий</th>
    </tr>
    <tr>
        <th>Номер группы</th>
    </tr>
    <c:forEach var="group" items="${groupList}">
        <tr onclick="window.location.href='/homeworkListByGroup=${group.id}'; return false">
            <td>${group.numberOfGroup}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
