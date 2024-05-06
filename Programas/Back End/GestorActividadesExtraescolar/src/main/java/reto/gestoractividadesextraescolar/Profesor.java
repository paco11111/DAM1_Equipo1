/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

import Enumerados.PuestoProfesor;

/**
 *
 * @author Francisco Sitjar
 */
public class Profesor {
    private int id;
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private PuestoProfesor PUESTO;
    private int  departamento;
    private boolean activo;
    
    
    
    
    public Profesor(int id, String dni, String nombre, String apellidos, String email,int departamento, PuestoProfesor puesto, boolean activo){
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.departamento = departamento;
        this.PUESTO = puesto;
        this.activo = activo;
        
    }
    
    public Profesor(boolean tieneId){
        if(tieneId){
            this.id = Teclado.nextInt("id: ");
        }
        this.dni = Teclado.dni();
        this.nombre = Teclado.nextString("Nombre: ");
        this.apellidos = Teclado.nextString("Apellidos: ");
        this.email = Teclado.email();
        this.departamento = Teclado.nextInt("id del departamento:");
        this.PUESTO = Teclado.puesto();
        this.activo = Teclado.nextBolean("El profesor esta activo?");
        
    }
    
    

    public int getId() {
        return id;
    }

    public int getDepartamento() {
        return departamento;
    }
    

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public PuestoProfesor getPUESTO() {
        return PUESTO;
    }

    public boolean isActivo() {
        return activo;
    }
    
    
    
}
