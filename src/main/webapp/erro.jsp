<%-- 
    Document   : erro
    Created on : 23/04/2021, 17:33:49
    Author     : Martins
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color: red">ERRO NA OPERAÇÃO</h1>
        <p>${msgErro}</p>
        <c:import url="footer.jsp"/>
    </body>
</html>
