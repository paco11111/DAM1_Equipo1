/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Enumerados.PuestoProfesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reto.gestoractividadesextraescolar.AccesoBaseDatos;
import reto.gestoractividadesextraescolar.Departamento;
import reto.gestoractividadesextraescolar.Profesor;
import reto.gestoractividadesextraescolar.Repositorio;
import reto.gestoractividadesextraescolar.Teclado;

/**
 *
 * @author Francisco Sitjar
 */
public class ProfesorDAO implements Repositorio<Profesor>{
    private DepartamentoDAO departamentoDAO = new DepartamentoDAO(); 
    
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Profesor> listar() {
        List<Profesor> profesores = new ArrayList<>();
        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT * FROM profesores");) {
            while (rs.next()) {
                Profesor profesor = crearProfesor(rs);
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
    private Profesor crearProfesor(final ResultSet rs) throws SQLException {
        Departamento departamento= departamentoDAO.porId(rs.getInt("idDepartamento"));
        if(departamento !=null){
            System.out.println("funciona");
        }else{
            System.out.println("No funciona");
        }
        
        
        
        return new Profesor(rs.getInt("idProfesor"), 
                rs.getString("nombre"), 
                rs.getString("apellidos"), 
                rs.getString("DNI"), 
                rs.getString("email"), 
                rs.getString("ocupacion"), rs.getBoolean("activo"));
    }

    @Override
    public Profesor porId(int id) {
        Profesor profesor = null;
        String sql = "SELECT idProfesor, nombre, apellidos, DNI, email, idDepartamento, ocupacion, activo FROM profesores WHERE idProfesor=?";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    profesor = crearProfesor(rs);
                }else{
                    System.out.println("No hay profesor con tal id");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return profesor;
    }

    @Override
    public void modificar(Profesor profesor) {
        try ( PreparedStatement stmt = getConnection().prepareStatement("UPDATE profesores SET nombre =?, apellidos = ?, DNI = ?, email = ?, idDepartamento = ?, ocupacion = ?, activo = ? WHERE idProfesor=?");) {
            stmt.setString(1, profesor.getNombre());
            stmt.setString(2, profesor.getApellidos());
            stmt.setString(3, profesor.getDni());
            stmt.setString(4, profesor.getEmail());
            stmt.setInt(5, profesor.getDepartamento().getId());
            String puesto = ""+profesor.getPUESTO();
            stmt.setString(6, puesto);
            stmt.setBoolean(7, profesor.isActivo());
             stmt.setInt(8, profesor.getId());
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
    public void agregar(Profesor profesor){
        try ( PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO profesores (nombre,apellidos, DNI, email, idDepartamento, ocupacion, activo ) VALUES (?,?,?,?,?,?,?)");) {
            String pssw = Teclado.nextString("Inserta la contraseña: ");
            stmt.setString(1, profesor.getNombre());
            stmt.setString(2, profesor.getApellidos());
            stmt.setString(3, profesor.getDni());
            stmt.setString(4, profesor.getEmail());
            stmt.setInt(5, profesor.getDepartamento().getId());
            String puesto = ""+profesor.getPUESTO();
            stmt.setString(6, puesto);
            stmt.setBoolean(7, profesor.isActivo());
            try ( PreparedStatement stmt2 = getConnection().prepareStatement("INSERT INTO logprofesores (email, contraseña) VALUES (?,?)");){
                stmt2.setString(1, profesor.getEmail());
                stmt2.setString(2, pssw);
                int salida = stmt2.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha insertado/modificado un solo registro en logprofesores");
            }
                
            }
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
        String sql="DELETE FROM profesores WHERE idProfesor=?";
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
