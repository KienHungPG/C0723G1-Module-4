<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/14/2023
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form method="post" action="/dictionary">
  <div>
    <label for="word">Enter English vocabulary.</label>
    <input id="word" name="text" type="text">
  </div>
  <button type="submit">Enter</button>
</form>
<label>${result}</label>
</body>
</html>
