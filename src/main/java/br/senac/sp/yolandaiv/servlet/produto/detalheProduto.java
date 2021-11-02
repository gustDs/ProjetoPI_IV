package br.senac.sp.yolandaiv.servlet.produto;

import br.senac.sp.yolandaiv.dao.ProdutosDAO;
import br.senac.sp.yolandaiv.entidade.Produtos;
import br.senac.sp.yolandaiv.entidade.ProdutosImagem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Martins
 */
public class detalheProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String wIdStr = request.getParameter("wId");
        Integer wId = Integer.valueOf(wIdStr);

        Produtos produtos = ProdutosDAO.getProdutos(wId);
        request.setAttribute("produtos", produtos);
        List<ProdutosImagem> listaImagens = ProdutosDAO.getImagensDetalhe(wId);
        request.setAttribute("listaImagens", listaImagens);
        request.getRequestDispatcher("/protegido/produto/detalheProduto.jsp").forward(request, response);

    }

}
