/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

/**
 *
 * @author Francisco Sitjar
 */
public class Grupo{
   
    private int id;
    private String codigo;
    //private int idC;
    private Curso curso;
    private int numeroAlumnos;
    private boolean activoGrupo;
    
    
    
    /**
     * CONSTRUCTOR
     * 
     * @param id numero entero que identifica el objeto
     * @param codigo codigo del grupo
     * @param curso Curso en el que estan
     * @param numero numero de alumnos en el grupo
     * @param activo Indica si el grupo esta activo
     */
    public Grupo(int id, String codigo, int numero, Curso curso, boolean activo){
        this.id = id;
        this.codigo = codigo;
        if(curso != null){
            this.curso = curso;
        }else{
            this.curso = null;
        }
        this.numeroAlumnos = numero;
        this.activoGrupo = activo;
        
    }
    public Grupo(String codigo, int numero, Curso curso, boolean activo){
        this.codigo = codigo;
        if(curso != null){
            this.curso = curso;
        }else{
            this.curso = null;
        }
        this.numeroAlumnos = numero;
        this.activoGrupo = activo;
        
    }

    
 
    
    //METODOS

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public boolean isActivoGrupo() {
        return activoGrupo;
    }
    
    /*public int getIdC() {
        return idC;
    }*/
    public Curso getCurso(){
        return curso;
    }
}
