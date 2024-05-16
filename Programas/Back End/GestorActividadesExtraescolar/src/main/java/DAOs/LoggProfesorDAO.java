/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import reto.gestoractividadesextraescolar.LoggProfesor;
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
        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT email, password, profesores.idProfesor, ocupacion, profesores.nombre as profesor, apellidos,DNI,profesores.idDepartamento,activo, codigo, departamentos.nombre, idProfesorJefe FROM logprofesores INNER JOIN profesores ON logprofesores.idProfesor = profesores.idProfesor INNER JOIN departamentos ON profesores.idDepartamento= departamentos.idDepartamento");) {

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
        String sql = "SELECT logprofesores.idProfesor, nombre, apellidos,DNI,idDepartamento,ocupacion,activo, email, password FROM profesores INNER JOIN logprofesores ON profesores.idProfesor= profesores.idProfesor WHERE logprofesores.idProfesor=?";
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
    public LoggProfesor porEmail(String email) {
        LoggProfesor profesor = null;
        String sql = "SELECT logprofesores.idProfesor, nombre, apellidos,DNI,idDepartamento,ocupacion,activo, email, password FROM profesores INNER JOIN logprofesores ON profesores.idProfesor= profesores.idProfesor WHERE logprofesores.email=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setString(1, email);
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
    
    public String devolverPsswrd(String password) {
        String temp = "";
        String sql = "SELECT md5(?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setString(1, password);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    temp = rs.getString(1);
                } else {
                    System.out.println("No hay profesor usuario con tal id");
                }
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return temp;
    }

    @Override
    public void modificar(LoggProfesor profesor) {
        try ( PreparedStatement stmt = getConnection().prepareStatement("UPDATE logprofesores SET email = ?, password = md5(?), idProfesor = ?, ocupacion = ? WHERE idProfesor=?");) {
            stmt.setString(1, profesor.getEmail());
            stmt.setString(2, profesor.getPsswrd());
            stmt.setInt(3, profesor.getProfesor().getId());
            stmt.setString(4, profesor.getPUESTO().name());
            stmt.setInt(5, profesor.getProfesor().getId());
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
        try ( PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO logprofesores (email,password,idProfesor,ocupacion) VALUES (?,md5(?),?,?)");) {
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
