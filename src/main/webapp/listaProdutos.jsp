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
            function mostrarTelaConfirmacao(modelo, id) {
                
                $("#modeloProduto").html(modelo);
                $("#idProduto").val(id);
                
                var modalConfirmacao = $("#confirmarExclusao");
                modalConfirmacao.show();
                
            }
            
            function fecharTelaConfirmacao() {
                $("#confirmarExclusao").hide();
            }
            
            function deletarProduto() {
                var id = $("#idProduto").val();
                fecharTelaConfirmacao();
                $.ajax("ExcluirProdutosServlet?id=" + id).done(function () {
                    //SUCESSO
                    location.reload();
                })
                        .fail(function () {
                            console.log("error");
                        });
            }
            
        </script>
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
                    <td><button type="button" class="btn btn-link" onclick="mostrarTelaConfirmacao(`${produto.modelo}`, `${produto.id}`)">Excluir</td>
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
                        <p>Confirmar exclusão do produto <label id="modeloProduto"></label> ?</p>
                        <input type="hidden" id="idProduto"/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                        <button type="button" class="btn btn-primary" onclick="deletarProduto()">Confirmar</button>
                    </div>
                </div>
            </div>
        </div>
        <br/>
    </body>
</html>
