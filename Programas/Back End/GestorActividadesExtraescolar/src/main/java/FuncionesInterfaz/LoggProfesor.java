/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FuncionesInterfaz;

import Enumerados.PuestoProfesor;

/**
 *
 * @author Fabian Saiz Landeras
 */
public class LoggProfesor {
    private String email;
    private String paswrd;
    private PuestoProfesor PUESTO;
    
    public LoggProfesor(String email, String paswrd, PuestoProfesor PUESTO){
        this.email = email;
        this.paswrd = paswrd;
        this.PUESTO = PUESTO;
    }
    
    public void verificar(String email, String paswrd){
        if (this.getEmail().equals(email)) {
            
        }
        if (this.getPaswrd().equals(paswrd)) {
            
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaswrd() {
        return paswrd;
    }

    public void setPaswrd(String paswrd) {
        this.paswrd = paswrd;
    }

    public PuestoProfesor getPUESTO() {
        return PUESTO;
    }

    public void setPUESTO(PuestoProfesor PUESTO) {
        this.PUESTO = PUESTO;
    }
    
}
