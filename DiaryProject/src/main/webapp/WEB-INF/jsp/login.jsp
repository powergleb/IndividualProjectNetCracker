<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login</h1>
<c:if test="${param.error != null}">
    <p>Invalid username / password</p>
</c:if>
<c:url var="login" value="/j_spring_security_check"/>
<form action="${login}" method="post">
    <label for="username">User:</label>
    <br>
    <input type="text" id="username" name="username"/>
    <br>
    <label for="password">Password:</label>
    <br>
    <input type="password" id="password" name="password">

    <div>
        <input name="submit" type="submit"/>
    </div>


</form>
</body>
</html>