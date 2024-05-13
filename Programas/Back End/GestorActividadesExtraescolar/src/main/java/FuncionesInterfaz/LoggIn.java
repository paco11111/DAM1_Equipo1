/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FuncionesInterfaz;

import reto.gestoractividadesextraescolar.Utilidad;

/**
 *
 * @author Francisco Sitjar
 */
public class LoggIn {
    private String email;
    private String psswrd;
    
<<<<<<< Updated upstream
    public LoggIn(){
        
        email = Utilidad.email();
        psswrd = Utilidad.nextString("");               
        
        
=======
    
    public static boolean validarEmail(String email){
        boolean valido = false;
        validar = new ArrayList<LoggProfesor>();
        loggProfesorDAO = new LoggProfesorDAO();
        validar = loggProfesorDAO.listar();
        try {
            for(LoggProfesor p : validar){
                if (p.getEmail().equals(email)) {
                    System.out.println("TRUE");
                    System.out.println(p.getEmail());
                    valido = true;
                }else{
                    System.out.println("FALSE");
                }
            }
        }catch(Exception e){
            e.getMessage();
        }             
        return valido;        
>>>>>>> Stashed changes
    }
    
    
    
    
    
}
