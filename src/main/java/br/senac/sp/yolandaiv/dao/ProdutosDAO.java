package br.senac.sp.yolandaiv.dao;

import br.senac.sp.yolandaiv.conexao.Conexao;
import br.senac.sp.yolandaiv.entidade.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutosDAO {

    //CADASTRAR PRODUTOS
    public static boolean cadastrar(Produtos produtos) {
        boolean ok = true;
        String query = "insert into produtos (anNome, nmAvaliacao, anDescricao, vlProduto, qtProduto) values (?, ?, ?, ?, ?)";

        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, produtos.getwNome());
            ps.setDouble(2, produtos.getwAvaliacao());
            ps.setString(3, produtos.getwDesc());
            ps.setDouble(4, produtos.getwValor());
            ps.setInt(5, produtos.getwQtdProduto());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }

        return ok;
    }

    //LISTAR PRODUTOS
    public static List<Produtos> getProdutos() {
        List<Produtos> produtos = new ArrayList<>();
        String wQuery = "select * from produtos";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int wId = rs.getInt("id");
                String wNome = rs.getString("anNome");
                double wAvaliacao = rs.getDouble("nmAvaliacao");
                String wDesc = rs.getString("anDescricao");
                double wValor = rs.getDouble("vlProduto");
                int wQtdProduto = rs.getInt("qtProduto");
                boolean wStatus = rs.getBoolean("boStatus");

                Produtos produto = new Produtos(wId, wNome, wAvaliacao, wDesc, wValor, wQtdProduto, wStatus);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;

    }

    //INATIVAR / REATIVAR PRODUTO
    public static boolean atualizarStatus(Produtos produtos, int id) {
        boolean ok = true;
        String query = "update produtos set boStatus=? where id=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setBoolean(1, produtos.iswStatus());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;

    }

    //PEGA O PRODUTO DA LISTA E JOGA OS DADOS NO FORMULÁRIO PARA QUE POSSAM SER ALTERADOS
    public static Produtos getProdutos(int id) {
        Produtos produtos = null;
        String wQuery = "select * from produtos where id =?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String wNome = rs.getString("anNome");
                double wAvaliacao = rs.getDouble("nmAvaliacao");
                String wDesc = rs.getString("anDescricao");
                double wValor = rs.getDouble("vlProduto");
                int wQtdProduto = rs.getInt("qtProduto");
                boolean wStatus = rs.getBoolean("boStatus");
                produtos = new Produtos(id, wNome, wAvaliacao, wDesc, wValor, wQtdProduto, wStatus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;

    }

    public static boolean atualizar(Produtos produtos) {
        boolean ok = true;
        String wQuery = "update produtos set anNome=?, nmAvaliacao=?, anDescricao=?, vlProduto=?, qtProduto=? where id=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ps.setString(1, produtos.getwNome());
            ps.setDouble(2, produtos.getwAvaliacao());
            ps.setString(3, produtos.getwDesc());
            ps.setDouble(4, produtos.getwValor());
            ps.setInt(5, produtos.getwQtdProduto());
            ps.setInt(6, produtos.getwId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;

    }
}
