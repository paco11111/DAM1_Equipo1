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
    private Profesor jefe;
    
    public Departamento(int id,String codigo, String nombre, Profesor jef){
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        if(jef != null){
            this.jefe = jef;
        }else{
            this.jefe = null;
        }
    }
    public Departamento(int id,String codigo, String nombre){
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    /*
    public Departamento(boolean tieneId){
        if(tieneId){
            this.id = Teclado.nextInt("Id del departamento: ");
        }
        this.codigo = Teclado.codigoDepartamento();
        this.nombre = Teclado.nextString("Nombre del departamento: ");
        this.jefe = Teclado.nextInt("Id del profesor jefe");
        
    }
*/
    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getJefe() {
        return jefe;
    }
    
    
}
