/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

/**
 *
 * @author Francisco Sitjar
 */
public class Profesor {
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private PuestoProfesor puesto;
    private boolean activo;
    
    
    
    
    public Profesor(String dni, String nombre, String apellidos, String email, PuestoProfesor puesto, boolean activo){
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.puesto = puesto;
        this.activo = activo;
        
        
        
        
    }
    
    public Profesor(){
        this.dni = Teclado.dni();
        this.nombre = Teclado.nextString("Nombre: ");
        this.apellidos = Teclado.nextString("Apellidos: ");
        this.email = Teclado.email();
        this.puesto = 
        
    }
    
}
