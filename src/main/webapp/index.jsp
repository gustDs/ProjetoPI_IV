<%-- 
    Document   : index
    Created on : 12/09/2021, 16:51:53
    Author     : Martins
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Yolanda</title>
        <c:import url="header.jsp"/>
        <link rel="stylesheet" href="cards.css"> 
    </head>
    <body>


        <div style="background-color: #e8e8e8 !important;" class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
            <h5 class="my-0 mr-md-auto font-weight-normal"><img width="200px" style="height: 120px;" name="cc-cli" src="logo.png"></h5>
            <nav class="my-2 my-md-0 mr-md-3">
                <a class="p-2 text-dark" href="index.jsp"> Home</i></a>
                <c:if test="${sessionScope.usuario.anPerfil == 'estoquista' or sessionScope.usuario.anPerfil == 'dev'}">
                    <a class="p-2 text-dark" data-page="protegido/produto">Listar Produtos</a>
                </c:if>              
                <c:if test="${sessionScope.usuario.anPerfil == 'administrador' or sessionScope.usuario.anPerfil == 'dev'}">
                    <a class="p-2 text-dark" data-page="protegido/ListarUsuariosSV">Listar Usuarios</a>
                </c:if>
                <c:if test="${sessionScope.usuario.anPerfil == 'administrador' or sessionScope.usuario.anPerfil == 'dev'}">
                    <a class="p-2 text-dark" data-page="protegido/usuario/cadastrarUsuarios.jsp">Cadastrar Usuarios</a>
                </c:if>
                <a class="p-2 text-dark" data-page="    carrinho">Carrinho</a>
                
                    <a class="p-2 text-dark" data-page="login.jsp">Logar</a>
                
                 
            </nav>
            <a class="p-2  btn" data-page="Sair" href="protegido/LogoutSV">Sair</a>
            <c:if test="${sessionScope.usuario.anPerfil == 'administrador' or sessionScope.usuario.anPerfil == 'dev'}">
                <a class="p-2  btn" data-page="protegido/cliente/cadastrarClientes.jsp"   >Cadastrar-se</a>
            </c:if>
        </div>

        <div id="container" name="container" class="d-flex">
            <!-- card produtos -->
        </div>
        <div class="cc-loading-full" data-loading-name="loading">

            <div class="cc-loading-fade"></div>

        </div>
    </body>
    <script type="text/javascript" src="index.js"></script>
</html>
