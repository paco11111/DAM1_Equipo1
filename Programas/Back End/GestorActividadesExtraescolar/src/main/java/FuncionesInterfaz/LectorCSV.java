/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FuncionesInterfaz;

import DAOs.DepartamentoDAO;
import DAOs.LoggProfesorDAO;
import DAOs.ProfesorDAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import reto.gestoractividadesextraescolar.Departamento;
import reto.gestoractividadesextraescolar.LoggProfesor;
import reto.gestoractividadesextraescolar.Profesor;



/**
 *
 * @author Francisco Sitjar
 */
public class LectorCSV {
    private static BufferedReader reader = null;
    private static String line = "";
    private static ProfesorDAO profesorDAO = new ProfesorDAO();
    private static LoggProfesorDAO loggProfesorDAO = new LoggProfesorDAO();
    private static DepartamentoDAO departamentoDAO = new DepartamentoDAO();
    private static int index = 1;
    
    public static void lectorCSV(String file){
        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while((line = reader.readLine()) != null){
             //String[] linea = new String[5];
             String[] linea = line.split(",");
             Departamento d = departamentoDAO.porId(Integer.parseInt(linea[4]));
             Profesor p = new Profesor(linea[1], linea[0], linea[2], d);
             profesorDAO.agregar(p);
             LoggProfesor logp = new LoggProfesor(profesorDAO.porId(index), linea[3]);
             loggProfesorDAO.agregar(logp);
             index++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    
    
    
    
    
}
