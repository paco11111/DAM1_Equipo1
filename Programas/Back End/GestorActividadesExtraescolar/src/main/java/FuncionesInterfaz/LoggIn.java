/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FuncionesInterfaz;

import DAOs.LoggProfesorDAO;
import java.util.ArrayList;
import java.util.List;
import reto.gestoractividadesextraescolar.LoggProfesor;


/**
 *
 * @author Fabian Saiz Landeras
 */
public class LoggIn {
    private static List<LoggProfesor> validar;
    private static LoggProfesorDAO loggProfesorDAO;
 
    
    public static boolean validarEmail(String email){
        boolean valido = false;
        validar = new ArrayList<LoggProfesor>();
        loggProfesorDAO = new LoggProfesorDAO();
        validar = loggProfesorDAO.listar();
        try {
            for(LoggProfesor p : validar){
                if (p.getEmail().equals(email)) {
                    valido = true;
                }else{
                    
                }
            }
        }catch(Exception e){
            e.getMessage();
        }             
        return valido;        

    }


    /*public static boolean validarPasswrd(String password){
        boolean valida = false;
        LoggProfesorDAO login = new LoggProfesorDAO();
        try {
            List<LoggProfesor> validar = login.listar();
            Iterator it = validar.iterator();
            for(LoggProfesor p : validar){
                if (p.getPsswrd().equals(password)) {
                    valida = true;
                }else{
                    valida = false;
                }
            }
        }catch(Exception e){
            e.getMessage();
        }             
        return valida;        
    }*/
    
    
    
}
