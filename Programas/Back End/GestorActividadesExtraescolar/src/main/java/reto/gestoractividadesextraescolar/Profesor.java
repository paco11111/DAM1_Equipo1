/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

import DAOs.DepartamentoDAO;
import Enumerados.PuestoProfesor;

/**
 *
 * @author Francisco Sitjar
 */
public class Profesor implements Comparable<Profesor> {
    
    //ATRIBUTOS
    
     /**
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
    private PuestoProfesor PUESTO;
    private Departamento departamento;
    private boolean activo;
<<<<<<< Updated upstream

    public Profesor(int id, String nombre, String apellidos, String dni, Departamento departamento, String puesto, boolean activo) {
=======
    
    //CONSTRUCCTORES
    
    /**
     * @param id numero entero que identifica el objeto
     * @param nombre Cadena de texto que guarad el nombre
     * @param apellidos Cadena de texto que guarad los apellidos
     * @param dni Cadena de texto que guarda DNI
     * @param departamento Objeto Departamento al que pertenece el profesor
     * @param activo boolean que informa si el profesor esta activo o no 
     */
    public Profesor(int id, String nombre, String apellidos, String dni, Departamento departamento, boolean activo) {
>>>>>>> Stashed changes
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
       
        this.PUESTO = puesto(puesto);
        this.activo = activo;

    }
<<<<<<< Updated upstream
=======
    
    /**
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
>>>>>>> Stashed changes

  

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
    

    private PuestoProfesor puesto(String temp) {
        PuestoProfesor puesto = null;
        switch (temp.toUpperCase()) {
            case "SUPERUSUARIO" -> {
                puesto = PuestoProfesor.SUPERUSUARIO;
            }
            case "ADMINISTRADOR" -> {
                puesto = PuestoProfesor.ADMINISTRADOR;
            }
            case "EQUIPO_DIRECTIVO" -> {
                puesto = PuestoProfesor.EQUIPO_DIRECTIVO;
            }
            case "PROFESOR" -> {
                puesto = PuestoProfesor.PROFESOR;
            }
            default ->
                System.out.println("Opcion no valida");
        }
        return puesto;
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


    public PuestoProfesor getPUESTO() {
        return PUESTO;
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public int compareTo(Profesor o) {
        return this.getNombre().compareTo(o.getNombre());
    }

}