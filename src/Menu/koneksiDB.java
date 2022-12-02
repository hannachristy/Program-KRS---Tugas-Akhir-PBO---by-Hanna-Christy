/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class koneksiDB {
    static Connection conn;
    static Statement stmt;
    String sql;
    
    public static void konekDB (){
    try{
            String user = "root";
            String pass = "";
            String url = "jdbc:mysql://localhost:3306/kuliah";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
             }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e){
                 System.err.println("koneksi gagal "+e.getMessage()); //perintah menampilkan error
             }
    }
    
    public static ResultSet retrieveData(String query){
        ResultSet hasil = null;
        try{
            String sqlSmt = query;
            hasil = stmt.executeQuery(sqlSmt);
        }catch(SQLException e){
            System.err.println("koneksi gagal1 "+e.getMessage()); //perintah menampilkan error
        }
        return hasil;
    }
    
    public static int manipulation(String query){
        int updateCount = 0;
        try{
            String sqlSmt = query;
            updateCount = stmt.executeUpdate(sqlSmt);
            stmt.close();
            conn.close();
        }catch(SQLException e){
            System.err.println("koneksi gagal2 "+e.getMessage()); //perintah menampilkan error
        }
        return updateCount;
    }   
}
