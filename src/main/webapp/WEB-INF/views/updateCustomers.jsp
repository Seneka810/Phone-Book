<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: IUAD1DEN
  Date: 08.05.2019
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить данные пользователя</title>
</head>
<body>
Редактировать пользователя
<form action="/table/${param.id}" method="post">
    <input type="hidden" name = "id" value="${param.id}">
    <input type="text" name="surname" value="${param.surname}" placeholder="${param.surname}">
    <input type="text" name="name" value="${param.name}" placeholder=${param.name}>
    <input type="text" name="age" value="${param.age}" placeholder=${param.age}>
    <input type="text" name="sex" value="${param.sex}" placeholder=${param.sex}>
    <input type="text" name="phone" value="${param.phone}" placeholder=${param.phone}>
    <input type="submit" value="Обновить">
</form>
</body>
</html>
