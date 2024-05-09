/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

import Enumerados.PuestoProfesor;

/**
 *
 * @author Francisco Sitjar
 */
public class Profesor implements Comparable<Profesor> {

    private int id;
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private PuestoProfesor PUESTO;
    private Departamento departamento;
    private boolean activo;

    public Profesor(int id, String nombre, String apellidos, String dni, String email, Departamento departamento, String puesto, boolean activo) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        if (departamento != null) {
            this.departamento = departamento;
        } else {
            this.departamento = null;
        }
        this.PUESTO = puesto(puesto);
        this.activo = activo;

    }

    public Profesor(int id, String dni, String nombre, String apellidos, String email, String puesto, boolean activo) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.PUESTO = puesto(puesto);
        this.activo = activo;

    }

    /*public Profesor(boolean tieneId) {
        if (tieneId) {
            this.id = Teclado.nextInt("Id: ");
        }
        this.dni = Teclado.dni();
        this.nombre = Teclado.nextString("Nombre: ");
        this.apellidos = Teclado.nextString("Apellidos: ");
        this.email = Teclado.email();
        this.departamento = Teclado.nextInt("Id del departamento");
        this.PUESTO = Teclado.puesto();
        this.activo = Teclado.nextBolean("El profesor esta activo?");

    }*/

    private PuestoProfesor puesto(String temp) {
        PuestoProfesor puesto = null;
        switch (temp.toUpperCase()) {
            case "SUPERUSUARIO" -> {
                puesto = PuestoProfesor.SUPERUSUARIO;
            }
            case "ADMINISTRADOR" -> {
                puesto = PuestoProfesor.ADMINISTRADOR;
            }
            case "EQUIPO_DIRECTIVO" -> {
                puesto = PuestoProfesor.EQUIPO_DIRECTIVO;
            }
            case "PROFESOR" -> {
                puesto = PuestoProfesor.PROFESOR;
            }
            default ->
                System.out.println("Opcion no valida");
        }
        return puesto;
    }

    public int getId() {
        return id;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public PuestoProfesor getPUESTO() {
        return PUESTO;
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public int compareTo(Profesor o) {
        return this.getNombre().compareTo(o.getNombre());
    }

}
