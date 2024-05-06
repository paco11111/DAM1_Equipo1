/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

import DAOs.SolicitudDAO;
import Enumerados.EstadoSolicitud;
import reto.gestoractividadesextraescolar.Solicitud;
import reto.gestoractividadesextraescolar.Teclado;

/**
 *
 * @author Francisco Sitjar
 */
public class UsuarioProfesor {
    SolicitudDAO sol;
    
    public UsuarioProfesor(){
        sol = new SolicitudDAO();
        
    }
    
    public void verSolicitudes(){
        for(Solicitud s : sol.listar()){
            System.out.println(s);
        }
        
    }
    
    public void modificarSolicitud(){
       int id = Teclado.nextInt("Que solicitud desea modificar?");
       if(sol.porId(id).getESTADO().equals(EstadoSolicitud.SOLICITADA)){
           sol.modificar(new Solicitud());
       }
    }
    
    
    
    
}
