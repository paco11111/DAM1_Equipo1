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
    private int idCurso;
    private String codigo;
    private EtapaCurso etapa;
    private String descripcion;
    private boolean activoCurso;
    
    public Curso(){
        
    }
    
    public Curso(boolean tieneId){
        if(tieneId){
            this.idCurso = Teclado.nextInt("Id del curso");
        }
        etapa = Teclado.etapaCurso();
        codigo = Teclado.codigoCurso();
        boolean opc = Teclado.nextBolean("Añadir comentario sobre el transporte?");
        if(opc){
            descripcion = Teclado.nextString("Añade un comentario: ");
        }
        activoCurso = Teclado.nextBolean("Curso activo?");
        
    }
    
    public Curso(int id, String codigo, EtapaCurso etapa, String descripcion, boolean activo){
        this.idCurso = id;
        this.codigo = codigo;
        this.etapa = etapa;
        this.descripcion = descripcion;
        this.activoCurso = activo;
        
        
    }
            
            
    public String getCodigo() {
        return codigo;
    }

    public int getIdCurso() {
        return idCurso;
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


