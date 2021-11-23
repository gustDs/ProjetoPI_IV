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
            <h3>CARRINHO PORRA</h3>
            <div class="cc-col w-100 border p-3">
                <div class=" cc-col cc-col-36" > 
                    <table class="table">
                        <thead  class="text-center ">
                        <th>Codigo</th>
                        <th>Item</th>
                        <th>Quantidade</th>
                        <th></th>
                        </thead>

                        <tbody name="data-tbody" class="text-center ">
                        </tbody>
                    </table>
                </div>
                <div class="text-right m-1" >
                    <button type="button" class="btn btn-success">COMPRAR</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        var wCard = localStorage.getItem("card")
        if (wCard != null) {
            wCard = JSON.parse(wCard)
            var wDataCard = wCard.data;
            var wHtml = "";
            wDataCard.forEach(item1 => {
                wHtml += "<tr data-id='" + item1["id"] + "'>"
                Object.keys(item1).forEach(element => {
                    wHtml += "<td >" + item1[element] + "</td>"
                });
                wHtml += "<td><button data-id='" + item1["id"] + "' type='button' data-btn-remove class='btn btn-danger'>REMOVER</button></td></tr>"
            });
            $("[name='data-tbody']").append(wHtml)
        }
    })
    $(document).off("click", "[data-btn-remove]");
    $(document).on("click", "[data-btn-remove]", function (e) {
        let wIdRemove = $(this).attr("data-id")
        $("tr[data-id='" + wIdRemove + "']").remove();
        var wCard = localStorage.getItem("card")
        var wJson = []
        wCard = JSON.parse(wCard)
        for (let wIdx = 0; wIdx < wCard["data"].length; wIdx++) {
            if (wCard["data"][wIdx]["id"] == wIdRemove) {
                //alertify.set("notifier", "position", "top-right");
                //alertify.error("<p style='color:white;font-size:16px;'>Produto já adicionado no carrinho</p>", "danger", 10);
                wJson = wCard["data"].splice(0, wIdx)
                continue;
            }
        }
        var wJsonCarrinho = {
            data: wJson
        }
        //localStorage.setItem("card", JSON.stringify(wJsonCarrinho));
        alertify.set("notifier", "position", "top-right");
        alertify.notify("<p style='color:white;font-size:16px;'>Produto Removido do Carrinho com Sucesso</p>", "success", 10);
    })

</script>

