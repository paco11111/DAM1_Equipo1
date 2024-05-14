/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

import Enumerados.PuestoProfesor;
import reto.gestoractividadesextraescolar.Profesor;

/**
 *
 * @author Fabian Saiz Landeras
 */
public class LoggProfesor {
    private Profesor profesor;
    private String email;
    private String psswrd;
    private PuestoProfesor PUESTO;
    
    public LoggProfesor(Profesor profesor,String email, String psswrd, String puesto){
        this.profesor = profesor;
        this.email = email;
        this.psswrd = psswrd;
        this.PUESTO = puesto(puesto);
    }
    public LoggProfesor(Profesor profesor,String email){
        this.profesor = profesor;
        this.email = email;
        PUESTO = PuestoProfesor.PROFESOR;
    }

    
    
    
    
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
                System.out.println("Opcion no valida3");
        }
        return puesto;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    
    
    public String getEmail() {
        
        return email;
        
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsswrd() {
        return psswrd;
    }

    public void setPsswrd(String paswrd) {
        this.psswrd = paswrd;
    }

    public PuestoProfesor getPUESTO() {
        return PUESTO;
    }

    public void setPUESTO(PuestoProfesor PUESTO) {
        this.PUESTO = PUESTO;
    }
    
}
