<%-- 
    Document   : footer
    Created on : 22/04/2021, 22:48:01
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
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class=" navbar-collapse">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ClientesServlet">Lista Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="clientes/cadastrar.jsp">Cadastrar Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ProdutosServlet">Lista Produtos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="produtos/cadastrar.jsp">Cadastrar Produto</a>
                    </li>
                </ul>
            </div>
        </nav>
    </body>
</html>
