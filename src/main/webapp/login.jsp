
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- JavaScript -->
        <script src="../lib/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/0f483a9f55.js"></script>
    </head>
    <body class="container" style="background: black;background: rgba(0,0,0,0.75)" >
        <div class='d-flex justify-content-center'>

            <div style='width: 45%;' >

                <div class='mt-4 border p-4 m-auto mb-4' style="background: white;border-radius: 5px">
                    <c:if test="${notValid}"> 
                        <div class="alert alert-danger text-center" role="alert">
                            Usuario não Autenticado !<br><small>Verifique usuario ou senha</small>
                        </div>
                    </c:if>

                    <form action="LoginServlet" method="POST">

                        <div class='w-100 text-center'>
                            <img width="200px" name="cc-cli" class="m-2" src="logo.png">
                        </div>
                        <label class="form-label">Usuario</label><br/>
                        <input type="text" name="login" required="true" class="form-control" required/> <br/>
                        <label class="form-label">Senha</label><br/>
                        <input type="password" name="senha" required="true" class="form-control" required/><br/>
                        <button type="submit" style="background: rgb(0, 0, 0); color: white;" class="btn w-100">ENTRAR</button>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
