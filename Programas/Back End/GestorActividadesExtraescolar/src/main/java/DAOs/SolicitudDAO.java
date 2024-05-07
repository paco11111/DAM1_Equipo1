/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Enumerados.EstadoSolicitud;
import Enumerados.PuestoProfesor;
import Enumerados.TipoActividad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import reto.gestoractividadesextraescolar.AccesoBaseDatos;
import reto.gestoractividadesextraescolar.Profesor;
import reto.gestoractividadesextraescolar.Repositorio;
import reto.gestoractividadesextraescolar.Solicitud;

/**
 *
 * @author Francisco Sitjar
 */
public class SolicitudDAO implements Repositorio<Solicitud>{
    
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Solicitud> listar() {
        List<Solicitud> solicitudes = new ArrayList<>();
        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT * FROM solicitudes");) {
            while (rs.next()) {
                Solicitud solicitud = crearSolicitud(rs);
                if (!solicitudes.add(solicitud)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
                 }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return solicitudes;
    }
    private Profesor crearProfesor(final ResultSet rs) throws SQLException {
        PuestoProfesor puesto = null;
        switch (rs.getString("ocupacion")) {
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

        return new Profesor(rs.getInt("idProfesor"), rs.getString("apellidos"), rs.getString("nombre"), rs.getString("DNI"), rs.getString("email"), rs.getInt("idDepartamento"), puesto, rs.getBoolean("activo"));
    }
    
    private Solicitud crearSolicitud(final ResultSet rs) throws SQLException {
        TipoActividad actividad = null;
        switch (rs.getString("tipo_actividad")) {
                case "COMPLEMENTARIA" -> {
                    actividad = TipoActividad.COMPLEMENTARIA;
                }
                case "EXTRAESCOLAR" -> {
                    actividad = TipoActividad.EXTRAESCOLAR;
                }
                default ->
                    System.out.println("Opcion no valida");
            }
        
        
        EstadoSolicitud estado = null;
        switch (rs.getString("tipo_actividad")) {
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
                    System.out.println("Opcion no valida");
            }
        
        Profesor solicitante;
        ProfesorDAO temp = new ProfesorDAO();
        solicitante = temp.porId(rs.getInt("idSolicitante"));
        
        //Profesores Participantes
        TreeMap <Integer, Profesor> profesoresParticipantes = new TreeMap <Integer, Profesor>();
        
        try ( PreparedStatement stmt = getConnection().prepareStatement("SELECT * FORM profesores WHERE id = (SELECT idProfe FROM idprofes_participantes WHERE idSolicitud = ?)");) {
            stmt.setInt(1, rs.getInt("idSolicitud"));            
            ResultSet rs2 = stmt.executeQuery();
            int index = 0;
            while (rs2.next()) {
                Profesor profesor = crearProfesor(rs);
                profesoresParticipantes.put(index, profesor);
                index++;
            }
            

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        
        //Profesores Responsables
        TreeMap <Integer, Profesor> profesoresResponsables = new TreeMap <Integer, Profesor>();
        
        try ( PreparedStatement stmt = getConnection().prepareStatement("SELECT * FORM profesores WHERE idProfesor = (SELECT idProfe FROM idprofes_responsables WHERE idSolicitud = ?)");) {
            stmt.setInt(1, rs.getInt("idSolicitud"));            
            ResultSet rs2 = stmt.executeQuery();
            int index = 0;
            while (rs2.next()) {
                Profesor profesor = crearProfesor(rs);
                profesoresResponsables.put(index, profesor);
                index++;
            }
            

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        //Codigo departamento
        String departamento = null;
        try ( PreparedStatement stmt = getConnection().prepareStatement("SELECT codigo  FORM departamento WHERE idDepartamento = (SELECT idDepartamento FROM profesores WHERE idProfesor = ?)");) {
            stmt.setInt(1, rs.getInt("idSolicitud"));            
            ResultSet rs2 = stmt.executeQuery();
            departamento = rs.getString("codigo");
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        LocalDate finicio = rs.getDate("finicio").toLocalDate();
        LocalDate ffin = rs.getDate("ffin").toLocalDate();
        LocalTime horaInicio = rs.getTime("hora_inicio").toLocalTime();
        LocalTime horaFin = rs.getTime("hora_fin").toLocalTime();
        
        return new Solicitud(rs.getInt("idSolicitud"),solicitante,rs.getString("actividad"),actividad,departamento, rs.getBoolean("previsto_programacion"), rs.getBoolean("requiere_transporte"), rs.getString("comentario_transporte"),finicio, ffin,horaInicio,horaFin, rs.getBoolean("alojamiento"), rs.getString("comentario_alojamiento"), rs.getString("comentarios_adicionales"), estado, rs.getString("comentario_estado"), profesoresParticipantes, profesoresResponsables);
    }

    @Override
    public Solicitud porId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(Solicitud t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregar(Solicitud t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
