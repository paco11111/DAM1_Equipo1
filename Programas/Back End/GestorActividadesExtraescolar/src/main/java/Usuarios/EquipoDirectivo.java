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
public class EquipoDirectivo {
      SolicitudDAO sol;
    
    public EquipoDirectivo(){
        sol = new SolicitudDAO();
    }
    
    public void verSolicitudes(){
        for(Solicitud s : sol.listar()){
            System.out.println(s);
        }
        
    }
    
    public void estadoSolicitud(String estado){
        for(Solicitud s : sol.listar()){
            System.out.println(s);
        }
        if(estado.toUpperCase().equals(EstadoSolicitud.APROBADA)){
            
        }
        
        
    }
    
    
    
    
    
}
