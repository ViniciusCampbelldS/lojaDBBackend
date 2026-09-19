<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Funcionários</title>
</head>
<body>
<h1>Funcionários da Loja</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Função</th>
        <th>CPF</th>
        <th>Salário</th>
    </tr>
    <c:forEach var="funcionario" items="${funcionarios}">
        <tr>
            <td>${funcionario.id}</td>
            <td>${funcionario.name}</td>
            <td>${funcionario.funcao}</td>
            <td>${funcionario.cpf}</td>
            <td>${funcionario.salario}</td>
        </tr>
    </c:forEach>
</table>
</body>

</html>