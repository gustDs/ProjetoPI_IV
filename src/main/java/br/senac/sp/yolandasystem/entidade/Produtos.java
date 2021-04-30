/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.yolandasystem.entidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produtos {
    
    private int id;
    private String filial;
    private String nome;
    private String categoria;
    private String modelo;
    private double preco;
    private int quantidade;

    public Produtos(int id, String filial, String nome, String categoria, String modelo, double preco, int quantidade) {
        this.id = id;
        this.filial = filial;
        this.nome = nome;
        this.categoria = categoria;
        this.modelo = modelo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return String.format("ID: %s <br/> Filial: %s <br/> Nome: %s <br/> Categoria: %s <br/> Modelo: %s <br/> Preço: %s <br/> Quantidade: %s <br/>", id, filial, nome, categoria, modelo, preco, quantidade);
    }
    
    
    
    
}
