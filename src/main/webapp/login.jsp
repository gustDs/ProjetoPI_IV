<%-- 
    Document   : login
    Created on : 19/10/2021, 19:25:20
    Author     : Martins
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body class="container">
        <h1>Login</h1>
        <br>
        <form action="LoginSV" method="POST">
            <label>E-mail</label>
            <input type="text" name="anEmail" required="true" class="form-control"/><br/>        
            <label>Senha</label>
            <input type="password" name="nmSenha" required="true" class="form-control"/><br/>
            <label>Confirmar Senha</label>
            <input type="password" name="nmSenhaConfirma" required="true" class="form-control"/><br/>
            <button class="btn-btn-primary" type="submit">Entrar</button>
        </form>
    </body>
</html>
