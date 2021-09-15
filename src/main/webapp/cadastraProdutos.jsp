<%-- 
    Document   : cadastrarProdutos
    Created on : 13/09/2021, 17:14:02
    Author     : Martins
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produtos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    </head>
    <body class="container">
        <h1>Cadastro de Produtos</h1>

        <c:if test="${empty produtos}">
            <form action="CadastrarProdutosSV" method="POST">
                <label>Nome</label><br/>
                <input type="text" name="anNome" required="true" class="form-control"/> <br/><br/>
                <label>Avaliação</label><br/>
                <input type="text" name="nmAvaliacao" required="true" class="form-control"/> <br/><br/>
                <label>Descrição</label><br/>
                <textarea row="6" style="width: 26em;" name="anDescricao" required="true" class="form-control"></textarea> <br/><br/>
                <label>Valor</label><br/>
                <input type="text" name="vlProduto" required="true" class="form-control"/> <br/><br/>
                <label>Quantidade</label><br/>
                <input type="text" name="qtProduto" required="true" class="form-control"/> <br/><br/>

                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </c:if>
        <c:if test="${not empty produtos}">
            <form action="AlterarProdutosSV" method="POST">
                <input type="text" name="id" required="true" class="form-control" value="${produtos.wId}" hidden="true"/> <br/><br/>
                <label>Nome</label><br/>
                <input type="text" name="anNome" required="true" class="form-control" value="${produtos.wNome}"/> <br/><br/>
                <label>Avaliação</label><br/>
                <input type="text" name="nmAvaliacao" required="true" class="form-control" value="${produtos.wAvaliacao}"/> <br/><br/>
                <label>Descrição</label><br/>
                <input type="text" name="anDescricao" required="true" class="form-control" value="${produtos.wDesc}"/> <br/><br/>
                <label>Valor</label><br/>
                <input type="text" name="vlProduto" required="true" class="form-control" value="${produtos.wValor}"/> <br/><br/>
                <label>Quantidade</label><br/>
                <input type="text" name="qtProduto" required="true" class="form-control" value="${produtos.wQtdProduto}"/> <br/><br/>

                <button type="submit" class="btn btn-primary">Atualizar</button>
            </form>
        </c:if>


        <a href="ListarProdutosSV">Cancelar</a>
    </body>
</html>
