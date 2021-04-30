package br.senac.sp.yolandasystem.servlet;

import br.senac.sp.yolandasystem.dao.ProdutosDAO;
import br.senac.sp.yolandasystem.entidade.Produtos;
import br.senac.sp.yolandasystem.utils.Redirect;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarProdutosServlet extends HttpServlet {

    // CARREGAR INFORMAÇÕES DO CLIENTE
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idstr = request.getParameter("id");
        Integer id = Integer.valueOf(idstr);
        
        Produtos produto = ProdutosDAO.getProduto(id);
        request.setAttribute("produto", produto);
        
        request.getRequestDispatcher("/produtos/cadastrar.jsp").forward(request, response);
    }

    //ATUALIZAR O BD COM AS NOVAS INFORMAÇÕES
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        
        Produtos produtos = new Produtos(id, filial, nome, categoria, modelo, preco, quantidade);
        boolean ok = ProdutosDAO.atualizar(produtos);
        Redirect.sendRedirect(ok, response);
    }

}
