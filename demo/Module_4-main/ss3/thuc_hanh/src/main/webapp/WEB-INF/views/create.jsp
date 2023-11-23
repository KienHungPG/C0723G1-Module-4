<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<%--@elvariable id="employee" type="java"--%>
<form:form method="post" modelAttribute="employee" action="addEmployee">
    <table>
        <tr>
            <td><form:label path="id">ID:</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="name">ID:</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="contactNumber">Number:</form:label></td>
            <td><form:input path="contactNumber"/></td>
        </tr>
        <tr>
            <td>
                <button type="submit"> submit</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>