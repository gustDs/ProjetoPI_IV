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
    public static List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();

        String query = "select * from cliente";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Date datanasc = rs.getDate("datanasc");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String sexo = rs.getString("sexo");
                Cliente cliente = new Cliente(id, nome, cpf, datanasc, email, endereco, telefone, sexo);
                clientes.add(cliente);

            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
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