/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author james
 */
public class Empleados extends Persona {
    private String codigo,puesto;
    public Empleados(){}

    public Empleados(String codigo, String puesto, String nombres, String apellidos, String direccion, String telefono, String fn) {
        super(nombres, apellidos, direccion, telefono, fn);
        this.codigo = codigo;
        this.puesto = puesto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    
    public void agregar(){
        this.getNombres();
        this.getApellidos();
        this.getDireccion();
        
    }
    
    
    
    
}
