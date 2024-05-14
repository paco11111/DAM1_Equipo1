/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

import Enumerados.EtapaCurso;

/**
 *
 * @author Francisco Sitjar
 */
public class Curso {
    
    
    private int id;
    private String codigo;
    private EtapaCurso etapa;
    private String descripcion;
    private boolean activoCurso;
    
   
    
    public Curso(){
        
    }
    
    /*public Curso(boolean tieneId){
        if(tieneId){
            this.id = Utilidad.nextInt("Id del curso");
        }
        etapa = Utilidad.etapaCurso();
        codigo = Utilidad.codigoCurso();
        boolean opc = Utilidad.nextBolean("Añadir comentario sobre el transporte?");
        if(opc){
            descripcion = Utilidad.nextString("Añade un comentario: ");
        }
        activoCurso = Utilidad.nextBolean("Curso activo?");
        
    }*/
    
     /**
     * CONSTRUCTOR
     * 
     * @param id numero entero que identifica el objeto
     * @param codigo Codigo del departamento
     * @param etapa Etapa del curso
     * @param descripcion Profesor jefe del departamento
     * @param activo Indica si esta activo o no
     */
    public Curso(int id, String codigo, EtapaCurso etapa, String descripcion, boolean activo){
        this.id = id;
        this.codigo = codigo;
        this.etapa = etapa;
        this.descripcion = descripcion;
        this.activoCurso = activo;
        
        
    }
            
            
    public String getCodigo() {
        return codigo;
    }

    public int getId() {
        return id;
    }

    public EtapaCurso getEtapa() {
        return etapa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isActivoCurso() {
        return activoCurso;
    }
    
    
    
}


