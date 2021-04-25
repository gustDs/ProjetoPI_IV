package br.senac.sp.yolandasystem.servlet;

import br.senac.sp.yolandasystem.dao.ClienteDAO;
import br.senac.sp.yolandasystem.utils.Redirect;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idstr = request.getParameter("id");
        Integer id = Integer.valueOf(idstr);
        boolean ok = ClienteDAO.deletar(id);
        response.setStatus(ok? 200:500);
    }

}
