/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.yolandaiv.servlet.cliente;

import br.senac.sp.yolandaiv.dao.ClientesDAO;
import br.senac.sp.yolandaiv.entidade.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Martins
 */
public class AlterarClientesSV extends HttpServlet {
    
    

    //CARREGAR INFORMAÇÕES DO CLIENTE
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idstr = request.getParameter("id");
        Integer id = Integer.valueOf(idstr);
        
        Clientes clientes = ClientesDAO.getCliente(id);
        request.setAttribute("clientes", clientes);
        
        request.getRequestDispatcher("/protegido/cliente/atualizarCliente.jsp").forward(request, response);

    }

    //ATUALIZAR O BD COM NOVAS INFORMAÇÕES
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String dataNasc = request.getParameter("dataNasc");
        
        Date date = Date.valueOf(dataNasc);
        
        String genero = request.getParameter("genero");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String cpf = request.getParameter("cpf");
        String logradouro = request.getParameter("logradouro");
        String cep = request.getParameter("cep");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String endEntrega = request.getParameter("endEntrega");
        String endFaturamento = request.getParameter("endFaturamento");
        
        Clientes clientes = new Clientes(0, "cliente", nome, date, genero, email, senha, cpf, logradouro, cep, bairro, cidade, uf, endEntrega ,endFaturamento);
        boolean ok = ClientesDAO.atualizar(clientes);
        
        if(ok) {
            response.sendRedirect(request.getContextPath()+ "/sucesso.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+ "/erro.jsp");
        }
    }

}
