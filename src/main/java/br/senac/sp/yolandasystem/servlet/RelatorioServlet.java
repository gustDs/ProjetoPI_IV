/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.yolandasystem.servlet;

import br.senac.sp.yolandasystem.dao.ClienteDAO;
import br.senac.sp.yolandasystem.dao.VendaDAO;
import br.senac.sp.yolandasystem.entidade.Cliente;
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
public class RelatorioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //CHAMA A LISTA DE VENDAS E JOGA NA TELA DE RELATÓRIOS (JSP)
        //List<Venda> listaVendas = VendaDAO.getVenda();
        //request.setAttribute("listaVendas", listaVendas);
        request.getRequestDispatcher("/relatorio.jsp").forward(request, response);

    }

}
