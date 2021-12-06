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

public class CarrinhoDAO {

    //CADASTRAR PRODUTOS
    public static int cadastrarCarrinho(String pCliente) {
        int wRetorno = -1;
        String query = "INSERT INTO `yolanda4`.`ysycarrinho` (`anEmailCliente`) VALUES ('"+pCliente+"'); ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection con;
        try {
            con = Conexao.getConexao();
            ps = con.prepareStatement(query, ps.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                wRetorno = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            wRetorno = -1;
        }

        return wRetorno;
    }

    //CADASTRAR PRODUTOS
    public static boolean insertItem(int pCarrinho, int pItem, int pQtd, double pValorTotal) {
        System.out.println("######");
        System.out.println("pCarrinho " + pCarrinho);
        System.out.println("pItem " + pItem);
        System.out.println("pQtd " + pQtd);
        System.out.println("######");
        boolean ok = true;
        String query = "UPDATE produtos SET qtProduto = qtProduto - " + pQtd + " WHERE id = " + pItem + "";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            int wSucesso = ps.executeUpdate();
            if (wSucesso > 0) {
                String wQueryItem = "INSERT INTO `yolanda4`.`ysycarrinhoitens` (`idCarrinho`, `idProduto`, `qtProduto`,`vlProdutoTotal`) VALUES (" + pCarrinho + ", " + pItem + ", " + pQtd + "," + pValorTotal + ")";
                Connection wConnection;
                wConnection = Conexao.getConexao();
                PreparedStatement wStatement = wConnection.prepareStatement(wQueryItem);
                wStatement.executeUpdate();
            } else {

            }

        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }

        return ok;
    }

}
