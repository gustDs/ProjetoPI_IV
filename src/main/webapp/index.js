/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("[data-loading-name='loading']").show()


    $.ajax({
        url: "protegido/imagemPrincipal",
        contentType: "text/plain",
        type: "GET",
        success: function (result) {

            var wDataResult = JSON.parse(result)
            var wHtm = "";
            wDataResult.forEach(element => {
//                                <p class="card-text ">${element.anDescricao}</p>
                wHtm += `
                            <div class="cc-card card text-center m-4" style="width: 18rem;" href="imagemPrincipal?id=${element.id}">
                              <a class=" " data-page="protegido/detalheProduto?wId=${element.id}">
                                    <img class="p-4 img-responsive center-block cc-image" src="${element.blArquivo}" alt="Imagem">
                                    <div class="card-body">
                                      <h5 class="card-title ">${element.anNome}</h5>

                                      <p class="card-text font-weight-bold">R$ ${element.vlProduto}</p>
                                      <div>

                                      </div>           
                                    </div>
                                </a>
                            </div>
                        `
            });
            /* APPEND CARD TO CONTAINER*/
            $("[data-loading-name='loading']").hide()
            $("[name='container']").html(wHtm)
            $("[data-page]").off("click");
            $("[data-page]").on("click", function () {
                var wPage = $(this).attr("data-page")
                var wAjax = $.ajax(wPage)
                console.log(wPage)
                $.ajax({
                    url: wPage,
                }).done(function (result) {
                    $("[name='container']").html(result)
                });

            });
        },

        error: function (err) {
            $("[data-loading-name='loading']").hide()
            console.log("ERR")
            console.log(err)

        }
    });
    $("[data-page]").off("click");
    $("[data-page]").on("click", function () {
        var wPage = $(this).attr("data-page")
        var wAjax = $.ajax(wPage)
        console.log(wPage)
        $.ajax({
            url: wPage,
        }).done(function (result) {
            $("[name='container']").html(result)
        });

    });
});