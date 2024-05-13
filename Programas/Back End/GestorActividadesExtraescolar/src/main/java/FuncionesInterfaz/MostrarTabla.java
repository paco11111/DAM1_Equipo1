/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FuncionesInterfaz;

import DAOs.CursoDAO;
import DAOs.DepartamentoDAO;
import DAOs.GrupoDAO;
import DAOs.ProfesorDAO;
import DAOs.SolicitudAprobadaDAO;
import DAOs.SolicitudDAO;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import reto.gestoractividadesextraescolar.Curso;
import reto.gestoractividadesextraescolar.Departamento;
import reto.gestoractividadesextraescolar.Grupo;
import reto.gestoractividadesextraescolar.Profesor;
import reto.gestoractividadesextraescolar.Solicitud;
import reto.gestoractividadesextraescolar.SolicitudAprobada;
import reto.gestoractividadesextraescolar.Utilidad;

/**
 *
 * @author Francisco Sitjar
 */
public class MostrarTabla {

    private static DefaultTableModel model;
    private static SolicitudDAO solicitudDAO = new SolicitudDAO();
    private static String[] solicitud = new String[16];
    private static List<Solicitud> solicitudes = new ArrayList<>();

    private static SolicitudAprobadaDAO solicitudAprobadaDAO = new SolicitudAprobadaDAO();
    private static String[] solicitudAprobada = new String[19];
    private static List<SolicitudAprobada> solicitudesAprobadas = new ArrayList<>();

    private static GrupoDAO grupoDAO = new GrupoDAO();
    private static String[] grupo = new String[5];
    private static List<Grupo> grupos = new ArrayList<>();

    private static CursoDAO cursoDAO = new CursoDAO();
    private static String[] curso = new String[5];
    private static List<Curso> cursos = new ArrayList<>();

    private static DepartamentoDAO departamentoDAO = new DepartamentoDAO();
    private static String[] departamento = new String[4];
    private static List<Departamento> departamentos = new ArrayList<>();

    private static ProfesorDAO profesorDAO = new ProfesorDAO();
    private static String[] profesor = new String[6];
    private static List<Profesor> profesores = new ArrayList<>();

    
    public static DefaultTableModel mostrarSolicitud() {
        model = new DefaultTableModel();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy").withLocale(new Locale("es", "ES"));
        DateTimeFormatter t = DateTimeFormatter.ofPattern("hh:mm").withLocale(new Locale("es", "ES"));
        solicitudes = solicitudDAO.listar();
        try {
            model.addColumn("idSolicitud");
            model.addColumn("idProfesorSolicitante");
            model.addColumn("Actividad");
            model.addColumn("Tipo Actividad");
            model.addColumn("Previsto Programacion");
            model.addColumn("Transporte");
            model.addColumn("Comentario Transporte");
            model.addColumn("Fecha Inicio");
            model.addColumn("Fecha Final");
            model.addColumn("Hora Inicio");
            model.addColumn("Hora Final");
            model.addColumn("Comentario Alojamiento");
            model.addColumn("Comentario Adicional");
            model.addColumn("Estado");
            model.addColumn("Comentario Estado");

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
        return model;

    }

    public static DefaultTableModel mostrarSolicitudAprobada() {
        model = new DefaultTableModel();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy").withLocale(new Locale("es", "ES"));
        DateTimeFormatter t = DateTimeFormatter.ofPattern("' hh:mm").withLocale(new Locale("es", "ES"));
        solicitudesAprobadas = solicitudAprobadaDAO.listar();
        try {
            for (SolicitudAprobada sa : solicitudesAprobadas) {
                solicitud[0] = String.valueOf(sa.getId());
                solicitud[1] = sa.getProfesorSolicitante().getNombre() + " " + sa.getProfesorSolicitante().getApellidos();
                solicitud[2] = sa.getActividad();
                solicitud[3] = "" + sa.getTIPOACTIVIDAD();
                solicitud[4] = Utilidad.respuestaBoolean(sa.isPrevisto());
                solicitud[5] = Utilidad.respuestaMapa(sa.getTransporte());
                solicitud[6] = sa.getComentarioTransporte();
                solicitud[7] = sa.getFechaInicio().format(f);
                solicitud[8] = sa.getFechaFinal().format(f);
                solicitud[9] = sa.getHoraInicio().format(t);
                solicitud[10] = sa.getHoraFinal().format(t);
                solicitud[11] = Utilidad.respuestaBoolean(sa.isAlojamiento());
                solicitud[12] = sa.getComentarioAlojamiento();
                solicitud[13] = sa.getComentarioAdicional();
                solicitud[14] = "" + sa.getESTADO();
                solicitud[15] = sa.getComentarioEstado();
                solicitud[16] = sa.getInfoEmpresaTransporte();
                solicitud[17] = String.valueOf(sa.getImporteTransporte());
                solicitud[18] = sa.getComentarioActividad();

                model.addRow(solicitudAprobada);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;
    }

    public static DefaultTableModel mostrarGrupo() {
        model = new DefaultTableModel();
        grupos = grupoDAO.listar();
        try {
            for (Grupo g : grupos) {
                grupo[0] = String.valueOf(g.getId());
                grupo[1] = g.getCodigo();
                grupo[2] = g.getCurso().getCodigo();
                grupo[3] = String.valueOf(g.getNumeroAlumnos());
                grupo[4] = Utilidad.respuestaBoolean(g.isActivoGrupo());

                model.addRow(grupo);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;
    }

    public static DefaultTableModel mostrarCurso() {
        model = new DefaultTableModel();
        cursos = cursoDAO.listar();
        try {
            for (Curso c : cursos) {
                curso[0] = String.valueOf(c.getId());
                curso[1] = c.getCodigo();
                curso[2] = c.getEtapa().name();
                curso[3] = c.getDescripcion();
                curso[4] = Utilidad.respuestaBoolean(c.isActivoCurso());

                model.addRow(curso);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;
    }

    public static DefaultTableModel mostrarDepartamento() {
        model = new DefaultTableModel();
        departamentos = departamentoDAO.listar();
        try {
            for (Departamento d : departamentos) {
                curso[0] = String.valueOf(d.getId());
                curso[1] = d.getCodigo();
                curso[2] = d.getNombre();
                curso[3] = d.getJefe().getNombre() + " " + d.getJefe().getApellidos();

                model.addRow(departamento);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;
    }

    public static DefaultTableModel mostrarProfesor() {
        model = new DefaultTableModel();
        profesores = profesorDAO.listar();
        try {
            for (Profesor p : profesores) {
                curso[0] = String.valueOf(p.getId());
                curso[1] = p.getDni();
                curso[2] = p.getNombre();
                curso[3] = p.getApellidos();
                curso[4] = p.getDepartamento().getNombre();
                curso[5] = Utilidad.respuestaBoolean(p.isActivo());

                model.addRow(profesor);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;
    }

}

