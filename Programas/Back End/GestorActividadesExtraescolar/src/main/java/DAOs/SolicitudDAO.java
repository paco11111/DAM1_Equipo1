/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import reto.gestoractividadesextraescolar.AccesoBaseDatos;
import reto.gestoractividadesextraescolar.Curso;
import reto.gestoractividadesextraescolar.Grupo;
import reto.gestoractividadesextraescolar.Profesor;
import reto.gestoractividadesextraescolar.Repositorio;
import reto.gestoractividadesextraescolar.Solicitud;
import reto.gestoractividadesextraescolar.Transporte;



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
        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT idSolicitud, idSolicitante, actividad, tipo_actividad, previsto_programacion, requiere_transporte, comentario_transporte, finicio, ffinal, hora_inicio, hora_fin, alojamiento, comentario_alojamiento, comentarios_adicionales, estado, comentario_estado FROM solicitudes");) {
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
    
    
    private Solicitud crearSolicitud(final ResultSet rs) throws SQLException {
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
        
        //Agregar grupos + contador de alumnos
        TreeMap <Integer, Grupo> grupos = new TreeMap <Integer, Grupo>();
        int numeroAlumnos = 0;
        Grupo g;
        try ( PreparedStatement stmt = getConnection().prepareStatement("SELECT idGrupo FROM solicitudes_has_grupos WHERE idSolicitud = ? ");) {
            stmt.setInt(1, rs.getInt("idSolicitud"));            
            ResultSet rs2 = stmt.executeQuery();
            int index = 0;
            
            while (rs2.next()) {
                grupos.put(index, new GrupoDAO().porId(rs2.getInt("idGrupo")));
                g = new GrupoDAO().porId(rs2.getInt("idGrupo"));
                index++;
                numeroAlumnos += g.getNumeroAlumnos();
            }
            
            

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        //Agregar cursos
        TreeMap <Integer, Curso> cursos = new TreeMap <Integer, Curso>();
        
        try ( PreparedStatement stmt = getConnection().prepareStatement("SELECT idCurso FROM solicitudes_has_cursos WHERE idSolicitud = ? ");) {
            stmt.setInt(1, rs.getInt("idSolicitud"));            
            ResultSet rs2 = stmt.executeQuery();
            int index = 0;
            while (rs2.next()) {
                cursos.put(index, new CursoDAO().porId(rs2.getInt("idCurso")));
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
        
        //Transporte
        TreeMap <Integer, Transporte> transportes = new TreeMap <Integer, Transporte>();
        
        try ( PreparedStatement stmt = getConnection().prepareStatement("SELECT idTransporte FROM solicitudes_has_transporte WHERE idSolicitud = ? ");) {
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
        LocalDate ffin = rs.getDate("ffinal").toLocalDate();
        LocalTime horaInicio = rs.getTime("hora_inicio").toLocalTime();
        LocalTime horaFin = rs.getTime("hora_fin").toLocalTime();
        
        
        return new Solicitud(rs.getInt("idSolicitud"),profesorDAO.porId(rs.getInt("idSolicitante")),
                rs.getString("actividad"),rs.getString("tipo_actividad"),
                departamentoDAO.porId(profesorDAO.porId(rs.getInt("idSolicitante")).getDepartamento().getId()), 
                rs.getBoolean("previsto_programacion"),transportes , rs.getString("comentario_transporte"),
                finicio, ffin,horaInicio,horaFin, rs.getBoolean("alojamiento"), 
                rs.getString("comentario_alojamiento"), rs.getString("comentarios_adicionales"), 
                rs.getString("estado"), rs.getString("comentario_estado"), profesoresParticipantes,
                profesoresResponsables, grupos, cursos, numeroAlumnos);
    }
    

    @Override
    public Solicitud porId(int id) {
        Solicitud solicitud = null;
        String sql = "SELECT * FROM solicitudes WHERE idSolicitud = ?";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    solicitud = crearSolicitud(rs);
                }else{
                    System.out.println("No hay solicitud con tal id");
                }
            } 
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return solicitud;
    }

    @Override
    public void modificar(Solicitud solicitud) {
        try ( PreparedStatement stmt = getConnection().prepareStatement("UPDATE solicitudes SET idSolicitante = ?, actividad = ?, tipo_actividad = ?, previsto_programacion = ?, requiere_transporte = ?, comentario_transporte = ?, finicio = ?, ffinal = ?, hora_inicio = ?, hora_fin = ?, alojamiento = ?, comentario_alojamiento = ?, comentarios_adicionales = ?, estado = ?, comentario_estado = ? WHERE idSolicitud=?");) {
            stmt.setInt(1, solicitud.getProfesorSolicitante().getId());
            stmt.setString(2, solicitud.getActividad());
            String tipoActividad = "" + solicitud.getTIPOACTIVIDAD();
            stmt.setString(3, tipoActividad);
            stmt.setBoolean(4, solicitud.isPrevisto());
            if(solicitud.getTransporte().isEmpty()){
                stmt.setBoolean(5, false);
            }else{                                        
                stmt.setBoolean(5, true);
            }
            stmt.setString(6, solicitud.getComentarioTransporte());
            Date fechaInicio = Date.valueOf(solicitud.getFechaInicio());
            stmt.setDate(7, fechaInicio);
            Date fechaFinal = Date.valueOf(solicitud.getFechaFinal());
            stmt.setDate(8, fechaFinal);
            Time horaInicio = Time.valueOf(solicitud.getHoraInicio());
            stmt.setTime(9, horaInicio);
            Time horaFinal = Time.valueOf(solicitud.getHoraFinal());
            stmt.setTime(10, horaFinal);
            stmt.setBoolean(11,solicitud.isAlojamiento());
            stmt.setString(12, solicitud.getComentarioAlojamiento());
            stmt.setString(13, solicitud.getComentarioAdicional());
            String estado = "" + solicitud.getESTADO();
            stmt.setString(14, estado);
            stmt.setString(15, solicitud.getComentarioEstado());
            stmt.setInt(16, solicitud.getId());
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
    public void agregar(Solicitud solicitud) {
        int id = agregar2(solicitud);
        //Agrega en tabla Profes Participantes
        try ( PreparedStatement stmt2 = getConnection().prepareStatement("INSERT INTO idprofes_participantes (idProfe, idSolicitud) VALUES (?,?)");) {
            for(Map.Entry<Integer, Profesor> entry : solicitud.getProfesoresParticipantes().entrySet()){
                stmt2.setInt(1, entry.getValue().getId());
                stmt2.setInt(2, id);
                 int salida = stmt2.executeUpdate();
                if (salida != 1) {
                    throw new Exception(" No se ha insertado/modificado un solo registro en profesores");
                }
            }
        }
        catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //Agrega en tabla Profes Responsables
        try ( PreparedStatement stmt2 = getConnection().prepareStatement("INSERT INTO idprofes_responsables (idProfe, idSolicitud) VALUES (?,?)");) {
            for(Map.Entry<Integer, Profesor> entry : solicitud.getProfesoresResponsables().entrySet()){
                stmt2.setInt(1, entry.getValue().getId());
                stmt2.setInt(2, id);
                 int salida = stmt2.executeUpdate();
                if (salida != 1) {
                    throw new Exception(" No se ha insertado/modificado un solo registro en profesores");
                }
            }
        }
        catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //Agrega en tabla solicitudes_curso
        try ( PreparedStatement stmt2 = getConnection().prepareStatement("INSERT INTO solicitudes_has_cursos (idCurso, idSolicitud) VALUES (?,?)");) {
            for(Map.Entry<Integer, Curso> entry : solicitud.getCurso().entrySet()){
                stmt2.setInt(1, entry.getValue().getId());
                stmt2.setInt(2, id);
                 int salida = stmt2.executeUpdate();
                if (salida != 1) {
                    throw new Exception(" No se ha insertado/modificado un solo registro en profesores");
                }
            }
        }
        catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //Agrega en tabla solicitudes_grupo
        try ( PreparedStatement stmt2 = getConnection().prepareStatement("INSERT INTO solicitudes_has_grupos (idGrupo, idSolicitud) VALUES (?,?)");) {
            for(Map.Entry<Integer, Grupo> entry : solicitud.getGrupo().entrySet()){
                stmt2.setInt(1, entry.getValue().getId());
                stmt2.setInt(2, id);
                 int salida = stmt2.executeUpdate();
                if (salida != 1) {
                    throw new Exception(" No se ha insertado/modificado un solo registro en profesores");
                }
            }
        }
        catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        //Agrega en tabla solicitudes transporte
        try ( PreparedStatement stmt2 = getConnection().prepareStatement("INSERT INTO solicitudes_has_transporte (idTransporte, idSolicitud) VALUES (?,?)");) {
            for(Map.Entry<Integer, Transporte> entry : solicitud.getTransporte().entrySet()){
                stmt2.setInt(1, entry.getValue().getId());
                stmt2.setInt(2, id);
                 int salida = stmt2.executeUpdate();
                if (salida != 1) {
                    throw new Exception(" No se ha insertado/modificado un solo registro en profesores");
                }
            }
        }
        catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int agregar2(Solicitud solicitud) {
        try ( PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO solicitudes (idSolicitante, actividad, tipo_actividad, previsto_programacion, requiere_transporte, comentario_transporte, finicio, ffinal, hora_inicio, hora_fin, alojamiento, comentario_alojamiento, comentarios_adicionales, estado, comentario_estado ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);) {
            stmt.setInt(1, solicitud.getProfesorSolicitante().getId());
            stmt.setString(2, solicitud.getActividad());
            String tipoActividad = "" + solicitud.getTIPOACTIVIDAD();
            stmt.setString(3, tipoActividad);
            stmt.setBoolean(4, solicitud.isPrevisto());
            if(solicitud.getTransporte().isEmpty()){
                stmt.setBoolean(5, false);
            }else{                                        
                stmt.setBoolean(5, true);
            }
            stmt.setString(6, solicitud.getComentarioTransporte());
            Date fechaInicio = Date.valueOf(solicitud.getFechaInicio());
            stmt.setDate(7, fechaInicio);
            Date fechaFinal = Date.valueOf(solicitud.getFechaFinal());
            stmt.setDate(8, fechaFinal);
            Time horaInicio = Time.valueOf(solicitud.getHoraInicio());
            stmt.setTime(9, horaInicio);
            Time horaFinal = Time.valueOf(solicitud.getHoraFinal());
            stmt.setTime(10, horaFinal);
            stmt.setBoolean(11,solicitud.isAlojamiento());
            stmt.setString(12, solicitud.getComentarioAlojamiento());
            stmt.setString(13, solicitud.getComentarioAdicional());
            String estado = "" + solicitud.getESTADO();
            stmt.setString(14, estado);
            stmt.setString(15, solicitud.getComentarioEstado());
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha insertado/modificado un solo registro en profesores");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
            

        }
        catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
         
         
         return -1;
        
    }
    
    
    
    @Override
    public void eliminar(int id) {
        String sql="DELETE FROM solicitudes WHERE idSolicitud=?"; 
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
