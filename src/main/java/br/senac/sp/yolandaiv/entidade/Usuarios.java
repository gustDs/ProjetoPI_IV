package br.senac.sp.yolandaiv.entidade;

public class Usuarios {
    
    private String anNome;
    private String nmCpf;
    private String anEmail;
    private String anPerfil;
    private String nmSenha;
    private String nmSenhaConfirma;
    private int boInativo;
    
    public boolean isAdministrador() {
        return anPerfil.equalsIgnoreCase("administrador");
    }
    
    public boolean isEstoquista() {
        return anPerfil.equalsIgnoreCase("estoquista");
    }
    
    public int getBoInativo() {
        return boInativo;
    }

    public void setBoInativo(int boInativo) {
        this.boInativo = boInativo;
    }

    public String getAnNome() {
        return anNome;
    }

    public void setAnNome(String anNome) {
        this.anNome = anNome;
    }

    public String getNmCpf() {
        return nmCpf;
    }

    public void setNmCpf(String nmCpf) {
        this.nmCpf = nmCpf;
    }

    public String getAnEmail() {
        return anEmail;
    }

    public void setAnEmail(String anEmail) {
        this.anEmail = anEmail;
    }

    public String getAnPerfil() {
        return anPerfil;
    }

    public void setAnPerfil(String anPerfil) {
        this.anPerfil = anPerfil;
    }

    public String getNmSenha() {
        return nmSenha;
    }

    public void setNmSenha(String nmSenha) {
        this.nmSenha = nmSenha;
    }

    public String getNmSenhaConfirma() {
        return nmSenhaConfirma;
    }

    public void setNmSenhaConfirma(String nmSenhaConfirma) {
        this.nmSenhaConfirma = nmSenhaConfirma;
    }
    
    public Usuarios() {
    }

    public Usuarios(String anNome, String nmCpf, String anEmail, String anPerfil, String nmSenha, String nmSenhaConfirma, int boInativo) {
        this.anNome = anNome;
        this.nmCpf = nmCpf;
        this.anEmail = anEmail;
        this.anPerfil = anPerfil;
        this.nmSenha = nmSenha;
        this.nmSenhaConfirma = nmSenhaConfirma;
        this.boInativo = boInativo;
    }

    @Override
    public String toString() {
        return String.format("{\"anNome\": %s, \"nmCpf\": \"%s\", \"anEmail\": \"%s\" , \"anPerfil\": \"%s\" , \"nmSenha\": \"%s\" , \"nmSenhaConfirma\": \"%s\", \"boInativo\": \"%s\"}", anNome, nmCpf, anEmail, anPerfil, nmSenha, nmSenhaConfirma, boInativo);

    }

}
