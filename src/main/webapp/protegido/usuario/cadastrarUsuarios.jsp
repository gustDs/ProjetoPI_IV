<%-- 
    Document   : cadastrarUsuarios
    Created on : 15/10/2021, 20:36:22
    Author     : Martins
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body >
    <div class="cc-row ">

        <div class="row m-auto " style="max-width: 1900px;">
            <div class="cc-col w-100 "  >
                <h3>Produtos</h3>
                <div class="cc-col w-100">
                    <div class=" border  cc-col cc-col-36" > 
                        <c:if test="${empty usuarios}">
                            <form action="protegido/CadastrarUsuariosSV" method="POST">
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
                                    <option value="dev">DEV</option>
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
                                <div class="p-3">
                                    <button class="cc-btn-azul w-100" type="submit">Cadastrar</button>
                                </div>

                            </form>
                        </c:if>
                        <c:if test="${not empty usuarios}">
                            <form action="protegido/AlterarUsuariosSV" method="POST">
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
                                    <option value="dev">DEV</option>
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
                                <div class="p-3">
                                    <button class='cc-btn-verde w-100' type="submit">Atualizar</button>
                                </div>
                                
                            </form>
                        </c:if>

                    </div>
                </div>
            </div>
        </div>

</body>

