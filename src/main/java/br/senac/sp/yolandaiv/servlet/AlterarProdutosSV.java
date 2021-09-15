package br.senac.sp.yolandaiv.servlet;

import br.senac.sp.yolandaiv.dao.ProdutosDAO;
import br.senac.sp.yolandaiv.entidade.Produtos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarProdutosSV extends HttpServlet {
    
    //CARREGAR INFORMAÇÕES DO PRODUTO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String wIdStr = request.getParameter("wId");
        Integer wId = Integer.valueOf(wIdStr);
        
        Produtos produtos = ProdutosDAO.getProdutos(wId);
        request.setAttribute("produtos", produtos);
        
        request.getRequestDispatcher("cadastraProdutos.jsp").forward(request, response);
        

    }

    //ATUALIZAR O BD COM AS NOVAS INFORMAÇÕES
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //!CAMPO ID NA PAG JSP ESTÁ COMO HIDDEN!
        String wIdStr = request.getParameter("id");
        Integer wId = Integer.valueOf(wIdStr);
        
        String wNome = request.getParameter("anNome");
        
        String wAvaliacaoStr = request.getParameter("nmAvaliacao");
        Double wAvaliacao = Double.valueOf(wAvaliacaoStr);
        
        String wDesc = request.getParameter("anDescricao");
        
        String wValorStr = request.getParameter("vlProduto");
        Double wValor = Double.valueOf(wValorStr);
        
        String wQtdProdutoStr = request.getParameter("qtProduto");
        Integer wQtdProduto = Integer.valueOf(wQtdProdutoStr);
        
        
        //!STATUS SEMPRE ESTÁ COMO TRUE!
        Produtos produtos = new Produtos(wId, wNome, wAvaliacao, wDesc, wValor, wQtdProduto, true);
        boolean ok = ProdutosDAO.atualizar(produtos);
        
         if (ok) {
            response.sendRedirect(request.getContextPath()+ "/sucesso.jsp");
            
        }else {
            response.sendRedirect(request.getContextPath()+ "/erro.jsp");
        }

    }

}
