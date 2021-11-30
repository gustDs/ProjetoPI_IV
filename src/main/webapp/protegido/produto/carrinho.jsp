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
                    <button type="button" data-btn-salvar='1' class="btn btn-success">COMPRAR</button>
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
        wCard = JSON.parse(wCard)
        for (let wIdx = 0; wIdx < wCard["data"].length; wIdx++) {
            if (wCard["data"][wIdx]["id"] == wIdRemove) {
                console.log("wIdx", wIdx)
                wCard["data"].splice(wIdx, 1);

                continue;
            }

        }
        localStorage.setItem("card", JSON.stringify(wCard));
        alertify.set("notifier", "position", "top-right");
        alertify.notify("<p style='color:white;font-size:16px;'>Produto Removido do Carrinho com Sucesso</p>", "success", 10);
    })

    $(document).off("click", "[data-btn-salvar]");
    $(document).on("click", "[data-btn-salvar]", function (e) {
        var wCard = localStorage.getItem("card")
        wCard = JSON.parse(wCard)
        wCard = wCard.data
        for (let wIdx = 0; wIdx < wCard.length; wIdx++) {
            const element = wCard[wIdx];
            console.log(element)

        }

        var wJson = {
            id: 22
        }
        $.ajax({
            type: "post",
            url: "protegido/carrinho",
            data: JSON.stringify(wJson),
        }).then((result) => {
            console.log(result)
        })
    })

</script>

