package br.senac.sp.yolandaiv.entidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutosIndex {

    private int id;
    private int cnProduto;
    private String blArquivo;
    private int boImgPrincipal;
    private String anNome;
    private String anDescricao;
    private double vlProduto;

    public String getAnNome() {
        return anNome;
    }

    public void setAnNome(String anNome) {
        this.anNome = anNome;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int pId) {
        this.id = pId;
    }

    public int getProduto() {
        return cnProduto;
    }

    public void setProduto(String pProduti) {
        this.cnProduto = cnProduto;
    }


    public String getblArquivo() {
        return blArquivo;
    }

    public void setblArquivo(String pblArquivo) {
        this.blArquivo = blArquivo;
    }

    public int getboImgPrincipal() {
        return boImgPrincipal;
    }

    public void setboImgPrincipal(String pboImgPrincipal) {
        this.boImgPrincipal = boImgPrincipal;
    }

    
    public String getanDescricao() {
        return anDescricao;
    }

    public void setanDescricao(String anDescricao) {
        this.anDescricao = anDescricao;
    }
    
    public double getvlProduto() {
        return vlProduto;
    }

    public void setvlProduto(int vlProduto) {
        this.vlProduto = vlProduto;
    }
    
    


    public ProdutosIndex(int pId, int pcnProduto, String pblArquivo, int pboImgPrincipal, String pAnNome, String pAnDescricao, double pVlProduto) {
        this.id = pId;
        this.cnProduto = pcnProduto;
        this.blArquivo = pblArquivo;
        this.boImgPrincipal = pboImgPrincipal;
        this.anNome = pAnNome;
        this.anDescricao = pAnDescricao;
        this.vlProduto = pVlProduto;

    }


    @Override
    public String toString() {
        return String.format("{\"id\": %s, \"cnProduto\": \"%s\", \"blArquivo\": \"%s\" , \"boImgPrincipal\": \"%s\" , \"anNome\": \"%s\" , \"anDescricao\": \"%s\" , \"vlProduto\": \"%s\"}", id, cnProduto, blArquivo, boImgPrincipal, anNome, anDescricao, vlProduto);
    }
}
