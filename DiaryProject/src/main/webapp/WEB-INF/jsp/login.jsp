<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<h1>Login</h1>

<c:url var="login" value="/j_spring_security_check"/>
<form action="${login}" method="post">
    <input type="text" id="username" name="username" placeholder="Логин:"/>
    <input type="password" id="password" name="password" placeholder="Пароль">
    <c:if test="${param.error != null}">
        <div class="error">Неверный пароль или логин</div>
    </c:if>
    <div>
        <button class="button" type="submit">Войти</button>
    </div>
</form>

</body>
</html>