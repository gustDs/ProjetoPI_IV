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

public class produto extends HttpServlet {

    /* METHOD GET */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameterMap().containsKey("Id")) {
            Integer wId = Integer.valueOf(request.getParameter("Id"));
            Produtos produtos = ProdutosDAO.getProdutos(wId);
            /* RETURN PRODUTO */
            response.getWriter().write(produtos.toString());
        } else if (request.getParameterMap().containsKey("all")) {
            List<Produtos> produtos = ProdutosDAO.getAllProdutos();
            /* RETURN TODOS PRODUTOS */
            response.getWriter().write(produtos.toString());
        } else {
            /* RETURN TELA DE PRODUTOS */
            List<Produtos> listaProdutos = ProdutosDAO.getProdutos();
            request.setAttribute("listaProdutos", listaProdutos);
            request.getRequestDispatcher("produto/produto.jsp").forward(request, response);
        }
    }

    /* METHOD POST - INSERIR */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
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

            /* GET ITENS JSON*/
            String wNmProduto = wJson.getString("nmProduto");
            Double wDmAvaliacao = Double.valueOf(wJson.getString("dmAvaliacao"));
            String wAnDescricao = wJson.getString("anDescricao");
            Double wvlProduto = Double.valueOf(wJson.getString("vlProduto"));
            Integer wQtProduto = Integer.valueOf(wJson.getString("qtProduto"));

            //!STATUS SEMPRE ESTÁ COMO TRUE!
            Produtos produtos = new Produtos(0, wNmProduto, wDmAvaliacao, wAnDescricao, wvlProduto, wQtProduto, 0);
            boolean ok = ProdutosDAO.cadastrar(produtos);

            if (ok) {
                response.setStatus(200);
                response.getWriter().write("{\"cnRetorno\":0}");
            } else {
                response.setStatus(500);
                response.getWriter().write("{\"cnRetorno\":1,\"anMensagem\":\"Erro Interno, Contate A Equipe de Suporte Do Sistema\"}");
            }
        } catch (Exception e) {
            response.setStatus(500);
            response.getWriter().write("{\"cnRetorno\":1,\"anMensagem\":\"Erro Interno, Contate A Equipe de Suporte Do Sistema\"}");
        }

    }

    /* METHOD PUT ALTERACAO */
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

        /* GET ITENS JSON*/
        int wId = Integer.parseInt(wJson.getString("id"));
        String wNmProduto = wJson.getString("nmProduto");
        Double wDmAvaliacao = Double.valueOf(wJson.getString("dmAvaliacao"));
        String wAnDescricao = wJson.getString("anDescricao");
        Double wvlProduto = Double.valueOf(wJson.getString("vlProduto"));
        Integer wQtProduto = Integer.valueOf(wJson.getString("qtProduto"));

        /* ARRAY */
        Produtos produtos = new Produtos(wId, wNmProduto, wDmAvaliacao, wAnDescricao, wvlProduto, wQtProduto, 0);
        boolean ok = ProdutosDAO.atualizar(produtos);
        /* RETORNO*/
        if (ok) {
            response.setStatus(200);
            response.getWriter().write("{\"cnRetorno\":0}");
        } else {
            response.setStatus(500);
            response.getWriter().write("{\"cnRetorno\":1,\"anMensagem\":\"Erro Interno, Contate A Equipe de Suporte Do Sistema\"}");
        }
    }

    /* METHOD DELETE */
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int wId = Integer.parseInt(request.getParameter("Id"));
        int wBoInativo = Integer.parseInt(request.getParameter("boInativo"));

        wBoInativo = (wBoInativo == 0) ? 1 : 0;
        ProdutosDAO.inativarProduto(wId, wBoInativo);
        List<Produtos> listaProdutos = ProdutosDAO.getProdutos();
        request.setAttribute("listaProdutos", listaProdutos);
        response.setStatus(200);
        response.getWriter().write("{\"cnRetorno\":0}");
    }
}
