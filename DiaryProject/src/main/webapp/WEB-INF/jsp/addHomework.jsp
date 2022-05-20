<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<%--    <link rel="stylesheet" href="resources/css/style.css">--%>
<%--    <script src="resources/js/dragdrop.js"></script>--%>
</head>
<%--@elvariable id="homeworkForm" type="com.diary.DiaryProject.entities.Homework"--%>
<form:form method="POST"
           action="/addHomework"
           enctype="multipart/form-data"
           modelAttribute="homeworkForm">
    <div>
        <form:textarea type="textarea" path="taskText" placeholder="Описание задания"
                       autofocus="true"></form:textarea>
        <form:errors path="taskText"></form:errors>
            ${secondNameError}
    </div>
    <div>
        <form:select path="group">
            <form:option value=""> Укажите группу</form:option>
            <form:options items="${groupForm}" itemValue="id" itemLabel="numberOfGroup"></form:options>
        </form:select>
        <form:errors path="group"></form:errors>
            ${groupError}
    </div>
    <div>
        File to upload: <input type="file" name="files" multiple="true">
    </div>

<%--<div>--%>
<%--    <div id="drop-area">--%>
<%--        <form class="my-form">--%>
<%--            <p>Upload multiple files with the file dialog or by dragging and dropping images onto the dashed region</p>--%>
<%--            <input type="file" id="fileElem" multiple accept="image/*" onchange="handleFiles(this.files)">--%>
<%--            <label class="button" for="fileElem">Select some files</label>--%>
<%--        </form>--%>
<%--        <progress id="progress-bar" max=100 value=0></progress>--%>
<%--        <div id="gallery" /></div>--%>
<%--</div>--%>
<%--</div>--%>


    <div>>
        <input type="submit" value="submit"> Press here to upload the file!
    </div>
    <form:errors path="fileInfoList"></form:errors>
    ${filesForHomeworkError}
</form:form>

