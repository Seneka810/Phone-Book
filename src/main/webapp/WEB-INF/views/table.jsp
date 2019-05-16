
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
               <td>${customer.getSurname()}</td>
               <td>${customer.getName()}</td>
               <td>${customer.getAge()}</td>
               <td>${customer.getSex()}</td>
               <td>${customer.getPhone()}</td>
               <td>
                   <jsp:forward page="updateCustomers.jsp">
                       <input type="number" name="id" value="${customer.getId()}" />
                       <input type="text" name="surname" value="${customer.getSurname()}">
                       <input type="text" name="name" value="${customer.getName()}">
                       <input type="number" name="age" value="${customer.getAge()}">
                       <input type="text" name="sex" value="${customer.getSex()}">
                       <input type="tel" name="phone" value="${customer.getPhone()}">
                       <input type="submit" value="Изменить">
                   </jsp:forward>
               </td>

           </tr>
       </c:forEach>
   </table>
</body>
</html>
