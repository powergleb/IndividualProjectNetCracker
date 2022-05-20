<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: groka
  Date: 08.05.2022
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
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
<h1>Описание домашнего задания</h1>
<c:out value="${date}" escapeXml="false"/>
<c:out value="${text}" escapeXml="false"/>
<table>
    <c:forEach var="file" items="${homeworkFiles}">
    <tr onclick="window.location.href='/downloadHomeworkTeacherFiles=${file.id}'; return false">
        <td>${file.name}</td>
    <tr>
            <%--        <input type="button" value="скачать на ваш страх и риск" onclick="window.location.href='/downloadfiles=${file.id}'; return false">--%>
        </c:forEach>
</table>
<c:if test="${answerList.size() != 0}">
    <table style="border: 2px solid black;">
        <tr>
            <th colspan="3">Список ответивших</th>
        </tr>
        <tr>
            <th >Студент ФИО</th>
            <th>Время ответа</th>
            <th>Оценка</th>
        </tr>
        <c:forEach var="answer" items="${answerList}">
        <tr onclick="window.location.href='/answerViewTeacher=${answer.id}'; return false">
            <td>${answer.student.name} ${answer.student.secondName} ${answer.student.patronymic}</td>
            <td>${answer.date.getTime()}</td>
            <td>${answer.mark.value}</td>
        </tr>
            </c:forEach>
    </table>
</c:if>
</body>
</html>
