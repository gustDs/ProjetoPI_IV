/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    /* DATA TABLES*/
    var p_grd_json_datatable = {
        "aaSorting": [],
        "paging": false,
        "ordering": true,
        "destroy": true,
        "deferRender": true,
        "info": false,
        "language": {
            "sEmptyTable": "Nenhum registro encontrado",
            "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
            "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
            "searchPlaceholder": "Buscar",
            "sInfoFiltered": "(Filtrados de _MAX_ registros)",
            "sInfoPostFix": "",
            "sInfoThousands": ".",
            "sLengthMenu": "_MENU_ <span class='cc-float-left cc-datatable-length'>resultados por pagina</span>",
            "sLoadingRecords": "Carregando...",
            "sProcessing": "Carregando...",
            "sZeroRecords": "Nenhum registro encontrado",
            "sSearch": "",
            "oPaginate": {
                "sNext": "Próximo",
                "sPrevious": "Anterior",
                "sFirst": "Primeiro",
                "sLast": "Último"
            },
            "buttons": ["excel"],
            "oAria": {
                "sSortAscending": ": Ordenar A-Z",
                "sSortDescending": ": Ordenar Z-A"
            }
        }
    };
    $('#table').DataTable(p_grd_json_datatable);
    $("#table tbody tr").on("click", function () {
        $("tr").removeClass("cc-tabela-tr-selecionada")
        fValidaSalvar(1)
        $(this).addClass("cc-tabela-tr-selecionada")
        fEditarProduto($(this).attr("data-id"))
    });
    /* CLICK BTN EXCLUIR*/
    $("[data-btn-exluir='1']").on("click", function () {
        fDeletarProduto()
    });
    /* CLICK BTN SALVAR*/
    $("[data-btn-salvar='1']").on("click", function () {
        fSalvarProduto()
    });
    /* CLICK BTN NOVO*/
    $("[data-btn-novo='1']").on("click", function () {
        fNovoProduto()
    });

    function fDeletarProduto() {

        var wId = $("[name='id']").val();

        $.ajax("../ExcluirProdutosServlet?id=" + wId).then((result) => {
            console.log(result)
            alertify.set("notifier", "position", "top-right");
            alertify.notify("<p style='color:white;font-size:16px;'>Produto Excluido com Sucesso</p>", "success", 10);
            /* RECARREGA PAGINA QUEBRA GALHO*/
            setTimeout(function () {
                document.location.reload(true);
            }, 1500);

        }).catch((err) => {
            console.log("ERR")
            console.log(err)
            alertify.error('err');

        });
    }


    function fNovoProduto() {
        $("[name='id']").val("")
        $("[name='dmFilial']").val("")
        $("[name='nmProduto']").val("")
        $("[name='dmCategoria']").val("")
        $("[name='nmModelo']").val("")
        $("[name='vlProduto']").val("")
        $("[name='qtProduto']").val("")
    }

    function fValidaSalvar(pOpcao) {
        /* VARIAVEIS */
        var wInpBoNull = [],
                wStrInp = "";
        /* REMOVE CLASS */
        if (pOpcao == 1) {
            $("[required='required']").each(function (wIdx, wEl) {

                $(wEl).removeClass("border border-danger");
                $(wEl).siblings('label').removeClass("text-danger");
            });
            return true;
        }
        /* VALIDA CAMPOS */
        $("[required='required']").each(function (wIdx, wEl) {
            var wValor = $(wEl).val();
            if (!wValor) {
                /* INSERT */
                $(wEl).addClass("border border-danger");
                $(wEl).siblings('label').addClass("text-danger");
                wInpBoNull.push($(wEl).siblings('label').text())
            } else {
                $(wEl).removeClass("border border-danger");
                $(wEl).siblings('label').removeClass("text-danger");
            }
        });
        wInpBoNull.forEach(wInpBoNull => {
            wStrInp += "<br> - " + wInpBoNull + "";
        });
        if (wInpBoNull.length > 0) {
            alertify.set("notifier", "position", "top-right");
            alertify.error("<p style='color:white;font-size:16px;'> Há campos obrigatórios não preenchidos: " + wStrInp + "</p>", "danger", 10);
            return false;
        } else {
            return true;
        }
    }


    /* BUSCA CLIENTE PARA EDICAO */
    function fEditarProduto(pId) {
        $.ajax("../AlterarProdutosServlet?id=" + pId).then((result) => {
            var wResult = JSON.parse(result);
            $("[name='id']").val(wResult["id"])
            $("[name='dmFilial']").val(wResult["dmFilial"])
            $("[name='nmProduto']").val(wResult["nmProduto"])
            $("[name='dmCategoria']").val(wResult["dmCategoria"])
            $("[name='nmModelo']").val(wResult["nmModelo"])
            $("[name='vlProduto']").val(wResult["vlProduto"])
            $("[name='qtProduto']").val(wResult["qtProduto"])
        }).catch((err) => {
            console.log("ERR")
            console.log(err)
        });
    }

    /* CRIA OU ALTERA PRODUTO */
    function fSalvarProduto() {
        var wId = $("[name='id']").val()
        var wDmFilial = $("[name='dmFilial']").val()
        var wNmCliente = $("[name='nmProduto']").val()
        var wDmCategoria = $("[name='dmCategoria']").val()
        var wNmModelo = $("[name='nmModelo']").val()
        var wVlProduto = $("[name='vlProduto']").val()
        var wQtProduto = $("[name='qtProduto']").val()
        /* SE FOR UM NOVO REGISTRO [POST]*/
        if (wId == "") {
            /* VALIDA CAMPOS */
            var wValoresValidos = fValidaSalvar();
            /* SE CAMPOS OBRIGATORIOS NAO PREENCHIDO*/
            if (!wValoresValidos) {
                return
            }
            /* JSON */

            var wData = "";
            wData += "filial=" + wDmFilial + "&";
            wData += "nome=" + wNmCliente + "&";
            wData += "categoria=" + wDmCategoria + "&";
            wData += "modelo=" + wNmModelo + "&";
            wData += "preco=" + wVlProduto + "&";
            wData += "quantidade=" + wQtProduto + "";
            wData = encodeURI(wData)

            wURI = "../produtos/CadastrarProdutosServlet"


            $.ajax({
                type: "post",
                url: wURI,
                data: wData,
            }).then((res, textStatus, jqXHR) => {
                var wStatus = jqXHR.status
                if (wStatus == 200) {
                    alertify.set("notifier", "position", "top-right");
                    alertify.notify("<p style='color:white;font-size:16px;'>Produto Cadastrado com Sucesso com Sucesso</p>", "success", 10);
                    setTimeout(function () {
                        document.location.reload(true);
                    }, 1500);
                } else {
                    alertify.set("notifier", "position", "top-right");
                    alertify.error("<p style='color:white;font-size:16px;'>Erro interno Contate a Equipe de suporte do Sistema code[001]</p>", "danger", 10);
                }
            }).catch((err) => {
                alertify.set("notifier", "position", "top-right");
                alertify.error("<p style='color:white;font-size:16px;'>Erro interno Contate a Equipe de suporte do Sistema code[002]</p>", "danger", 10);
                console.log(err)

            });
        } else {
            /* VALIDA CAMPOS */
            var wValoresValidos = fValidaSalvar();
            /* SE CAMPOS OBRIGATORIOS NAO PREENCHIDO*/
            if (!wValoresValidos) {
                return
            }
            /* ID PREENCHIDO FAZ UM PUT */
            /* JSON */
            var wData = "";
            wData += "id=" + wId + "&";
            wData += "filial=" + wDmFilial + "&";
            wData += "nome=" + wNmCliente + "&";
            wData += "categoria=" + wDmCategoria + "&";
            wData += "modelo=" + wNmModelo + "&";
            wData += "preco=" + wVlProduto + "&";
            wData += "quantidade=" + wQtProduto + "";
            wData = encodeURI(wData)

            wURI = "../AlterarProdutosServlet"



            $.ajax({
                type: "post",
                url: wURI,
                data: wData,
            }).then((res, textStatus, jqXHR) => {
                console.log("res")
                console.log(res)
                var wStatus = jqXHR.status
                if (wStatus == 200) {
                    alertify.set("notifier", "position", "top-right");
                    alertify.notify("<p style='color:white;font-size:16px;'>Produto Alterado com Sucesso com Sucesso</p>", "success", 10);
                    setTimeout(function () {
                        document.location.reload(true);
                    }, 1500);
                } else {
                    alertify.set("notifier", "position", "top-right");
                    alertify.error("<p style='color:white;font-size:16px;'>Erro interno Contate a Equipe de suporte do Sistema code[001]</p>", "danger", 10);
                }
            }).catch((err) => {
                alertify.set("notifier", "position", "top-right");
                alertify.error("<p style='color:white;font-size:16px;'>Erro interno Contate a Equipe de suporte do Sistema code[002]</p>", "danger", 10);
                console.log(err)

            });
        }
    }
})

