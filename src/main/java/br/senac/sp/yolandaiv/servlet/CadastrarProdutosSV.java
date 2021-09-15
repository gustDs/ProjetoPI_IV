package br.senac.sp.yolandaiv.servlet;

import br.senac.sp.yolandaiv.dao.ProdutosDAO;
import br.senac.sp.yolandaiv.entidade.Produtos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarProdutosSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //1 - RECUPERAR OS PARÂMETROS
        
        String wNome = request.getParameter("anNome");
        
        String wAvaliacaoStr = request.getParameter("nmAvaliacao");
        Double wAvaliacao = Double.valueOf(wAvaliacaoStr);
        
        String wDesc = request.getParameter("anDescricao");
        
        String wValorStr = request.getParameter("vlProduto");
        Double wValor = Double.valueOf(wValorStr);
        
        String wQtdProdutoStr = request.getParameter("qtProduto");
        Integer wQtdProduto = Integer.valueOf(wQtdProdutoStr);
        
        //2 - INSERIR O CLIENTE NO BD
        Produtos produtos = new Produtos(0, wNome, wAvaliacao, wDesc, wValor, wQtdProduto, true);
        boolean ok = ProdutosDAO.cadastrar(produtos);
        
        
        //3 - REDIRECIONAR PARA TELA DE SUCESSO/ERRO
        if (ok) {
            response.sendRedirect(request.getContextPath()+ "/sucesso.jsp");
            
        }else {
            response.sendRedirect(request.getContextPath()+ "/erro.jsp");
        }
    }

}
