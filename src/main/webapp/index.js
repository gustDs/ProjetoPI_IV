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
              $("[name='conteiner']").html(result)
        });
    });
    
});