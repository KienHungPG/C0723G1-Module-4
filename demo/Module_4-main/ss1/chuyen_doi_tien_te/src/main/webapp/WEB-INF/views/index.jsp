<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<br/>
<form method="post" action="/calculator">
    <div>
        <label>Nhập USD</label>
        <input name="money">
    </div>
    <button type="submit">Change</button>
</form>

<label> ${result} VND</label>
</body>
</html>