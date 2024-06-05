<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/FooterHeader/Header.jsp" %>
<div class="search-bar">
    <form action="apart1" method="get" class="no-style">
        <input type="hidden" name="action" value="search"/>
        <input type="text" name="searchAddress"  placeholder="Введіть адресу для пошуку" />
        <button type="submit">Пошук за адресою</button>
    </form>
    <form action="apart1" method="get" class="no-style"  >
    <input type="hidden" name="action" value="searchParamPage"/>
    <button type="submit" class="search-button">Пошук за параметрами</button>
    </form>
</div>



<h2>Доступні апартаменти</h2>
<form action="apart" method="get" class="no-style"  >
<input type="hidden" name="action" value="createPage" />
<button type="submit" class="add-button" style=" background-color: #45a049">Додати квартиру для оренди</button>
</form>

<div class="sort-buttons">
    <button onclick="location.href='/apart1?action=sortByPrice'" class="sort-button">Сортувати за ціною</button>
    <button onclick="location.href='/apart1?action=sortByArea'" class="sort-button">Сортувати за площею</button>
    <button onclick="location.href='/apart1?action=sortByNumberOfRooms'" class="sort-button">Сортувати за кількістю кімнат</button>
</div>


<c:forEach var="apart" items="${apartments}">
    <div class="apartment">
        <h2><c:out value=" ${apart.address}"/></h2>
        <p><strong>Кількість кімнат:</strong> <c:out value="${apart.numberOfRooms}"/></p>
        <p><strong>Ціна оренди:</strong> <fmt:formatNumber value="${apart.rentPrice}" type="currency"/></p>
        <p><strong>Площа:</strong> <c:out value=" ${apart.area}"/> м^2</p>
        <p><strong>Додаткова інформація:</strong> <c:out value=" ${apart.description}"/></p>
        <form action="apart" method="post">
            <input type="hidden" name="id" value="${apart.id}"/>
            <input type="hidden" name="action" value="delete"/>
            <button type="submit" class="delete-button">Видалити</button>
        </form>
        <form action="apart" method="get">
            <input type="hidden" name="action" value="upgradePage" />
            <input type="hidden" name="id" value="${apart.id}"/>
            <button type="submit" class="update-button">Змінити інформацію</button>
        </form>
    </div>
</c:forEach>

<%@ include file="/jsp/FooterHeader/Footer.jsp" %>



