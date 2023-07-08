<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form</title>
    <style>
        /* CSS styles */
        body {
            font-family: Arial, sans-serif;
        }

        label {
            font-weight: bold;
            color: #333;
        }

        input[type="radio"] {
            margin-right: 10px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 6px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        .question {
            padding: 10px 0;
        }
    </style>
</head>
<body>
<form method="post" action="HelloServlet">
    <div class="question">
        <label>Question 1: What is the year now?</label>
        <br>
        <input type="radio" name="question1" value="2023"> 2023
        <br>
        <input type="radio" name="question1" value="2024"> 2024
    </div>

    <div class="question">
        <label>Question 2: What do you like more?</label>
        <br>
        <input type="radio" name="question2" value="Beer"> Beer
        <br>
        <input type="radio" name="question2" value="Coca-Cola"> Coca-Cola
    </div>

    <input type="submit" value="Submit">
</form>
</body>
</html>
