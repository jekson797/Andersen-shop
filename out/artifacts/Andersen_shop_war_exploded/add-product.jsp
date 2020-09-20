<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="availableChoices" scope="request" type="java.util.List"/>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
    <h3>Выберите тип добавляемого товара из списка ниже</h3>
    <form>
        <c:forEach items="${availableChoices}" var="choice">
            <input type="radio" id="${choice}" name="group" value="${choice}">
            <label for="${choice}">${choice}</label>
        </c:forEach>
    </form>
</body>
</html>
