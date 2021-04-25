<%-- 
    Document   : listaClientes
    Created on : 22/04/2021, 22:40:20
    Author     : Martins
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>     
    </head>
    <body class="container">
        <c:import url="header.jsp"/>
        
        <script type="text/javascript">
            function mostrarTelaConfirmacao(nome, id) {
                
                $("#nomeCliente").html(nome);
                $("#idCliente").val(id);
                var modalConfirmacao = $("#confirmarExclusao");
                modalConfirmacao.show();
            }
            
            function fecharTelaConfirmacao() {
                $("#confirmarExclusao").hide();
            }
            
            function deletarCliente() {
                var id = $("#idCliente").val();
                fecharTelaConfirmacao();
                  $.ajax( "ExcluirClienteServlet?id=" + id).done(function() {
                      //SUCESSO
                        location.reload();
                      })
                      .fail(function() {
                        console.log( "error" );
                      });           
            }
            
        </script>
        
        <h1>Clientes:</h1>
        
        <table class="table">
            <th>ID</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>Data de Nascimento</th>
            <th>E-mail</th>
            <th>Endereço</th>
            <th>Telefone</th>
            <th>Sexo</th>
            
            <c:forEach items="${listaClientes}" var="cliente">
                <tr>
                    <td>${cliente.id}</td>
                    <td>${cliente.nome}</td>
                    <td>${cliente.cpf}</td>
                    <td>${cliente.datanasc}</td>
                    <td>${cliente.email}</td>
                    <td>${cliente.endereco}</td>
                    <td>${cliente.telefone}</td>
                    <td>${cliente.sexo}</td>
                    <td><a href="AlterarClienteServlet?id=${cliente.id}">Alterar</td>
                    
                    <td><button type="button" class="btn btn-link" onclick="mostrarTelaConfirmacao(`${cliente.nome}`,`${cliente.id}`)">Excluir</button></td>
                </tr>
            </c:forEach>   
        </table>
        
        <!-- Modal -->
        <div class="modal" id="confirmarExclusao">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title">Confirmar Exclusão</h5>
              </div>
              <div class="modal-body">
                  <p>Confirmar exclusão do cliente <label id="nomeCliente"></label> ?</p>
                  <input type="hidden" id="idCliente"/>
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                  <button type="button" class="btn btn-primary" onclick="deletarCliente()">Confirmar</button>
              </div>
            </div>
          </div>
        </div>
        
        <c:import url="footer.jsp"/>
    </body>
</html>
