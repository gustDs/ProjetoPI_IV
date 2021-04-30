<%-- 
    Document   : cadastrar
    Created on : 28/04/2021, 23:19:20
    Author     : Martins
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
    </head>
    <body>
        <c:import url="../header.jsp"/>

        <c:if test="${empty produto}">
            <form action="CadastrarProdutosServlet" method="POST">
             
                <label class="form-label">Filial</label><br/>
                <input type ="text" name="filial" required="true" class="form-control"/><br/><br/>
                <label class="form-label">Nome</label><br/>
                <input type ="text" name="nome" required="true" class="form-control"/><br/><br/>
                <label class="form-label">Categoria</label><br/>
                <input type ="text" name="categoria" required="true" class="form-control"/><br/><br/>
                <label class="form-label">Modelo</label><br/>
                <input type ="text" name="modelo" required="true" class="form-control"/><br/><br/>
                <label class="form-label">Preço</label><br/>
                <input type ="text" name="preco" required="true" class="form-control"/><br/><br/>
                <label class="form-label">Quantidade</label><br/>
                <input type ="text" name="quantidade" required="true" class="form-control"/><br/><br/>

                <button type="submit" class="btn btn-success">Cadastrar</button>
            </form> 
        </c:if>
        <c:if test="${not empty produto}">
            <form action="AlterarProdutosServlet" method="POST">
                <label class="form-label">ID</label><br/>
                <input type ="text" name="id" required="true" value="${produto.id}" hidden = true class="form-control"/> <br/><br/>
                <label class="form-label">Filial</label><br/>
                <input type ="text" name="filial" required="true" value="${produto.filial}" class="form-control"/> <br/><br/>
                <label class="form-label">Nome</label><br/>
                <input type ="text" name="nome" required="true" value="${produto.nome}" class="form-control"/> <br/><br/>
                <label class="form-label">Categoria</label><br/>
                <input type ="text" name="categoria" required="true" value="${produto.categoria}" class="form-control"/> <br/><br/>
                <label class="form-label">Modelo</label><br/>
                <input type ="text" name="modelo" required="true" value="${produto.modelo}" class="form-control"/> <br/><br/>
                <label class="form-label">Preço</label><br/>
                <input type ="text" name="preco" required="true" value="${produto.preco}" class="form-control"/> <br/><br/>
                <label class="form-label">Quantidade</label><br/>
                <input type ="text" name="quantidade" required="true" value="${produto.quantidade}" class="form-control"/> <br/><br/>

                <button type="submit" class="btn btn-success">Alterar</button>
            </form> 
        </c:if>


        <c:import url="../footer.jsp"/>
    </body>
</html>
