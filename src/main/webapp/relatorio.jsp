<%-- 
    Document   : vendas
    Created on : 07/05/2021, 22:47:57
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
    <body class="">
        <c:import url="header.jsp"/>
        <c:import url="navBar.jsp"/>
        <h1>Clientes:</h1>

        <table id="table" class="table">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>ID do Produto</th>
                    <th>Quantidade</th>
                    <th>Valor do Produto</th>
                    <th>Valor Total</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
  
            </tbody>   
        </table>
    </body>
</html>
