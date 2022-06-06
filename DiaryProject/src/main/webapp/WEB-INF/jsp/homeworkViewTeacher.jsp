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
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<h3>Описание домашнего задания</h3>
<p>Дата загрузки: <c:out value="${date}" escapeXml="false"/></p>
<p>Описание: <c:out value="${text}" escapeXml="false"/></p>
<c:if test="${homeworkFiles.size() != 0}">
    <table class="filetable">
        <thead>
        <tr>
            <th>Вложения</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="file" items="${homeworkFiles}">
            <tr onclick="window.location.href='/downloadHomeworkTeacherFiles=${file.id}'; return false">
                <td>${file.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<c:if test="${answerList.size() != 0}">
    <h3>
        Список ответивших
    </h3>
    <table class="table">
        <thead>
        <tr>
            <th>Студент ФИО</th>
            <th>Время ответа</th>
            <th>Оценка</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="answer" items="${answerList}">
            <tr onclick="window.location.href='/answerViewTeacher=${answer.id}'; return false">
                <td>${answer.student.name} ${answer.student.secondName} ${answer.student.patronymic}</td>
                <td>${answer.date.getTime()}</td>
                <td>${answer.mark.value}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
