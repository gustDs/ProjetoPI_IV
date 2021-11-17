

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Dados</title>
    </head>
    <body>
        <h1>Atualize seus dados:</h1>
        <form action="AlterarClientesSV" method="POST">
            <label class="form-label">Nome</label>
            <input type="text" name="nome" required="true" value="${sessionScope.clientes.nome}" class="form-control"/><br/>
            <label>Data de Nascimento</label>
            <input type="date" name="dataNasc" required="true" value="${sessionScope.clientes.dataNasc}" class="form-control"/><br/>
            <label>Gênero</label>
            <select name="genero" id="genero" required="true" value="${sessionScope.clientes.genero}" class="form-control"><br/>
                <option value="masculino">Masculino</option>
                <option value="feminino">Feminino</option>
            </select>
            <label>Senha</label>
            <input type="password" name="senha" required="true" value="${sessionScope.clientes.senha}" class="form-control"/><br/>
            <button class="cc-btn-azul w-100" type="submit">Cadastrar</button>
        </form>
    </body>
</html>
