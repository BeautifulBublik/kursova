<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/FooterHeader/Header.jsp" %>
<style>
    form{
        text-align: center;
    }
</style>

<h2>Додати квартиру для оренди</h2>
<form action="/apart" method="POST">
    <label for="address">Адреса:</label><br>
    <input type="text" id="address" name="address" required><br><br>

    <label for="numberOfRooms">Кількість кімнат:</label><br>
    <input type="number" id="numberOfRooms" name="numberOfRooms" required><br><br>

    <label for="rentPrice">Ціна оренди:</label><br>
    <input type="number" id="rentPrice" name="rentPrice" required><br><br>

    <label for="area">Площа (кв. м):</label><br>
    <input type="number" id="area" name="area" required><br><br>

    <label for="description">Опис:</label><br>
    <textarea id="description" name="description" rows="4" cols="50" required></textarea><br><br>

    <input type="hidden" name="action" value="create">
    <button  type="submit" class="add-button">Додати</button>
</form>

<%@ include file="/jsp/FooterHeader/Footer.jsp" %>
