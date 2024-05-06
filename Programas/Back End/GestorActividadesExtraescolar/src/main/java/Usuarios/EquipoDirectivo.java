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
    
    public void estadoSolicitud(){
        int id = Teclado.nextInt("Que solicitud desea modificar?");
        sol.porId(id);
        //menu desplegable para cambiar aprobado o denegado
        
        
    }
    
    
    
    
    
}
