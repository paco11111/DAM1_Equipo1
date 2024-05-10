/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import FuncionesInterfaz.LoggProfesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reto.gestoractividadesextraescolar.AccesoBaseDatos;
import reto.gestoractividadesextraescolar.Profesor;
import reto.gestoractividadesextraescolar.Repositorio;

/**
 *
 * @author Francisco Sitjar
 */
public class LoggProfesorDAO implements Repositorio<LoggProfesor> {
    
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<LoggProfesor> listar() {
        List<LoggProfesor> profesores = new ArrayList<>();
        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT idProfesor, profesores.nombre as profesor, apellidos,DNI,profesores.idDepartamento,activo, codigo, departamentos.nombre, idProfesorJefe FROM profesores INNER JOIN departamentos WHERE profesores.idDepartamento= departamentos.idDepartamento");) {

            while (rs.next()) {
                LoggProfesor profesor = crearLoggProfesor(rs);
                if (!profesores.add(profesor)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return profesores;
    }
    public LoggProfesor crearLoggProfesor(final ResultSet rs) throws SQLException {
        Profesor prof = new Profesor(rs.getInt("idProfesor"), rs.getString("profesor"), rs.getString("apellidos"),rs.getString("DNI"),  new DepartamentoDAO().porId(rs.getInt("idDepartamento")),  rs.getBoolean("activo"));
        LoggProfesor p = new LoggProfesor(prof, rs.getString("email"), rs.getString("password"),rs.getString("ocupacion"));
        
        return p;
    }

    @Override
    public LoggProfesor porId(int id) {
        LoggProfesor profesor = null;
        String sql = "SELECT logprofesores.idProfesor, nombre, apellidos,DNI,idDepartamento,ocupacion,activo, email, password, ocupacion FROM profesores INNER JOIN logprofesores ON profesores.idProfesor= profesores.idProfesor WHERE logprofesores.idProfesor=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    profesor = crearLoggProfesor(rs);
                } else {
                    System.out.println("No hay profesor usuario con tal id");
                }
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return profesor;
    }

    @Override
    public void modificar(LoggProfesor profesor) {
        try ( PreparedStatement stmt = getConnection().prepareStatement("UPDATE logprofesores SET email = ?, password = md5(?), idProfesor = ?, ocupacion = ? WHERE idProfesor=?");) {
            stmt.setString(1, profesor.getEmail());
            stmt.setString(2, profesor.getPsswrd());
            stmt.setInt(3, profesor.getProfesor().getId());
            String ocupacion = ""+profesor.getPUESTO();
            stmt.setString(4, ocupacion);
            stmt.setInt(5, 0);
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
    public void agregar(LoggProfesor profesor) {
        try ( PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO profesores (email, password, idProfesor, ocupacion ) VALUES (?,md5(?),?,?)");) {
            stmt.setString(1, profesor.getEmail());
            stmt.setString(2, profesor.getPsswrd());
            stmt.setInt(3, profesor.getProfesor().getId());
            String ocupacion = ""+profesor.getPUESTO();
            stmt.setString(4, ocupacion);
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
        String sql="DELETE FROM logprofesores WHERE idProfesor=?";
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