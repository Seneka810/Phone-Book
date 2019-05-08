<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: IUAD1DEN
  Date: 08.05.2019
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Весь список</title>
</head>
<body>
   <table border="2">
       <tr>
           <td>№</td>
           <td>Фамилия</td>
           <td>Имя</td>
           <td>Возраст</td>
           <td>Пол</td>
           <td>Телефон</td>
       </tr>
       <jsp:useBean id="customers" scope="request" type="java.util.List"/>
       <c:forEach items="${customers}" var="customer">
           <tr>
               <td>${customer.getId()}</td>
               <td contenteditable="true">${customer.getSurname()}</td>
               <td contenteditable="true">${customer.getName()}</td>
               <td contenteditable="true">${customer.getAge()}</td>
               <td contenteditable="true">${customer.getSex()}</td>
               <td contenteditable="true">${customer.getPhone()}</td>
           </tr>
       </c:forEach>
   </table>
</body>
</html>
