/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Enumerados.EtapaCurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reto.gestoractividadesextraescolar.AccesoBaseDatos;
import reto.gestoractividadesextraescolar.Curso;
import reto.gestoractividadesextraescolar.Repositorio;

/**
 *
 * @author Francisco Sitjar
 */
public class CursoDAO implements Repositorio<Curso>{
    
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    
     

    @Override
    public List<Curso> listar() {
        List<Curso> cursos = new ArrayList<>();
        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT * FROM cursos");) {
            while (rs.next()) {
                Curso curso = crearCurso(rs);
                if (!cursos.add(curso)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
                 }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cursos;
    }
    
    private Curso crearCurso(final ResultSet rs) throws SQLException {
        
        return new Curso( rs.getInt("idCurso"),rs.getString("codigo"),rs.getString("etapa"), rs.getString("descripcion"),rs.getBoolean("activo"));
    }

    @Override
    public Curso porId(int id) {
        Curso curso = null;
        String sql = "SELECT idCurso, codigo, descripcion, etapa, activo FROM cursos WHERE idCurso = ?";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    curso = crearCurso(rs);
                }else{
                    System.out.println("No hay curso con tal id");
                }
            } 
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return curso;
    }
    
    public Curso porCodigo(String codigo) {
        Curso curso = null;
        String sql = "SELECT idCurso, codigo, descripcion, etapa, activo FROM cursos WHERE codigo = ?";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setString(1, codigo);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    curso = crearCurso(rs);
                }else{
                    System.out.println("No hay curso con tal id");
                }
            } 
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return curso;
    }

    @Override
    public void modificar(Curso curso) {
         try ( PreparedStatement stmt = getConnection().prepareStatement("UPDATE cursos SET codigo =?, descripcion = ?, etapa = ?, activo = ? WHERE idCurso=?");) {
            stmt.setString(1, curso.getCodigo());
            stmt.setString(2, curso.getDescripcion());
            stmt.setString(3, curso.getEtapa().name());
            stmt.setBoolean(4, curso.isActivoCurso());
            stmt.setInt(5, curso.getId());
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
    public void agregar(Curso curso) {
        try ( PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO cursos (codigo, descripcion,etapa, activo ) VALUES (?,?,?,?)");) {
             stmt.setString(1, curso.getCodigo());
            stmt.setString(2, curso.getDescripcion());
            stmt.setString(3, curso.getEtapa().name());
            stmt.setBoolean(4, curso.isActivoCurso());
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
        String sql="DELETE FROM cursos WHERE idCurso=?";
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
