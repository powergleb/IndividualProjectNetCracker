<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: groka
  Date: 06.05.2022
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<%--@elvariable id="answerForm" type="com.diary.DiaryProject.entities.Answer"--%>
<form:form method="POST"
           action="/homework/addAnswer=${homeworkid}"
           enctype="multipart/form-data"
           modelAttribute="answerForm">
    <div>
        <form:textarea type="textarea" path="taskText" placeholder="Описание ответа"
                       autofocus="true"></form:textarea>
        <form:errors path="taskText" cssClass="error"></form:errors>
            ${taskTextError}
    </div>
    <div>
        <input type="file" name="files" multiple="true">
    </div>
    <div>
        <button class="button" type="submit">Загрузить</button>
    </div>
    <form:errors path="fileInfoList" cssClass="error"></form:errors>
    ${fileInfoListError}
</form:form>
</body>
</html>
