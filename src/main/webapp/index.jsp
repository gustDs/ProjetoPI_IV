<%-- 
    Document   : index
    Created on : 22/04/2021, 22:15:53
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
    <body class="container">
        <c:import url="header.jsp"/>
        <h1>Menu</h1>
        
        <br/>
        <a href="ClientesServlet">Lista Clientes</a>
        <br/>
        <a href="clientes/cadastrar.jsp">Cadastrar Clientes</a>
        
        <br/><br/>
        <c:import url="footer.jsp"/>
        
        
    </body>
</html>
