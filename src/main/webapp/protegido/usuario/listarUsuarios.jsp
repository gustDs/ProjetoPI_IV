
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <div class="row m-auto " style="max-width: 1900px;">
        <div class="cc-col w-100 "  >
            <h3>Lista de Usuarios!</h3>
            <div class="cc-col w-100 col-26">
                <table class="table table-striped table-bordered ">
                    <thead  class="text-center " style="background: #3b3b3b; color:#fff;">
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>E-mail</th>
                    <th>Perfil</th>
                    <th>Status</th>
                    <th></th>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaUsuarios}" var="usuarios">
                            <tr>
                                <td>${usuarios.anNome}</td>
                                <td>${usuarios.nmCpf}</td>
                                <td>${usuarios.anEmail}</td>
                                <td>${usuarios.anPerfil}</td>
                                <td>${usuarios.boInativo}
                                <td><button class="btn btn btn-info w-100" data-page="AlterarUsuariosSV?anEmail=${usuarios.anEmail}">
                                        Alterar
                                    </button>
                                </td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
<script>
    $("[data-page]").on("click", function () {
        var wPage = $(this).attr("data-page")
        var wAjax = $.ajax(wPage)
        console.log(wPage)
        $.ajax({
            url: wPage,
        }).done(function (result) {
            $("[name='container']").html(result)
        });

    });
</script>
