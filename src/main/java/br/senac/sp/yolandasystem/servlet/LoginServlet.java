
package br.senac.sp.yolandasystem.servlet;

import br.senac.sp.yolandasystem.dao.UsuarioDAO;
import br.senac.sp.yolandasystem.entidade.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Usuario usuario = UsuarioDAO.getUsuario(login, senha);
        if (usuario != null) { //Usuario OK
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario);
            response.sendRedirect(request.getContextPath() + "/protegido/index.jsp");
        } //Erro
    }

}
