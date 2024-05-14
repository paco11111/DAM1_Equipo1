/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

/**
 *
 * @author Francisco Sitjar
 */
public class Transporte implements Comparable<Transporte> {
    private int id;
    private String tipo;
    private String descripcion;
    
    /**
     * CONSTRUCTOR
     * 
     * @param id numero entero que identifica el objeto
     * @param tipo tipo de transporte
     * @param descripcion del transporte
     */
    public Transporte(int id, String tipo, String descripcion){
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
    
    /**
     * CONSTRUCTOR
     *
     * @param tipo tipo de transporte
     * @param descripcion del transporte
     */
    public Transporte(String tipo, String descripcion){
        this.tipo = tipo;
        this.descripcion = descripcion;
    }


    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     * @param o Objeto Transporte a comparar
     * @return Compara ambos objetos transportes por nombre 
     */
    @Override
    public int compareTo(Transporte o) {
        return this.getTipo().compareTo(o.getTipo());
    }
    
    

    
}
