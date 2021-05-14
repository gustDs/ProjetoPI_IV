package br.senac.sp.yolandasystem.servlet;

import br.senac.sp.yolandasystem.dao.ClienteDAO;
import br.senac.sp.yolandasystem.entidade.Cliente;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //PASSO 1 - RECUPERAR OS PARÂMETROS
        //CHAMA A LISTA DE CLIENTES E JOGA NA TELA (JSP)
        List<Cliente> listaClientes = ClienteDAO.getClientes();

        request.setAttribute("cliente", listaClientes);
        response.getWriter().write(listaClientes.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //PASSO 1 - RECUPERAR OS PARÂMETROS

        String nome = request.getParameter("nmCliente");
        String cpf = request.getParameter("anCpf");
        String datanasc = request.getParameter("dtNascimento");

        Date date = Date.valueOf(datanasc);

        String email = request.getParameter("anEmail");
        String endereco = request.getParameter("anLogradouro");
        String telefone = request.getParameter("anTelefone");
        String sexo = request.getParameter("dmSexo");

        //PASSO 2 - INSERIR O CLIENTE NO BD
        Cliente cliente = new Cliente(0, nome, cpf, date, email, endereco, telefone, sexo);
        boolean ok = ClienteDAO.cadastrar(cliente);

        //PASSO 3 -= REDIRECIONAR PARA TELA DE SUCESSO / ERRO
        response.setStatus(ok ? 200 : 500);
    }

}
