<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Runge-Kutta Results</title>
    <style>
        body {
            text-align: center;
        }
        table {
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        .button-container {
            margin-top: 20px;
        }
        .try-another-button {
            background-color: white;
            color: black;
            border: 2px solid black;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Runge-Kutta Calculation Results</h1>
    <table>
        <tr>
            <th>X</th>
            <th>Y</th>
            <th>F1</th>
            <th>F2</th>
            <th>F3</th>
            <th>F4</th>
        </tr>
        <c:forEach items="${resultList}" var="result">
            <tr>
                <td><c:out value="${String.format('%.2f', result.x)}"/></td>
                <td><c:out value="${String.format('%.4f', result.y)}"/></td>
                <td><c:out value="${String.format('%.6f', result.f1)}"/></td>
                <td><c:out value="${String.format('%.6f', result.f2)}"/></td>
                <td><c:out value="${String.format('%.6f', result.f3)}"/></td>
                <td><c:out value="${String.format('%.6f', result.f4)}"/></td>
            </tr>
        </c:forEach>
    </table>

    <div class="button-container">
        <a href="javascript:history.back();" class="try-another-button">Try another one!</a>
    </div>
</body>
</html>