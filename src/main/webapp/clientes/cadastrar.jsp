<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="../header.jsp"/>
        <script type="text/javascript" src="clientes/cadastrar.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
    </head>
    <body class="">


        <c:if test="${empty cliente}">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class=" navbar-collapse">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ClientesServlet">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ProdutosServlet">Lista Produtos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="produtos/cadastrar.jsp">Cadastrar Produto</a>
                        </li>
                    </ul>
                </div>
            </nav>

            <div class="cc-row m-auto m-4 p-4 border">
                <div class="cc-col w-100" > 
                    <div class="mt-4 border p-4" style="width:35%;float:left;margin-left:5px;margin-right:5px">
                        <div class="table-responsive border">
                            <table id="table" class="table border">
                                <thead  class="text-center " style="background: #3b3b3b; color:#fff;">
                                    <tr>
                                        <th>Codigo</th>
                                        <th>Nome</th>
                                        <th>CPF</th>
                                        <th>Data de Nascimento</th>
                                        <!-- 
                                          <th>E-mail</th> 
                                          <th>Endereço</th>
                                        -->
                                        <th>Telefone</th>
                                        <th>Sexo</th>
                                    </tr>
                                </thead>
                                <tbody class="text-center">
                                    <c:forEach items="${listaClientes}" var="cliente">
                                        <tr data-id="${cliente.id}">
                                            <td>${cliente.id}</td>
                                            <td>${cliente.nome}</td>
                                            <td>${cliente.cpf}</td>
                                            <td>${cliente.datanasc}</td>
                                            <!-- 
                                            <td>${cliente.email}</td>
                                            <td>${cliente.endereco}</td>
                                            -->
                                            <td>${cliente.telefone}</td>
                                            <td>${cliente.sexo}</td>
                                        </tr>

                                    </c:forEach>  
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="mt-4 border p-4" style="width:60%;float:left;margin-left:5px;margin-right:5px" >

                        <div class="cc-row">
                            <div class="cc-col col-2">
                                <label class="form-label">Codigo</label>
                                <input type ="text" id="idCliente" disabled name="idCliente" class="form-control"/>
                            </div>
                            <div class="cc-col col-8">
                                <label class="form-label">Nome</label>
                                <input type ="text" name="nmCliente" required='required' class="form-control"/>
                            </div>
                            <div class="cc-col col-4">
                                <label class="form-label">CPF</label>
                                <input type ="text" name="anCpf" required='required' class="form-control"/>
                            </div>
                            <div class="cc-col col-3">
                                <label class="form-label">Data de Nascimento</label>
                                <input type ="date" name="dtNascimento" required='required' class="form-control"/>
                            </div>
                            <div class="cc-col col-5">
                                <label class="form-label">Sexo</label>
                                <select name="dmSexo" required='required' class="form-control">
                                    <option value="0">Selecione</option>
                                    <option value="M">Masculino</option>
                                    <option value="F">Femenino</option>
                                </select>
                        
                            </div>
                            <div class="cc-col col-5">
                                <label class="form-label">Endereço</label>
                                <input type ="text" name="anLogradouro" required='required' class="form-control"/>
                            </div>
                            <div class="cc-col col-5">
                                <label class="form-label">E-mail</label>
                                <input type ="text" name="anEmail" required='required' class="form-control"/>
                            </div>
                            <div class="cc-col col-5">
                                <label class="form-label">Telefone</label>
                                <input type ="text" name="anTelefone" required='required' class="form-control"/>
                            </div>
                            <div class="cc-row w-100 mt-3">
                                <div class="cc-col col-3 ">
                                    <button data-btn-novo="1" class="w-100 cc-btn  cc-btn-azul"><i class="fas fa-plus" aria-hidden="true">  NOVO</i></button>
                                </div>
                                <div class="cc-col col-3 ">
                                    <button data-btn-salvar="1"  class="w-100  cc-btn cc-btn-verde"><i class="fas fa-check">   SALVAR</i></button>
                                </div>
                                <div class="cc-col col-1 float-right">
                                    <button data-btn-exluir="1"  class="w-100 cc-btn cc-btn-vermelho" ><i class="fas fa-trash" aria-hidden="true"></i></button>
                                </div>
                            </div>


                        </div>

                    </div>
                </div>
            </div>

        </c:if>
    </body>
</html>
