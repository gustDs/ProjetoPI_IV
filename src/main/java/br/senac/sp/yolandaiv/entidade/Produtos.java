
package br.senac.sp.yolandaiv.entidade;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Produtos {
    private int wId;
    private String wNome;
    private double wAvaliacao;
    private String wDesc;
    private double wValor;
    private int wQtdProduto;
    private int wBoInativo;

    public int getwId() {
        return wId;
    }

    public void setwId(int wId) {
        this.wId = wId;
    }

    public String getwNome() {
        return wNome;
    }

    public void setwNome(String wNome) {
        this.wNome = wNome;
    }

    public double getwAvaliacao() {
        return wAvaliacao;
    }

    public void setwAvaliacao(double wAvaliacao) {
        this.wAvaliacao = wAvaliacao;
    }

    public String getwDesc() {
        return wDesc;
    }

    public void setwDesc(String wDesc) {
        this.wDesc = wDesc;
    }

    public double getwValor() {
        return wValor;
    }

    public void setwValor(double wValor) {
        this.wValor = wValor;
    }

    public int getwQtdProduto() {
        return wQtdProduto;
    }

    public void setwQtdProduto(int wQtdProduto) {
        this.wQtdProduto = wQtdProduto;
    }

    public int getwBoInativo() {
        return wBoInativo;
    }

    public void setwBoInativo(int wBoInativo) {
        this.wBoInativo = wBoInativo;
    }
    
    
    
 

    public Produtos(int wId, String wNome, double wAvaliacao, String wDesc, double wValor, int wQtdProduto, int wBoInativo) {
        this.wId = wId;
        this.wNome = wNome;
        this.wAvaliacao = wAvaliacao;
        this.wDesc = wDesc;
        this.wValor = wValor;
        this.wQtdProduto = wQtdProduto;
        this.wBoInativo = wBoInativo;
    }

    @Override
    public String toString() {
        return String.format("{\"id\": %s, \"nmProduto\": \"%s\", \"dmAvaliacao\": \"%s\" , \"anDescricao\": \"%s\" , \"vlProduto\": \"%s\" , \"qtProduto\": \"%s\", \"dmStatus\": \"%s\"}", wId, wNome, wAvaliacao, wDesc, wValor, wQtdProduto, wBoInativo);
        //return String.format("ID: %s <br/> Nome: %s <br/> Avaliação: %s <br/> Descrição: %s <br/> Valor: %s <br/> Quantidade: %s <br/> Status: %s <br/>", wId, wNome, wAvaliacao, wDesc, wValor, wQtdProduto, wBoInativo);
    }
    
    
    
    
    
}
