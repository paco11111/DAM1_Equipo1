/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FuncionesInterfaz;

import DAOs.SolicitudDAO;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import reto.gestoractividadesextraescolar.Solicitud;
import reto.gestoractividadesextraescolar.Utilidad;

/**
 *
 * @author Francisco Sitjar
 */
public class MostrarTabla {

    private static DefaultTableModel model = new DefaultTableModel();
    private static SolicitudDAO solicitudDAO = new SolicitudDAO();
    private static String[] solicitud = new String[16];
    private static List<Solicitud> solicitudes = new ArrayList<>();

    public static void mostrarSolicitud() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd '-' MMMM '-' yyyy '").withLocale(new Locale("es", "ES"));
        DateTimeFormatter t = DateTimeFormatter.ofPattern("' hh:mm").withLocale(new Locale("es", "ES"));
        solicitudes = solicitudDAO.listar();
        try {
            for (Solicitud s : solicitudes) {
                solicitud[0] = String.valueOf(s.getId());
                solicitud[1] = s.getProfesorSolicitante().getNombre() + " " + s.getProfesorSolicitante().getApellidos();
                solicitud[2] = s.getActividad();
                solicitud[3] = "" + s.getTIPOACTIVIDAD();
                solicitud[4] = Utilidad.respuestaBoolean(s.isPrevisto());
                solicitud[5] = Utilidad.respuestaMapa(s.getTransporte());
                solicitud[6] = s.getComentarioTransporte();
                solicitud[7] = s.getFechaInicio().format(f);
                solicitud[8] = s.getFechaFinal().format(f);
                solicitud[9] = s.getHoraInicio().format(t);
                solicitud[10] = s.getHoraFinal().format(t);
                solicitud[11] = Utilidad.respuestaBoolean(s.isAlojamiento());
                solicitud[12] = s.getComentarioAlojamiento();
                solicitud[13] = s.getComentarioAdicional();
                solicitud[14] = "" + s.getESTADO();
                solicitud[15] = s.getComentarioEstado();
                
                model.addRow(solicitud);
            }

        } catch (Exception e) {
            e.getMessage();
        }

    }

}
