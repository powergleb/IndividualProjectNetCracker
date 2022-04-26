<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: groka
  Date: 24.04.2022
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form method="POST"
           action="/addHomework"
           enctype="multipart/form-data">
    <div>
        File to upload: <input type="file" name="file">
    </div>
    <div>
        <input type="submit" value="submit"> Press here to upload the file!
    </div>
    <form:errors path="fileError"></form:errors>
    ${fileError}
</form:form>