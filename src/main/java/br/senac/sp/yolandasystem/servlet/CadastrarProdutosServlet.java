package br.senac.sp.yolandasystem.servlet;

import br.senac.sp.yolandasystem.dao.ProdutosDAO;
import br.senac.sp.yolandasystem.entidade.Produtos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarProdutosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //PASSO 1 - RECUPERAR OS PARAMETROS
        
        String idstr = request.getParameter("id");
        Integer id = Integer.valueOf(idstr);
        
        String filial = request.getParameter("filial");
        String nome = request.getParameter("nome");
        String categoria = request.getParameter("categoria");
        String modelo = request.getParameter("modelo");
        
        String precostr = request.getParameter("preco");
        Double preco = Double.valueOf(precostr);
        
        String qtdstr = request.getParameter("quantidade");
        Integer quantidade = Integer.valueOf(qtdstr);
        
        //PASSO 2 - INSERIR O CLIENTE NO BD
        
        Produtos produtos = new Produtos(id, filial, nome, categoria, modelo, preco, quantidade);
        boolean ok = ProdutosDAO.cadastrar(produtos);
        
        //PASSO 3 - REDIRECIONAR PARA TELA DE SUCESSO/ERRO
        
        if (ok) {
            response.sendRedirect(request.getContextPath()+ "/sucesso.jsp");
        } else {
            String msg = "Não foi possível cadastrar o cliente!";
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
        
        
        

    }

}
