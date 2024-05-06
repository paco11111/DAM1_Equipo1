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
import reto.gestoractividadesextraescolar.Grupo;
import reto.gestoractividadesextraescolar.Repositorio;

/**
 *
 * @author Francisco Sitjar
 */
public class GrupoDAO implements Repositorio<Grupo>{
    
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    
    private Grupo crearGrupo(final ResultSet rs) throws SQLException {
        return new Grupo( rs.getInt("idGrupo"),rs.getString("codigo"),rs.getInt("numero_alumnos"),rs.getInt("Cursos_idCursos"),rs.getBoolean("activo"));
    }

    @Override
    public List<Grupo> listar() {
        List<Grupo> grupos = new ArrayList<>();
        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT idGrupo, codigo, numero_alumnos, Cursos_idCursos, activo FROM grupos");) {
            while (rs.next()) {
                Grupo grupo = crearGrupo(rs);
                if (!grupos.add(grupo)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
                 }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return grupos;
    }

    @Override
    public Grupo porId(int id) {
         Grupo grupo = null;
        String sql = "SELECT idGrupo, codigo, numero_alumnos, Cursos_idCursos, activo FROM grupos";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    grupo = crearGrupo(rs);
                }else{
                    System.out.println("No hay profesor con tal id");
                }
            } 
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return grupo;
    }

    @Override
    public void modificar(Grupo grupo) {
        try ( PreparedStatement stmt = getConnection().prepareStatement("UPDATE grupos SET codigo =?, numero_alumnos = ?, Cursos_idCursos = ?, activo = ? WHERE idGrupo=?");) {
            stmt.setString(1, grupo.getCodigo());
            stmt.setInt(2, grupo.getNumeroAlumnos());
            stmt.setInt(3, grupo.getIdC());
            stmt.setBoolean(4, grupo.isActivoGrupo());
            stmt.setInt(5, grupo.getIdGrupo());
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
    public void agregar(Grupo grupo) {
        try ( PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO grupos (codigo, numero_alumnos, Cursos_idCursos,activo ) VALUES (?,?,?,?)");) {
             stmt.setString(1, grupo.getCodigo());
            stmt.setInt(2, grupo.getNumeroAlumnos());
            stmt.setInt(3, grupo.getIdC());
            stmt.setBoolean(4, grupo.isActivoGrupo());
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
        String sql="DELETE FROM grupos WHERE idGrupo=?";
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
