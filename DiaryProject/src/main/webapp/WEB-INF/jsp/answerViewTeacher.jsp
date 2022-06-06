<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: groka
  Date: 10.05.2022
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
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
<p>Дата выставления: <c:out value="${date}" escapeXml="false"/></p>
<p>Текст задания: <c:out value="${text}" escapeXml="false"/></p>
<p>ФИО ответившего: <c:out value="${studentName}" escapeXml="false"/>
    <c:out value="${studentSecondName}" escapeXml="false"/>
    <c:out value="${studentPatronymic}" escapeXml="false"/></p>


<c:if test="${answerFiles.size() != 0}">
    <table class="filetable">
        <thead>
        <tr>
            <th>Вложения</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="file" items="${answerFiles}">
            <tr onclick="window.location.href='/downloadAnswerFiles=${file.id}'; return false">
                <td>${file.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<p><c:if test="${mark != null}">
    <c:out value="Оценка ${mark}" escapeXml="false"/>
</c:if></p>

<c:if test="${mark == null}">
    <%--    <input type="button" value="Оценить" id=addMarkBtn name="button" onClick='addMarkBtnClick()' style="display: block;"/>--%>
    <%--@elvariable id="markForm" type="com.diary.DiaryProject.entities.Mark"--%>
    <form:form id="markForm" action="createMarkTeacher=${idAnswer}" method="POST" modelAttribute="markForm"
               style="display: block;">
        <div>

            <form:input type="number" path="value" placeholder="Оценка"
                        autofocus="true"></form:input>
            <div id="valueError">
                <form:errors id="valueError" path="value" cssClass="error"></form:errors>
                    ${valueError}
            </div>
        </div>
        <input type="submit" id=submitBtn value="Подтвердить"/>
        <%--        <input type="button" value="Отменить" id=cancelMarkBtn onClick='cancelMarkBtnClick()'/>--%>
    </form:form>
</c:if>
<c:if test="${commentList.size() != 0}">
    <h3>
        Комментарии
    </h3>
    <table class="table">
        <thead>
        <tr>
            <th>Текст</th>
            <th>ФИО</th>
            <th>Время ответа</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="comment" items="${commentList}">
            <tr>
                <td>${comment.commentText}</td>
                <td>${comment.user.name} ${comment.user.secondName} ${comment.user.patronymic}</td>
                <td>${comment.date.getTime()}</td>

            </tr>
        </c:forEach>
        </tbody>

    </table>
</c:if>
<c:out value="${commentTextError}" escapeXml="false"/>
<input type="button" value="Добавить комментарий" id=addCommentBtn name="button" onClick='addCommentBtnClick()'
       style="display: block;"/>
<%--@elvariable id="commentForm" type="com.diary.DiaryProject.entities.Comment"--%>
<form:form id="formComment" action="createCommentTeacher=${idAnswer}" method="POST" modelAttribute="commentForm"
           style="display: none;">
    <div>

        <form:textarea type="textarea" path="commentText" placeholder="Текст комментария"
                       autofocus="true"></form:textarea>
        <form:errors path="commentText" cssClass="error"></form:errors>
            ${commentTextError}
    </div>
    <input type="submit" id=submitBtn value="Подтвердить"/>
    <input type="button" value="Отменить" id=cancelCommentBtn onClick='cancelCommentBtnClick()'/>
</form:form>

</body>
</html>
