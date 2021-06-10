/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.yolandasystem.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 *
 * @author Martins
 */
public class CryptoUtils {
    
    public static String hashSenha(String senhaAberta) {
        return BCrypt.withDefaults().hashToString(12, senhaAberta.toCharArray());
    }
    
    public static boolean verificarSenha(String senhaAberta, String senhaFechada) {
        
        BCrypt.Result result = BCrypt.verifyer().verify(senhaAberta.toCharArray(), senhaFechada);
        return result.verified;
    }
    
    public static void main(String[] args) {
        String senha = "1234";
        System.out.println("hash = " + hashSenha(senha));
    }
    
}
