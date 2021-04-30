package br.senac.sp.yolandasystem.servlet;

import br.senac.sp.yolandasystem.dao.ProdutosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirProdutosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idstr = request.getParameter("id");
        Integer id = Integer.valueOf(idstr);
        boolean ok = ProdutosDAO.deletar(id); 
        if (ok) {
            response.sendRedirect("sucesso.jsp");
        } else {
            response.sendRedirect("erro.jsp");
        }
        
    }
}
