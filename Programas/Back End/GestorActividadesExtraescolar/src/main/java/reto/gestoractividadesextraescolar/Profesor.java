/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

import DAOs.DepartamentoDAO;
import Enumerados.PuestoProfesor;

/**
 *  Esta clase representa la tabla profesor en la base de datos.
 * @author Francisco Sitjar
 */
public class Profesor implements Comparable<Profesor> {
    
   
    
     /**
     * CONSTRUCTOR
     * 
     * @param id numero entero que identifica el objeto
     * @param nombre Cadena de texto que guarad el nombre
     * @param apellidos Cadena de texto que guarad los apellidos
     * @param dni Cadena de texto que guarda DNI
     * @param departamento Objeto Departamento al que pertenece el profesor
     * @param activo boolean que informa si el profesor esta activo o no 
     */
    private int id;
    private String dni;
    private String nombre;
    private String apellidos;
    private Departamento departamento;

    private boolean activo;


   
    /**
     * CONSTRUCTOR
     * 
     * @param id numero entero que identifica el objeto
     * @param nombre Cadena de texto que guarad el nombre
     * @param apellidos Cadena de texto que guarad los apellidos
     * @param dni Cadena de texto que guarda DNI
     * @param departamento Objeto Departamento al que pertenece el profesor
     * @param activo boolean que informa si el profesor esta activo o no 
     */
    public Profesor(int id, String nombre, String apellidos, String dni, Departamento departamento, boolean activo) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        if(departamento != null){
            this.departamento = departamento;
           this. departamento.setJefe(this);
        }else{
            this.departamento = null;
        }
       
        this.activo = activo;

    }
    /**
     * CONSTRUCTOR
     * 
     * @param nombre Cadena de texto que guarad el nombre
     * @param apellidos Cadena de texto que guarad los apellidos
     * @param dni Cadena de texto que guarda DNI
     * @param departamento Objeto Departamento al que pertenece el profesor
     */
    public Profesor( String nombre, String apellidos, String dni, Departamento departamento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        if(departamento != null){
            this.departamento = departamento;
           this. departamento.setJefe(this);
        }else{
            this.departamento = null;
        }
        this.activo = true;
       

    }
  

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
    public int getId() {
        return id;
    }

    public Departamento getDepartamento() {
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


    

    public boolean isActivo() {
        return activo;
    }

    /**
     * 
     * @param o Objeto profesor a comparar
     * @return Compara ambos objetos profesores por nombre 
     */
    
    @Override
    public int compareTo(Profesor o) {
        return this.getNombre().compareTo(o.getNombre());
    }

}
