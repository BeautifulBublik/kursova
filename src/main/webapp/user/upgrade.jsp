<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/FooterHeader/Header.jsp" %>
<style>
    form{
        text-align: center;
    }
</style>
<html>

<body>
<form action="apart" method="POST">
    <input type="hidden" name="id" value="${apartam.id}" />
    <input type="hidden" name="command" value="upgrade" />
    <label for="address">Адреса:</label><br>
    <input type="text" id="address" name="address1"  value="<c:out value="${apartam.address}"/>" required><br><br>

    <label for="numberOfRooms">Кількість кімнат:</label><br>
    <input type="number" id="numberOfRooms" name="numberOfRooms1" value="<c:out value="${apartam.numberOfRooms}"/>" required><br><br>

    <label for="rentPrice">Ціна оренди:</label><br>
    <input type="number" id="rentPrice" name="rentPrice1"  value="<c:out value="${apartam.rentPrice}"/>" required><br><br>

    <label for="area">Площа (кв. м):</label><br>
    <input type="number" id="area" name="area1" value="<c:out value="${apartam.area}"/>" required><br><br>

    <label for="description">Опис:</label><br>
    <textarea id="description" name="description1"  rows="4" cols="50" value="<c:out value="${apartam.description}"/>" required><c:out value="${apartam.description}"/></textarea><br><br>
    <input type="hidden" name="action" value="upgrade" class="add-button"/>
    <button  type="submit" class="add-button">Зберегти зміни</button>
</form>
</body>
<%@ include file="/jsp/FooterHeader/Footer.jsp" %>
</html>
