
package br.senac.sp.yolandaiv.dao;

import br.senac.sp.yolandaiv.conexao.Conexao;
import br.senac.sp.yolandaiv.entidade.Clientes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientesDAO {
    
    public static boolean cadastrar(Clientes clientes) {
        boolean ok = true;
        String wQuery = "insert into clientes (nome, dataNasc, genero, email, senha, cpf, logradouro, cep, bairro, cidade, uf, endEntrega, endFaturamento) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ps.setString(1, clientes.getNome());
            ps.setDate(2, clientes.getDataNasc());
            ps.setString(3, clientes.getGenero());
            ps.setString(4, clientes.getEmail());
            ps.setString(5, clientes.getSenha());
            ps.setString(6, clientes.getCpf());
            ps.setString(7, clientes.getLogradouro());
            ps.setString(8, clientes.getCep());
            ps.setString(9, clientes.getBairro());
            ps.setString(10, clientes.getCidade());
            ps.setString(11, clientes.getUf());
            ps.setString(12, clientes.getEndEntrega());
            ps.setString(13, clientes.getEndFaturamento());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
    
    public static Clientes getClienteLogin(String email, String senha) {
        Clientes clientes = null;
        try {
            Connection con = Conexao.getConexao();
            String wQuery = "select * from clientes where email = ? and senha = ?";
            PreparedStatement ps = con.prepareStatement(wQuery);
            ps.setString(1, email);
            ps.setString(2, senha);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                clientes = new Clientes();
                clientes.setEmail(email);
                clientes.setSenha(senha);
                clientes.setPerfil(rs.getString("perfil"));
                clientes.setNome(rs.getString("nome"));
                clientes.setDataNasc(rs.getDate("dataNasc"));
                clientes.setGenero(rs.getString("genero"));
                clientes.setCpf(rs.getString("cpf"));
                clientes.setLogradouro(rs.getString("logradouro"));
                clientes.setCep(rs.getString("cep"));
                clientes.setBairro(rs.getString("bairro"));
                clientes.setCidade(rs.getString("cidade"));
                clientes.setUf(rs.getString("uf"));
                clientes.setEndEntrega(rs.getString("endEntrega"));
                clientes.setEndFaturamento(rs.getString("endFaturamento"));
                
            }
        } catch(SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
    
    public static Clientes getCliente (int id) {
        Clientes clientes = null;
        String wQuery = "select * from clientes where id = ?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                String perfil = rs.getString("perfil");
                String nome = rs.getString("nome");
                Date dataNasc = rs.getDate("dataNasc");
                String genero = rs.getString("genero");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                String cpf = rs.getString("cpf");
                String logradouro = rs.getString("logradouro");
                String cep = rs.getString("cep");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String endEntrega = rs.getString("endEntrega");
                String endFaturamento = rs.getString("endFaturamento");
                
                clientes = new Clientes(id, perfil, nome, dataNasc, genero, email, senha, cpf, logradouro, cep, bairro, cidade, uf, endEntrega, endFaturamento);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
    
    public static boolean atualizar(Clientes clientes) {
        boolean ok = true;
        String wQuery = "update clientes set nome=?, dataNasc=?, genero=?, senha=? where id=? ";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ps.setString(1, clientes.getNome());
            ps.setDate(2, clientes.getDataNasc());
            ps.setString(3, clientes.getGenero());
            ps.setString(4, clientes.getSenha());
            ps.setInt(5, clientes.getId());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        System.out.println(wQuery);
        return ok;
    }
    
}
