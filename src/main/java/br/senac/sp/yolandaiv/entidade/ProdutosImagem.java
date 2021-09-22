package br.senac.sp.yolandaiv.entidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutosImagem {

    private int id;
    private int cnProduto;
    private String nmImagem;
    private String blArquivo;
    private int boImgPrincipal;
    private int boInativo;
    private String dtInclusao;

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

    public String getnmImagem() {
        return nmImagem;
    }

    public void setnmImagem(String pnmImagem) {
        this.nmImagem = nmImagem;
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

    public int getboInativo() {
        return boInativo;
    }

    public void setboInativo(int pboInativo) {
        this.boInativo = boInativo;
    }

    public ProdutosImagem(int pId, int pcnProduto, String pblArquivo, int pboImgPrincipal, int pboInativo, String pDtInclusao, String pnmImagem) {
        this.id = pId;
        this.cnProduto = pcnProduto;
        this.blArquivo = pblArquivo;
        this.boImgPrincipal = pboImgPrincipal;
        this.boInativo = pboInativo;
        this.dtInclusao = pDtInclusao;
        this.nmImagem = pnmImagem;

    }

    public String getdtInclusao() {
        return dtInclusao;
    }

    public void setdtInclusao(String pblArquivo) {
        this.dtInclusao = dtInclusao;
    }

    @Override
    public String toString() {
        return String.format("{\"id\": %s, \"cnProduto\": \"%s\", \"blArquivo\": \"%s\" , \"boImgPrincipal\": \"%s\" , \"boInativo\": \"%s\", \"dtIncSys\": \"%s\", \"nmImagem\": \"%s\" }", id, cnProduto, blArquivo, boImgPrincipal, boInativo, dtInclusao, nmImagem);
    }
}
