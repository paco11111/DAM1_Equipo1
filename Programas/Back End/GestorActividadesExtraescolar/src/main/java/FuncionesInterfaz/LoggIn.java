/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FuncionesInterfaz;

import reto.gestoractividadesextraescolar.Teclado;

/**
 *
 * @author Francisco Sitjar
 */
public class LoggIn {
    private String email;
    private String psswrd;
    
    public LoggIn(){
        
        email = Teclado.email();
        psswrd = Teclado.nextString("");               
        
        
    }
    
    
    
    
    
}
