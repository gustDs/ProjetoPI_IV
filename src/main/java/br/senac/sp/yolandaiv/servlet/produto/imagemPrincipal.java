package br.senac.sp.yolandaiv.servlet.produto;

import br.senac.sp.yolandaiv.dao.ProdutosDAO;
import br.senac.sp.yolandaiv.entidade.ProdutosImagem;
import br.senac.sp.yolandaiv.entidade.ProdutosIndex;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class imagemPrincipal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ProdutosIndex> imagensProdutos = ProdutosDAO.getImagemPrincipal();
        request.setAttribute("imagensProdutos", imagensProdutos);
        
        response.getWriter().write(imagensProdutos.toString());



    }
}
