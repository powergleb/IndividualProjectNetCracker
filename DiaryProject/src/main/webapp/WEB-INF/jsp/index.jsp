<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Главная</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div>
    <h3>${pageContext.request.userPrincipal.name}</h3>
    <sec:authorize access="!isAuthenticated()">
        <h4><a href="/j_spring_security_check">Войти</a></h4>
        <h4><a href="/registrationBase">Зарегистрироваться</a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/j_spring_security_logout">Выйти</a></h4>
    </sec:authorize>
    <sec:authorize access = "hasAuthority('TEACHER')">
        <h4><a href="/addHomework">Добавить домашнее задание (только учитель)</a></h4>
    </sec:authorize>
    <sec:authorize access = "hasAuthority('TEACHER')">
        <h4><a href="/groupViewTeacher">Просмотр домашних заданий и ответов на них</a></h4>
    </sec:authorize>
    <sec:authorize access = "hasAuthority('STUDENT')">
        <h4><a href="/homeworkListView">Посмотреть список домашних заданий</a></h4>
    </sec:authorize>



</div>
</body>
</html>