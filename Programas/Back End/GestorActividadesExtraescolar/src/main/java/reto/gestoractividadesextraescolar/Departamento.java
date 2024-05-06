/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

/**
 *
 * @author Francisco Sitjar
 */
public class Departamento {
    private int id;
    private String codigo;
    private String nombre;
    private int jefe;
    
    public Departamento(int id,String codigo, String nombre, int jefe){
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.jefe = jefe;
    }
    
    public Departamento(boolean tieneId){
        if(tieneId){
            this.id = Teclado.nextInt("Id del departamento: ");
        }
        this.codigo = Teclado.codigoDepartamento();
        this.nombre = Teclado.nextString("Nombre del departamento: ");
        this.jefe = Teclado.nextInt("Id del jefe de departamento");
        
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getJefe() {
        return jefe;
    }
    
    
}
