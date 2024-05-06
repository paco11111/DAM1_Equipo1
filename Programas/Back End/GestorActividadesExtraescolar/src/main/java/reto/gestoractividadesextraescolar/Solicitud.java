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

/**
 *
 * @author Francisco Sitjar
 */
public class Solicitud {
    private int id;
    private Profesor profesorSolicitante;
    private String actividad;
    private TipoActividad TIPOACTIVIDAD;
    private String departamento;
    private boolean previsto;
    private boolean transporte;
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
    private List <Profesor> profesoresParticipantes;
    private List <Profesor> profesoresResponsables;
    
    
    
    public Solicitud(){
        //profesorSolicitante = *** ESTO LLAMA A CLASE PROFESORES
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
        //profesoresParticipantes = new ArrayList<Profesor>(); ***Insertar profesores participantes por su nombre o dni (mirar cual es mas comodo)
        //profesoresResponsables = new ArrayList<Profesor>(); *** Repetir proceso anterior para los profesores responsables
        
        
        
        
        
    }
    
    
    @Override
    public String toString(){
         //DateTimeFormatter f = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy ").withLocale(new Locale("es", "ES"));
         //DateTimeFormatter t = DateTimeFormatter.ofPattern("'a las' hh:mm").withLocale(new Locale("es", "ES"));
         
        return "\nID: " + id + "-- Profesor: "+ profesorSolicitante.getNombre() + " " + profesorSolicitante.getApellidos();
    }

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

    public String getDepartamento() {
        return departamento;
    }

    public boolean isPrevisto() {
        return previsto;
    }

    public boolean isTransporte() {
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

    public List<Profesor> getProfesoresParticipantes() {
        return profesoresParticipantes;
    }

    public List<Profesor> getProfesoresResponsables() {
        return profesoresResponsables;
    }
    
    
    
    
    
}
