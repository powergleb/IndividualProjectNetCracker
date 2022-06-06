<%@ page import="com.diary.DiaryProject.entities.Group" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="<c:url value="/resources/js/select.js" />"></script>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <meta charset="utf-8">
    <title>Регистрация</title>
</head>

<body>
<%--@elvariable id="studentForm" type="com.diary.DiaryProject.entities.Student"--%>
<form:form method="POST" modelAttribute="studentForm">
    <h2>Регистрация студента</h2>
    <div>
        <form:input type="text" path="name" placeholder="Имя"
                    autofocus="true"></form:input>
        <form:errors path="name" cssClass="error"></form:errors>
            ${nameError}
    </div>
    <div>
        <form:input type="text" path="secondName" placeholder="Фамилия"
                    autofocus="true"></form:input>
        <form:errors path="secondName" cssClass="error"></form:errors>
            ${secondNameError}
    </div>
    <div>
        <form:input type="text" path="patronymic" placeholder="Отчество"
                    autofocus="true"></form:input>
        <form:errors path="patronymic" cssClass="error"></form:errors>
            ${patronymicError}
    </div>
    <div>
        <form:input type="text" path="login" placeholder="Никнейм"
                    autofocus="true"></form:input>
        <form:errors path="login" cssClass="error"></form:errors>
            ${loginError}
    </div>
    <div>
        <form:input type="text" path="mail" placeholder="Электронная почта"
                    autofocus="true"></form:input>
        <form:errors path="mail" cssClass="error"></form:errors>
            ${mailError}
    </div>
    <div>
        <form:input type="text" path="address" placeholder="Адресс"
                    autofocus="true"></form:input>
        <form:errors path="address" cssClass="error"></form:errors>
            ${addressError}
    </div>
    <div>
        <form:input type="number" path="phone" placeholder="Номер телефона"
                    autofocus="true"></form:input>
        <form:errors path="phone" cssClass="error"></form:errors>
            ${phoneError}
    </div>
    <div>
        <form:input type="password" path="pass" placeholder="Пароль"></form:input>
    </div>
    <div>
        <form:input type="password" path="passwordConfirm"
                    placeholder="Подтвердите пароль"></form:input>
        <form:errors path="passwordConfirm" cssClass="error"></form:errors>
            ${passwordError}
    </div>
    <div class="custom-select" style="width:20%;">
        <form:select path="group">
            <form:option value=""> Укажите группу</form:option>
            <form:options items="${groupForm}" itemValue="id" itemLabel="numberOfGroup"></form:options>
        </form:select>
    </div>
    <div class="error">
        <form:errors path="group" cssClass="error"></form:errors>
            ${groupError}
    </div>

    <button class="button" type="submit">Зарегистрироваться</button>
</form:form>
<a href="/">Главная</a>
</body>
</html>
