/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

import Enumerados.EstadoSolicitud;
import Enumerados.TipoActividad;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/**
 *
 * @author Francisco Sitjar
 */
public class Solicitud {
    private int id;
    private Profesor profesorSolicitante;
    private String actividad;
    private TipoActividad TIPOACTIVIDAD;
    private Departamento departamento;
    private boolean previsto;
    private TreeMap <Integer, Transporte> transporte;
    private String comentarioTransporte;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    private boolean alojamiento;
    private String comentarioAlojamiento;
    private String comentarioAdicional;
    private EstadoSolicitud ESTADO;
    private String comentarioEstado;
    private TreeMap <Integer, Profesor> profesoresParticipantes;
    private TreeMap <Integer, Profesor> profesoresResponsables;

    public Solicitud(int id, Profesor profesorSolicitante, String actividad, String tipoActividad, Departamento departamento, boolean previsto, TreeMap <Integer, Transporte> transporte, String comentarioTransporte, LocalDate fechaInicio, LocalDate fechaFinal, LocalTime horaInicio, LocalTime horaFinal, boolean alojamiento, String comentarioAlojamiento, String comentarioAdicional, String estado, String comentarioEstado, TreeMap<Integer, Profesor> profesoresParticipantes, TreeMap<Integer, Profesor> profesoresResponsables) {
        this.id = id;
        this.profesorSolicitante = profesorSolicitante;
        this.actividad = actividad;
        this.TIPOACTIVIDAD = tipoActividad(tipoActividad);
        if(departamento != null){
            this.departamento = departamento;
        }else{
            departamento = null;
        }
        if(transporte.isEmpty()){
            
        }
        this.previsto = previsto;
        this.transporte = transporte;
        this.departamento = departamento;
        this.comentarioTransporte = comentarioTransporte;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.alojamiento = alojamiento;
        this.comentarioAlojamiento = comentarioAlojamiento;
        this.comentarioAdicional = comentarioAdicional;
        this.ESTADO = estadoSolicitud(estado);
        this.comentarioEstado = comentarioEstado;
        this.profesoresParticipantes = profesoresParticipantes;
        this.profesoresResponsables = profesoresResponsables;
    }
     public Solicitud(Profesor profesorSolicitante, String actividad, String tipoActividad, Departamento departamento, boolean previsto, TreeMap <Integer, Transporte> transporte, String comentarioTransporte, LocalDate fechaInicio, LocalDate fechaFinal, LocalTime horaInicio, LocalTime horaFinal, boolean alojamiento, String comentarioAlojamiento, String comentarioAdicional, String estado, String comentarioEstado, TreeMap<Integer, Profesor> profesoresParticipantes, TreeMap<Integer, Profesor> profesoresResponsables) {
        
        this.profesorSolicitante = profesorSolicitante;
        this.actividad = actividad;
        this.TIPOACTIVIDAD = tipoActividad(tipoActividad);
        if(departamento != null){
            this.departamento = departamento;
        }else{
            departamento = null;
        }
        if(transporte.isEmpty()){
            
        }
        this.previsto = previsto;
        this.transporte = transporte;
        this.departamento = departamento;
        this.comentarioTransporte = comentarioTransporte;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.alojamiento = alojamiento;
        this.comentarioAlojamiento = comentarioAlojamiento;
        this.comentarioAdicional = comentarioAdicional;
        this.ESTADO = estadoSolicitud(estado);
        this.comentarioEstado = comentarioEstado;
        this.profesoresParticipantes = profesoresParticipantes;
        this.profesoresResponsables = profesoresResponsables;
    }
     
     
     public void agregarTransporte(Transporte t){
         if(transporte.isEmpty()){
             transporte.put(1, t);
         }else{
             transporte.put((transporte.lastKey()+1), t);
         }
     }
     
     public void agregarParticipante(Profesor p){
         if(profesoresParticipantes.isEmpty()){
             profesoresParticipantes.put(1, p);
         }else{
             profesoresParticipantes.put((profesoresParticipantes.lastKey()+1), p);
         }
         
     }
     
     public void agregarResponsable(Profesor p){
         
         if(profesoresResponsables.isEmpty()){
             profesoresResponsables.put(1, p);
         }else{
             profesoresResponsables.put((profesoresResponsables.lastKey()+1), p);
         }
     }
     
        
    private TipoActividad tipoActividad(String temp){
        TipoActividad actividad = null;
        switch (temp.toUpperCase()) {
                case "COMPLEMENTARIA" -> {
                    actividad = TipoActividad.COMPLEMENTARIA;
                }
                case "EXTRAESCOLAR" -> {
                    actividad = TipoActividad.EXTRAESCOLAR;
                }
                default ->
                    System.out.println("Opcion no valida1");
            }
        return actividad;
    }
    
    private EstadoSolicitud estadoSolicitud(String temp){
        EstadoSolicitud estado = null;
        switch (temp.toUpperCase()) {
                case "APROBADA" -> {
                    estado = EstadoSolicitud.APROBADA;
                }
                case "DENEGADA" -> {
                    estado = EstadoSolicitud.DENEGADA;
                }
                case "REALIZADA" -> {
                    estado = EstadoSolicitud.REALIZADA;
                }
                case "SOLICITADA" -> {
                    estado = EstadoSolicitud.SOLICITADA;
                }
                default ->
                    System.out.println("Opcion no valida2");
            }
        return estado;
    }
    
   /* public Solicitud(){
        profesorSolicitante = new Profesor(false);
        actividad = Teclado.nextString("Actividad a solicitar:");
        TIPOACTIVIDAD = Teclado.tipoActividad();
        departamento = Teclado.nextString("Departamento");
        previsto = Teclado.nextBolean("Estaba previsto en la programación didáctica? ");
        transporte = Teclado.nextBolean("Hay transporte? ");
        boolean opc = Teclado.nextBolean("Añadir comentario sobre el transporte?");
        if(opc){
            comentarioTransporte = Teclado.nextString("Añade un comentario: ");
        }
        fechaInicio = Teclado.fecha("Fecha de inicio: ");
        fechaFinal = Teclado.fecha("Fecha de finalización: ");
        horaInicio = Teclado.hora("Hora de salida: ");
        horaFinal = Teclado.hora("Hora de entrada: ");
        alojamiento = Teclado.nextBolean("Alojamiento?");
        opc = Teclado.nextBolean("Añadir comentario sobre el alojamiento?");
        if(opc){
            comentarioTransporte = Teclado.nextString("Añade un comentario: ");
        }
        opc = Teclado.nextBolean("Añadir comentario adicional?");
        if(opc){
            comentarioTransporte = Teclado.nextString("Añade un comentario: ");
        }
        ESTADO = Teclado.estado();
        opc = Teclado.nextBolean("Añadir comentario sobre el estado?");
        if(opc){
            comentarioTransporte = Teclado.nextString("Añade un comentario: ");
        }
        profesoresParticipantes = new TreeMap<Integer, Profesor>(); 
        profesoresResponsables = new TreeMap<Integer, Profesor>(); 
        
    }
    
    */
    
    
   
    public int getId() {
        return id;
    }

    public Profesor getProfesorSolicitante() {
        return profesorSolicitante;
    }

    public String getActividad() {
        return actividad;
    }

    public TipoActividad getTIPOACTIVIDAD() {
        return TIPOACTIVIDAD;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public boolean isPrevisto() {
        return previsto;
    }

    public TreeMap getTransporte() {
        return transporte;
    }

    public String getComentarioTransporte() {
        return comentarioTransporte;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public boolean isAlojamiento() {
        return alojamiento;
    }

    public String getComentarioAlojamiento() {
        return comentarioAlojamiento;
    }

    public String getComentarioAdicional() {
        return comentarioAdicional;
    }

    public EstadoSolicitud getESTADO() {
        return ESTADO;
    }

    public String getComentarioEstado() {
        return comentarioEstado;
    }

    public TreeMap<Integer, Profesor> getProfesoresParticipantes() {
        return profesoresParticipantes;
    }

    public TreeMap<Integer, Profesor> getProfesoresResponsables() {
        return profesoresResponsables;
    }

    
    
    
    
    
    
    
}
