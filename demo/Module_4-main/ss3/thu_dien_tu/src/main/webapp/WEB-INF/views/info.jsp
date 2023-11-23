<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 19-06-2023
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form>
    <div>
        Languages: ${email.languages}
    </div>
    <div>
        Page Size: ${email.pageSize}
    </div>
    <div>
        <td>
            <c:if test="${email.spamsFilter==false}">
                Disable spams filter
            </c:if>
            <c:if test="${email.spamsFilter==true}">
                Enable spams filter
            </c:if>

        </td>
    </div>
    <div>
        Signature: ${email.signature}
    </div>
    <tr>
        <td></td>
        <td>
            <button class="btn"><a href="/email/setting">Setting</a></button>
        </td>
    </tr>
</form:form>
</body>
</html>
