<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: groka
  Date: 01.05.2022
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
</head>
<body>

<p>Дата выставления: <c:out value="${date}" escapeXml="false"/></p>
<p>Текст задания: <c:out value="${text}" escapeXml="false"/></p>
<p>Преподаватель: <c:out value="${teacherSecondName}" escapeXml="false"/>
    <c:out value="${teacherName}" escapeXml="false"/>
    <c:out value="${teacherPatronymic}" escapeXml="false"/></p>
<c:if test="${homeworkFiles.size() != 0}">
    <table class="filetable">
        <thead>
        <tr>
            <th>Вложения</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="file" items="${homeworkFiles}">
            <tr onclick="window.location.href='/downloadfiles=${file.id}'; return false">
                <td>${file.name}</td>
            </tr>
        </c:forEach>
        </tbody>
            <%--        <input type="button" value="скачать на ваш страх и риск" onclick="window.location.href='/downloadfiles=${file.id}'; return false">--%>
    </table>
</c:if>
<input type="button" value="добавить ответ"
       onclick="window.location.href='/homework/addAnswer=${homeworkid}'; return false">
<c:if test="${answerList.size() != 0}">
    <h3>
        Список ваших ответов
    </h3>
    <table class="table">
        <thead>
        <tr>
            <th>Время ответа</th>
            <th>Оценка</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="answer" items="${answerList}">
            <tr onclick="window.location.href='/answerViewStudent=${answer.id}'; return false">
                <td>${answer.date.getTime()}</td>
                <td>${answer.mark.value}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>


</body>
</html>
