<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<br>
<h2>
    Введите данные:
</h2>
<body>
<form action="addtable/" method="POST" accept-charset="UTF-8">
    <label for="surname">Фамилия:</label>
    <input type="text" minlength="2" name="surname" pattern="^[A-Za-zА-Яа-яЁё]+$" id="surname" />
    <br><br>
    <label for="name">Имя:</label>
    <input type="text" minlength="2" name="name" pattern="^[A-Za-zА-Яа-яЁё]+$" id="name" />
    <br><br>
    <label for="age">Возраст:</label>
    <input type="number" minlength="1" name="age" id="age" />
    <br><br>
    <label for="sex">Пол:</label>
    <select name="sex" id="sex">
        <option>м</option>
        <option>ж</option>
    </select>
    <br><br>
    <label for="phone">Номер телефона в формате +(xxx) xxx-xx-xx:</label>
    <input type="tel" name="phone" pattern="\+\([0-9]{3}\)\s[0-9]{3}-[0-9]{2}-[0-9]{2}" id="phone" />
    <br><br>
    <input type="submit" value="Добавить" />
    <br><br>
</form>
<a href="table/">Показать весь список</a>
</body>
</html>
