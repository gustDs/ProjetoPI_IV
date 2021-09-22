package br.senac.sp.yolandaiv.servlet.produto;

import br.senac.sp.yolandaiv.dao.ProdutosDAO;
import br.senac.sp.yolandaiv.entidade.ProdutosImagem;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class produtoImagem extends HttpServlet {

    /* METHOD GET */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getParameterMap().containsKey("produto")) {
                Integer wProduto = Integer.valueOf(request.getParameter("produto"));
                List<ProdutosImagem> produtosImagem = ProdutosDAO.getImagensProduto(wProduto);
                /* RETURN PRODUTO */
                response.getWriter().write(produtosImagem.toString());
            } else if (request.getParameterMap().containsKey("id")) {
                Integer wId = Integer.valueOf(request.getParameter("id"));
                ProdutosImagem produtosImagem = ProdutosDAO.getImagemProduto(wId);
                /* RETURN PRODUTO */
                response.getWriter().write(produtosImagem.toString());
            }

        } catch (Exception e) {
            response.setStatus(500);
            response.getWriter().write("{\"cnRetorno\":1,\"anMensagem\":\"Erro Interno, Contate A Equipe de Suporte Do Sistema\"}");
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
            //int wId = wJson.getInt("id");
            int wCnProduto = wJson.getInt("cnProduto");
            String wBlArquivo = wJson.getString("blArquivo");
            int wBoImgPrincipal = wJson.getInt("boImgPrincipal");
            int wBoInativo = wJson.getInt("boInativo");
            //String wDtInclusao = wJson.getString("dtIncSys");
            String wNmImagem = wJson.getString("nmImagem");
            System.out.println("wBlArquivo");
            System.out.println(wBlArquivo);
            //!STATUS SEMPRE ESTÁ COMO TRUE!
            ProdutosImagem produtosImagem = new ProdutosImagem(0, wCnProduto, wBlArquivo, wBoImgPrincipal, wBoInativo, "", wNmImagem);
            boolean ok = ProdutosDAO.cadastrarImagemProduto(produtosImagem);

            if (ok) {
                response.setStatus(200);
                response.getWriter().write("{\"cnRetorno\":0}");
            } else {
                response.setStatus(500);
                response.getWriter().write("{\"cnRetorno\":1,\"anMensagem\":\"Erro Interno, Contate A Equipe de Suporte Do Sistema\"}");
            }
        } catch (Exception e) {
            response.setStatus(500);
            response.getWriter().write("{\"cnRetorno\":1,\"anMensagem\":\"Erro Interno, Contate A Equipe de Suporte Do Sistema\",\"anErro\":\"" + e + "\"}");
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
        int wId = wJson.getInt("id");
        int wCnProduto = wJson.getInt("cnProduto");
        String wBlArquivo = wJson.getString("blArquivo");
        int wBoImgPrincipal = wJson.getInt("boImgPrincipal");
        int wBoInativo = wJson.getInt("boInativo");
        //String wDtInclusao = wJson.getString("dtIncSys");
        String wNmImagem = wJson.getString("nmImagem");

        /* ARRAY */
        ProdutosImagem produtosImagem = new ProdutosImagem(wId, wCnProduto, wBlArquivo, wBoImgPrincipal, wBoInativo, "", wNmImagem);
        boolean ok = ProdutosDAO.atualizarImagemProduto(produtosImagem);
        /* RETORNO*/
        if (ok) {
            response.setStatus(200);
            response.getWriter().write("{\"cnRetorno\":0}");
        } else {
            response.setStatus(500);
            response.getWriter().write("{\"cnRetorno\":1,\"anMensagem\":\"Erro Interno, Contate A Equipe de Suporte Do Sistema\"}");
        }
    }
}
