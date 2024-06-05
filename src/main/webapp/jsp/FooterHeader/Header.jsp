<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MyApartments</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Style.css">
</head>
<body>
<div class="header">
    <h1>MyApartments</h1>
    <c:if test="${not empty sessionScope.user}">
        <form action="logout" method="post" style="display:inline;">
            <button type="submit" class="logout-button">Log Out</button>
        </form>
    </c:if>
</div>
<div class="container">
</div>