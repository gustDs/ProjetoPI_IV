
package br.senac.sp.yolandaiv.servlet;

import br.senac.sp.yolandaiv.dao.ClientesDAO;
import br.senac.sp.yolandaiv.entidade.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginClienteSV extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        Clientes clientes = ClientesDAO.getClienteLogin(email, senha);
        if(clientes != null) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("clientes", clientes);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+ "/erro.jsp");
        }

    }

}
