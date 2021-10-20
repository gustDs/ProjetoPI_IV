package br.senac.sp.yolandaiv.servlet.usuario;



import br.senac.sp.yolandaiv.dao.UsuariosDAO;
import br.senac.sp.yolandaiv.entidade.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarUsuariosSV extends HttpServlet {
    

    //CARREGAR INFOS DO CLIENTE
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String anEmail = request.getParameter("anEmail");
        
        Usuarios usuarios = UsuariosDAO.getUsuario(anEmail);
        request.setAttribute("usuarios", usuarios);
        
        request.getRequestDispatcher("/protegido/usuario/cadastrarUsuarios.jsp").forward(request, response);

    }

 
    //ATUALIZAR O BD COM AS NOVAS INFORMAÇÕES
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String anNome = request.getParameter("anNome");
        String nmCpf = request.getParameter("nmCpf");
        String anEmail = request.getParameter("anEmail");
        String anPerfil = request.getParameter("anPerfil");
        String nmSenha = request.getParameter("nmSenha");
        String nmSenhaConfirma = request.getParameter("nmSenhaConfirma");
        
        
        String boInativoStr = request.getParameter("boInativo");
        Integer boInativo = Integer.valueOf(boInativoStr);
        
        Usuarios usuarios = new Usuarios(anNome, nmCpf, anEmail, anPerfil, nmSenha, nmSenhaConfirma, boInativo);
        boolean ok = UsuariosDAO.atualizar(usuarios);
        
        if(ok) {
            response.sendRedirect(request.getContextPath()+ "/sucesso.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+ "/erro.jsp");
        }

    }

   

}
