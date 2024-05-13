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
    
    public Transporte(boolean tieneId){
        if(tieneId){
            id = Utilidad.nextInt("Id del transporte: ");
        }
        tipo = Utilidad.nextString("Tipo de transporte: ");
        boolean opc = Utilidad.nextBolean("Añadir descripción sobre el  transporte?");
        if(opc){
            descripcion = Utilidad.nextString("Añade una descripción : ");
        }
    }
    public Transporte(int id, String tipo, String descripcion){
        this.id = id;
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

    @Override
    public int compareTo(Transporte o) {
        return this.getTipo().compareTo(o.getTipo());
    }
    
    

    
}
