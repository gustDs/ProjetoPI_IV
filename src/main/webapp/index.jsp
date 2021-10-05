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
        <img width="200px" style="height: 120px;" name="cc-cli"  src="logo.png">
        <nav class="navbar navbar-expand-lg my-2 my-lg-0 navbar-dark bg-dark" >
            <div class=" navbar-collapse " >
                <ul class="navbar-nav ml-3   mb-3 mt-3" name='menu' style="max-width: 2200px;">
                    <li class="nav-item active border">
                        <a class="nav-link" href="index.jsp"> Home</i></a>
                    </li>
                    <li class="nav-item border">
                        <a class="nav-link" data-page="produto">Listar Produtos</a>
                    </li>
                    <li class="nav-item border">
                        <a class="nav-link" data-page="Login">Login</a>
                    </li>
                    <li class="nav-item border">
                        <a class="nav-link" data-page="carrinho">Carrinho</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div id="container" name="container">
            <!-- card produtos -->
        </div>
    </body>
    <script type="text/javascript" src="index.js"></script>
</html>
