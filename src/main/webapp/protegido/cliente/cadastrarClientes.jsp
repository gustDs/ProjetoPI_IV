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

        <div class="row m-auto " style="max-width: 1100px;">
            <div class="cc-col w-100 "  >
                <h3>Novo Cadastro</h3>
                <div class="cc-col w-100">
                    <div class=" border  cc-col cc-col-36" > 
                        <c:if test="${empty clientes}">
                            <form action="CadastrarClientesSV" method="POST">
                                <label class="form-label">Nome</label>
                                <input type="text" name="nome" required="true" class="form-control"/><br/>
                                <label>Data de Nascimento</label>
                                <input type="date" name="dataNasc" required="true" class="form-control"/><br/>
                                <label>Gênero</label>
                                <select name="genero" id="genero" required="true" class="form-control"><br/>
                                    <option value="masculino">Masculino</option>
                                    <option value="feminino">Feminino</option>
                                </select>
                                <label>E-mail</label>
                                <input type="text" name="email" required="true" class="form-control"/><br/>
                                <label>Senha</label>
                                <input type="password" name="senha" required="true" class="form-control"/><br/>
                                <label>CPF</label>
                                <input type="text" name="cpf" required="true" class="form-control"/><br/>
                                <label>CEP</label>
                                <input type="text" name="cep" required="true" class="form-control"/><br/>
                                <label>Logradouro</label>
                                <input type="text" name="logradouro" required="true" class="form-control"/><br/>

                                <label>Bairro</label>
                                <input type="text" name="bairro" required="true" class="form-control"/><br/>
                                <label>Cidade</label>
                                <input type="text" name="cidade" required="true" class="form-control"/><br/>
                                <label>UF</label>
                                <select name="uf" id="uf" required="true" class="form-control"><br/>
                                    <option value="AC">AC</option>
                                    <option value="AL">AL</option>
                                    <option value="AP">AP</option>
                                    <option value="AM">AM</option>
                                    <option value="BA">BA</option>
                                    <option value="CE">CE</option>
                                    <option value="DF">DF</option>
                                    <option value="ES">ES</option>
                                    <option value="GO">GO</option>
                                    <option value="MA">MA</option>
                                    <option value="MT">MT</option>
                                    <option value="MS">MS</option>
                                    <option value="MG">MG</option>
                                    <option value="PA">PA</option>
                                    <option value="PB">PB</option>
                                    <option value="PR">PR</option>
                                    <option value="PE">PE</option>
                                    <option value="PI">PI</option>
                                    <option value="RJ">RJ</option>
                                    <option value="RN">RN</option>
                                    <option value="RS">RS</option>
                                    <option value="RO">RO</option>
                                    <option value="RR">RR</option>
                                    <option value="SC">SC</option>
                                    <option value="SP">SP</option>
                                    <option value="SE">SE</option>
                                    <option value="TO">TO</option>
                                </select>
                                <label>Endereço de Entrega</label>
                                <input type="text" name="endEntrega" required="true" class="form-control"/><br/>
                                <label>Endereço de Faturamento</label>
                                <input type="text" name="endFaturamento" required="true" class="form-control"/><br/>
                                <div class="p-3">
                                    <button class="cc-btn-azul w-100" type="submit">Cadastrar</button>
                                </div>

                            </form>
                        </c:if>
                        <c:if test="${not empty usuarios}">
                            <form action="AlterarClientesSV" method="POST">
                                label class="form-label">Nome</label>
                            <input type="text" name="nome" required="true" value="${clientes.nome}" class="form-control"/><br/>
                                <label>Data de Nascimento</label>
                                <input type="date" name="dataNasc" required="true" value="${clientes.dataNasc}" class="form-control"/><br/>
                                <label>Gênero</label>
                                <select name="genero" id="genero" required="true" value="${clientes.genero}" class="form-control"><br/>
                                    <option value="masculino">Masculino</option>
                                    <option value="feminino">Feminino</option>
                                </select>
                                <label>Senha</label>
                                <input type="password" name="senha" required="true" value="${clientes.senha}" class="form-control"/><br/>
                            </form>
                        </c:if>

                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="protegido/cliente/cliente.js"></script>
</body>

