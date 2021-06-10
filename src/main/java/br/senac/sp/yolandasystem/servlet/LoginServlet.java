package br.senac.sp.yolandasystem.servlet;

import br.senac.sp.yolandasystem.dao.UsuarioDAO;
import br.senac.sp.yolandasystem.entidade.Usuario;
import br.senac.sp.yolandasystem.utils.CryptoUtils;
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
        String senhaAberta = request.getParameter("senha");

        Usuario usuario = UsuarioDAO.getUsuario(login);
        if (usuario == null) { //Usuario naoOk
            response.sendRedirect(request.getContextPath() + "/login.jsp?loginInvalido=true");

        } else {
            boolean senhaOk = CryptoUtils.verificarSenha(senhaAberta, usuario.getSenha());
            if (senhaOk) {
                HttpSession sessao = request.getSession();
                sessao.setAttribute("usuario", usuario);
                response.sendRedirect(request.getContextPath() + "/protegido/index.jsp");
            } else {
                request.setAttribute("notValid", true);
                response.sendRedirect(request.getContextPath() + "/login.jsp?loginInvalido=true");
            }

        }
    }

}
