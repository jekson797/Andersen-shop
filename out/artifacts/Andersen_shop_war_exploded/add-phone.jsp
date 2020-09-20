<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Add Phone</title>
</head>
<body>
    <form action="/">
        <div>
            <label for="brand">Бренд:</label>
            <input type="text" id="brand" name="brand">
        </div>
        <div>
            <label for="model">Модель:</label>
            <input type="text" id="model" name="model">
        </div>
        <div>
            <label for="os">Операционная система:</label>
            <input type="text" id="os" name="os">
        </div>
        <div>
            <label for="memorySize">Размер памяти:</label>
            <input type="text" id="memorySize" name="memorySize">
        </div>
        <div>
            <label for="ram">Размер операционной памяти:</label>
            <input type="text" id="ram" name="ram">
        </div>
        <div>
            <label for="coresNumber">Количество ядер:</label>
            <input type="text" id="coresNumber" name="coresNumber">
        </div>
        <div>
            <label for="diagonal">Диагональ экрана:</label>
            <input type="text" id="diagonal" name="diagonal">
        </div>
        <div>
            <label for="price">Цена:</label>
            <input type="text" id="price" name="price">
        </div>
        <div>
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
