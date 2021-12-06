package br.senac.sp.yolandaiv.servlet.produto;

import br.senac.sp.yolandaiv.dao.CarrinhoDAO;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;

import org.json.JSONObject;

public class carrinho extends HttpServlet {

    /* METHOD GET */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/protegido/produto/carrinho.jsp").forward(request, response);

    }

    /* METHOD POST - INSERIR */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpSession session = httpServletRequest.getSession();

            //System.out.println(wSession.getJSONObject(0).getString("anEmail"));
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
            JSONArray wData = wJson.getJSONArray("data");
            int wCardCodigo = -1;
            String wCliente = (String) session.getAttribute("email");
            if (wData.length() > 0) {
                /* CRIA CARRINHO */
                wCardCodigo = CarrinhoDAO.cadastrarCarrinho(wCliente);
                /* LOOP PARA CADA ITEM*/
                for (int i = 0; i < wData.length(); i++) {
                    /* INSERT ITEM IN CARD */
                    CarrinhoDAO.insertItem(wCardCodigo, wData.getJSONObject(i).getInt("id"), wData.getJSONObject(i).getInt("qtCompra"), wData.getJSONObject(i).getDouble("vlTotalProduto"));

                }
                System.out.println("PASSOU");
            }

            response.setStatus(200);
            response.getWriter().write("{\"cnRetorno\":" + wCardCodigo + "}");

        } catch (Exception e) {
            response.setStatus(500);
            response.getWriter().write("{\"cnRetorno\":1,\"anMensagem\":\"Erro Interno, Contate A Equipe de Suporte Do Sistema\"}");
        }

    }
}
