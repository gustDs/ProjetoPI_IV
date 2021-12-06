
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body class="container">
    <div class="cc-row ">

        <div class="row m-auto " style="max-width: 1900px;">
            <div class="cc-col w-100 "  >
                <div class="cc-col w-100">
                    <div class=" border  cc-col cc-col-36" > 
                        <div class="info">
                            <c:if test="${not empty produtos}">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="cc-col-36">
                                            <div class="card w-100">
                                                <div class="card-body">
                                                    <div class="row cc-col cc-col-36" > 
                                                        <div class="cc-col-12 border p-2">
                                                            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                                                                <div class="carousel-inner">
                                                                    <c:forEach items="${listaImagens}" var="imagens">

                                                                        <c:set var = "principal"  value = "${imagens.boImgPrincipal}"/>
                                                                        <c:if test = "${principal == 1}">

                                                                            <div class="carousel-item active">
                                                                                <img class="d-block" src="${imagens.blArquivo}" width="600px" height="500px" alt="First slide">
                                                                            </div>
                                                                        </c:if>
                                                                        <c:if test = "${principal == 0}">
                                                                            <div class="carousel-item">
                                                                                <img class="d-block" src="${imagens.blArquivo}" width="600px" height="500px" alt="First slide">
                                                                            </div>
                                                                        </c:if>


                                                                    </c:forEach>
                                                                    <script>
                                                                        $('.carousel').carousel({
                                                                            interval: 2000
                                                                        })
                                                                    </script>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="cc-col-21">
                                                            <div class="ml-3 card w-100 ">
                                                                <div class="card-body">
                                                                    <h5 class="card-title" >${produtos.wNome}</h5>
                                                                    <h6 class="card-subtitle mb-2 text-muted">${produtos.wDesc}</h6>
                                                                    <p class="card-text"> R$ ${produtos.wValor}</p>
                                                                    <p class="card-text"> Estoque ${produtos.wQtdProduto}</p>
                                                                    <p>
                                                                        <c:forEach var = "i" begin = "1" end = "${produtos.wAvaliacao}">
                                                                            ⭐
                                                                        </c:forEach>
                                                                    </p>  
                                                                    <p>
                                                                        <input type="number" value="1" name='produto-qtd' class="form-control" style="width: 100px;" value="0" onkeypress='return event.charCode >= 48 && event.charCode <= 57'></input>
                                                                    </p> 
                                                                    <button type="button" data-produto-id="${produtos.wId}"data-btn-add-card="true" class="btn btn-primary">Adicionar os Carrinho</button>


                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</body>
<script>
    $(document).ready(function () {
        $(document).off("click", "[data-btn-add-card='true']");
        $(document).on("click", "[data-btn-add-card='true']", function (e) {

            var wJsonProduto = ${produtos}
            var wQtdEstoque = parseInt(wJsonProduto.qtProduto);
            var wVlProduto = wJsonProduto.vlProduto;
            var wQtdCompra = parseInt($("[name='produto-qtd']").val());
            if (wQtdCompra == 0) {
                alertify.set("notifier", "position", "top-right");
                alertify.error("<p style='color:white;font-size:16px;'>Quantidade Informada Invalida</p>", "danger", 10);
                return;
            } else if (wQtdCompra > wQtdEstoque) {
                alertify.set("notifier", "position", "top-right");
                alertify.error("<p style='color:white;font-size:16px;'>Opss apenas " + wQtdEstoque + " Quantidades disponivel em estoque < /p>", "danger", 10);
                return;
            } else {
                var wJson = {
                    id: wJsonProduto.id,
                    nmProduto: wJsonProduto.nmProduto,
                    qtCompra: wQtdCompra,
                    vlTotalProduto: (wVlProduto * wQtdCompra)
                }
                wCarrinho = localStorage.getItem("card")
                if (wCarrinho == null) {
                    var wJsonCarrinho = {
                        data: [wJson]
                    }
                    localStorage.setItem("card", JSON.stringify(wJsonCarrinho));
                    alertify.set("notifier", "position", "top-right");
                    alertify.notify("<p style='color:white;font-size:16px;'>Produto Adiconado no carrinho com Sucesso</p>", "success", 10);
                } else {
                    var wJsonCarrinho2 = JSON.parse(wCarrinho);
                    for (let wIdx = 0; wIdx < wJsonCarrinho2["data"].length; wIdx++) {
                        if (wJsonCarrinho2["data"][wIdx]["id"] == wJson.id) {
                            alertify.set("notifier", "position", "top-right");
                            alertify.error("<p style='color:white;font-size:16px;'>Produto já adicionado no carrinho</p>", "danger", 10);
                            console.log("CARRINHO ATUAL")
                            wCarrinho = JSON.parse(localStorage.getItem("card"))
                            wCarrinho = wCarrinho.data
                            for (let wIdx = 0; wIdx < wCarrinho.length; wIdx++) {
                                console.log(wCarrinho[wIdx])
                            }
                            return;
                        }
                    }
                    wJsonCarrinho2.data.push(wJson)
                    localStorage.setItem("card", JSON.stringify(wJsonCarrinho2));
                    alertify.set("notifier", "position", "top-right");
                    alertify.notify("<p style='color:white;font-size:16px;'>Produto Adiconado com Sucesso com Sucesso</p>", "success", 10);
                }
            }
            console.log("CARRINHO ATUAL")
            wCarrinho = JSON.parse(localStorage.getItem("card"))
            wCarrinho = wCarrinho.data
            for (let wIdx = 0; wIdx < wCarrinho.length; wIdx++) {
                console.log(wCarrinho[wIdx])
            }
        });
    })
</script>

