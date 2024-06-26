/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.gestoractividadesextraescolar;

import Enumerados.EstadoSolicitud;
import Enumerados.EtapaCurso;
import Enumerados.PuestoProfesor;
import Enumerados.TipoActividad;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco Sitjar
 */
public class Utilidad {

    public static String nextString(String texto) {
        System.out.println(texto);
        return new Scanner(System.in).nextLine();
    }

    public static int nextInt(String texto) {
        boolean salir = false;
        int temp = 0;
        do {
            try {
                System.out.println(texto);
                temp = new Scanner(System.in).nextInt();
                salir = true;
            } catch (InputMismatchException a) {
                System.out.println("Error: no se ha introducido un entero");
            }

        } while (!salir);
        return temp;
    }

    public static double nextDouble(String texto) {
        boolean salir = false;
        double temp = 0;
        do {
            try {
                System.out.println(texto);
                temp = new Scanner(System.in).nextDouble();
                salir = true;
            } catch (InputMismatchException a) {
                System.out.println("Error: no se ha introducido un numero");
            }
        } while (!salir);

        return temp;
    }

    public static boolean nextBolean(String cadena) {
        boolean temp = false;
        boolean salir = false;
        Scanner teclado = new Scanner(System.in);
        String x;
        do {
            try {
                System.out.println(cadena + " (Si/No)");
                System.out.println();
                x = teclado.nextLine();
                if (x.equalsIgnoreCase("Si") || x.equalsIgnoreCase("S")) {
                    temp = true;
                    salir = true;
                } else if (x.equalsIgnoreCase("No") || x.equalsIgnoreCase("N")) {
                    temp = false;
                    salir = true;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error: respuesta no valida");
            }
        } while (!salir);
        return temp;
    }
    

    public static LocalDate fecha(String texto) {
        System.out.print(texto);
        int dia = nextInt("Introduce el dia: ");
        int mes = nextInt("Introduce el mes: ");
        int anio = nextInt("Introduce el año: ");
        LocalDate temp = LocalDate.now();
        try {
            temp = LocalDate.of(dia, mes, anio);
        } catch (DateTimeException a) {
            System.out.println("Error: Los datos no son validos para el formato de fecha");
        }
        return temp;
    }
    public static LocalTime hora(String texto) {
        System.out.print(texto);
        int hora = nextInt("Introduce la hora: ");
        LocalTime temp = LocalTime.now();
        try {
            temp = LocalTime.of(hora, 0, 0);
        } catch (DateTimeException a) {
            System.out.println("Error: Los datos no son validos para el formato de hora");
        }
        return temp;
    }


    private static boolean letraDni(String dni) {
        int numDni = Integer.parseInt(dni.substring(0, 8));
        boolean valido = false;
        int resto;
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        resto = numDni % 23;
        if (letras[resto] == dni.charAt(8)) {
            valido = true;
        }
        return valido;
    }

    public static String dni(String temp) {
        boolean valido = false;
        while (!valido) {
            if (temp.matches("[0-9]{8}[A-Z]") && letraDni(temp)) {
                valido = true;
            } else {
                JOptionPane.showMessageDialog(null,"DNI no valido");
            }
        }
        return temp;

    }

    public static String generarDNI() {
        int numDNI = (int) (Math.random() * 99999999);

        String[] letrasDNI = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        int indiceLetra = numDNI % 23;
        String letraDNI = letrasDNI[indiceLetra];

        String dni = String.format("%08d%s", numDNI, letraDNI);

        return dni;
    }

    public static String email() {
        String temp = "";
        boolean salir = false;
        do {
            temp = Utilidad.nextString("Email: ");
            if (temp.contains("@")) {
                salir = true;
            } else {
                System.out.println("Email no valido, vuelva a intentarlo.");
            }
        } while (!salir);

        return temp;
    }
    
    public static int id(String texto){
       boolean salir = false;
        int temp = 0;
        do {
            try {
                System.out.println(texto);
                temp = new Scanner(System.in).nextInt();
                salir = true;
            } catch (InputMismatchException a) {
                System.out.println("Error: no se ha introducido un entero");
            }

        } while (!salir);
        return temp;
    }

    public static PuestoProfesor puesto() {
        int opc;
        PuestoProfesor puesto = null;
        boolean salir = false;

        do {
            opc = Utilidad.nextInt("Puesto del profesor: \n1.-Super Usuario\n2.-Administrador\n3.-Equipo Directivo\n4.-Profesor");
            switch (opc) {
                case 1 -> {
                    puesto = PuestoProfesor.SUPERUSUARIO;
                    salir = true;
                }
                case 2 -> {
                    puesto = PuestoProfesor.ADMINISTRADOR;
                    salir = true;
                }
                case 3 -> {
                    puesto = PuestoProfesor.EQUIPO_DIRECTIVO;
                    salir = true;
                }
                case 4 -> {
                    puesto = PuestoProfesor.PROFESOR;
                    salir = true;
                }
                default ->
                    System.out.println("Opcion no valida4");
            }

        } while (!salir);
        
        return puesto;

    }
    
    public static TipoActividad tipoActividad(){
        TipoActividad actividad = null;
        boolean salir = false;
        do {
            int opc = Utilidad.nextInt("Tipo de actividad:       1-Extraescolar      2-Complementaria");
            if(opc == 1){
                actividad = TipoActividad.EXTRAESCOLAR;
                salir = true;
            }else if (opc == 2){
                actividad = TipoActividad.COMPLEMENTARIA;
                salir = true;
            }else{
                System.out.println("Opción no valida");
            }
        } while (!salir);

        return actividad;
    }
    
    public static EstadoSolicitud estado(){
        int opc;
        EstadoSolicitud estado = null;
        boolean salir = false;

        do {
            opc = Utilidad.nextInt("Estado de la actividad: \n1.-Solicitada\n2.-Aprobada\n3.-Denegada\n4.-Realizada");
            switch (opc) {
                case 1 -> {
                    estado = EstadoSolicitud.SOLICITADA;
                    salir = true;
                }
                case 2 -> {
                    estado = EstadoSolicitud.APROBADA;
                    salir = true;
                }
                case 3 -> {
                    estado = EstadoSolicitud.DENEGADA;
                    salir = true;
                }
                case 4 -> {
                    estado = EstadoSolicitud.REALIZADA;
                    salir = true;
                }
                default ->
                    System.out.println("Opcion no valida5");
            }

        } while (!salir);
        
        return estado;
    }
    public static EtapaCurso etapaCurso(){
        int opc;
        EtapaCurso etapa = null;
        boolean salir = false;

        do {
            opc = Utilidad.nextInt("Etapa del curso: \n1.-ESO\n2.-Bachillerato\n3.-FP Basica\n4.-FP grado medio\n5.-FP grado superior\n6.-FP curso especializacion: ");
            switch (opc) {
                case 1 -> {
                    etapa = EtapaCurso.ESO;
                    salir = true;
                }
                case 2 -> {
                    etapa = EtapaCurso.BACHILLERATO;
                    salir = true;
                }
                case 3 -> {
                    etapa = EtapaCurso.FPB;
                    salir = true;
                }
                case 4 -> {
                    etapa = EtapaCurso.FPGM;
                    salir = true;
                }
                case 5 -> {
                    etapa = EtapaCurso.FPGS;
                    salir = true;
                }
                case 6 -> {
                    etapa = EtapaCurso.FPCE;
                    salir = true;
                }
                default ->
                    System.out.println("Opcion no valida6");
            }

        } while (!salir);
        
        return etapa;
    }
    
    public static String codigoGrupo() {
        String temp = "";
        boolean salir = false;
        do {
            temp = Utilidad.nextString("Codigo del curso (No puede tener mas de 8 caracteres): ");
            if (temp.length() <= 8) {
                salir = true;
            } else {
                System.out.println("Curso no valido, vuelva a intentarlo.");
            }
        } while (!salir);

        return temp;
    }
    
    public static String codigoCurso() {
        String temp = "";
        boolean salir = false;
        do {
            temp = Utilidad.nextString("Codigo del curso (No puede tener mas de 5 caracteres): ");
            if (temp.length() <= 5) {
                salir = true;
            } else {
                System.out.println("Curso no valido, vuelva a intentarlo.");
            }
        } while (!salir);

        return temp;
    }
    
    public static String codigoDepartamento() {
        String temp = "";
        boolean salir = false;
        do {
            temp = Utilidad.nextString("Codigo de Departamento (3 caracteres en mayuscula): ");
            if (temp.matches("[A-Z]{3}")) {
                salir = true;
            } else {
                System.out.println("El codigo debe cumplir los requisitos.");
            }
        } while (!salir);

        return temp;
    }
    
    public static String respuestaBoolean(boolean temp){
        String texto = "";
        if(temp){
            texto = "Si";
        }else{
            texto = "No";
        }
        return texto;
    }
    
   public static String respuestaMapa(TreeMap <Integer, Object> temp){
       String texto = "";
        if(temp.isEmpty()){
            texto = "No";
        }else{
            texto = "Si";
        }
        return texto;
       
       
   }

}
