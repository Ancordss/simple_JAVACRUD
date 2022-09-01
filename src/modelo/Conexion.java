/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author james
 */
public class Conexion {
    public Connection conexionBD;
    private final String puerto = "3306";
    private final String bd = "db_empresa";
    private final String urlConexion = String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC", puerto,bd);
    private final String usuario = "usr_empresa";
    private final String pass = "empres@1234";
    private final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    
    public void Conectar(){
        try{
            Class.forName(jdbc);
            conexionBD = DriverManager.getConnection(urlConexion,usuario,pass);
            //JOptionPane.showMessageDialog(null,"conexion exitosa","exito",JOptionPane.INFORMATION_MESSAGE);
        
        
        
        
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        
        }
    
    
    public void Cerrar(){
         try{
            conexionBD.close();
        }catch(SQLException ex){
            System.out.println("error" + ex.getMessage());
        }
        
        
    }
    
    
    
    
    
}
