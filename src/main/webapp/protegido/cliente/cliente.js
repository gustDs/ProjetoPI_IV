/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




$(document).ready(function () {

    $("[name='cep']").on("blur", function () {

        $.ajax({
            url: `http://viacep.com.br/ws/${$("[name='cep']").val()}/json/`,
        }).done(function (result) {
            $("[name='bairro']").val(result.bairro)
            $("[name='cidade']").val(result.localidade)
            $("[name='uf']").val((result.uf).toUpperCase())
            $("[name='logradouro']").val(result.logradouro)
            console.log(result)
        })
    })
});