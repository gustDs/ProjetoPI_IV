
package br.senac.sp.yolandasystem.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConexao() throws SQLException {
        String wUrl = "jdbc:mysql://localhost:3306/yolanda3?useSSL=false&useTimezone=true&serverTimezone=UTC";
        String wUser = "root";
        String wPass = "knnsys3434@";
        
        return DriverManager.getConnection(wUrl, wUser, wPass);
    }
    
}
