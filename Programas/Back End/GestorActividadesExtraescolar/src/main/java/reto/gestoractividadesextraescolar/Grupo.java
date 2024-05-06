/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

/**
 *
 * @author Francisco Sitjar
 */
public class Grupo extends Curso{
    private int idGrupo;
    private String codigoCurso;
    private int idC;
    private int numeroAlumnos;
    private boolean activoGrupo;
    
    
    public Grupo(int id, String codigoCurso, int numero, int idC, boolean activo){
        this.idGrupo = id;
        this.codigoCurso = codigoCurso;
        this.idC = idC;
        this.numeroAlumnos = numero;
        this.activoGrupo = activo;
        
    }

    public int getIdC() {
        return idC;
    }
    
    public Grupo(){
        codigoCurso = Teclado.codigoGrupo();
        numeroAlumnos = Teclado.nextInt("Numeor de alumnos: ");
        activoGrupo = Teclado.nextBolean("Grupo activo? ");
        
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public boolean isActivoGrupo() {
        return activoGrupo;
    }
    
    
}
