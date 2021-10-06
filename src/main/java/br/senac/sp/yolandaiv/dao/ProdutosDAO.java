package br.senac.sp.yolandaiv.dao;

import br.senac.sp.yolandaiv.conexao.Conexao;
import br.senac.sp.yolandaiv.entidade.Produtos;
import br.senac.sp.yolandaiv.entidade.ProdutosImagem;
import br.senac.sp.yolandaiv.entidade.ProdutosIndex;
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
                int wBoInativo = rs.getInt("boInativo");
                Produtos produto = new Produtos(wId, wNome, wAvaliacao, wDesc, wValor, wQtdProduto, wBoInativo);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;

    }

    //INATIVAR / REATIVAR PRODUTO
    public static boolean inativarProduto(int pid, int pBoInativo) {
        boolean boRetorno = true;
        String query = "update produtos set boInativo=? where id=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, pBoInativo);
            ps.setInt(2, pid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            boRetorno = false;
        }
        return boRetorno;

    }

    //PEGA O PRODUTO DA LISTA E JOGA OS DADOS NO FORMULÁRIO PARA QUE POSSAM SER ALTERADOS
    public static Produtos getProdutos(int pId) {
        Produtos produtos = null;
        String wQuery = "select * from produtos where id =?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ps.setInt(1, pId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String wNome = rs.getString("anNome");
                double wAvaliacao = rs.getDouble("nmAvaliacao");
                String wDesc = rs.getString("anDescricao");
                double wValor = rs.getDouble("vlProduto");
                int wQtdProduto = rs.getInt("qtProduto");
                int wBoInativo = rs.getInt("boInativo");
                produtos = new Produtos(pId, wNome, wAvaliacao, wDesc, wValor, wQtdProduto, wBoInativo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;

    }

    public static List<Produtos> getAllProdutos() {
        List<Produtos> produtos = new ArrayList<>();
        String wQuery = "select * from produtos";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int wid = rs.getInt("id");
                String wNome = rs.getString("anNome");
                double wAvaliacao = rs.getDouble("nmAvaliacao");
                String wDesc = rs.getString("anDescricao");
                double wValor = rs.getDouble("vlProduto");
                int wQtdProduto = rs.getInt("qtProduto");
                int wBoInativo = rs.getInt("boInativo");
                produtos.add(new Produtos(wid, wNome, wAvaliacao, wDesc, wValor, wQtdProduto, wBoInativo));
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

    public static List<ProdutosImagem> getImagensProduto(int pProduto) {
        List<ProdutosImagem> produtosImagem = new ArrayList<>();
        String wQuery = "SELECT * FROM produtosimagem WHERE cnProduto=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ps.setInt(1, pProduto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int wId = rs.getInt("id");
                int wCnProduto = rs.getInt("cnProduto");
                String wBlArquivo = rs.getString("blArquivo");
                int wBoImgPrincipal = rs.getInt("boImgPrincipal");
                int wBoInativo = rs.getInt("boInativo");
                String wDtInclusao = rs.getString("dtIncSys");
                String wNmImagem = rs.getString("nmImagem");

                produtosImagem.add(new ProdutosImagem(wId, wCnProduto, wBlArquivo, wBoImgPrincipal, wBoInativo, wDtInclusao, wNmImagem));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return produtosImagem;

    }

    public static ProdutosImagem getImagemProduto(int pId) {
        ProdutosImagem produtosImagem = null;
        String wQuery = "SELECT * FROM produtosimagem WHERE id=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ps.setInt(1, pId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int wId = rs.getInt("id");
                int wCnProduto = rs.getInt("cnProduto");
                String wBlArquivo = rs.getString("blArquivo");
                int wBoImgPrincipal = rs.getInt("boImgPrincipal");
                int wBoInativo = rs.getInt("boInativo");
                String wDtInclusao = rs.getString("dtIncSys");
                String wNmImagem = rs.getString("nmImagem");

                produtosImagem = new ProdutosImagem(wId, wCnProduto, wBlArquivo, wBoImgPrincipal, wBoInativo, wDtInclusao, wNmImagem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return produtosImagem;

    }

    //CADASTRAR PRODUTOS
    public static boolean cadastrarImagemProduto(ProdutosImagem produtosImagem) {
        boolean ok = true;
        String query = "insert into produtosimagem (cnProduto, nmImagem, blArquivo, boImgPrincipal, boInativo) values (?, ?, ?, ?, ?)";

        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, produtosImagem.getCnProduto());
            ps.setString(2, produtosImagem.getnmImagem());
            ps.setString(3, produtosImagem.getblArquivo());
            ps.setInt(4, produtosImagem.getboImgPrincipal());
            ps.setInt(5, produtosImagem.getboInativo());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }

        return ok;
    }

    public static boolean atualizarImagemProduto(ProdutosImagem produtosImagem) {
        boolean ok = true;
        String wQuery = "update produtosimagem set nmImagem=?, blArquivo=?, boImgPrincipal=?, boInativo=? where id=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ps.setString(1, produtosImagem.getnmImagem());
            ps.setString(2, produtosImagem.getblArquivo());
            ps.setInt(3, produtosImagem.getboImgPrincipal());
            ps.setInt(4, produtosImagem.getboInativo());
            ps.setInt(5, produtosImagem.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;

    }

    public static List<ProdutosImagem> getImagensDetalhe(int pProduto) {
        List<ProdutosImagem> produtosImagem = new ArrayList<>();
        String wQuery = "SELECT *\n"
                + "FROM produtosimagem AS pi\n"
                + "JOIN produtos AS P ON pi.cnProduto = p.id";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ps.setInt(1, pProduto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int wId = rs.getInt("id");
                int wCnProduto = rs.getInt("cnProduto");
                String wBlArquivo = rs.getString("blArquivo");
                int wBoImgPrincipal = rs.getInt("boImgPrincipal");
                int wBoInativo = rs.getInt("boInativo");
                String wDtInclusao = rs.getString("dtIncSys");
                String wNmImagem = rs.getString("nmImagem");

                produtosImagem.add(new ProdutosImagem(wId, wCnProduto, wBlArquivo, wBoImgPrincipal, wBoInativo, wDtInclusao, wNmImagem));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return produtosImagem;

    }
    
   /////  -------------------------- ******GUSTA****** ---------------------------- ////////
    public static List<ProdutosIndex>  getImagemPrincipal() {
       List<ProdutosIndex> produtosIndex = new ArrayList<>();
        
        String wQuery = "SELECT *\n"
                + "FROM produtos x\n"
                + "LEFT JOIN produtosimagem y ON(y.cnProduto = x.id) WHERE y.boImgPrincipal = 1";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(wQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int wId = rs.getInt("id");
                int wCnProduto = rs.getInt("cnProduto");
                String wBlArquivo = rs.getString("blArquivo");
                int wBoImgPrincipal = rs.getInt("boImgPrincipal");
                String anNome = rs.getString("anNome");
                String anDescricao = rs.getString("anDescricao");
                double wValor = rs.getDouble("vlProduto");

                ProdutosIndex imagensProdutos = new ProdutosIndex(wId, wCnProduto, wBlArquivo, wBoImgPrincipal, anNome, anDescricao, wValor);
                produtosIndex.add(imagensProdutos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return produtosIndex;

    }

}
