<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>

<head>
    <meta charset = "utf-8">
<%--    <title>Главная</title>--%>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div>
    <h2>${pageContext.request.userPrincipal.name}</h2>
    <sec:authorize access="!isAuthenticated()">
        <h3><a href="/j_spring_security_check">Войти</a></h3>
        <h3><a href="/registrationBase">Зарегистрироваться</a></h3>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h3><a href="/j_spring_security_logout">Выйти</a></h3>
    </sec:authorize>
    <sec:authorize access = "hasAuthority('TEACHER')">
        <h3><a href="/addHomework">Добавить домашнее задание (только учитель)</a></h3>
    </sec:authorize>
    <sec:authorize access = "hasAuthority('TEACHER')">
        <h3><a href="/groupViewTeacher">Просмотр домашних заданий и ответов на них</a></h3>
    </sec:authorize>
    <sec:authorize access = "hasAuthority('STUDENT')">
        <h3><a href="/homeworkListView">Посмотреть список домашних заданий</a></h3>
    </sec:authorize>
</div>
</body>
</html>