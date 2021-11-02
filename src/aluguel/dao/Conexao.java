/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aluguel.dao;
import java.sql.*;
/**
 *
 * @author Adriano Melo
 */
public class Conexao {
    
    public static Connection conector(){
        java.sql.Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbinfox";
        String user = "root";
        String password = "";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user, password);
            return conexao;
        } catch (Exception e) {
            e.printStackTrace();
             return null;
        }  
    }  
}
