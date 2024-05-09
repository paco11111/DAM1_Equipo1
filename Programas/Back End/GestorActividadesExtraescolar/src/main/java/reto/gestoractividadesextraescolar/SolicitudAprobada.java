/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TreeMap;

/**
 *
 * @author Francisco Sitjar
 */
public class SolicitudAprobada extends Solicitud{
    private String infoEmpresaTransporte;
    private double importeTransporte;
    private String comentarioActividad;

    public SolicitudAprobada(int id, Profesor profesorSolicitante, String actividad, String tipoActividad, Departamento departamento, boolean previsto, TreeMap<Integer, Transporte> transporte, String comentarioTransporte, LocalDate fechaInicio, LocalDate fechaFinal, LocalTime horaInicio, LocalTime horaFinal, boolean alojamiento, String comentarioAlojamiento, String comentarioAdicional, String estado, String comentarioEstado, TreeMap<Integer, Profesor> profesoresParticipantes, TreeMap<Integer, Profesor> profesoresResponsables, String infoEmpresa, double importeTransportes, String infoActividad) {
        super(id, profesorSolicitante, actividad, tipoActividad, departamento, previsto, transporte, comentarioTransporte, fechaInicio, fechaFinal, horaInicio, horaFinal, alojamiento, comentarioAlojamiento, comentarioAdicional, estado, comentarioEstado, profesoresParticipantes, profesoresResponsables);
        this.infoEmpresaTransporte = infoEmpresa;
        this.importeTransporte = importeTransportes;
        this.comentarioActividad = infoActividad;
        
    }

  
    
    

    
    public String getInfoEmpresaTransporte() {
        return infoEmpresaTransporte;
    }

    public double getImporteTransporte() {
        return importeTransporte;
    }

    public String getComentarioActividad() {
        return comentarioActividad;
    }
    
    
    
}
