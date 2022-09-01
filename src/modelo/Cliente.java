/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author james
 */
public class Cliente extends Persona {
    private int id;
    private String nit;
    Conexion cn;
    
    public Cliente(){}

    public Cliente(int id, String nit, String nombres, String apellidos, String direccion, String telefono, String fn) {
        super(nombres, apellidos, direccion, telefono, fn);
        this.nit = nit;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            cn = new Conexion();
            cn.Conectar();
            String query;
            query = "SELECT id_clientes as id,nit,nombres,apellidos,direccion,telefono,fecha_nacimiento FROM clientes;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[]= {"id","nit","nombres","apellidos","direccion","telefono","fecha_nacimiento"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[7];
            while(consulta.next()){
                datos[0]=consulta.getString("id");
                datos[1]=consulta.getString("nit");
                datos[2]=consulta.getString("nombres");
                datos[3]=consulta.getString("apellidos");
                datos[4]=consulta.getString("direccion");
                datos[5]=consulta.getString("telefono");
                datos[6]=consulta.getString("fecha_nacimiento");
                tabla.addRow(datos);
            }
            cn.Cerrar();
        }catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        return tabla;
        
    }
    
    
    @Override
    public void agregar(){
        try{
            cn = new Conexion();
            PreparedStatement parametro;
            cn.Conectar();
            String query;
            query = "INSERT INTO clientes(nit,nombres,apellidos,direccion,telefono,fecha_nacimiento) VALUES(?,?,?,?,?,?);";
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getNit());
            parametro.setString(2,getNombres());
            parametro.setString(3,getApellidos());
            parametro.setString(4,getDireccion());
            parametro.setString(5,getTelefono());
            parametro.setString(6,getFn());
            int execute = parametro.executeUpdate();
            JOptionPane.showMessageDialog(null, Integer.toString(execute) + "registros ingresador","Message",JOptionPane.INFORMATION_MESSAGE);
            cn.Cerrar();
            
            
        
        
        
        }catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
        
        /*
        System.out.println("NIt: "+ this.getNit());
        System.out.println("Nombres: "+ this.getNombres());
        System.out.println("apellidos: "+ this.getApellidos());
        System.out.println("direccion: "+ this.getDireccion());
        System.out.println("telefono: "+ this.getTelefono());
        System.out.println("fecha de nacimiento : "+ this.getFn());*/
        }
    @Override
    public void modificar(){
    
            try{
            cn = new Conexion();
            PreparedStatement parametro;
            cn.Conectar();
            String query;
            query = "UPDATE clientes set nit=?,nombres=?,apellidos=?,direccion=?,telefono=?,fecha_nacimiento=? WHERE id_clientes=?;";
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getNit());
            parametro.setString(2,getNombres());
            parametro.setString(3,getApellidos());
            parametro.setString(4,getDireccion());
            parametro.setString(5,getTelefono());
            parametro.setString(6,getFn());
            parametro.setInt(7, getId());
            int execute = parametro.executeUpdate();
            JOptionPane.showMessageDialog(null, Integer.toString(execute) + "registros modificado","Message",JOptionPane.INFORMATION_MESSAGE);
            cn.Cerrar();
            
            
        
        
        
        }catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
        
        /*
        System.out.println("NIt: "+ this.getNit());
        System.out.println("Nombres: "+ this.getNombres());
        System.out.println("apellidos: "+ this.getApellidos());
        System.out.println("direccion: "+ this.getDireccion());
        System.out.println("telefono: "+ this.getTelefono());
        System.out.println("fecha de nacimiento : "+ this.getFn());*/
        }
    
    
    
    @Override
       public void eliminar(){
    
            try{
            cn = new Conexion();
            PreparedStatement parametro;
            cn.Conectar();
            String query;
            query = "DELETE FROM clientes WHERE id_clientes=?;";
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getId());
            int execute = parametro.executeUpdate();
            JOptionPane.showMessageDialog(null, Integer.toString(execute) + "registro eliminados","Message",JOptionPane.INFORMATION_MESSAGE);
            cn.Cerrar();
            
            
        
        
        
        }catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
        
        /*
        System.out.println("NIt: "+ this.getNit());
        System.out.println("Nombres: "+ this.getNombres());
        System.out.println("apellidos: "+ this.getApellidos());
        System.out.println("direccion: "+ this.getDireccion());
        System.out.println("telefono: "+ this.getTelefono());
        System.out.println("fecha de nacimiento : "+ this.getFn());*/
        }
 
}
