package br.senac.sp.yolandasystem.servlet;

import br.senac.sp.yolandasystem.dao.VendaDAO;
import br.senac.sp.yolandasystem.entidade.Venda;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarVendaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //PASSO 1 - RECUPERAR OS PARÂMETROS

        String venda = request.getParameter("venda");
        String produto = request.getParameter("produto");
        String quantidade = request.getParameter("quantidade");
        String valor = request.getParameter("valor");
        String valorTotal = request.getParameter("valorTotal");

        //PASSO 2 - INSERIR O CLIENTE NO BD
        //Venda item = new Venda(0, venda, produto, quantidade, valor, valorTotal);
        //boolean ok = VendaDAO.cadastrar(item);

        //PASSO 3 -= REDIRECIONAR PARA TELA DE SUCESSO / ERRO
       // response.setStatus(ok ? 200 : 500);
    }



}
