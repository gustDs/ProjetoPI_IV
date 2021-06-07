<%-- 
    Document   : listaProdutos
    Created on : 28/04/2021, 23:05:41
    Author     : Martins
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lsita de Produtos</title>
        <c:import url="../header.jsp"/>
        <c:import url="../navBar.jsp"/>
        <script type="text/javascript" src="produtos/cadastrar.js"></script>
    </head>
    <body class="">
        <div class="cc-row m-auto m-4 p-4 border">
            <div class="cc-col w-100" > 
                <div class="mt-4 border p-4" style="width:48%;float:left;margin-left:5px;margin-right:5px">
                    <div class="">
                        <table class="table" id="table">
                            <thead  class="text-center " style="background: #3b3b3b; color:#fff;">
                            <th>Codigo</th>
                            <th>Filial</th>
                            <th>Produto</th>
                            <th>Categoria</th>
                            <th>Modelo</th>
                            <th>Preço</th>
                            <th>Quantidade</th>
                            </thead>

                            <tbody class="text-center "> 
                                <c:forEach items="${listaProdutos}" var="produto">                  
                                    <tr data-id="${produto.id}">
                                        <td>${produto.id}</td>
                                        <td>${produto.filial}</td>
                                        <td>${produto.nome}</td>
                                        <td>${produto.categoria}</td>
                                        <td>${produto.modelo}</td>
                                        <td>${produto.preco}</td>
                                        <td>${produto.quantidade}</td>
                                    </tr>
                                </c:forEach>    
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="mt-4 border p-4" style="width:50%;float:left;margin-left:5px;margin-right:5px" >
                    <div class="cc-col col-2">
                        <label class="form-label">Codigo</label>
                        <input type ="text" name="id"  disabled class="form-control"/>
                    </div>
                    <div class="cc-col col-5">
                        <label class="form-label">Produto</label>
                        <input type ="text" name="nmProduto" required='required'  class="form-control"/>
                    </div>
                    <div class="cc-col col-5">
                        <label class="form-label">Filial</label>
                        <select name="dmFilial" required='required' class="form-control">
                            <option value="0">--Escolha a Filial--</option>
                            <option value="Campina Grande">Campina Grande</option>
                            <option value="Sao Paulo">São Paulo</option>
                            <option value="Joinville">Joinville</option>
                            <option value="Brasilia">Brasilia</option>
                        </select>
                    </div>

                    <div class="cc-col col-5">
                        <label class="form-label">Modelo</label>
                        <input type ="text" name="nmModelo" required='required' class="form-control"/>
                    </div>
                    <div class="cc-col col-4">
                        <label class="form-label">Categoria</label>
                        <select name="dmCategoria" required='required' class="form-control">
                            <option value="0">--Escolha a Categoria--</option>
                            <option value="Hardware">Hardware</option>
                            <option value="Periferico">Periférico</option>
                            <option value="Acessorios">Acessórios</option>
                            <option value="Outros">Outros</option>
                        </select>
                    </div>
                    <div class="cc-col col-2">
                        <label class="form-label">Quantidade</label>
                        <input type ="text" name="qtProduto" required='required' class="form-control"/>
                    </div>
                    <div class="cc-col col-2">
                        <label class="form-label">Preço</label>
                        <input type ="text" name="vlProduto" required='required' class="form-control"/>
                    </div>
                    <div class="cc-row w-100 mt-3">
                        <div class="cc-col col-3 ">
                            <button data-btn-novo="1" class="w-100 cc-btn  cc-btn-azul"><i class="fa fa-plus" aria-hidden="true">  NOVO</i></button>
                        </div>
                        <div class="cc-col col-3 ">
                            <button data-btn-salvar="1"  class="w-100  cc-btn cc-btn-verde"><i class="fa fa-check">   SALVAR</i></button>
                        </div>
                        <div class="cc-col col-1 float-right">
                            <button data-btn-exluir="1"  class="w-100 cc-btn cc-btn-vermelho" ><i class="fa fa-trash" aria-hidden="true"></i></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>





    </body>
</html>
