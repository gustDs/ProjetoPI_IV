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
        url: "produto?all",
        contentType: "text/plain",
        type: "GET",
        success: function (result) {
            var wDataResult = JSON.parse(result)
            var wHtm = "";
            wDataResult.forEach(element => {
                wHtm += `
                        <div class="main">
                            <div class="cards">
                                <div class="image">
                                    <img src="nvidia.jpg">
                                </div>
                                <div class="tittle">
                                    <h2>${element.nmProduto}</h2>
                                </div>
                                <div class="preco">
                                    <h2>${element.vlProduto}</h2>
                                </div>
                                <div class="des">
                                    <p>${element.anDescricao}</p>
                                    <button>Deatlhes</button>
                                </div>
                            </div>
                        </div>
                        `
            });
            /* APPEND CARD TO CONTAINER*/
            $("[name='container']").html(wHtm)
        },

        error: function () {
            console.log("ERR")
            console.log(err)
            alert(err)
        }
    });

});