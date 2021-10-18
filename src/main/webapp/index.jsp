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
                <a class="p-2 text-dark" data-page="produto">Listar Produtos</a>
                <a class="p-2 text-dark" data-page="usuario" href="./ListarUsuariosSV">Listar Usuarios</a>
                <a class="p-2 text-dark" data-page="usuario" href="usuario/cadastrarUsuarios.jsp">Cadastrar Usuarios</a>
                <a class="p-2 text-dark" data-page="carrinho">Carrinho</a>
            </nav>
            <a class="p-2  btn" data-page="Login" href="login.html">Login</a>
        </div>

        <div id="container" name="container" class="d-flex">
            <!-- card produtos -->
        </div>
        <div class="cc-loading-full" data-loading-name="loading">
            <div class="cc-loading-spinner" name="cc-loading-spinner-full" id="cc-loading-spinner-full">
                <div class="spinner-border cc-text-branco" role="status">
                    <span class="sr-only">Carregando...</span>
                </div>
                <strong class="cc-loading-title">teste</strong>
            </div>
            <div class="cc-loading-fade"></div></div>
    </body>
    <script type="text/javascript" src="index.js"></script>
</html>
