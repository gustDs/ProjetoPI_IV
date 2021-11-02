
package br.senac.sp.yolandaiv.entidade;


import java.sql.Date;

public class Clientes {
    private int id;
    private String perfil;
    private String nome;
    private Date dataNasc;
    private String genero;
    private String email;
    private String senha;
    private String cpf;
    private String logradouro;
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;
    private String endEntrega;
    private String endFaturamento;

    public Clientes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEndEntrega() {
        return endEntrega;
    }

    public void setEndEntrega(String endEntrega) {
        this.endEntrega = endEntrega;
    }

    public String getEndFaturamento() {
        return endFaturamento;
    }

    public void setEndFaturamento(String endFaturamento) {
        this.endFaturamento = endFaturamento;
    }

    public Clientes(int id, String perfil, String nome, Date dataNasc, String genero, String email, String senha, String cpf, String logradouro, String cep, String bairro, String cidade, String uf, String endEntrega, String endFaturamento) {
        this.id = id;
        this.perfil = perfil;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.logradouro = logradouro;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.endEntrega = endEntrega;
        this.endFaturamento = endFaturamento;
    }

    @Override
    public String toString() {
        return String.format("{\"id\": %s, \"perfil\": \"%s\", \"nome\": \"%s\" , \"dataNasc\": \"%s\" , \"genero\": \"%s\" , \"email\": \"%s\", \"senha\": \"%s\" , \"cpf\": \"%s\" , \"logradouro\": \"%s\" , \"cep\": \"%s\" , \"bairro\": \"%s\" , \"cidade\": \"%s\" , \"uf\": \"%s\" , \"endEntrega\": \"%s\" , \"endFaturamento\": \"%s\"}", id, perfil, nome, dataNasc, genero, email, senha, cpf, logradouro, cep, bairro, cidade, uf, endEntrega, endFaturamento);
    }
    
    
    
}
