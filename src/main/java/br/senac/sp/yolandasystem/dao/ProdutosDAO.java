package br.senac.sp.yolandasystem.dao;

import br.senac.sp.yolandasystem.conexao.Conexao;
import br.senac.sp.yolandasystem.entidade.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutosDAO {
    
    /*CLASSE DE QUERYS DA TABELA DE PRODUTOS*/
    
    //CADASTRAR PRODUTOS
    public static boolean cadastrar(Produtos produtos) {
        boolean ok = true;
        
        String query = "insert into produtos (filial, nome, categoria, modelo, preco, quantidade) values (?, ?, ?, ?, ?, ?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, produtos.getFilial());
            ps.setString(2, produtos.getNome());
            ps.setString(3, produtos.getCategoria());
            ps.setString(4, produtos.getModelo());
            ps.setDouble(5, produtos.getPreco());
            ps.setInt(6, produtos.getQuantidade());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        return ok;
    }

    //LISTAR PRODUTOS
    public static List<Produtos> getProdutos() {
        List<Produtos> produto = new ArrayList<>();
        String query = "select * from produtos";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String filial = rs.getString("filial");
                String nome = rs.getString("nome");
                String categoria = rs.getString("categoria");
                String modelo = rs.getString("modelo");
                double preco = rs.getDouble("preco");
                int quantidade = rs.getInt("quantidade");
                Produtos produtos = new Produtos(id, filial, nome, categoria, modelo, preco, quantidade);
                produto.add(produtos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;

    }
    
    //PEGA O CLIENTE JÁ CADASTRADO E JOGA EM OUTRA TELA PARA PODER ATUALIZÁ-LO
     public static Produtos getProduto(int id) {
        Produtos produtos = null;
        String query = "select * from produtos where id=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String filial = rs.getString("filial");
                String nome = rs.getString("nome");
                String categoria = rs.getString("categoria");
                String modelo = rs.getString("modelo");
                double preco = rs.getDouble("preco");
                int quantidade = rs.getInt("quantidade");
                produtos = new Produtos(id, filial, nome, categoria, modelo, preco, quantidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;

    }
    
    
    //DELETAR PRODUTOS
    public static boolean deletar(int id) {
        boolean ok = true;
        String query = "delete from produtos where id=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;

    }
    
    //ALTERAR PRODUTOS
    public static boolean atualizar(Produtos produtos) {
        boolean ok = true;
        String query = "update produtos set filial=?, nome=?, categoria=?, modelo=?, preco=?, quantidade=? where id=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, produtos.getFilial());
            ps.setString(2, produtos.getNome());
            ps.setString(3, produtos.getCategoria());
            ps.setString(4, produtos.getModelo());
            ps.setDouble(5, produtos.getPreco());
            ps.setInt(6, produtos.getQuantidade());
            ps.setInt(7, produtos.getId());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;

    }

}
