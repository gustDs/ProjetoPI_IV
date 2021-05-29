/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    /* DATA TABLES*/
    var p_grd_json_datatable = {
        "pageLength": 5,
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


    $("[data-btn-relatorio='1']").on("click", function () {

        $("[name='data-relatorio']").DataTable().destroy()

        /* VARIAVEIS */
        var wCodigoVenda = $("[name='cnVenda']").val();
        var wFilial = $("[name='cnFilial']").val();
        var wDataInicial = $("[name='dtInicial']").val();
        var wDataFinal = $("[name='dtFinal']").val();

        /* DATA */
        var wData = "";
        wData += "cnVenda=" + wCodigoVenda + "&";
        wData += "cnFilial=" + wFilial + "&";
        wData += "dtInicial=" + wDataInicial + "&";
        wData += "dtFinal=" + wDataFinal + "";
        wData = encodeURI(wData)


        wURI = "ClientesVendasServlet"


        $.ajax({
            type: "post",
            url: wURI,
            data: wData,
        }).then((res, textStatus, jqXHR) => {

            var wStatus = jqXHR.status
            if (wStatus == 200) {
                var wResult = JSON.parse(res);
                var wData = ""
                $("[name='data-relatorio'] tbody").empty();
                for (let wIdx = 0; wIdx < wResult.length; wIdx++) {
                    const wRow = wResult[wIdx];
                    wData += "<tr>";
                    wData += "<td class='text-center'>";
                    wData += "" + wRow.venda + "";
                    wData += "</td>";
                    wData += "<td class='text-center'>";
                    wData += "" + wRow.cnFilial + "";
                    wData += "</td>";
                    wData += "<td class='text-center'>";
                    wData += "" + wRow.dtVenda + "";
                    wData += "<td class='text-center'>";
                    wData += "" + wRow.produto + "";
                    wData += "</td>";
                    wData += "<td class='text-center'>";
                    wData += "" + wRow.nmProduto + "";
                    wData += "</td>";
                    wData += "<td class='text-center'>";
                    wData += "" + wRow.quantidade + "";
                    wData += "</td>";
                    wData += "<td class='text-center'>";
                    wData += "" + wRow.valor + "";
                    wData += "</td>";
                    wData += "<td class='text-center'>";
                    wData += "" + wRow.valorTotal + "";
                    wData += "</td>";
                    wData += "</tr>";
                }
                $("[name='data-relatorio'] tbody").append(wData);
                $("[name='data-relatorio']").DataTable(p_grd_json_datatable);
            } else {
                alertify.set("notifier", "position", "top-right");
                alertify.error("<p style='color:white;font-size:16px;'>Erro interno Contate a Equipe de suporte do Sistema code[001]</p>", "danger", 10);
            }
        }).catch((err) => {
            alertify.set("notifier", "position", "top-right");
            alertify.error("<p style='color:white;font-size:16px;'>Erro interno Contate a Equipe de suporte do Sistema code[002]</p>", "danger", 10);
            console.log(err)

        });
    });
});
