<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/16/2023
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Setting</h2>
<div>
    <table border="1">
        <form:form action="/email/save" modelAttribute="email" method="post">
            <tr>
                <th> Languages</th>
                <td><form:select path="languages" items="${languages}"/></td>
            </tr>
            <tr>
                <th>Page Size</th>
                <td>Show <form:select path="pageSize" items="${pageSize}"/> emails per page</td>
            </tr>
            <tr>
                <th> Spams Filter</th>
                <td><form:checkbox path="spamsFilter"/> Enable spams filter</td>
            </tr>
            <tr>
                <th>Signature</th>
                <td><form:textarea path="signature" cssStyle="width: 177px; height: 78px;"/></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">Save</button>
                    <button type="reset">Cancel</button>
                </td>
            </tr>
        </form:form>
    </table>
</div>
</body>
</html>
