<%-- 
    Document   : listaProdutos
    Created on : 28/04/2021, 23:05:41
    Author     : Martins
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lsita de Produtos</title>
        
        <script type="text/javascript">
            function mostrarTelaConfirmacao(nome, id) {
                var modalConfirmacao = $("#confirmarExclusao");
                modalConfirmacao.show();
                
            }
    </head>
    <body class="">
        <c:import url="header.jsp"/>
        <c:import url="navBar.jsp"/>
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
                    <td><a href="AlterarProdutosServlet?id=${produto.id}">Alterar</a></td>
                    <td><button type="button" class="btn btn-link" onclick="mostrarTelaConfirmacao()"</td>
                </tr>
            </c:forEach>    
        </table>
        <div class="modal" id="confirmarExclusao">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Confirmar Exclusão</h5>
                    </div>
                    <div class="modal-body">
                        <p>Confirmar exclusão do cliente <label id="nomeCliente"></label> ?</p>
                        <input type="hidden" id="idCliente"/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                        <button type="button" class="btn btn-primary" onclick="deletarCliente()">Confirmar</button>
                    </div>
                </div>
            </div>
        </div>
        <br/>
    </body>
</html>
