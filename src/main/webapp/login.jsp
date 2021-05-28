
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="container">
        <c:import url="/protegido/header.jsp"/>
        
        <form action="LoginServlet" method="POST">
            <label class="form-label">Usuario</label><br/>
            <input type="text" name="login" required="true" class="form-control" required/> <br/><br/>
            <label class="form-label">Senha</label><br/>
            <input type="password" name="senha" required="true" class="form-control" required/><br/><br/>
            

            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </body>
</html>
