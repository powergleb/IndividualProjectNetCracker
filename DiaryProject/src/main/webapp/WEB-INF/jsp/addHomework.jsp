<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: groka
  Date: 24.04.2022
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/js/select.js" />"></script>
</head>
<body>
<%--@elvariable id="homeworkForm" type="com.diary.DiaryProject.entities.Homework"--%>
<form:form method="POST"
           action="/addHomework"
           enctype="multipart/form-data"
           modelAttribute="homeworkForm">
    <div>
        <form:textarea type="textarea" path="taskText" placeholder="Описание задания"
                       autofocus="true"></form:textarea>
        <form:errors path="taskText" cssClass="error"></form:errors>
            ${taskTextError}
    </div>
    <div class="custom-select" style="width:200px;">
        <form:select path="group">
            <form:option value=""> Укажите группу</form:option>
            <form:options items="${groupForm}" itemValue="id" itemLabel="numberOfGroup"></form:options>
        </form:select>
    </div>
    <div class="error">
        <form:errors path="group" cssClass="error"></form:errors>
            ${groupError}
    </div>
    <div>
        <input type="file" name="files" multiple="true">
    </div>
    <div class="error">
        <form:errors path="fileInfoList" cssClass="error"></form:errors>
            ${fileInfoListError}
    </div>
    <div>
        <button class="button" type="submit">Загрузить</button>
    </div>
</form:form>
</body>
