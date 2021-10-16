
package br.senac.sp.yolandaiv.servlet.usuario;

import br.senac.sp.yolandaiv.dao.UsuariosDAO;
import br.senac.sp.yolandaiv.entidade.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarUsuariosSV extends HttpServlet {
    
    

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        //1 - RECUPERAR OS PARÂMETROS
        
        String anNome = request.getParameter("anNome");
        String nmCpf = request.getParameter("nmCpf");
        String anEmail = request.getParameter("anEmail");
        String anPerfil = request.getParameter("anPerfil");
        String nmSenha = request.getParameter("nmSenha");
        String nmSenhaConfirma = request.getParameter("nmSenhaConfirma");
        
        
        String boInativoStr = request.getParameter("boInativo");
        Integer boInativo = Integer.valueOf(boInativoStr);
        
        //2 - INSERIR O CLIENTE NO BD
        Usuarios usuarios = new Usuarios(anNome, nmCpf, anEmail, anPerfil, nmSenha, nmSenhaConfirma, boInativo);
        boolean ok = UsuariosDAO.cadastrar(usuarios);
        //3 - REDIRECIONAR PARA SUCESSO OU ERRO
        
        if(ok) {
            response.sendRedirect(request.getContextPath()+ "/sucesso.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+ "/erro.jsp");
        }
    }

}
