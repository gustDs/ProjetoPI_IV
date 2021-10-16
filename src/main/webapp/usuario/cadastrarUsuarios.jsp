<%-- 
    Document   : cadastrarUsuarios
    Created on : 15/10/2021, 20:36:22
    Author     : Martins
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Cadastrar Usuarios</title>
    </head>
    <body class="container">
        <c:if test="${empty usuarios}">
            <form action="CadastrarUsuariosSV" method="POST">
                <label class="form-label">Nome</label>
                <input type="text" name="anNome" required="true" class="form-control"/><br/>
                <label>CPF</label>
                <input type="text" name="nmCpf" required="true" class="form-control"/><br/>
                <label>E-mail</label>
                <input type="text" name="anEmail" required="true" class="form-control"/><br/>
                <label>Perfil</label>
                <select name="anPerfil" id="anPerfil" required="true" class="form-control"><br/>
                    <option value="administrador">ADM</option>
                    <option value="estoquista">Estoquista</option>
                </select>          
                <label>Senha</label>
                <input type="text" name="nmSenha" required="true" class="form-control"/><br/>
                <label>Confirmar Senha</label>
                <input type="text" name="nmSenhaConfirma" required="true" class="form-control"/><br/>
                <label>Status</label>
                <select name="boInativo" id="boInativo" required="true" class="form-control"><br/>
                    <option value="1">Ativo</option>
                    <option value="0">Inativo</option>
                </select>

                <button class="btn-btn-primary" type="submit">Cadastrar</button>
            </form>
        </c:if>
        <c:if test="${not empty usuarios}">
            <h1>testessssss</h1>
            <form action="AlterarUsuariosSV" method="POST">
                <label>Nome</label>
                <input type="text" name="anNome" required="true" value="${usuarios.anNome}" class="form-control"/><br/>
                <label>CPF</label>
                <input type="text" name="nmCpf" required="true" value="${usuarios.nmCpf}" class="form-control"/><br/>
                <label>E-mail</label>
                <input type="text" name="anEmail" required="true" readonly="true" value="${usuarios.anEmail}" class="form-control"/><br/>
                <label>Perfil</label>
                <select name="anPerfil" id="anPerfil" required="true" value="${usuarios.anPerfil}" class="form-control"><br/>
                    <option value="administrador">ADM</option>
                    <option value="estoquista">Estoquista</option>
                </select>          
                <label>Senha</label>
                <input type="text" name="nmSenha" required="true" value="${usuarios.nmSenha}" class="form-control"/><br/>
                <label>Confirmar Senha</label>
                <input type="text" name="nmSenhaConfirma" required="true" value="${usuarios.nmSenhaConfirma}" class="form-control"/><br/>
                <label>Status</label>
                <select name="boInativo" id="boInativo" required="true" value="${usuarios.boInativo}" class="form-control"><br/>
                    <option value="1">Arivo</option>
                    <option value="0">Inativo</option>
                </select>

                <button type="submit">Atualizar</button>
            </form>
        </c:if>

    </body>
</html>
