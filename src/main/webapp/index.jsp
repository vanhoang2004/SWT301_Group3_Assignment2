<%@ page import="test.integration.swt_assignment_2.model.CustomerType" %>
<%@ page import="test.integration.swt_assignment_2.model.EmployeeType" %>
<%@ page import="test.integration.swt_assignment_2.model.ItemType" %><%--a jsp page with input fields for customer type, employee type, item type and item price--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 8px;
            font-weight: bold;
            color: #555;
        }
        input[type="text"], input[type="number"], select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            transition: border-color 0.3s;
        }
        input[type="text"]:focus, input[type="number"]:focus, select:focus {
            border-color: #4CAF50;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin-top: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .result {
            margin-top: 20px;
            padding: 10px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
            border-radius: 4px;
        }
    </style>
    <meta charset="UTF-8">
    <title>Commission Calculator</title>
</head>
<body>
    <div class="container">
        <h2>Commission Calculator</h2>
        <form action="calculate" method="post">
            <label for="customerType">Customer Type:</label>
            <select id="customerType" name="customerType" required>
                <% for (CustomerType type : (CustomerType[]) request.getAttribute("customerTypes")) { %>
                <option value="<%= type.name() %>"><%= type.name() %></option>
                <% } %>
            </select>

            <label for="employeeType">Employee Type:</label>
            <select id="employeeType" name="employeeType" required>
                <% for (EmployeeType type : (EmployeeType[]) request.getAttribute("employeeTypes")) { %>
                <option value="<%= type.name() %>"><%= type.name() %></option>
                <% } %>
            </select>

            <label for="itemType">Item Type:</label>
            <select id="itemType" name="itemType" required>
                <% for (ItemType type : (ItemType[]) request.getAttribute("itemTypes")) { %>
                <option value="<%= type.name() %>"><%= type.name() %></option>
                <% } %>
            </select>

            <label for="itemPrice">Item Price:</label>
            <input type="number" id="itemPrice" name="itemPrice" required value="<%= request.getAttribute("itemPrice") != null ? request.getAttribute("itemPrice").toString() : "" %>">

            <input type="submit" value="Calculate Commission">
        </form>

        <% if (request.getAttribute("commission") != null) { %>
        <div class="result">
            <label for="result">Commission:</label>
            <input id="result" type="text" name="commission" value="<%= request.getAttribute("commission").toString() %>" readonly>
        </div>
        <% } %>
    </div>
</body>
</html>
