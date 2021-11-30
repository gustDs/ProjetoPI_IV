package br.senac.sp.yolandaiv.servlet.produto;

import br.senac.sp.yolandaiv.dao.ProdutosDAO;
import br.senac.sp.yolandaiv.entidade.Produtos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class carrinho extends HttpServlet {

    /* METHOD GET */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CHEGUEI AQUI");
        request.getRequestDispatcher("/protegido/produto/carrinho.jsp").forward(request, response);

    }

    /* METHOD POST - INSERIR */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            System.out.println("CHEGOUY AQUU");

            
            /* GET BODY JSON */
            StringBuilder buffer = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
                buffer.append(System.lineSeparator());
            }
            String data = buffer.toString();
            JSONObject wJson = new JSONObject(data);
            String wId = wJson.getString("id");
            System.out.println("wId " +wId);
            response.setStatus(200);
            response.getWriter().write("{\"cnRetorno\":"+wId+"}");

//
//            /* GET ITENS JSON*/
//            String wNmProduto = wJson.getString("nmProduto");
//            Double wDmAvaliacao = Double.valueOf(wJson.getString("dmAvaliacao"));
//            String wAnDescricao = wJson.getString("anDescricao");
//            Double wvlProduto = Double.valueOf(wJson.getString("vlProduto"));
//            Integer wQtProduto = Integer.valueOf(wJson.getString("qtProduto"));
//
//            Produtos produtos = new Produtos(0, wNmProduto, wDmAvaliacao, wAnDescricao, wvlProduto, wQtProduto, 0);
//            boolean ok = ProdutosDAO.cadastrar(produtos);
//
//            if (ok) {
//                response.setStatus(200);
//                response.getWriter().write("{\"cnRetorno\":0}");
//            } else {
//                response.setStatus(500);
//                response.getWriter().write("{\"cnRetorno\":1,\"anMensagem\":\"Erro Interno, Contate A Equipe de Suporte Do Sistema\"}");
//            }
        } catch (Exception e) {
            response.setStatus(500);
            response.getWriter().write("{\"cnRetorno\":1,\"anMensagem\":\"Erro Interno, Contate A Equipe de Suporte Do Sistema\"}");
        }

    }
}
