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
    
    
    public Grupo(int id, String codigo, int numero, /*int idC*/ Curso curso, boolean activo){
        this.id = id;
        this.codigo = codigo;
        //this.idC = idC;
        if(curso != null){
            this.curso = curso;
        }else{
            this.curso = null;
        }
        this.numeroAlumnos = numero;
        this.activoGrupo = activo;
        
    }

    
    
    public Grupo(){
        codigo = Teclado.codigoGrupo();
        numeroAlumnos = Teclado.nextInt("Numeor de alumnos: ");
        activoGrupo = Teclado.nextBolean("Grupo activo? ");
        
    }

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
