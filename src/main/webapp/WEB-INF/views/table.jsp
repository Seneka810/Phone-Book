
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
               <td contenteditable="false">${customer.getSurname()}</td>
               <td contenteditable="false">${customer.getName()}</td>
               <td contenteditable="false">${customer.getAge()}</td>
               <td contenteditable="false">${customer.getSex()}</td>
               <td contenteditable="false">${customer.getPhone()}</td>

               <td>
                   <form action="updateCustomers.jsp" method="post">
                       <input type="hidden" name="id" value="${customer.getId()}" />
                       <input type="hidden" name="surname" value="${customer.getSurname()}">
                       <input type="hidden" name="name" value="${customer.getName()}">
                       <input type="hidden" name="age" value="${customer.getAge()}">
                       <input type="hidden" name="sex" value="${customer.getSex()}">
                       <input type="hidden" name="phone" value="${customer.getPhone()}">
                       <input type="submit" value="Изменить">
                   </form>
               </td>

           </tr>
       </c:forEach>
   </table>
</body>
</html>
