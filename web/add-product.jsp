<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
    <h3>Выберите тип добавляемого товара из списка ниже:</h3>
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/add-product/phone">Телефон</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/pc">Компьютер</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/notebook">Ноутбук</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/monitor">Монитор</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/game-console">Игровая приставка</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/computer-accessory">Компьютерный Аксессуар</a>
        </li>
    </ul>
</body>
</html>
