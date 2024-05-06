/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reto.gestoractividadesextraescolar.AccesoBaseDatos;
import reto.gestoractividadesextraescolar.Departamento;
import reto.gestoractividadesextraescolar.Repositorio;

/**
 *
 * @author Francisco Sitjar
 */
public class DepartamentoDAO implements Repositorio<Departamento>{
    
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Departamento> listar() {
        List<Departamento> departamentos = new ArrayList<>();
        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT idDepartamento, codigo,nombre, idProfesorJefe FROM departamentos");) {
            while (rs.next()) {
                Departamento departamento = crearDepartamento(rs);
                if (!departamentos.add(departamento)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
                 }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return departamentos;
    }
    
    private Departamento crearDepartamento(final ResultSet rs) throws SQLException {
        return new Departamento( rs.getInt("idDepartamento"),rs.getString("codigo"),rs.getString("nombre"), rs.getInt("idProfesorJefe"));
    }

    @Override
    public Departamento porId(int id) {
        Departamento departamento = null;
        String sql = "SELECT idDepartamento, codigo,nombre, idProfesorJefe FROM departamentos";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    departamento = crearDepartamento(rs);
                }else{
                    System.out.println("No hay profesor con tal id");
                }
            } 
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return departamento;
    }

    @Override
    public void modificar(Departamento departamento) {
        try ( PreparedStatement stmt = getConnection().prepareStatement("UPDATE departamentos SET codigo =?, nombre = ?, idProfesorJefe = ? WHERE idDepartamento=?");) {
            stmt.setString(1, departamento.getCodigo());
            stmt.setString(2, departamento.getNombre());
            stmt.setInt(3, departamento.getJefe());
            stmt.setInt(3, departamento.getId());
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
    public void agregar(Departamento departamento) {
        try ( PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO transporte (codigo,nombre, idProfesorJefe ) VALUES (?,?,?)");) {
            stmt.setString(1, departamento.getCodigo());
            stmt.setString(2, departamento.getNombre());
            stmt.setInt(3, departamento.getJefe());
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
        String sql="DELETE FROM departamentos WHERE idDepartamento=?";
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
