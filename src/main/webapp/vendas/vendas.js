/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    /* DATA TABLES*/
    var p_grd_json_datatable = {
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

    $('#tableCarrinho').DataTable(p_grd_json_datatable);
    window.wCarrinho = []
    /* CLICK TABLE*/
    $("#tableProdutos tbody tr").on("click", function () {
        $("tr").removeClass("cc-tabela-tr-selecionada")
        $(this).addClass("cc-tabela-tr-selecionada")
        $("[name='qtProduto']").removeClass("border border-danger");
        $("[name='qtProduto']").siblings('label').removeClass("text-danger");
        $("[name='qtProduto']").val("")
        fGetProduto($(this).attr("data-id"))
    });

    $("#tableCarrinho tr").on("click", function () {
        alertify.confirm('ALERT', 'Deseja Excluir Esse Item do Carrinho', function () {
            alertify.success('Sim')
        }
        , function () {
            alertify.error('Cancel')
        });
    });

    $("[data-btn-close-card='1']").on("click", function () {
        alert("FECHAR CARRINHO")
    })


    $("[data-btn-add-card='1']").on("click", function () {
        /* VERIFICA SE O CARRINHO JA FOI ABERTO*/
        var wCodigo = $("[name='idProduto']").val()
        var wNome = $("[name='nmProduto']").val()
        var wValorUnitario = $("[name='vlProduto']").val()
        var wQuantidade = $("[name='qtProduto']").val()

        var wValorTotal = wValorUnitario * wQuantidade

        wCarrinho.push({"codigo": wCodigo, "valorUnitario": wValorUnitario, "quantidade": wQuantidade, "valorTotal": wValorTotal})

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
                console.log("wQtdSeparada " + wQtdSeparada)
                console.log("wEstoqueMax " + wEstoqueMax)
                console.log(wQtdSeparada > wEstoqueMax)
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
})
        ;

