/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.yolandasystem.dao;

import br.senac.sp.yolandasystem.conexao.Conexao;
import br.senac.sp.yolandasystem.entidade.Venda;
import br.senac.sp.yolandasystem.entidade.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martins
 */
public class VendaDAO {

    /*CLASSE DE QUERYS DA TABELA DE PRODUTOS*/
    //CREATE CLIENTES
    public static boolean cadastrar(Venda itens) {
        boolean ok = true;
        String query = "insert into vendasitens (cnVenda, idProduto, qtProduto,vlProduto, vlTotal) values (?, ?, ?, ?, ?)";

        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, itens.getVenda());
            ps.setString(2, itens.getProduto());
            ps.setString(3, itens.getQuantidade());
            ps.setString(4, itens.getValor());
            ps.setString(5, itens.getValorTotal());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    //READ CLIENTES
    //LISTAR PRODUTOS
    public static List<Venda> getVenda(String pcnVenda) {
        List<Venda> venda = new ArrayList<>();
        String query = "SELECT\n"
                + "    x.id,\n"
                + "    x.cnVenda,\n"
                + "    idProduto,\n"
                + "    qtProduto,\n"
                + "    vlProduto,\n"
                + "    vlTotal,\n"
                + "    y.cnFilial,\n"
                + "    j.nome,\n"
                + "    x.dtIncSys\n"
                + "FROM\n"
                + "    vendasitens x\n"
                + "    LEFT JOIN produtos j ON (j.id = x.idProduto)\n"
                + "    LEFT JOIN vendas y ON (y.id = x.cnVenda)";

        if (!pcnVenda.equals("")) {
            /* cnVenda = */
            query += " WHERE cnVenda = " + pcnVenda + "";
        }
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String cnVenda = rs.getString("cnVenda");
                String idProduto = rs.getString("idProduto");
                String qtProduto = rs.getString("qtProduto");
                String vlProduto = rs.getString("vlProduto");
                String vlTotal = rs.getString("vlTotal");
                String nmVenda = rs.getString("nome");
                String cnFilial = rs.getString("cnFilial");
                String dtVenda = rs.getString("dtIncSys");
                Venda vendas = new Venda(id, cnVenda, idProduto, qtProduto, vlProduto, vlTotal, nmVenda, dtVenda, cnFilial);
                venda.add(vendas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venda;

    }

    //PEGA O CLIENTE JÁ CADASTRADO E JOGA EM OUTRA TELA PARA PODER ATUALIZÁ-LO
    public static Cliente getCliente(int id) {
        Cliente cliente = null;

        String query = "select * from cliente where id=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Date datanasc = rs.getDate("datanasc");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String sexo = rs.getString("sexo");
                cliente = new Cliente(id, nome, cpf, datanasc, email, endereco, telefone, sexo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    //DELETE CLIENTES
    public static boolean deletar(int id) {
        boolean ok = true;
        String query = "delete from cliente where id=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

    //UPDATE CLIENTES
    public static boolean atualizar(Cliente cliente) {
        boolean ok = true;
        String query = "update cliente set nome=?, cpf=?, datanasc=?, email=?, endereco=?, telefone=?, sexo=? where id=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setDate(3, cliente.getDatanasc());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getEndereco());
            ps.setString(6, cliente.getTelefone());
            ps.setString(7, cliente.getSexo());
            ps.setInt(8, cliente.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

}
