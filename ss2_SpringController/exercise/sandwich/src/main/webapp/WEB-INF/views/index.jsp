<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/15/2023
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<h3>Sandwich Condiments</h3>
<form method="post" action="/save">
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    <hr>
    <button type="submit">Save</button>
</form>
<br>
<label>${result}</label>
</body>
</html>
