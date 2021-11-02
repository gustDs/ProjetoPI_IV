package br.senac.sp.yolandasystem.entidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private String nome;
    private String login;
    private String senha;
    private String perfil;
    private String filial;

    public boolean isRetaguarda() {
        return perfil.equalsIgnoreCase("RETAGUARDA");
    }

    public boolean isTI() {
        return perfil.equalsIgnoreCase("T.I");
    }

    public boolean isGerente() {
        return perfil.equalsIgnoreCase("GERENTE");
    }

    public boolean isVendedor() {
        return perfil.equalsIgnoreCase("VENDEDORES");
    }

    public boolean isAdministrador() {
        return perfil.equalsIgnoreCase("ADMINISTRADOR");
    }

}
