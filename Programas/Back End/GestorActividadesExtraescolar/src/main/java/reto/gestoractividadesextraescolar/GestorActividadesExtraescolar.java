/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package reto.gestoractividadesextraescolar;

import DAOs.DepartamentoDAO;
import DAOs.ProfesorDAO;
import DAOs.SolicitudDAO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TreeMap;





/**
 *
 * @author Francisco Sitjar
 */
public class GestorActividadesExtraescolar {
     
    public static void main(String[] args) {
        SolicitudDAO sol = new SolicitudDAO();
        ProfesorDAO p = new ProfesorDAO();
        Profesor pro = p.porId(1);
        /*DepartamentoDAO d = new DepartamentoDAO();
        TreeMap <Integer, Transporte> t = new TreeMap <Integer, Transporte>();
        TreeMap <Integer, Profesor> mapa1 = new TreeMap <Integer, Profesor>();
        TreeMap <Integer, Profesor> mapa2 = new TreeMap <Integer, Profesor>();
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        Solicitud temp = new Solicitud(p.porId(1), "Temporal", "COMPLEMENTARIA", d.porId(9), false, t, "Se mueve", date, date,time, time, true, "No", "No hay", "SOLICITADA", "No hay comentario", mapa1, mapa2);
        sol.agregar(temp);*/
      
    }
}
