<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Список продуктов</h1>
    <c:forEach items="$products" var="product">
        <p>Название: ${product.brand} ${product.model}</p>
        <p>Категория: ${product.category}</p>
        <p>Цена: ${product.price} ${product.currency}</p>
    </c:forEach>
</body>
</html>
