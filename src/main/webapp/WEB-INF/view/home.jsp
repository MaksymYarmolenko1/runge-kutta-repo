<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Runge-Kutta Calculator</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .form-container {
            width: 60%;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 2px 2px 5px #aaa;
            background-color: #f7f7f7;
        }
        form {
            text-align: left;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"] {
            width: 100%;
            padding: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .checkbox-label {
            display: flex;
            align-items: center;
        }
        .checkbox-label input[type="checkbox"] {
            margin-right: 10px;
        }
        .center-button {
            text-align: center;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>Runge-Kutta Calculator</h1>
        <form name="expressionForm" method="POST" action="/calculate">
            <label for="x0">x0:</label>
            <input type="text" name="x0" id="x0" value="0.0" /><br/>

            <label for="y0">y0:</label>
            <input type="text" name="y0" id="y0" value="1.0" /><br/>

            <label for="x">x:</label>
            <input type="text" name="x" id="x" value="1.0" /><br/>

            <label for="h">h:</label>
            <input type="text" name="h" id="h" value="0.1" /><br/>

            <label for="expression">Expression:</label>
            <input type="text" name="expression" id="expression" value="(5 * x * x - y) / e^(x + y)" disabled/><br/>

            <div class="checkbox-label">
                <input type="checkbox" name="printStacktrace" id="printStacktrace" ${expressionForm.printStacktrace ? 'checked' : ''} />
                <label for="printStacktrace">Print Stack Trace</label>
            </div>

            <div class="center-button">
                <input type="submit" value="Calculate" />
            </div>
        </form>
    </div>
</body>
</html>