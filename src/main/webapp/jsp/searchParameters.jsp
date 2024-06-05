<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/FooterHeader/Header.jsp" %>

<h2>Пошук апартаментів за параметрами</h2>
<form action="/apart1" method="get">
  <label for="minRooms">Мінімальна кількість кімнат:</label>
  <input type="number" id="minRooms" name="minRooms" required />

  <label for="maxRooms">Максимальна кількість кімнат:</label>
  <input type="number" id="maxRooms" name="maxRooms" required />

  <label for="minArea">Мінімальна площа (м^2):</label>
  <input type="number" id="minArea" name="minArea" required />

  <label for="maxArea">Максимальна площа (м^2):</label>
  <input type="number" id="maxArea" name="maxArea" required />

  <label for="minRentPrice">Мінімальна ціна оренди:</label>
  <input type="number" id="minRentPrice" name="minRentPrice" required />

  <label for="maxRentPrice">Максимальна ціна оренди:</label>
  <input type="number" id="maxRentPrice" name="maxRentPrice" required />

  <input type="hidden" name="action" value="SearchParameters" class="add-button"/>
  <button type="submit" class="add-button">Пошук</button>
</form>

<%@ include file="/jsp/FooterHeader/Footer.jsp" %>