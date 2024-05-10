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

    private int id;
    private String dni;
    private String nombre;
    private String apellidos;
    private Departamento departamento;
    private boolean activo;

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

    @Override
    public int compareTo(Profesor o) {
        return this.getNombre().compareTo(o.getNombre());
    }

}