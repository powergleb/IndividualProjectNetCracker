<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <form:errors path="taskText"></form:errors>
            ${taskTextError}
    </div>
    <div>
        File to upload: <input type="file" name="files" multiple="true">
    </div>



    <div>>
        <input type="submit" value="submit"> Press here to upload the file!
    </div>
    <form:errors path="fileInfoList"></form:errors>
    ${filesForAnswerError}
</form:form>
</body>
</html>
