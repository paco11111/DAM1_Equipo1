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
 
    
    public static boolean validar(String email, String password){
        boolean valido = false;
        validar = new ArrayList<LoggProfesor>();
        loggProfesorDAO = new LoggProfesorDAO();
        validar = loggProfesorDAO.listar();
        try {
            /*for(LoggProfesor p : validar){
                if (p.getEmail().equals(email)) {

                    if (p.getPsswrd().equals(null)){
                        p.setPsswrd(JOptionPane.showInputDialog("Establezca su contraseña","password"));
                    }else if (p.getPsswrd().equals(password) && p.getEmail().equals(email)) {
                        valido = true;
                    }else{
                        JOptionPane.showMessageDialog(null,"Usuario o Contraseña incorrectos");
                    }
                }else{
                }
            }*/
            
        }catch(Exception e){
            e.getMessage();
        }             
        return valido;
    }    
}
