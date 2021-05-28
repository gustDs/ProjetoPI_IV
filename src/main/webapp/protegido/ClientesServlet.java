/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.yolandasystem.servlet;

import br.senac.sp.yolandasystem.dao.ClienteDAO;
import br.senac.sp.yolandasystem.entidade.Cliente;
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
public class ClientesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //CHAMA A LISTA DE CLIENTES E JOGA NA TELA (JSP)
        List<Cliente> listaClientes = ClienteDAO.getClientes();   
        request.setAttribute("listaClientes", listaClientes);
        request.getRequestDispatcher("/protegido/cadastrar.jsp").forward(request, response);

    }

}
