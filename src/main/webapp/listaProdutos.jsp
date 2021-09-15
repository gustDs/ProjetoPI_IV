<%-- 
    Document   : listaProdutos
    Created on : 12/09/2021, 17:08:26
    Author     : Martins
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>
    </head>
    <body>
        <h1>Produtos:</h1>

        <table>
            <th>ID</th>
            <th>Nome</th>
            <th>Avalicação</th>
            <th>Descrição</th>
            <th>Valor</th>
            <th>Quantidade</th>
            <th>Status</th>


            <c:forEach items="${listaProdutos}" var="produtos">
                <tr>
                    <td>${produtos.wId}</td>
                    <td>${produtos.wNome}</td>
                    <td>${produtos.wAvaliacao}</td>
                    <td>${produtos.wDesc}</td>
                    <td>${produtos.wValor}</td>
                    <td>${produtos.wQtdProduto}</td>
                    <td>${produtos.wStatus}</td>
                    <td><a href="StatusProdutosSV?wId=${produtos.wId}">Inativar</a></td>
                    <td><a href="AlterarProdutosSV?wId=${produtos.wId}">Alterar</a></td>
                </tr>
            </c:forEach>

        </table>
        <br/>
        <a href="index.jsp">Voltar</a><br/>
        <a href="cadastraProdutos.jsp">Cadastrar novo Produto</a>
    </body>
</html>
