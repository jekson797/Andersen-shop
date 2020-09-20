<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="products" scope="request" type="java.util.List"/>
<html>
<head>
    <title>Catalog</title>
</head>
    <body>
    <h1>Магазин Дядюшки Бобби :)</h1>
    <a href="${pageContext.request.contextPath}/add-product">Добавить продукт</a>
    <h3>Список продуктов</h3>
    <ul>
        <c:forEach items="${products}" var="product">
            <li>
                <p>Название: ${product.brand} ${product.model}</p>
                <p>Категория: ${product.group}</p>
                <p>Цена: ${product.price} ${product.currency}</p>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
