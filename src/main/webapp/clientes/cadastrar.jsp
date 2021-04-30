<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
    </head>
    <body class="">
        <c:import url="../header.jsp"/>

        <c:if test="${empty cliente}">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class=" navbar-collapse">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="../index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../ClientesServlet">Lista Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="cadastrar.jsp">Cadastrar Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ProdutosServlet">Lista Produtos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="produtos/cadastrar.jsp">Cadastrar Produto</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <form action="CadastrarClienteServlet" method="POST">
               
                <label class="form-label">Nome</label><br/>
                <input type ="text" name="nome" required="true" class="form-control"/><br/><br/>
                <label class="form-label">CPF</label><br/>
                <input type ="text" name="cpf" required="true" class="form-control"/><br/><br/>
                <label class="form-label">Data de Nascimento</label><br/>
                <input type ="date" name="datanasc" required="true" class="form-control"/><br/><br/>
                <label class="form-label">E-mail</label><br/>
                <input type ="text" name="email" required="true" class="form-control"/><br/><br/>
                <label class="form-label">Endereço</label><br/>
                <input type ="text" name="endereco" required="true" class="form-control"/><br/><br/>
                <label class="form-label">Telefone</label><br/>
                <input type ="text" name="telefone" required="true" class="form-control"/><br/><br/>
                <label class="form-label">Sexo</label><br/>
                <input type ="text" name="sexo" required="true" class="form-control"/><br/><br/>

                <button type="submit" class="btn btn-success">Cadastrar</button>
            </form>
        </c:if>
        <c:if test="${not empty cliente}">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class=" navbar-collapse">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ClientesServlet">Lista Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="clientes/cadastrar.jsp">Cadastrar Clientes</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <form action="AlterarClienteServlet" method="POST">
                
                <input type ="text" name="id" required="true" value="${cliente.id}" hidden="true" class="form-control"/><br/><br/>
                <label>Nome</label><br/>
                <input type ="text" name="nome" required="true" value="${cliente.nome}" class="form-control"/><br/><br/>
                <label>CPF</label><br/>
                <input type ="text" name="cpf" required="true" value="${cliente.cpf}" class="form-control"/><br/><br/>
                <label>Data de Nascimento</label><br/>
                <input type ="date" name="datanasc" required="true" value="${cliente.datanasc}" class="form-control"/><br/><br/>
                <label>E-mail</label><br/>
                <input type ="text" name="email" required="true" value="${cliente.email}" class="form-control"/><br/><br/>
                <label>Endereço</label><br/>
                <input type ="text" name="endereco" required="true" value="${cliente.endereco}" class="form-control"/><br/><br/>
                <label>Telefone</label><br/>
                <input type ="text" name="telefone" required="true" value="${cliente.telefone}" class="form-control"/><br/><br/>
                <label>Sexo</label><br/>
                <input type ="text" name="sexo" required="true" value="${cliente.sexo}" class="form-control"/><br/><br/>

                <button type="submit" class="btn btn-success">Atualizar</button>
            </form>
        </c:if>
        <c:import url="../footer.jsp"/>
    </body>
</html>
