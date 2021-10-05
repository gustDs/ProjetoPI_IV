/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




$(document).ready(function () {
    var p_grd_json_datatable = {
        "aaSorting": [],
        "paging": false,
        "ordering": true,
        "destroy": true,
        "deferRender": true,
        "pageLength": 1,
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
    $('[name="gridProdutos"]').DataTable(p_grd_json_datatable);
    wTableGridImg = $('[name="gridProdutosImagem"]').DataTable(p_grd_json_datatable);
    /* CLICK TABLE PRODUTO */
    $(document).off("click", "#gridProdutos tbody tr");
    $(document).on("click", "#gridProdutos tbody tr", function (e) {
        /* REMOVE CLASS LINHA SELECIONADA */
        $("tr").removeClass("cc-tabela-tr-selecionada");
        /* ADD CLASS LINHA SELECIONADA */
        $(this).addClass("cc-tabela-tr-selecionada");
        /* CALL FUNCTION GET PRODUTO*/
        fGetProduto($(this).attr("data-id"));
        /* CALL FUNCTION GET IMAGENS DO PRODUTO*/
        fGetProdutoImagem($(this).attr("data-id"));

    });
    /* CLICK BTN NOVO*/
    $("[data-btn-novo='1']").on("click", function () {
        /* LIMPA CAMPOS*/
        $("[name='id']").val("");
        $("[name='nmProduto']").val("");
        $("[name='dmAvaliacao']").val("");
        $("[name='anDescricao']").val("");
        $("[name='vlProduto']").val("");
        $("[name='qtProduto']").val("");
        $("[name='dmStatus']").val("");
        $("[name='idImagem']").val("");
        $("#previewImg").html("");
        $("[name='dtImagem']").val("");
        $("[name='nmImagem']").val("");
        $("[name='boImagemPrincipal']").prop("checked", false);
        /* REMOVE CLASS DANGER */
        fValidaSalvar(1, "formProduto");
        $("[name='formImagem'] button").attr("disabled", "disabled");
        wTableGridImg.destroy();
        $('[name="gridProdutosImagem"] tbody').empty();
    });
    /* CLICK NOVO IMAGEM */
    $("[data-btn-novo-img='1']").on("click", function () {
        $("[name='idImagem']").val("");
        $("#previewImg").html("");
        $("[name='dtImagem']").val("");
        $("[name='nmImagem']").val("");
        $("[name='boImagemPrincipal']").prop("checked", false);
        fValidaSalvar(1, "formImagem");

    })
    /* CLICK SALVAR IMAGEM */
    $("[data-btn-salvar-img='1']").on("click", function () {
        let wId = $("[name='idImagem']").val(),
                wCnProduto = $("[name='id']").val(),
                wNmImagem = $("[name='nmImagem']").val(),
                wBlArquivo = $("#previewImg img").attr("src"),
                wBoImgPrincipal = $('input[name="boImagemPrincipal"]:checked').length > 0,
                wBoInativo = 0;


        wBoImgPrincipal = (wBoImgPrincipal) ? 1 : 0;
        var wValoresValidos = fValidaSalvar(0, "formImagem");
        if (wValoresValidos) {
            if (!wId) {
                /* POST */
                var wJson = {
                    cnProduto: wCnProduto,
                    nmImagem: wNmImagem,
                    blArquivo: wBlArquivo,
                    boImgPrincipal: wBoImgPrincipal,
                    boInativo: wBoInativo
                }
                $.ajax({
                    type: "post",
                    url: "produtoImagem",
                    data: JSON.stringify(wJson),
                }).then((res, textStatus, jqXHR) => {
                    var wStatus = jqXHR.status
                    if (wStatus == 200) {
                        alertify.set("notifier", "position", "top-right");
                        alertify.notify("<p style='color:white;font-size:16px;'>Imagem do Produto Cadastrado com Sucesso com Sucesso</p>", "success", 10);
                        $.ajax({
                            url: "produto",
                        }).done(function (result) {
                            $("[name='container']").html(result)
                        });
                    } else {
                        alertify.set("notifier", "position", "top-right");
                        alertify.error("<p style='color:white;font-size:16px;'>Erro interno Contate a Equipe de suporte do Sistema codeErr[001]</p>", "danger", 10);
                    }

                }).catch((err) => {
                    alertify.set("notifier", "position", "top-right");
                    alertify.error("<p style='color:white;font-size:16px;'>Erro interno Contate a Equipe de suporte do Sistema codeErr[002]</p>", "danger", 10);
                });
            } else {
                /*PUT*/
                var wJson = {
                    id: wId,
                    cnProduto: wCnProduto,
                    nmImagem: wNmImagem,
                    blArquivo: wBlArquivo,
                    boImgPrincipal: wBoImgPrincipal,
                    boInativo: wBoInativo 
                }
                $.ajax({
                    type: "PUT",
                    url: "produtoImagem",
                    data: JSON.stringify(wJson),
                }).then((res, textStatus, jqXHR) => {
                    var wStatus = jqXHR.status
                    if (wStatus == 200) {
                        alertify.set("notifier", "position", "top-right");
                        alertify.notify("<p style='color:white;font-size:16px;'>Imagem do Produto Alterada com Sucesso com Sucesso</p>", "success", 10);
                        $.ajax({
                            url: "produto",
                        }).done(function (result) {
                            $("[name='container']").html(result)
                        });
                    } else {
                        alertify.set("notifier", "position", "top-right");
                        alertify.error("<p style='color:white;font-size:16px;'>Erro interno Contate a Equipe de suporte do Sistema codeErr[001]</p>", "danger", 10);
                    }

                }).catch((err) => {
                    alertify.set("notifier", "position", "top-right");
                    alertify.error("<p style='color:white;font-size:16px;'>Erro interno Contate a Equipe de suporte do Sistema codeErr[002]</p>", "danger", 10);
                    console.log(err)

                });
            }

        }

    })
    /* CLICK SALVAR PRODUTO */
    $("[data-btn-salvar='1']").on("click", function () {
        let wId = $("[name='id']").val(),
                wNmProduto = $("[name='nmProduto']").val(),
                wDmAvaliacao = $("[name='dmAvaliacao']").val(),
                wAnDescricao = $("[name='anDescricao']").val(),
                wVlProduto = $("[name='vlProduto']").val(),
                wQtProduto = $("[name='qtProduto']").val(),
                wDmStatus = $("[name='dmStatus']").val();
        if (!wId) {
            /*POST*/
            /* VALIDA CAMPOS */
            var wValoresValidos = fValidaSalvar(0, "formProduto");
            /* SE CAMPOS OBR
             var wValoresValidos = fValidaSalvar(0, "formProduto");IGATORIOS NAO PREENCHIDO*/
            if (wValoresValidos) {
                var wJson = {
                    nmProduto: wNmProduto,
                    dmAvaliacao: wDmAvaliacao,
                    anDescricao: wAnDescricao,
                    vlProduto: wVlProduto,
                    qtProduto: wQtProduto,
                    dmStatus: wDmStatus
                }
                $.ajax({
                    type: "post",
                    url: "produto",
                    data: JSON.stringify(wJson),
                }).then((res, textStatus, jqXHR) => {
                    var wStatus = jqXHR.status
                    if (wStatus == 200) {
                        alertify.set("notifier", "position", "top-right");
                        alertify.notify("<p style='color:white;font-size:16px;'>Produto Cadastrado com Sucesso com Sucesso</p>", "success", 10);
                        $.ajax({
                            url: "produto",
                        }).done(function (result) {
                            $("[name='container']").html(result)
                        });
                    } else {
                        alertify.set("notifier", "position", "top-right");
                        alertify.error("<p style='color:white;font-size:16px;'>Erro interno Contate a Equipe de suporte do Sistema codeErr[001]</p>", "danger", 10);
                    }
                }).catch((err) => {
                    alertify.set("notifier", "position", "top-right");
                    alertify.error("<p style='color:white;font-size:16px;'>Erro interno Contate a Equipe de suporte do Sistema codeErr[002]</p>", "danger", 10);
                    console.log(err)

                });
            }
        } else {
            /*GET*/
            var wJson = {
                id: wId,
                nmProduto: wNmProduto,
                dmAvaliacao: wDmAvaliacao,
                anDescricao: wAnDescricao,
                vlProduto: wVlProduto,
                qtProduto: wQtProduto,
                dmStatus: wDmStatus
            }
            $.ajax({
                type: "put",
                url: "produto",
                data: JSON.stringify(wJson),
            }).then((res, textStatus, jqXHR) => {
                var wStatus = jqXHR.status
                if (wStatus == 200) {
                    alertify.set("notifier", "position", "top-right");
                    alertify.notify("<p style='color:white;font-size:16px;'>Produto Atualizado com Sucesso com Sucesso</p>", "success", 10);
                    $.ajax({
                        url: "produto",
                    }).done(function (result) {
                        $("[name='container']").html(result)
                    });
                } else {
                    alertify.set("notifier", "position", "top-right");
                    alertify.error("<p style='color:white;font-size:16px;'>Erro interno Contate a Equipe de suporte do Sistema codeErr[003]</p>", "danger", 10);
                }
                fGetProduto(wId)
            }).catch((err) => {
                alertify.set("notifier", "position", "top-right");
                alertify.error("<p style='color:white;font-size:16px;'>Erro interno Contate a Equipe de suporte do Sistema codeErr[004]</p>", "danger", 10);
                console.log(err)

            });
        }
    });
    /* FUNCTIONS */
    function fGetProduto(pId) {
        $.ajax({
            url: "produto?Id=" + pId,
        }).done(function (result) {
            var wResult = JSON.parse(result);
            $("[name='id']").val(wResult.id);
            $("[name='nmProduto']").val(wResult.nmProduto);
            $("[name='dmAvaliacao']").val(wResult.dmAvaliacao);
            $("[name='anDescricao']").val(wResult.anDescricao);
            $("[name='vlProduto']").val(wResult.vlProduto);
            $("[name='qtProduto']").val(wResult.qtProduto);
            $("[name='dmStatus']").val(wResult.dmStatus);
        });
    }
    /* FUNCTIONS */
    function fGetProdutoImagem(pProduto) {
        $("[name='formImagem'] button").attr("disabled", false);
        /* LIMPA CAMPOS */
        $("[name='idImagem']").val("");
        $("#previewImg").html("");
        $("[name='dtImagem']").val("");
        $("[name='nmImagem']").val("");
        $("[name='boImagemPrincipal']").prop("checked", false);
        $.ajax({
            url: "produtoImagem?produto=" + pProduto,
        }).done(function (result) {
            result = JSON.parse(result);
            if (result.length) {
                wHtml = "";
                wTableGridImg.destroy();
                $('[name="gridProdutosImagem"] tbody').empty();
                for (let wIdx = 0; wIdx < result.length; wIdx++) {
                    const wRow = result[wIdx];
                    wHtml += `
                    <tr data-id=${wRow.id}>
                        <td>${wRow.id}</td>
                        <td>${wRow.nmImagem}</td>
                        <td>${wRow.dtIncSys}</td>
                    </tr>
                        `;
                }
                $('[name="gridProdutosImagem"] tbody').append(wHtml);
                wTableGridImg = $('[name="gridProdutosImagem"]').DataTable(p_grd_json_datatable);
                /* EVENT CLICK TABLE PRODUTO IMAGEM */
                $(document).off("click", "#gridProdutosImagem tbody tr");
                $(document).on("click", "#gridProdutosImagem tbody tr", function (e) {
                    fValidaSalvar(1, "formImagem");
                    /* HABILITA BTS */
                    $("[name='formImagem'] button").attr("disabled", false);
                    /* REMOVE CLASS LINHA SELECIONADA */
                    $('[name="gridProdutosImagem"] tr').removeClass("cc-tabela-tr-selecionada");
                    /* ADD CLASS LINHA SELECIONADA */
                    $(this).addClass("cc-tabela-tr-selecionada");
                    /* GET IMG PRODUTO*/
                    $.ajax({
                        url: "produtoImagem?id=" + $(this).attr("data-id"),
                    }).done(function (result) {
                        wJson = JSON.parse(result);
                        // debugger;
                        $("[name='idImagem']").val(wJson.id);
                        $("#previewImg").html("<img width='auto' height='300px' src='" + wJson.blArquivo + "'>");
                        $("[name='dtImagem']").val(wJson.dtIncSys);
                        $("[name='nmImagem']").val(wJson.nmImagem);
                        if (wJson.boImgPrincipal == 1) {
                            $("[name='boImagemPrincipal']").prop("checked", true);
                        } else {
                            $("[name='boImagemPrincipal']").prop("checked", false);
                        }

                    })
                });
            } else {
                wTableGridImg.destroy();
                $('[name="gridProdutosImagem"] tbody').empty();
                wTableGridImg = $('[name="gridProdutosImagem"]').DataTable(p_grd_json_datatable);
            }
        });
    }
    /* VALIDA SALVAR */
    function fValidaSalvar(pOpcao, pObjReferencia) {
        /* VARIAVEIS */
        var wInpBoNull = [],
                wStrInp = "";
        /* REMOVE CLASS */
        if (pOpcao === 1) {
            $("[name='" + pObjReferencia + "'] [required='required']").each(function (wIdx, wEl) {

                $(wEl).removeClass("border border-danger");
                $(wEl).siblings('label').removeClass("text-danger");
            });
            return true;
        }
        /* VALIDA CAMPOS */
        $("[name='" + pObjReferencia + "'] [required='required']").each(function (wIdx, wEl) {
            //debugger;
            var wValor = ($(wEl).val()) ? $(wEl).val() : $(wEl).find("img").attr("src");

            if (!wValor) {
                /* INSERT */
                $(wEl).addClass("border border-danger");
                $(wEl).siblings('label').addClass("text-danger");
                wInpBoNull.push($(wEl).siblings('label').text());
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
    $("[data-ref]").on("click", function () {
        wURI = "produto?" + $(this).attr("data-ref");
        $.ajax({
            type: "DELETE",
            url: wURI
        }).then((res, textStatus, jqXHR) => {
            res = JSON.parse(res)
       
            if (res.cnRetorno == 0) {
                alertify.set("notifier", "position", "top-right");
                alertify.notify("<p style='color:white;font-size:16px;'>Produto Alterado com Sucesso com Sucesso</p>", "success", 10);
                $.ajax({
                    url: "produto",
                }).done(function (result) {
     
                    $("[name='container']").html(result)
                });
            }
        })
    })

    $("[name='blImagem']").on("change", function () {

        wFileUpload = $("#blImagem")[0].files[0]
        wFileReader = new FileReader();
        wFileReader.fileName = wFileUpload.name;
        /* LEITURA DO ARQUIVO */
        wFileReader.readAsDataURL(wFileUpload);
        wFileReader.onload = function (readerEvt) {
            $("#previewImg").html("<img width='auto' height='300px' src='" + wFileReader.result + "'>");
        }
    })
});