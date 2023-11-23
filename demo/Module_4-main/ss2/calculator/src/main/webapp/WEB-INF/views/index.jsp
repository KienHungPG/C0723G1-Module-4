<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>CALCULATOR</h2>
<div>
    <form method="post" action="/calculator">
        <div>
            <label> Number 1 :</label>
            <input type="number" name="num1">
        </div>
        <div>
            <label> Number 2 :</label>
            <input type="number" name="num2">
        </div>
        <button type="submit" name="calculator" value="addition">Addition</button>
        <button type="submit" name="calculator" value="subtraction">Subtraction</button>
        <button type="submit" name="calculator" value="multiplication">Multiplication</button>
        <button type="submit" name="calculator" value="division">Divion</button>
    </form>
</div>
<label>Result: ${result}</label>
</body>
</html>