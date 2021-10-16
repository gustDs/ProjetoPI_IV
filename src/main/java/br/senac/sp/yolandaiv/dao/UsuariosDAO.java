
package br.senac.sp.yolandaiv.dao;

import br.senac.sp.yolandaiv.conexao.Conexao;
import br.senac.sp.yolandaiv.entidade.Usuarios;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuariosDAO {
    
    public static boolean cadastrar(Usuarios usuarios){
        boolean ok = true;
        String wQuery = "insert into usuarios (anNome, nmCpf, anEmail, anPerfil, nmSenha, nmSenhaConfirma, boInativo) values (?, ?, ?, ?, ?, ?, ?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ps.setString(1, usuarios.getAnNome());
            ps.setString(2, usuarios.getNmCpf());
            ps.setString(3, usuarios.getAnEmail());
            ps.setString(4, usuarios.getAnPerfil());
            ps.setString(5, usuarios.getNmSenha());
            ps.setString(6, usuarios.getNmSenhaConfirma());
            ps.setInt(7, usuarios.getBoInativo());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
    
    //LISTAR USUÁRIOS
    public static List<Usuarios> getUsuarios() {
        List<Usuarios> usuarios = new ArrayList<>();
        String wQuery = "select * from usuarios";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String anNome = rs.getString("anNome");
                String nmCpf = rs.getString("nmCpf");
                String anEmail = rs.getString("anEmail");
                String anPerfil = rs.getString("anPerfil");
                String nmSenha = rs.getString("nmSenha");
                String nmSenhaConfirma = rs.getString("nmSenhaConfirma");
                int boInativo = rs.getInt("boInativo");
                
                Usuarios usuario = new Usuarios(anNome, nmCpf, anEmail, anPerfil, nmSenha, nmSenhaConfirma, boInativo);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
    
    public static Usuarios getUsuario(String anEmail) {
        Usuarios usuario = null;
        String wQuery = "select * from usuarios where anEmail = ?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ps.setString(1, anEmail);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String anNome = rs.getString("anNome");
                String nmCpf = rs.getString("nmCpf");
                String anPerfil = rs.getString("anPerfil");
                String nmSenha = rs.getString("nmSenha");
                String nmSenhaConfirma = rs.getString("nmSenhaConfirma");
                int boInativo = rs.getInt("boInativo");
                
                usuario = new Usuarios(anNome, nmCpf, anEmail, anPerfil, nmSenha, nmSenhaConfirma, boInativo);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
    public static boolean atualizar(Usuarios usuarios) {
        boolean ok = true;
        String wQuery = "update usuarios set anNome=?, nmCpf=?, anEmail=?, anPerfil=?, nmSenha=?, nmSenhaConfirma=?, boInativo=? where anEmail='?'";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ps.setString(1, usuarios.getAnNome());
            ps.setString(2, usuarios.getNmCpf());
            ps.setString(3, usuarios.getAnEmail());
            ps.setString(4, usuarios.getAnPerfil());
            ps.setString(5, usuarios.getNmSenha());
            ps.setString(6, usuarios.getNmSenhaConfirma());
            ps.setInt(7, usuarios.getBoInativo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;

    }
}
