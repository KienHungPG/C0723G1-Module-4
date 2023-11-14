<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/14/2023
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency conversion</title>
</head>
<body>
<h1>Currency conversion application</h1>
<form method="post">
    <label for="rate">Rate</label>
    <input type="number" placeholder="Enter rate" id="rate" name="rate">
    <label for="usd">USD</label>
    <input type="number" step="any" name="usd" placeholder="Enter USD" id="usd">
    <button>Convert</button>
    <p>
        Result: ${usd} USD = ${result} VND
    </p>
</form>
</body>
</html>
