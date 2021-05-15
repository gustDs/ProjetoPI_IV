/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.yolandasystem.servlet;

import br.senac.sp.yolandasystem.dao.ClienteDAO;
import br.senac.sp.yolandasystem.dao.ProdutosDAO;
import br.senac.sp.yolandasystem.dao.VendaDAO;
import br.senac.sp.yolandasystem.entidade.Cliente;
import br.senac.sp.yolandasystem.entidade.Produtos;
import br.senac.sp.yolandasystem.entidade.Venda;
import br.senac.sp.yolandasystem.entidade.Venda2;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Richard
 */
public class VendasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuilder buffer = new StringBuilder();

        BufferedReader reader = request.getReader();

        System.out.println("reader");
        System.out.println(reader);

        String line;

        while ((line = reader.readLine()) != null) {

            buffer.append(line);

            buffer.append(System.lineSeparator());

        }

        String data = buffer.toString();

        JSONObject obj = new JSONObject(data);

        String wCnCliente = obj.getString("cnCliente");
        
        String wCnFilial = obj.getString("cnFilial");

        String wCnVenda = VendaDAO.cadastrarVenda(wCnCliente,wCnFilial);

        JSONArray arr = obj.getJSONArray("data");

        
        
        boolean ok = false;

        for (int i = 0; i < arr.length(); i++) {
            String produto = arr.getJSONObject(i).getString("produto");
            String quantidade = arr.getJSONObject(i).getString("quantidade");
            String valor = arr.getJSONObject(i).getString("valor");
            String valorTotal = arr.getJSONObject(i).getString("valorTotal");
            Venda2 Venda2 = new Venda2(0, wCnVenda, produto, quantidade, valor, valorTotal);

            VendaDAO.cadastrarItensVenda(Venda2);

        }

        response.setStatus(200);

    }

}
