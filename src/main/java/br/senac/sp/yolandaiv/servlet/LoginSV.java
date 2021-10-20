
package br.senac.sp.yolandaiv.servlet;

import br.senac.sp.yolandaiv.dao.UsuariosDAO;
import br.senac.sp.yolandaiv.entidade.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String anEmail = request.getParameter("anEmail");
        String nmSenha = request.getParameter("nmSenha");
        String nmSenhaConfirma = request.getParameter("nmSenhaConfirma");

        
        Usuarios usuario = UsuariosDAO.getUsuarioLogin(anEmail, nmSenha, nmSenhaConfirma);
        if (usuario != null) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario);
            response.sendRedirect(request.getContextPath() + "/protegido/index.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+ "/erro.jsp");
        }

    }

   
}
