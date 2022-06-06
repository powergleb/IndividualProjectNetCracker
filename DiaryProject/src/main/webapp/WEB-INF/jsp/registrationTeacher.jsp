<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <meta charset="utf-8">
    <title>Регистрация</title>
</head>

<body>
<div>
    <%--@elvariable id="teacherForm" type="com.diary.DiaryProject.entities.Teacher"--%>
    <form:form method="POST" modelAttribute="teacherForm">
        <h2>Регистрация учителя</h2>
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
        <button type="submit">Зарегистрироваться</button>
    </form:form>
    <a href="/">Главная</a>
</div>
</body>
</html>
