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
    <style type="text/css">
        TABLE {
            border: 2px solid black; /* Рамка вокруг таблицы */
        }
        TD, TH {
            border: 2px solid black; /* Рамка вокруг таблицы */
        }
        TH {
            border: 2px solid black; /* Рамка вокруг таблицы */
        }
    </style>
</head>
<body>
<table>
        <tfoot>Список домашних заданий группы <c:out value="${group}"/></tfoot>

    <tr>
        <td>Время загрузки</td>
        <td>Описание задания</td>
    </tr>
    <c:forEach var="homework" items="${homeworkList}">
        <tr onclick="window.location.href='/homeworkViewTeacher=${homework.id}'; return false">
            <td>${homework.date.getTime()}</td>
            <td>${homework.taskText}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
