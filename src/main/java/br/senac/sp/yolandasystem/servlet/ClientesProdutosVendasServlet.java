/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.yolandasystem.servlet;

import br.senac.sp.yolandasystem.dao.ClienteDAO;
import br.senac.sp.yolandasystem.dao.ProdutosDAO;
import br.senac.sp.yolandasystem.dao.VendaDAO;
import br.senac.sp.yolandasystem.entidade.Cliente;
import br.senac.sp.yolandasystem.entidade.Produtos;
import br.senac.sp.yolandasystem.entidade.Venda;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Martins
 */
public class ClientesProdutosVendasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //CHAMA A LISTA DE CLIENTES E JOGA NA TELA (JSP)
        List<Cliente> listaClientes = ClienteDAO.getClientes();
        request.setAttribute("listaClientes", listaClientes);
        request.getRequestDispatcher("vendas/vendas.jsp");

        //CHAMA A LISTA DE PRODUTOS E JOGA NA TELA (JSP)
        List<Produtos> listaProdutos = ProdutosDAO.getProdutos();
        request.setAttribute("listaProdutos", listaProdutos);
        request.getRequestDispatcher("vendas/vendas.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //PASSO 1 - RECUPERAR OS PARÂMETROS
        String cnVenda = request.getParameter("cnVenda");
        String cnFilial = request.getParameter("cnFilial");
        String dtVenda = request.getParameter("dtInicial");
        String dtFim = request.getParameter("dtFinal");
        List<Venda> listaVendas = VendaDAO.getVenda(cnVenda, cnFilial, dtVenda, dtFim);
        request.setAttribute("listaVendas", listaVendas);
        response.getWriter().write(listaVendas.toString());
    }

}
