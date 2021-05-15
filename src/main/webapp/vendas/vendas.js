/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    /* DATA TABLES*/
    var p_grd_json_datatable = {
        "pageLength": 100000,
        "aaSorting": [],
        "orderCellsTop": true,
        "fixedHeader": true,
        "fixedColumns": true,
        "paging": true,
        "ordering": true,
        "destroy": true,
        "orderCellsTop": true,
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
    $('#tableCliente').DataTable(p_grd_json_datatable);
    /* TABELA DE PRODUTOS */
    var wTable = $('#tableProdutos').DataTable(p_grd_json_datatable);
    $('#tableProdutos tfoot th').each(function (i) {
        var title = $('#tableProdutos thead th').eq($(this).index()).text();
        $(this).html('<input class="form-control" type="text" placeholder="" ' + title + '" data-index="' + i + '" />');
    });

    $(wTable.table().container()).on('keyup', 'tfoot input', function () {
        wTable
                .column($(this).data('index'))
                .search(this.value)
                .draw();
    });

    
    window.wCarrinho = []
    /* CLICK TABLE*/
    $("#tableProdutos tbody tr").on("click", function () {
        $("tr").removeClass("cc-tabela-tr-selecionada")
        $(this).addClass("cc-tabela-tr-selecionada")
        $("[name='qtProduto']").removeClass("border border-danger");
        $("[name='qtProduto']").siblings('label').removeClass("text-danger");
        $("[name='qtProduto']").val("")
        console.log($(this))
        console.log($(this).attr("data-id"))
        fGetProduto($(this).attr("data-id"))
    });
    
    $('#tableCarrinho').DataTable(p_grd_json_datatable);

    $("#tableCarrinho tbody tr").on("click", function () {
        alertify.confirm('ALERT', 'Deseja Excluir Esse Item do Carrinho', function () {
            alertify.success('Sim')
        }
        , function () {
            alertify.error('Cancel')
        });
    });

    $("[data-btn-close-card='1']").on("click", function () {
        console.log($("[name='cbCliente']").val())
        if ($("[name='cbCliente']").val() == "0") {
            alertify.set("notifier", "position", "top-right");
            alertify.error("<p style='color:white;font-size:16px;'>É necessário informar um cliente antes de fechar o Carrinho!", "danger", 15);
            $("[name='cbCliente']").addClass("border border-danger");
            $("[name='cbCliente']").siblings('label').addClass("text-danger");
            $("[name='cbCliente']").focus();
            return false;
        } else if ($("[name='cbFilial']").val() == "0") {
            alertify.set("notifier", "position", "top-right");
            alertify.error("<p style='color:white;font-size:16px;'>É necessário informar uma Filial antes de fechar o Carrinho!", "danger", 15);
            $("[name='cbFilial']").addClass("border border-danger");
            $("[name='cbFilial']").siblings('label').addClass("text-danger");
            $("[name='cbFilial']").focus();
            return false;
        } else {
            /* REMOVE */
            $("[name='cbCliente']").removeClass("border border-danger");
            $("[name='cbCliente']").siblings('label').removeClass("text-danger");
            $("[name='cbFilial']").removeClass("border border-danger");
            $("[name='cbFilial']").siblings('label').removeClass("text-danger");

            var wJsn = "{"
            wJsn += "   \"cnCliente\" : \"" + $("[name='cbCliente']").val() + "\","
            wJsn += "   \"cnFilial\" : \"" + $("[name='cbFilial']").val() + "\","
            wJsn += "   \"data\" :"
            wJsn += "   ["
            wCarrinho.forEach(element => {
                wJsn += "     {"
                wJsn += "        \"produto\" : \"" + element.produto + "\","
                wJsn += "        \"quantidade\" : \"" + element.quantidade + "\","
                wJsn += "        \"valor\" : \"" + element.valor + "\","
                wJsn += "        \"valorTotal\" : \"" + element.valorTotal + "\""
                wJsn += "     },"
            });
            wJsn = wJsn.substr(0, wJsn.length - 1) + "";
            wJsn += "  ]";
            wJsn += "   }";

            console.log("WJSON")
            console.log(wJsn)

            /* URI DA API NODE */
            var wRest = "VendasServlet"

            /* AJAX  */
            $.ajax({
                type: "post",
                url: wRest,
                data: wJsn
            }).then((res, textStatus, jqXHR) => {
                var wStatus = jqXHR.status
                if (wStatus == 200) {
                    alertify.set("notifier", "position", "top-right");
                    alertify.notify("<p style='color:white;font-size:16px;'>Carrinho fechado com sucesso</p>", "success", 10);
                    setTimeout(function () {
                        document.location.reload(true);
                    }, 1500);
                }


            }).catch((err) => {
                alert("erro")
                console.log("err")
                console.log(err)

            });

        }

    })


    $("[data-btn-add-card='1']").on("click", function () {
        $("[name='qtProduto']").blur();
        /* VERIFICA SE O CARRINHO JA FOI ABERTO*/
        var wCodigo = $("[name='idProduto']").val()
        var wNome = $("[name='nmProduto']").val()
        var wValorUnitario = $("[name='vlProduto']").val()
        var wQuantidade = $("[name='qtProduto']").val()

        var wValorTotal = wValorUnitario * wQuantidade

        wCarrinho.push({"produto": wCodigo, "valor": wValorUnitario, "quantidade": wQuantidade, "valorTotal": wValorTotal})

        $('#tableCarrinho').DataTable().row.add([
            wCodigo,
            wNome,
            wValorUnitario,
            wQuantidade,
            wValorTotal
        ]).draw(false);

    });
    function fGetProduto(pId) {

        $.ajax("AlterarProdutosServlet?id=" + pId).then((result) => {
            var wResult = JSON.parse(result);
            var wEstoqueMax = wResult.qtProduto
            $("[name='idProduto']").val(wResult.id)
            $("[name='nmProduto']").val(wResult.nmProduto)
            $("[name='dmCategoria']").val(wResult.dmCategoria)
            $("[name='nmModelo']").val(wResult.nmModelo)
            $("[name='vlProduto']").val(wResult.vlProduto)
            $("[name='qtProduto']").val()
            $(document).off("blur", "[name='qtProduto']");
            $(document).on("blur", "[name='qtProduto']", function (e) {
                var wQtdSeparada = $(this).val()

                if (parseInt(wQtdSeparada) <= 0) {
                    alertify.set("notifier", "position", "top-right");
                    alertify.error("<p style='color:white;font-size:16px;'>Quantidade adicionada no carrinho não pode ser menor ou igual a 0 !", "danger", 15);
                    /* INSERT */
                    $(this).addClass("border border-danger");
                    $(this).siblings('label').addClass("text-danger");
                    $("[data-btn-add-card='1']").prop('disabled', true);
                    return;
                }



                if (parseInt(wQtdSeparada) > parseInt(wEstoqueMax)) {
                    alertify.set("notifier", "position", "top-right");
                    alertify.error("<p style='color:white;font-size:16px;'>Quantidade adicionada no carrinho não pode ser superior a quantidade <br> Disponivel em Estoque !", "danger", 15);
                    /* INSERT */
                    $(this).addClass("border border-danger");
                    $(this).siblings('label').addClass("text-danger");
                    $("[data-btn-add-card='1']").prop('disabled', true);

                } else {
                    /* REMOVE */
                    $(this).removeClass("border border-danger");
                    $(this).siblings('label').removeClass("text-danger");
                    $("[data-btn-add-card='1']").prop('disabled', false);
                }
            })
        }).catch((err) => {
            console.log("ERR")
            console.log(err)
        });
    }


    wURICbCliente = "clientes/CadastrarClienteServlet"
    $.ajax({
        type: "get",
        url: wURICbCliente,
    }).then((res, textStatus, jqXHR) => {

        var wStatus = jqXHR.status
        if (wStatus == 200) {

            var wOptions = ""
            var wResponse = JSON.parse(res)
            console.log(wResponse)
            wResponse.forEach(element => {
                wOptions += "<option value='" + element.id + "'>" + element.nmCliente + "</option>"
            });
            $("[name='cbCliente']").append(wOptions)
        }
    }).catch((err) => {
        alertify.set("notifier", "position", "top-right");
        alertify.error("<p style='color:white;font-size:16px;'>Erro interno Contate a Equipe de suporte do Sistema code[004]</p>", "danger", 10);
        console.log(err)

    });


});
