<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/15/2023
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>CALCULATOR</title>
</head>
<body>
<h2>CALCULATOR</h2>
<div>
    <form method="post" action="/calculator">
        <div>
            <label for="num1"> Number 1 :</label>
            <input type="number" name="num1" id="num1">
        </div>
        <div>
            <label for="num2"> Number 2 :</label>
            <input type="number" name="num2" id="num2">
        </div>
        <br>
        <button type="submit" name="calculator" value="addition">Addition(+)</button>
        <button type="submit" name="calculator" value="subtraction">Subtraction(-)</button>
        <button type="submit" name="calculator" value="multiplication">Multiplication(X)</button>
        <button type="submit" name="calculator" value="division">Divion(/)</button>
    </form>
</div>
<hr>
<label>Result: ${result}</label>
</body>
</html>
