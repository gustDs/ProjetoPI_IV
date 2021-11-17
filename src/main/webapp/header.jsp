<%-- 
    Document   : header
    Created on : 22/04/2021, 22:47:05
    Author     : Martins
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- JavaScript -->
        <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.min.js" type="text/javascript"></script>
        <link href="yolanda.css" rel="stylesheet" >
        <link href="//cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css" rel="stylesheet" >
        <script src="http://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!-- CSS -->
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:if test="${sessionScope.usuario != null}">
            <p>Usuário Logado: ${sessionScope.usuario.anNome}</p>
            <p>Perfil: ${sessionScope.usuario.anPerfil}</p>
        </c:if>

        <c:if test="${sessionScope.clientes != null}">
            <p>Cliente Logado: ${sessionScope.clientes.nome}</p>
            <p>Perfil: ${sessionScope.clientes.perfil}</p>
        </c:if>



    </body>
</html>
