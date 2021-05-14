package br.senac.sp.yolandasystem.entidade;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Venda {

    private int id;
    private String venda;
    private String produto;
    private String quantidade;
    private String valor;
    private String valorTotal;
    private String nome;
    private String dataVenda;
    private String cnFilial;

    //GET E SET
    public Venda(int id, String venda, String produto, String quantidade, String valor, String valorTotal, String nome, String dataVenda, String cnFilial) {
        this.id = id;
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.valorTotal = valorTotal;
        this.nome = nome;
        this.dataVenda = dataVenda;
        this.cnFilial = cnFilial;
    }

    public boolean validarID() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("{\"id\": %s, \"venda\": \"%s\", \"produto\": \"%s\" , \"quantidade\": \"%s\" , \"valor\": \"%s\" , \"valorTotal\": \"%s\", \"nmProduto\": \"%s\", \"dtVenda\": \"%s\", \"cnFilial\": \"%s\"}", id, venda, produto, quantidade, valor, valorTotal, nome, dataVenda,cnFilial);
    }
}
