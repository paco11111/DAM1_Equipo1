/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FuncionesInterfaz;

import DAOs.LoggProfesorDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import reto.gestoractividadesextraescolar.LoggProfesor;

/**
 *
 * @author Fabian Saiz Landeras
 */
public class LoggIn {

    private static List<LoggProfesor> validar;
    private static LoggProfesorDAO loggProfesorDAO;

    /*   
    public static boolean validar(String email){
        boolean valido = false;
        loggProfesorDAO = new LoggProfesorDAO();
        validar = loggProfesorDAO.listar();
        for(LoggProfesor p : validar){
                if (p.getEmail().equals(email)) {
                    valido = true;
                }else{
                    System.out.println("FALSE");
                }

                    
    } 
        return valido;
    }
    
     */
    public static boolean validar(String email, String password) {
        boolean valido = false;
        String psswrd = null;
        String psswrd2;
        validar = new ArrayList<LoggProfesor>();
        loggProfesorDAO = new LoggProfesorDAO();
        validar = loggProfesorDAO.listar();
        try {
            for (LoggProfesor p : validar) {
                System.out.println(p.getPsswrd());
                if (p.getEmail().equals(email) && p.getPsswrd() == null) {
                    do {
                        psswrd = JOptionPane.showInputDialog("Inserta la contraseña que vas a usar: ");
                        psswrd2 = JOptionPane.showInputDialog("Repite la contraseña: ");
                    } while (!psswrd.equals(psswrd2));
                    p.setPsswrd(psswrd);
                    loggProfesorDAO.modificar(p);
                    JOptionPane.showMessageDialog(null, "Contraseña guardada correctamente:");
                    valido = true;
                } else if (p.getEmail().equals(email) && p.getPsswrd().equals(password)) {
                    valido = true;
                }
            }
            

        } catch (Exception e) {
            e.getMessage();
        }
        return valido;
    }

}
