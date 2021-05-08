<%-- 
    Document   : vendas
    Created on : 07/05/2021, 22:47:57
    Author     : Martins
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="">
        <c:import url="header.jsp"/>
        <c:import url="navBar.jsp"/>
        <h1>Clientes:</h1>

        <table id="table" class="table">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Data de Nascimento</th>
                    <th>E-mail</th>
                    <th>Endereço</th>
                    <th>Telefone</th>
                    <th>Sexo</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaClientes}" var="cliente">
                    <tr>
                        <td>${cliente.id}</td>
                        <td>${cliente.nome}</td>
                        <td>${cliente.cpf}</td>
                        <td>${cliente.datanasc}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.endereco}</td>
                        <td>${cliente.telefone}</td>
                        <td>${cliente.sexo}</td>
                    </tr>
                </c:forEach> 
            </tbody>   
        </table>
        <h1>Produtos:</h1>
        <table class="table">
            <th>ID</th>
            <th>Filial</th>
            <th>Nome</th>
            <th>Categoria</th>
            <th>Modelo</th>
            <th>Preço</th>
            <th>Quantidade</th>
            
            <c:forEach items="${listaProdutos}" var="produto">
                <tr>
                    <td>${produto.id}</td>
                    <td>${produto.filial}</td>
                    <td>${produto.nome}</td>
                    <td>${produto.categoria}</td>
                    <td>${produto.modelo}</td>
                    <td>${produto.preco}</td>
                    <td>${produto.quantidade}</td>    
                </tr>
            </c:forEach>    
        </table>
    </body>
</html>
