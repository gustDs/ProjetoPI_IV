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
    </head>
    <body class="">
        <c:import url="../header.jsp"/>
        <c:import url="../navBar.jsp"/>
        <script type="text/javascript" src="relatorio/relatorio.js"></script>

        <div class="mt-4 border p-4" style="width:100%;float:left;margin-left:5px;margin-right:5px" >
            <h4>Relatorio de Vendas</h4>
            <div class="cc-row text-center">
                <div class="cc-col col-2">
                    <label class="form-label">Venda</label>
                    <input type ="text" name="cnVenda"  class="form-control"/>
                </div>
                <div class="cc-col col-2">
                    <label class="form-label">Filial</label>
                    <input type ="text" name="cnFilial"   class="form-control"/>
                </div>
                <div class="cc-col col-2">
                    <label class="form-label">Data Inicial</label>
                    <input type ="date" name="dtInicial"   class="form-control"/>
                </div>
                <div class="cc-col col-2">
                    <label class="form-label">Data Final</label>
                    <input type ="date" name="dtFinal"   class="form-control"/>
                </div>


                <div class="cc-row w-100 mt-3">
                    <div class="cc-col col-12 ">
                        <button  data-btn-relatorio='1' class="w-100 cc-btn  cc-btn-azul"><i class="fa fa-print" aria-hidden="true">  GERAR RELATORIO</i></button>
                    </div>
                </div>
            </div>

            <div class="mt-4 border p-4" style="width:100%;float:left;margin-left:5px;margin-right:5px" >
                <table name='data-relatorio' class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th class="text-center">Código da Venda</th>
                            <th class="text-center">Filial</th>
                            <th class="text-center">Data da Venda</th>
                            <th class="text-center">Código de Produto</th>
                            <th class="text-center">Nome do Produto</th>
                            <th class="text-center">Quantidade do Produto</th>
                            <th class="text-center">Valor Unitario</th>
                            <th class="text-center">Valor Total</th>
                        </tr>
                    </thead>
                    <tbody>

                    </tbody>   
                </table>
            </div>
    </body>
</html>
