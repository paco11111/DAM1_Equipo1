/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Enumerados.EstadoSolicitud;
import Enumerados.TipoActividad;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.TreeMap;
import reto.gestoractividadesextraescolar.AccesoBaseDatos;
import reto.gestoractividadesextraescolar.Profesor;
import reto.gestoractividadesextraescolar.Repositorio;
import reto.gestoractividadesextraescolar.SolicitudAprobada;
import reto.gestoractividadesextraescolar.Transporte;

/**
 *
 * @author Francisco Sitjar
 */
public class SolicitudAprobadaDAO implements Repositorio<SolicitudAprobada> {
    
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<SolicitudAprobada> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private SolicitudAprobada crearSolicitudAprobada(final ResultSet rs) throws SQLException {
                
        ProfesorDAO profesorDAO = new ProfesorDAO();       
        //Profesores Participantes
        TreeMap <Integer, Profesor> profesoresParticipantes = new TreeMap <Integer, Profesor>();
        
        try ( PreparedStatement stmt = getConnection().prepareStatement("SELECT idProfe FROM idprofes_participantes WHERE idSolicitud = ? ");) {
            stmt.setInt(1, rs.getInt("idSolicitud"));            
            ResultSet rs2 = stmt.executeQuery();
            int index = 0;
            while (rs2.next()) {
                profesoresParticipantes.put(index, profesorDAO.porId(rs2.getInt("idProfe")));
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
        
        try ( PreparedStatement stmt = getConnection().prepareStatement("SELECT idProfe FROM idprofes_responsables WHERE idSolicitud = ? ");) {
            stmt.setInt(1, rs.getInt("idSolicitud"));            
            ResultSet rs2 = stmt.executeQuery();
            int index = 0;
            while (rs2.next()) {
                profesoresResponsables.put(index, profesorDAO.porId(rs2.getInt("idProfe")));
                index++;
            }
            

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        
        TransporteDAO transporteDAO = new TransporteDAO();
        
        //Profesores Responsables
        TreeMap <Integer, Transporte> transportes = new TreeMap <Integer, Transporte>();
        
        try ( PreparedStatement stmt = getConnection().prepareStatement("SELECT idTransporte FROM solicitudes_has_transporte WHERE idSolicitudes = ? ");) {
            stmt.setInt(1, rs.getInt("idSolicitud"));            
            ResultSet rs2 = stmt.executeQuery();
            int index = 0;
            while (rs2.next()) {
                transportes.put(index, transporteDAO.porId(rs2.getInt("idTransporte")));
                index++;
            } 
            

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
        
        return new SolicitudAprobada(rs.getInt("idSolicitud"),profesorDAO.porId(rs.getInt("idSolicitante")),rs.getString("actividad"),rs.getString("tipo_actividad"),departamentoDAO.porId(profesorDAO.porId(rs.getInt("idSolicitante")).getDepartamento().getId()), rs.getBoolean("previsto_programacion"),transportes , rs.getString("comentario_transporte"),finicio, ffin,horaInicio,horaFin, rs.getBoolean("alojamiento"), rs.getString("comentario_alojamiento"), rs.getString("comentarios_adicionales"), rs.getString("estado"), rs.getString("comentario_estado"), profesoresParticipantes, profesoresResponsables, rs.getString("empresa_transporte"), rs.getDouble("importe_transporte"), rs.getString("comentario_actividad"));
    }

    @Override
    public SolicitudAprobada porId(int id) {
        SolicitudAprobada solicitud = null;
        String sql = "SELECT idSolicitud, idSolicitante, actividad, tipo_actividad, requiere_transporte, comentario_transporte, finicio , ffinal, hora_inicio, hora_fin, alojamiento, comentario_alojamiento, comentarios_adicionales, estado, comentario_estado, empresa_transporte, importe_transporte, comentario_actividad FROM solicitudes_aprobadas WHERE idSolicitud = ?";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    solicitud = crearSolicitudAprobada(rs);
                }else{
                    System.out.println("No hay solicitud aprobada con tal id");
                }
            } 
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return solicitud;
    }

    @Override
    public void modificar(SolicitudAprobada solicitud) { //MODIFICAR LOS 3 ULTIMOS DATOS DEPENDIENDO DE LO QUE SE PIDA EN LA BASE DE DATOS
        try ( PreparedStatement stmt = getConnection().prepareStatement("UPDATE solicitudes_aprobadas SET idSolicitante = ?, actividad = ?, tipo_actividad = ?, requiere_transporte = ?, comentario_transporte = ?, finicio = ?, ffinal = ?, hora_inicio = ?, hora_fin = ?, alojamiento = ?, comentario_alojamiento = ?, comentarios_adicionales = ?, estado = ?, comentario_estado = ?, empresa_transporte = ?, importe_transporte = ?, comentario_actividad = ? WHERE idSolicitud=?");) {
            stmt.setInt(1, solicitud.getProfesorSolicitante().getId());
            stmt.setString(2, solicitud.getActividad());
            String tipoActividad = "" + solicitud.getTIPOACTIVIDAD();
            stmt.setString(3, tipoActividad);
            if(solicitud.getTransporte().isEmpty()){
                stmt.setString(4, "false");
            }else{
                stmt.setString(4, "true");
            }
            stmt.setString(5, solicitud.getComentarioTransporte());
            Date fechaInicio = Date.valueOf(solicitud.getFechaInicio());
            stmt.setDate(6, fechaInicio);
            Date fechaFinal = Date.valueOf(solicitud.getFechaFinal());
            stmt.setDate(7, fechaFinal);
            Time horaInicio = Time.valueOf(solicitud.getHoraInicio());
            stmt.setTime(8, horaInicio);
            Time horaFinal = Time.valueOf(solicitud.getHoraFinal());
            stmt.setTime(9, horaFinal);
            stmt.setBoolean(10,solicitud.isAlojamiento());
            stmt.setString(11, solicitud.getComentarioAlojamiento());
            stmt.setString(12, solicitud.getComentarioAdicional());
            String estado = "" + solicitud.getESTADO();
            stmt.setString(13, estado);
            stmt.setString(14, solicitud.getComentarioEstado());
            stmt.setString(15, solicitud.getInfoEmpresaTransporte());
            stmt.setDouble(16, solicitud.getImporteTransporte());
            stmt.setString(17, solicitud.getComentarioActividad());
            stmt.setInt(18, solicitud.getId());
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha insertado/modificado un solo registro");
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void agregar(SolicitudAprobada solicitud) {
        try ( PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO solicitudes_aprobadas (actividad, tipo_actividad, requiere_transporte, comentario_transporte, finicio, ffinal, hora_inicio, hora_fin, alojamiento, comentario_alojamiento, comentarios_adicionales, estado, comentario_estado, empresa_transporte, importe_transporte, comentario_actividad ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");) {
            stmt.setString(1, solicitud.getActividad());
            String tipoActividad = "" + solicitud.getTIPOACTIVIDAD();
            stmt.setString(2, tipoActividad);
            if(solicitud.getTransporte().isEmpty()){
                stmt.setString(3, "false");
            }else{
                stmt.setString(3, "true");
            }
            stmt.setString(4, solicitud.getComentarioTransporte());
            Date fechaInicio = Date.valueOf(solicitud.getFechaInicio());
            stmt.setDate(5, fechaInicio);
            Date fechaFinal = Date.valueOf(solicitud.getFechaFinal());
            stmt.setDate(6, fechaFinal);
            Time horaInicio = Time.valueOf(solicitud.getHoraInicio());
            stmt.setTime(7, horaInicio);
            Time horaFinal = Time.valueOf(solicitud.getHoraFinal());
            stmt.setTime(8, horaFinal);
            stmt.setBoolean(9,solicitud.isAlojamiento());
            stmt.setString(10, solicitud.getComentarioAlojamiento());
            stmt.setString(11, solicitud.getComentarioAdicional());
            String estado = "" + solicitud.getESTADO();
            stmt.setString(12, estado);
            stmt.setString(13, solicitud.getComentarioEstado());
            stmt.setString(14, solicitud.getInfoEmpresaTransporte());
            stmt.setDouble(15, solicitud.getImporteTransporte());
            stmt.setString(16, solicitud.getComentarioActividad());
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha insertado/modificado un solo registro en profesores");
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql="DELETE FROM solicitudes_aprobadas WHERE idSolicitud=?"; 
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha borrado un solo registro");
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
}
