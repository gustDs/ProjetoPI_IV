<%-- 
    Document   : vendas
    Created on : 07/05/2021, 22:47:57
    Author     : Martins
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:import url="../header.jsp"/>
        <script type="text/javascript" src="vendas/vendas.js"></script>
    </head>
    <body class="">
        <c:import url="../navBar.jsp"/>
        <div class="cc-row m-auto m-4 p-4 border">
            <div class="cc-col w-100">
                <div class="mt-4 border p-4" style="width:35%;float:left;margin-left:5px;margin-right:5px">
                    <div class="table-responsive border">
                        <h4>Produtos</h4>
                        <table id="tableProdutos" class="table">
                            <thead  class="text-center " style="background: #3b3b3b; color:#fff;">
                            <th>Codigo</th>
                            <th>Filial</th>
                            <th>Nome</th>
                            <th>Categoria</th>
                            <th>Modelo</th>
                            <th>Preço</th>
                            <th>Quantidade</th>
                            </thead>
                            <tfoot class="text-center " style="background: #3b3b3b; color:#fff;">
                            <th>Codigo</th>
                            <th>Filial</th>
                            <th>Nome</th>
                            <th>Categoria</th>
                            <th>Modelo</th>
                            <th>Preço</th>
                            <th>Quantidade</th>
                            </tfoot>
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

                <div class="mt-4 border p-4" style="width:30%;float:left;margin-left:5px;margin-right:5px" >

                    <div class="cc-row">
                        <div class="cc-col col-2">
                            <label class="form-label">Codigo</label>
                            <input type ="text" name="idProduto" disabled name="idCliente" class="form-control"/>
                        </div>
                        <div class="cc-col col-6">
                            <label class="form-label">Nome</label>
                            <input type ="text" name="nmProduto" disabled  class="form-control"/>
                        </div>
                        <div class="cc-col col-4">
                            <label class="form-label">Categoria</label>
                            <input type ="text" name="dmCategoria" disabled  class="form-control"/>
                        </div>
                        <div class="cc-col col-3">
                            <label class="form-label">Modelo</label>
                            <input type ="text" name="nmModelo" disabled  class="form-control"/>
                        </div>
                        <div class="cc-col col-4">
                            <label class="form-label">Preço</label>
                            <input type ="text" name="vlProduto" disabled class="form-control"/>
                        </div>
                        <div class="cc-col col-3">
                            <label class="form-label">Quantidade</label>
                            <input type ="number" name="qtProduto" required='required' class="form-control"/>
                        </div>
                        <div class="cc-row w-100 mt-3">
                            <div class="cc-col col-12 ">
                                <button data-btn-add-card='1' class="w-100 cc-btn  cc-btn-azul"><i class="fas fa-plus" aria-hidden="true">  ADICIONAR AO CARRINHO</i></button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="mt-4 border p-4" style="width:33%;float:left;margin-left:5px;margin-right:5px">
                    <div class="table-responsive border">
                        <h4>Carrinho</h4>
                        <table id="tableCarrinho" class="table">
                            <thead  class="text-center " style="background: #3b3b3b; color:#fff;">
                            <th>Codigo</th>
                            <th>Nome</th>
                            <th>Valor Unitario</th>
                            <th>Quantidade</th>
                            <th>Valor Total</th>
                            </thead>
                            <tbody class="text-center ">
                            </tbody>
                        </table>
                        <div class="cc-row p-2 mt-4">

                            <div class="cc-col col-12">
                                <label class="form-label">Clientes</label>
                                <select id="cbCliente" name='cbCliente' class="form-control">
                                    <option value='0'>Selecione</option>
                                </select>
                            </div>
                            <div class="cc-col col-12">
                                <label class="form-label">FILIAL</label>
                                <select id="cbFilial" name='cbFilial' class="form-control">
                                    <option value="0">Selecione uma Filial</option>
                                    <option value="Campina Grande">Campina Grande</option>
                                    <option value="Sao Paulo">São Paulo</option>
                                    <option value="Joinville">Joinville</option>
                                    <option value="Brasilia">Brasilia</option>
                                </select>
                            </div>
                        </div>
                        <hr>
                        <div class=" p-2 border">
                            <button data-btn-close-card="1"  class="w-100 cc-btn  cc-btn-verde"><i class="fas fa-cart-arrow-down"></i>  FECHAR CARRINHO</i></button>
                        </div>
                        <div class="cc-row p-2 mt-4">
                            <div class="cc-col col-2">
                                <label class="form-label">Codigo</label>
                                <input type ="text" name="cnVenda" disabled name="cnVenda" class="form-control"/>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</body>
</html>
