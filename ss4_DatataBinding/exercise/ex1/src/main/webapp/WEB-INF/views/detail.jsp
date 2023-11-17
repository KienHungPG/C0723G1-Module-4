<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/16/2023
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form>
    <div>
        Languages: ${email.getLanguages()}
    </div>
    <div>
        Page Size: ${email.getPageSize()}
    </div>
    <div>
        <td>
            <c:if test="${email.isSpamsFilter()==false}">
                Disable spams filter
            </c:if>
            <c:if test="${email.isSpamsFilter()==true}">
                Enable spams filter
            </c:if>

        </td>
    </div>
    <div>
        Signature: ${email.getSignature()}
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
