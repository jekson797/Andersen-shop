<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Add Phone</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/add-product/phone" method="post">
        <div>
            <label for="brand">Бренд:</label>
            <input type="text" id="brand" name="brand" required>
        </div>
        <div>
            <label for="model">Модель:</label>
            <input type="text" id="model" name="model" required>
        </div>
        <div>
            <label for="os">Операционная система:</label>
            <input type="text" id="os" name="os" required>
        </div>
        <div>
            <label for="memorySize">Размер памяти (GB):</label>
            <input type="number" id="memorySize" name="memorySize" required>
        </div>
        <div>
            <label for="ram">Размер оперативной памяти (GB):</label>
            <input type="number" id="ram" name="ram" required>
        </div>
        <div>
            <label for="coresNumber">Количество ядер:</label>
            <input type="number" id="coresNumber" name="coresNumber" required>
        </div>
        <div>
            <label for="diagonal">Диагональ экрана:</label>
            <input type="number" step=".01" id="diagonal" name="diagonal" required>
        </div>
        <div>
            <label for="price">Цена:</label>
            <input type="number" step=".01" id="price" name="price" required>
            <label for="currency"></label>
            <select name="currency" id="currency">
                <option value="usd">USD</option>
                <option value="eur">EUR</option>
                <option value="rub">RUB</option>
                <option value="byr">BYR</option>
            </select>
        </div>
        <div>
            <input type="submit" value="Добавить товар">
        </div>
    </form>
</body>
</html>
