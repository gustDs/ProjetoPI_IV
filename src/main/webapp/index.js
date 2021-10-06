/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    $("[name='menu'] li a").on("click", function () {
        var wPage = $(this).attr("data-page")
        var wAjax = $.ajax(wPage)

        $.ajax({
            url: wPage,
        }).done(function (result) {
           $("[name='container']").html(result)
        });

    });

    $.ajax({
        url: "imagemPrincipal",
        contentType: "text/plain",
        type: "GET",
        success: function (result) {
      
            var wDataResult = JSON.parse(result)
            var wHtm = "";
            wDataResult.forEach(element => {
               
                wHtm += `
                        <div class="main" href="imagemPrincipal?id=${element.id}">
                            <div class="cards">
                                <div class="image">
                                    <img src="${element.blArquivo}">
                                </div>
                                <div class="tittle">
                                    <h2>${element.anNome}</h2>
                                </div>
                                <div class="preco">
                                    <h2>R$ ${element.vlProduto}</h2>
                                </div>
                                <div class="des">
                                    <p>${element.anDescricao}</p>
                                <a href="detalheProduto?wId=${element.id}">Detalhes</a>
                                </div>
                            </div>
                        </div>
                        `
            });
            /* APPEND CARD TO CONTAINER*/
            $("[name='container']").html(wHtm)
        },

        error: function (err) {
            console.log("ERR")
            console.log(err)
        
        }
    });

});