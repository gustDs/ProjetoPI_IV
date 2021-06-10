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
        <c:if test="${not empty sessionScope.usuario}">
            <script>
                window.wTeste = "${sessionScope.usuario.filial}"
            </script>
            <div style="float: right;" class="mr-2">
                <div name="cc-cabecalho-dir" class="mt-2">
                    Filial ${sessionScope.usuario.filial}<br>Usuario: ${sessionScope.usuario.nome} - ${sessionScope.usuario.perfil}<br></div>
                <a href="<c:url value="/LogoutServlet"/>"><i style="color: red" class=" cc-icon-margin fas fa-sign-out-alt" aria-hidden="true"> </i> Sair</a>
            </div>
        </c:if>
        <nav class="navbar navbar-expand-lg my-2 my-lg-0 navbar-dark bg-dark">
            <div class=" navbar-collapse">
                <ul class="navbar-nav ml-3">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">  <i class="fa fa-home"></i></a>
                    </li>
                    <c:if test="${sessionScope.usuario.isRetaguarda() || sessionScope.usuario.isAdministrador()}"> 
                        <li class="nav-item">
                            <a class="nav-link" href="ProdutosServlet"><i class="fa fa-plus"></i> Produtos</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.usuario.isAdministrador() || sessionScope.usuario.isTI()}"> 
                        <li class="nav-item">
                            <a class="nav-link" href="ClientesServlet"><i class="fa fa-users"></i> Clientes</a>
                        </li>
                    </c:if>

                    <c:if test="${sessionScope.usuario.isVendedor() || sessionScope.usuario.isAdministrador() }">  
                        <li class="nav-item">
                            <a class="nav-link" href="ClientesVendasServlet"><i class="fa fa-university" aria-hidden="true"></i> Vendas</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.usuario.isGerente() || sessionScope.usuario.isAdministrador()}"> 
                        <li class="nav-item">
                            <a class="nav-link" href="RelatorioServlet"><i class="fa fa-print"></i> Relatório</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </nav>
    </body>
</html>
