/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

import DAOs.ProfesorDAO;

/**
 *
 * @author Francisco Sitjar
 */
public class Departamento {
    //ATRIBUTOS
   
    /**
     * @param id numero entero que identifica el objeto
     * @param nombre Cadena de texto que guarad el nombre
     * @param codigo Codigo del departamento
     * @param jefe Profesor jefe del departamento
     */
    private int id;
    private String codigo;
    private String nombre;
    private Profesor jefe;
    
    //CONSTRUCCTORES
    
     /**
     * @param id numero entero que identifica el objeto
     * @param nombre Cadena de texto que guarad el nombre
     * @param codigo Codigo del departamento
     * @param jefe Profesor jefe del departamento
     */
    public Departamento(int id,String codigo, String nombre, Profesor jefe){
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        if(jefe != null){
            this.jefe = jefe;
            this.jefe.setDepartamento(this);
        }else{
            this.jefe = null;
        }
        
        
    }
     /**
     * @param id numero entero que identifica el objeto
     * @param codigo Codigo del departamento
     * @param nombre Cadena de texto que guarad el nombre
     */
    public Departamento(int id,String codigo, String nombre){
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    

    public void setJefe(Profesor jefe) {
        this.jefe = jefe;
    }
    
    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getJefe() {
        return jefe;
    }
    
    
}