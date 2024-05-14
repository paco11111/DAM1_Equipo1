/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

import DAOs.SolicitudDAO;
import Enumerados.EstadoSolicitud;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TreeMap;
import reto.gestoractividadesextraescolar.Departamento;
import reto.gestoractividadesextraescolar.Profesor;
import reto.gestoractividadesextraescolar.Solicitud;
import reto.gestoractividadesextraescolar.Transporte;
import reto.gestoractividadesextraescolar.Utilidad;

/**
 *
 * @author Francisco Sitjar, Izan Franco 
 */
public class UsuarioProfesor {
    SolicitudDAO sol;
    
    public UsuarioProfesor(){
        sol = new SolicitudDAO();
        
    }
    
    public Solicitud crearSolicitudes(Profesor profesorSolicitante, String actividad, String tipoActividad, Departamento departamento, boolean previsto, TreeMap <Integer, Transporte> transporte, String comentarioTransporte, LocalDate fechaInicio, LocalDate fechaFinal, LocalTime horaInicio, LocalTime horaFinal, boolean alojamiento, String comentarioAlojamiento, String comentarioAdicional, String estado, String comentarioEstado, TreeMap<Integer, Profesor> profesoresParticipantes, TreeMap<Integer, Profesor> profesoresResponsables) {    
        
        Solicitud s = new Solicitud(profesorSolicitante, actividad, tipoActividad, departamento, previsto, transporte, comentarioTransporte, fechaInicio, fechaFinal, horaInicio, horaFinal, alojamiento, comentarioAlojamiento, comentarioAdicional, estado, comentarioEstado, profesoresParticipantes, profesoresResponsables);
        
        return s;
    }
    
    /*public void verSolicitudes(){
        
        
    }*/
    
    public Solicitud modificarSolicitud(Profesor profesorSolicitante, String actividad, String tipoActividad, Departamento departamento, boolean previsto, TreeMap <Integer, Transporte> transporte, String comentarioTransporte, LocalDate fechaInicio, LocalDate fechaFinal, LocalTime horaInicio, LocalTime horaFinal, boolean alojamiento, String comentarioAlojamiento, String comentarioAdicional, String estado, String comentarioEstado, TreeMap<Integer, Profesor> profesoresParticipantes, TreeMap<Integer, Profesor> profesoresResponsables) {    
        
        Solicitud s = new Solicitud(profesorSolicitante, actividad, tipoActividad, departamento, previsto, transporte, comentarioTransporte, fechaInicio, fechaFinal, horaInicio, horaFinal, alojamiento, comentarioAlojamiento, comentarioAdicional, estado, comentarioEstado, profesoresParticipantes, profesoresResponsables);
        
        return s;
    }
    
    
    
    
    
}
