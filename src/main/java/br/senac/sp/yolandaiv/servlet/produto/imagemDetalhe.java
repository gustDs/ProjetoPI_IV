package br.senac.sp.yolandaiv.servlet.produto;

import br.senac.sp.yolandaiv.dao.ProdutosDAO;
import br.senac.sp.yolandaiv.entidade.ProdutosImagem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class imagemDetalhe extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idStr = request.getParameter("id");
        Integer id = Integer.valueOf(idStr);
        
        List<ProdutosImagem> listaImagens = ProdutosDAO.getImagensDetalhe(id);
        request.setAttribute("listaImagens", listaImagens);
        request.getRequestDispatcher("/detalheProduto.jsp").forward(request, response);
        
    }

}
