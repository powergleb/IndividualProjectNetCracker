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

</head>
<body>
<c:out value="${date}" escapeXml="false" />
<c:out value="${text}" escapeXml="false" />
<c:out value="${teacherName}" escapeXml="false" />
<c:out value="${teacherSecondName}" escapeXml="false" />
<c:out value="${teacherPatronymic}" escapeXml="false" />
<table>

<c:forEach var="file" items="${homeworkFiles}">
        <tr onclick="window.location.href='/downloadfiles=${file.id}'; return false">
            <td>${file.name}</td>
        <tr>
<%--        <input type="button" value="скачать на ваш страх и риск" onclick="window.location.href='/downloadfiles=${file.id}'; return false">--%>
</c:forEach>
</table>
<input type="button" value="добавить ответ" onclick="window.location.href='/homework/addAnswer=${homeworkid}'; return false">

<c:if test="${answerList.size() != 0}">
    <table style="border: 2px solid black;">
        <tr>
            <th colspan="3">Список ваших ответов</th>
        </tr>
        <tr>
            <th>Время ответа</th>
            <th>Оценка</th>
        </tr>
        <c:forEach var="answer" items="${answerList}">
            <tr onclick="window.location.href='/answerViewStudent=${answer.id}'; return false">
                <td>${answer.date.getTime()}</td>
                <td>${answer.mark.value}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>


</body>
</html>
