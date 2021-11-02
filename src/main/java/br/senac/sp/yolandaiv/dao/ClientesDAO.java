
package br.senac.sp.yolandaiv.dao;

import br.senac.sp.yolandaiv.conexao.Conexao;
import br.senac.sp.yolandaiv.entidade.Clientes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
    
}
