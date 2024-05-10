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
import reto.gestoractividadesextraescolar.Repositorio;
import reto.gestoractividadesextraescolar.Transporte;

/**
 *
 * @author Francisco Sitjar
 */
public class TransporteDAO implements Repositorio<Transporte>{
    
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Transporte> listar() {
        List<Transporte> transportes = new ArrayList<>();
        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT idTransporte, Tipo_transporte, descripcion FROM transporte");) {
            while (rs.next()) {
                Transporte transporte = crearTransporte(rs);
                if (!transportes.add(transporte)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
                 }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return transportes;
    }
    
    private Transporte crearTransporte(final ResultSet rs) throws SQLException {
        return new Transporte( rs.getInt("idTransporte"),rs.getString("Tipo_transporte"),rs.getString("descripcion"));
    }

    @Override
    public Transporte porId(int id) {
        Transporte transporte = null;
        String sql = "SELECT idTransporte, Tipo_transporte, descripcion FROM transporte WHERE idTransporte = ?";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    transporte = crearTransporte(rs);
                }else{
                    System.out.println("No hay transporte con tal id");
                }
            } 
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return transporte;
    }

    @Override
    public void modificar(Transporte transporte) {
         try ( PreparedStatement stmt = getConnection().prepareStatement("UPDATE transporte SET Tipo_transporte =?, descripcion = ? WHERE idTransporte=?");) {
            stmt.setString(1, transporte.getTipo());
            stmt.setString(2, transporte.getDescripcion());
            stmt.setInt(3, transporte.getId());
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
    public void agregar(Transporte transporte) {
        try ( PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO transporte (Tipo_transporte, descripcion ) VALUES (?,?)");) {
            stmt.setString(1, transporte.getTipo());
            stmt.setString(2, transporte.getDescripcion());
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
        String sql="DELETE FROM transporte WHERE idTransporte=?";
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
