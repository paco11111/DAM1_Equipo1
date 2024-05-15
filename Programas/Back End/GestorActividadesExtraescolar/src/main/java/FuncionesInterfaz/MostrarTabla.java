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
import java.util.Map;
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
 * @author Francisco Sitjar, Izan Franco, Ciro Galan
 */
public class MostrarTabla {

    private static SolicitudDAO solicitudDAO = new SolicitudDAO();
    private static String[] solicitud = new String[21];
    private static List<Solicitud> solicitudes = new ArrayList<>();

    private static SolicitudAprobadaDAO solicitudAprobadaDAO = new SolicitudAprobadaDAO();
    private static String[] solicitudAprobada = new String[24];
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
        DefaultTableModel model = new DefaultTableModel();
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
            model.addColumn("Alojamiento");
            model.addColumn("Comentario Alojamiento");
            model.addColumn("Comentario Adicional");
            model.addColumn("Estado");
            model.addColumn("Comentario Estado");
            model.addColumn("Profesores Responsables");
            model.addColumn("Profesores Participantes");
            model.addColumn("Grupos");
            model.addColumn("Cursos");
            model.addColumn("NºAlumnos");
            for (Solicitud s : solicitudes) {
                solicitud[0] = String.valueOf(s.getId());
                solicitud[1] = s.getProfesorSolicitante().getNombre() + " " + s.getProfesorSolicitante().getApellidos();
                solicitud[2] = s.getActividad();
                solicitud[3] = s.getTIPOACTIVIDAD().name();
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
                solicitud[14] = s.getESTADO().name();
                solicitud[15] = s.getComentarioEstado();
                String pr = "";
                for (Map.Entry<Integer, Profesor> p : s.getProfesoresResponsables().entrySet()){
                    pr = p.getValue().getNombre() + " " + p.getValue().getApellidos() + ",";
                }
                solicitud[16] = pr;
                String pp = "";
                for (Map.Entry<Integer, Profesor> p : s.getProfesoresParticipantes().entrySet()){
                    pp = p.getValue().getNombre() + " " + p.getValue().getApellidos() + ",";
                }
                solicitud[17] = pp;
                String grupos = "";
                for (Map.Entry<Integer, Grupo> p : s.getGrupo().entrySet()){
                    pp = p.getValue().getCodigo()+ ", ";
                }
                solicitud[18] = grupos;
                String cursos = "";
                for (Map.Entry<Integer, Curso> p : s.getCurso().entrySet()){
                    pp = p.getValue().getCodigo()+ ",";
                }
                solicitud[19] = cursos;
                solicitud[20] = String.valueOf(s.getNumeroAlumnos());
                model.addRow(solicitud);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;

    }
    
    public static DefaultTableModel mostrarSolicitudResponsable(Profesor profesor) {
        DefaultTableModel model = new DefaultTableModel();
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
            model.addColumn("Alojamiento");
            model.addColumn("Comentario Alojamiento");
            model.addColumn("Comentario Adicional");
            model.addColumn("Estado");
            model.addColumn("Comentario Estado");
            model.addColumn("Profesores Responsables");
            model.addColumn("Profesores Participantes");
            model.addColumn("Grupos");
            model.addColumn("Cursos");
            model.addColumn("NºAlumnos");
            //PROFESORES RESOPONSABLES!!!!!!!!
            for (Solicitud s : solicitudes) {
                for(Map.Entry<Integer, Profesor> entry : s.getProfesoresResponsables().entrySet()){
                    if(entry.getValue().getNombre().equals(profesor.getNombre()) && entry.getValue().getApellidos().equals(profesor.getApellidos()) ){
                    solicitud[0] = String.valueOf(s.getId());
                    solicitud[1] = s.getProfesorSolicitante().getNombre() + " " + s.getProfesorSolicitante().getApellidos();
                    solicitud[2] = s.getActividad();
                    solicitud[3] = s.getTIPOACTIVIDAD().name();
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
                    solicitud[14] = s.getESTADO().name();
                    solicitud[15] = s.getComentarioEstado();
                    String pr = "";
                    for (Map.Entry<Integer, Profesor> p : s.getProfesoresResponsables().entrySet()){
                        pr = p.getValue().getNombre() + " " + p.getValue().getApellidos() + ",";
                    }
                    solicitud[16] = pr;
                    String pp = "";
                    for (Map.Entry<Integer, Profesor> p : s.getProfesoresParticipantes().entrySet()){
                        pp = p.getValue().getNombre() + " " + p.getValue().getApellidos() + ",";
                    }
                    solicitud[17] = pp;
                    String grupos = "";
                    for (Map.Entry<Integer, Grupo> p : s.getGrupo().entrySet()){
                        pp = p.getValue().getCodigo()+ ", ";
                    }
                    solicitud[18] = grupos;
                    String cursos = "";
                    for (Map.Entry<Integer, Curso> p : s.getCurso().entrySet()){
                        pp = p.getValue().getCodigo()+ ",";
                    }
                    solicitud[19] = cursos;
                    solicitud[20] = String.valueOf(s.getNumeroAlumnos());
                    model.addRow(solicitud);
                }
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;

    }

    public static DefaultTableModel mostrarSolicitudAprobada() {
        DefaultTableModel model = new DefaultTableModel();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy").withLocale(new Locale("es", "ES"));
        DateTimeFormatter t = DateTimeFormatter.ofPattern("' hh:mm").withLocale(new Locale("es", "ES"));
        solicitudesAprobadas = solicitudAprobadaDAO.listar();
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
            model.addColumn("Comentario Adicional");
            model.addColumn("Estado");
            model.addColumn("Comentario Estado");
            model.addColumn("Profesores Responsables");
            model.addColumn("Profesores Participantes");
            model.addColumn("Grupos");
            model.addColumn("Cursos");
            model.addColumn("NºAlumnos");
            model.addColumn("Informacion de Transporte");
            model.addColumn("Precio");
            model.addColumn("Comentario Actividad");
            
            for (SolicitudAprobada sa : solicitudesAprobadas) {
                solicitudAprobada[0] = String.valueOf(sa.getId());
                solicitudAprobada[1] = sa.getProfesorSolicitante().getNombre() + " " + sa.getProfesorSolicitante().getApellidos();
                solicitudAprobada[2] = sa.getActividad();
                solicitudAprobada[3] = sa.getTIPOACTIVIDAD().name();
                solicitudAprobada[4] = Utilidad.respuestaBoolean(sa.isPrevisto());
                solicitudAprobada[5] = Utilidad.respuestaMapa(sa.getTransporte());
                solicitudAprobada[6] = sa.getComentarioTransporte();
                solicitudAprobada[7] = sa.getFechaInicio().format(f);
                solicitudAprobada[8] = sa.getFechaFinal().format(f);
                solicitudAprobada[9] = sa.getHoraInicio().format(t);
                solicitudAprobada[10] = sa.getHoraFinal().format(t);
               solicitud[11] = Utilidad.respuestaBoolean(sa.isAlojamiento());
                solicitud[12] = sa.getComentarioAlojamiento();
                solicitud[13] = sa.getComentarioAdicional();
                solicitud[14] = sa.getESTADO().name();
                solicitud[15] = sa.getComentarioEstado();
                String pr = "";
                for (Map.Entry<Integer, Profesor> p : sa.getProfesoresResponsables().entrySet()){
                    pr = p.getValue().getNombre() + " " + p.getValue().getApellidos() + ",";
                }
                solicitud[16] = pr;
                String pp = "";
                for (Map.Entry<Integer, Profesor> p : sa.getProfesoresParticipantes().entrySet()){
                    pp = p.getValue().getNombre() + " " + p.getValue().getApellidos() + ",";
                }
                solicitud[17] = pp;
                String grupos = "";
                for (Map.Entry<Integer, Grupo> p : sa.getGrupo().entrySet()){
                    pp = p.getValue().getCodigo()+ ", ";
                }
                solicitud[18] = grupos;
                String cursos = "";
                for (Map.Entry<Integer, Curso> p : sa.getCurso().entrySet()){
                    pp = p.getValue().getCodigo()+ ",";
                }
                solicitud[19] = cursos;
                solicitud[20] = String.valueOf(sa.getNumeroAlumnos());
                solicitudAprobada[21] = sa.getInfoEmpresaTransporte();
                solicitudAprobada[22] = String.valueOf(sa.getImporteTransporte());
                solicitudAprobada[23] = sa.getComentarioActividad();

                model.addRow(solicitudAprobada);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;
    }

    public static DefaultTableModel mostrarGrupo() {
        DefaultTableModel model = new DefaultTableModel();
        grupos = grupoDAO.listar();
        try {
            model.addColumn("Id");
            model.addColumn("Código");
            model.addColumn("Curso codigo");
            model.addColumn("Numero de alumnos");
            model.addColumn("Activo");
            
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
        DefaultTableModel model = new DefaultTableModel();
        cursos = cursoDAO.listar();
        try {
            model.addColumn("Id");
            model.addColumn("Código");
            model.addColumn("Etapa");
            model.addColumn("Descripcion");
            model.addColumn("Activo");
            
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
        DefaultTableModel model = new DefaultTableModel();
        departamentos = departamentoDAO.listar();
        try {
            model.addColumn("Id");
            model.addColumn("Código"); 
            model.addColumn("Nombre");
            model.addColumn("Profesor Jefe");
            
            for (Departamento d : departamentos) {
                departamento[0] = String.valueOf(d.getId());
                departamento[1] = d.getCodigo();
                departamento[2] = d.getNombre();
                departamento[3] = d.getJefe().getNombre() + " " + d.getJefe().getApellidos();

                model.addRow(departamento);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;
    }

    public static DefaultTableModel mostrarProfesor() {
        DefaultTableModel model = new DefaultTableModel();
        profesores = profesorDAO.listar();
        try {
            model.addColumn("Id");
            model.addColumn("DNI");
            model.addColumn("Nombre");
            model.addColumn("Apellidos");
            model.addColumn("Departamento");
            model.addColumn("Activo");
            
            for (Profesor p : profesores) {
                profesor[0] = String.valueOf(p.getId());
                profesor[1] = p.getDni();
                profesor[2] = p.getNombre();
                profesor[3] = p.getApellidos();
                profesor[4] = p.getDepartamento().getCodigo();
                profesor[5] = Utilidad.respuestaBoolean(p.isActivo());

                model.addRow(profesor);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;
    }

}

