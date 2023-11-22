<%--
  Created by IntelliJ IDEA.
  User: TGDD
  Date: 11/20/2023
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/money" method="post">
   USD: <input type="number" name="result" placeholder="Nhap usd">
</form>
<button type="submit">Submit</button>
<p>Result: ${result} VND</p>
</body>
</html>
