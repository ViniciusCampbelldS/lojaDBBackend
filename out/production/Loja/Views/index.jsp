<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Loja Front End</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Bem-vindo à Loja Front End</h1>
        <p>Data e Hora: <%= new java.util.Date() %></p>
        <p>Sessão ID: <%= session.getId() %></p>
        <% 
            String userName = request.getParameter("user");
            if (userName != null) {
                out.println("<p>Olá, " + userName + "!</p>");
            }
        %>
    </div>
</body>
</html>
