<%-- 
    Document   : listaProdutos
    Created on : 12/09/2021, 17:08:26
    Author     : Martins
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="cc-row ">

    <div class="row m-auto " style="max-width: 1900px;">
        <div class="cc-col w-100 "  >
            <h3>Produtos</h3>
            <div class="cc-col w-100">
                <div class=" border  cc-col cc-col-16" > 
                    <table class="table table-striped table-bordered " name="gridProdutos" id="gridProdutos">
                        <thead  class="text-center " style="background: #3b3b3b; color:#fff;">
                        <th>Codigo</th>
                        <th>Nome</th>
                        <th>Avalicação</th>
                        <th>Valor</th>
                        <th>Quantidade</th>
                        <th>Status</th>
                        <th></th>
                        <th></th>
                        </thead>

                        <tbody>
                            <c:forEach items="${listaProdutos}" var="produtos">
                                <tr class="text-center" data-id="${produtos.wId}">
                                    <td>${produtos.wId}</td>
                                    <td>${produtos.wNome}</td>
                                    <td>${produtos.wAvaliacao}</td>
                                    <td>${produtos.wValor}</td>
                                    <td>${produtos.wQtdProduto}</td>
                                    <td>                         
                                        <c:if test = "${produtos.wBoInativo == 1}">
                                            INATIVO
                                        </c:if>
                                        <c:if test = "${produtos.wBoInativo == 0}">
                                            ATIVO
                                        </c:if></td>
                                    <td>
                                        <c:if test = "${produtos.wBoInativo == 1}">
                                            <button class="btn btn btn-warning w-100" data-ref="Id=${produtos.wId}&boInativo=${produtos.wBoInativo}">
                                                ATIVAR
                                            </button>
                                        </c:if>
                                        <c:if test = "${produtos.wBoInativo == 0}">
                                            <button class="btn btn btn-info w-100" data-ref="Id=${produtos.wId}&boInativo=${produtos.wBoInativo}">
                                                INATIVAR
                                            </button>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${not empty produtos}">
                                            <a href="detalheProduto?wId=${produtos.wId}">DETALHES</a>
                                        </c:if>
                                    </td>


                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
                <div class="border cc-col cc-col-16" style="float: right" >
                    <div name='formProduto'>
                        <div class="cc-col col-2">
                            <label class="form-label">Codigo</label>
                            <input type="text" name="id" disabled class="form-control" />
                        </div>
                        <div class="cc-col col-5">
                            <label class="form-label">Produto</label>
                            <input type="text" name="nmProduto" required='required' class="form-control" />
                        </div>
                        <div class="cc-col col-5">
                            <label class="form-label">Avaliação</label>
                            <input type="text" name="dmAvaliacao" required='required' class="form-control" />
                        </div>

                        <div class="cc-col col-5">
                            <label class="form-label">Valor</label>
                            <input type="text" name="vlProduto" required='required' class="form-control" />
                        </div>
                        <div class="cc-col col-5">
                            <label class="form-label">Quantidade</label>
                            <input type="text" name="qtProduto" required='required' class="form-control" />
                        </div>
                        <div class="cc-col col-5">
                            <label class="form-label">Status</label>
                            <select name="dmStatus" required='required' class="form-control">
                                <option value="0">Ativo</option>
                                <option value="1">Inativo</option>
                            </select>
                        </div>
                        <div class="cc-col col-12">
                            <label class="form-label">Descrição</label>
                            <textarea rows="4" name="anDescricao" required='required' class="form-control" /></textarea>
                        </div>
                        <div class="cc-row w-100 mt-3">
                            <div class="cc-col col-3 ">
                                <button data-btn-novo="1" class="w-100 cc-btn  cc-btn-azul"><i class="fa fa-plus" aria-hidden="true">  NOVO PRODUTO</i></button>
                            </div>
                            <div class="cc-col col-3 ">
                                <button data-btn-salvar="1"  class="w-100  cc-btn cc-btn-verde"><i class="fa fa-check">   SALVAR PRODUTO</i></button>
                            </div>
                        </div>
                    </div>
                    <div class="w-100">
                        <table class="table table-striped table-bordered" name="gridProdutosImagem" id="gridProdutosImagem">
                            <thead  class="text-center " style="background: #3b3b3b; color:#fff;">
                            <th>Codigo</th>
                            <th>Imagem</th>
                            <th>Data</th>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                        <hr>
                        <div name="formImagem">
                            <div class="cc-col col-2">
                                <label class="form-label">Codigo</label>
                                <input type="text" name="idImagem" disabled class="form-control" />
                            </div>
                            <div class="cc-col col-2">
                                <label class="form-label">Produto</label>
                                <input type="text" name="id" disabled class="form-control" />
                            </div>
                            <div class="cc-col col-5">
                                <label class="form-label">Nome Imagem </label>
                                <input type="text"  name="nmImagem" required='required' class="form-control" />
                            </div>
                            <div class="cc-col col-5">
                                <label class="form-label">Data de Inclusao </label>
                                <input type="data"  name="dtImagem"  disabled class="form-control" />
                            </div >
                            <div class="cc-col col-12">
                                <label for="base64">Arquivo</label><br>
                                <input type="file"  name="blImagem"  class="custom-file-input form-label" id="blImagem">
                            </div >
                            <div class="cc-col col-12">
                                <label for="previewImg">Arquivo</label><br>
                                <div required='required' name='previewImg' id='previewImg'></div>
                            </div>

                            <div class="cc-col col-12">
                                <input type="checkbox" class="form-check-input" id="boImagemPrincipal" name="boImagemPrincipal">
                                <label class="form-check-label"  for="boImagemPrincipal">Imagem Principal</label>
                            </div >
                            <div class="cc-row w-100 mt-3">
                                <div class="cc-col col-3 ">
                                    <button data-btn-novo-img="1" disabled class="w-100 cc-btn  cc-btn-azul"><i class="fa fa-plus" aria-hidden="true">  NOVA IMAGEM</i></button>
                                </div>
                                <div class="cc-col col-3 ">
                                    <button data-btn-salvar-img="1"  disabled class="w-100  cc-btn cc-btn-verde"><i class="fa fa-check">   SALVAR IMAGEM</i></button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="produto/produto.js"></script>

