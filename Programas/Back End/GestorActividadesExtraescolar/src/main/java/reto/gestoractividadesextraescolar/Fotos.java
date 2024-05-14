/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

/**
 *
 * @author Francisco Sitjar
 */
public class Fotos {
 
    private int id;
    private String url;
    private String descripcion;
    
    
    
    
    /**
     * CONSTRUCTOR
     * 
     * @param id numero entero que identifica el objeto
     * @param url Enlace de la foto
     * @param Descripcion Etapa del curso
     */
    public Fotos(int id, String url, String descripcion){
        this.id = id;
        this.url = url;
        this.descripcion = descripcion;
    }
    
    
    
}
