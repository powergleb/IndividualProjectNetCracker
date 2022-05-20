<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: groka
  Date: 13.05.2022
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function addCommentBtnClick() {
            document.getElementById('formComment').style.display = 'block';
            document.getElementById('addCommentBtn').style.display = 'none';
        }

        function cancelCommentBtnClick() {
            document.getElementById('formComment').style.display = 'none';
            document.getElementById('addCommentBtn').style.display = 'block';
        }
    </script>
</head>
<body>
<c:out value="${date}" escapeXml="false"/>
<c:out value="${text}" escapeXml="false"/>
<c:out value="${studentName}" escapeXml="false"/>
<c:out value="${studentSecondName}" escapeXml="false"/>
<c:out value="${studentPatronymic}" escapeXml="false"/>

<table>

    <c:forEach var="file" items="${answerFiles}">
    <tr onclick="window.location.href='/downloadAnswerFiles=${file.id}'; return false">
        <td>${file.name}</td>
    <tr>
            <%--        <input type="button" value="скачать на ваш страх и риск" onclick="window.location.href='/downloadfiles=${file.id}'; return false">--%>
        </c:forEach>
</table>
<c:if test="${mark != null}">
    <c:out value="Оценка ${mark} баллов" escapeXml="false"/>
</c:if>

<c:if test="${commentList.size() != 0}">
    <table style="border: 2px solid black;">
        <tr>
            <th colspan="3">Комментарии</th>
        </tr>
        <tr>
            <th>ФИО</th>
            <th>Время ответа</th>
            <th>Текст</th>
        </tr>
        <c:forEach var="comment" items="${commentList}">
            <tr>
                <td>${comment.user.name} ${comment.user.secondName} ${comment.user.patronymic}</td>
                <td>${comment.date.getTime()}</td>
                <td>${comment.commentText}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<input type="button" value="Добавить комментарий" id=addCommentBtn name="button" onClick='addCommentBtnClick()'
       style="display: block;"/>
<%--@elvariable id="commentForm" type="com.diary.DiaryProject.entities.Comment"--%>
<form:form id="formComment" action="createCommentStudent=${idAnswer}" method="POST" modelAttribute="commentForm"
           style="display: none;">
    <div>

        <form:textarea type="textarea" path="commentText" placeholder="Описание ответа"
                       autofocus="true"></form:textarea>
        <form:errors path="commentText"></form:errors>
            ${commentTextError}
    </div>
    <input type="submit" id=submitBtn value="Подтвердить"/>
    <input type="button" value="Отменить" id=cancelCommentBtn onClick='cancelCommentBtnClick()'/>
</form:form>
</body>
</html>
