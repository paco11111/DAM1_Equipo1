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
    //ATRIBUTOS
    
    /**
     * @param id numero entero que identifica el objeto
     * @param codigo codigo del grupo
     * @param curso Curso en el que estan
     * @param numeroAlumno numero de alumnos en el grupo
     * @param activoGrupo Indica si el grupo esta activo
     */
    private int id;
    private String codigo;
    //private int idC;
    private Curso curso;
    private int numeroAlumnos;
    private boolean activoGrupo;
    
    //CONSTRUCCTORES
    
    /**
     * @param id numero entero que identifica el objeto
     * @param codigo codigo del grupo
     * @param curso Curso en el que estan
     * @param numero numero de alumnos en el grupo
     * @param activo Indica si el grupo esta activo
     */
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
        codigo = Utilidad.codigoGrupo();
        numeroAlumnos = Utilidad.nextInt("Numeor de alumnos: ");
        activoGrupo = Utilidad.nextBolean("Grupo activo? ");
        
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
