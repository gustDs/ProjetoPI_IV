
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuarios</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body class="container">
        <h1>Lista de Usuarios!</h1>

        <table class="table">
            <th>Nome</th>
            <th>CPF</th>
            <th>E-mail</th>
            <th>Perfil</th>
            <th>Status</th>

            <c:forEach items="${listaUsuarios}" var="usuarios">
                <tr>
                    <td>${usuarios.anNome}</td>
                    <td>${usuarios.nmCpf}</td>
                    <td>${usuarios.anEmail}</td>
                    <td>${usuarios.anPerfil}</td>
                    <td>${usuarios.boInativo}</td>
                    <td><a href="AlterarUsuariosSV?anEmail=${usuarios.anEmail}">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="index.jsp">Voltar</a>
    </body>
</html>
