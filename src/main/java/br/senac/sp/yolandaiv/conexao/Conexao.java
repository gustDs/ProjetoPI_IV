
package br.senac.sp.yolandaiv.conexao;

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
    
    public static Connection getConexao() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/yolanda4?useSSL=false&useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String pass = "knnsys3434@";
        
        return DriverManager.getConnection(url, user, pass); 
        
    }
    
}
