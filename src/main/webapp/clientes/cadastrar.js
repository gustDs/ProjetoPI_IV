/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    /* DATA TABLES*/
    var p_grd_json_datatable = {
        "aaSorting": [],
        "paging": true,
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

    /* CLICK TABLE*/
    $("#table tbody tr").on("click", function () {
        $("tr").removeClass("cc-tabela-tr-selecionada")
        fValidaSalvar(1)
        $(this).addClass("cc-tabela-tr-selecionada")
        fEditarCliente($(this).attr("data-id"))
    });
    /* CLICK BTN EXCLUIR*/
    $("[data-btn-exluir='1']").on("click", function () {
        fDeletarCliente()
    });
    /* CLICK BTN SALVAR*/
    $("[data-btn-salvar='1']").on("click", function () {
        fSalvarCliente()
    });
    /* CLICK BTN NOVO*/
    $("[data-btn-novo='1']").on("click", function () {
        fNovoCliente()
    });


    function fNovoCliente() {
        $("[name='idCliente']").val("")
        $("[name='nmCliente']").val("")
        $("[name='anCpf']").val("")
        $("[name='dtNascimento']").val("")
        $("[name='dmSexo']").val("")
        $("[name='anLogradouro']").val("")
        $("[name='anEmail']").val("")
        $("[name='anTelefone']").val("")
    }
    /* BUSCA CLIENTE PARA EDICAO */
    function fEditarCliente(pId) {
        $.ajax("AlterarClienteServlet?id=" + pId).then((result) => {
            var wResult = JSON.parse(result);
            console.log(wResult)
            $("[name='idCliente']").val(wResult["id"])
            $("[name='nmCliente']").val(wResult["nmCliente"])
            $("[name='anCpf']").val(wResult["anCpf"])
            $("[name='dtNascimento']").val(wResult["dtNascimento"])
            $("[name='dmSexo']").val(wResult["dmSexo"])
            $("[name='anLogradouro']").val(wResult["anLogradouro"])
            $("[name='anEmail']").val(wResult["anEmail"])
            $("[name='anTelefone']").val(wResult["anTelefone"])
        }).catch((err) => {
            console.log("ERR")
            console.log(err)
        });
    }

    /* CRIA OU ALTERA CLIENTE */
    function fSalvarCliente() {
        /* VARIAVEIS */
        var wId = $("[name='idCliente']").val()
        var wNomeCliente = $("[name='nmCliente']").val()
        var wCpf = $("[name='anCpf']").val()
        var wNascimento = $("[name='dtNascimento']").val()
        var wSexo = $("[name='dmSexo']").val()
        var wLogradouro = $("[name='anLogradouro']").val()
        var wEmail = $("[name='anEmail']").val()
        var wTelefone = $("[name='anTelefone']").val()
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
            wData += "nmCliente=" + wNomeCliente + "&";
            wData += "anCpf=" + wCpf + "&";
            wData += "dtNascimento=" + wNascimento + "&";
            wData += "anEmail=" + wEmail + "&";
            wData += "anLogradouro=" + wLogradouro + "&";
            wData += "anTelefone=" + wTelefone + "&";
            wData += "dmSexo=" + wSexo + "";
            wData = encodeURI(wData)

            wURI = "clientes/CadastrarClienteServlet"


            $.ajax({
                type: "post",
                url: wURI,
                data: wData,
            }).then((res, textStatus, jqXHR) => {
                var wStatus = jqXHR.status
                if (wStatus == 200) {
                    alertify.set("notifier", "position", "top-right");
                    alertify.notify("<p style='color:white;font-size:16px;'>Cliente Cadastrado com Sucesso com Sucesso</p>", "success", 10);
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
            /* ID PREENCHIDO FAZ UM PUT */
            /* JSON */
            var wData = "";
            wData += "id=" + wId + "&";
            wData += "nmCliente=" + wNomeCliente + "&";
            wData += "anCpf=" + wCpf + "&";
            wData += "dtNascimento=" + wNascimento + "&";
            wData += "anEmail=" + wEmail + "&";
            wData += "anLogradouro=" + wLogradouro + "&";
            wData += "anTelefone=" + wTelefone + "&";
            wData += "dmSexo=" + wSexo + "";
            wData = encodeURI(wData)

            wURI = "AlterarClienteServlet"



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
                    alertify.notify("<p style='color:white;font-size:16px;'>Cliente Alterado com Sucesso com Sucesso</p>", "success", 10);
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
    /* DELETA CLIENTE */
    function fDeletarCliente() {
        var wId = $("#idCliente").val();
        console.log(fDeletarCliente)

        $.ajax("ExcluirClienteServlet?id=" + wId).then((result) => {
            console.log(result)
            alertify.set("notifier", "position", "top-right");
            alertify.notify("<p style='color:white;font-size:16px;'>Cliente Excluido com Sucesso</p>", "success", 10);
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
    ;
});

