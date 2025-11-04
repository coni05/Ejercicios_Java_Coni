import javax.swing.JOptionPane;

import clases.CitaMedica;
import clases.ModeloDatos;
import clases.Paciente;
import clases_empleado.EmpleadoEventual;
import clases_empleado.EmpleadoPlantilla;
import clases_empleado.Medico;

public class Procesos {

    ModeloDatos miModeloDatos;

    public Procesos() {
        miModeloDatos = new ModeloDatos();
        presentarMenuOpciones();
    }

    private void presentarMenuOpciones() {

        String menu = "MENU HOSPITAL\n\n";
        menu += "1. Registrar Paciente\n";
        menu += "2. Registrar Empleado\n";
        menu += "3. Registrar Cita Medica\n";
        menu += "4. Imprimir Información\n";
        menu += "5. Consultar persona por Documento\n";
        menu += "6. Salir\n\n";
        menu += "Ingrese una opción\n";

        int opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1:
                    registrarPaciente();
                    break;
                case 2:
                    registrarEmpleado();
                    break;
                case 3:
                    registrarCitaMedica();
                    break;
                case 4:
                    imprimirInformacion();
                    break;
                case 5:
                    consultarPersona();
                    break;
                case 6:
                    System.err.println("El sistema ha terminado!");
                    break;
                default:
                    System.err.println("No existe el código, verifique nuevamente");
                    break;
            }
        } while (opcion != 6);
    }

    private void registrarPaciente() {
        Paciente miPaciente = new Paciente();
        miPaciente.registrarDatos();

        miModeloDatos.registrarPersona(miPaciente);
    }

    private void registrarEmpleado() {
        String menuTipoEmpleado = "Registro de Empleado\n";
        menuTipoEmpleado += "1. Empleado Eventual\n";
        menuTipoEmpleado += "2. Empleado por Plantilla\n";
        menuTipoEmpleado += "Seleccione el tipo de empleado a registrar\n";

        int tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));

        switch (tipoEmpleado) {
            case 1: // Registro Empleado Eventual
                EmpleadoEventual miEmpleadoEventual = new EmpleadoEventual();
                miEmpleadoEventual.registrarDatos();
                miModeloDatos.registrarPersona(miEmpleadoEventual);
                break;
            case 2:
                String resp = JOptionPane
                        .showInputDialog("Ingrese si, si es un médico, de lo contrario es otro de empleado");
                if (resp.equalsIgnoreCase("si")) {
                    // Registro Medico
                    Medico miMedico = new Medico();
                    miMedico.registrarDatos();
                    miModeloDatos.registrarPersona(miMedico);
                } else {
                    // Registrar Empleado Plantilla
                    EmpleadoPlantilla miEmpleadoPlantilla = new EmpleadoPlantilla();
                    miEmpleadoPlantilla.registrarDatos();
                    miModeloDatos.registrarPersona(miEmpleadoPlantilla);
                }
                break;

            default:
                System.out.println("El tipo de empleado no es valido, intentelo nuevamente");
                break;
        }
    }

    private void registrarCitaMedica() {
        String documentoPaciente = JOptionPane.showInputDialog("Ingrese el documento del paciente");

        Paciente pacienteEncontrado = miModeloDatos.consultarPacientePorDocumento(documentoPaciente);

        if (pacienteEncontrado != null) {
            String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del médico");
            Medico medicoEncontrado = miModeloDatos.consultarMedicoPorNombre(nombreMedico);

            if (medicoEncontrado != null) {
                String servicio = JOptionPane.showInputDialog("Ingrese el servicio o motivo de la consulta");
                String fechaConsulta = JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
                String horaConsulta = JOptionPane.showInputDialog("Ingrese la hora de la consulta");

                String lugar = "La cita será en el consultorio " + medicoEncontrado.getNumeroDeConsultorio();
                CitaMedica miCita = new CitaMedica(pacienteEncontrado, medicoEncontrado, servicio, fechaConsulta,
                        horaConsulta, lugar);
                miModeloDatos.registrarCitaMedica(miCita);
            } else {
                System.out.println("El medico no se encuentra registrado en el sistema");
            }
        } else {
            System.out.println("El paciente no se encuentra registrado en el sistema");
        }
    }

    private void consultarPersona() {
        String menuConsulta = "CONSULTAS DISPONIBLES\n";
        menuConsulta += "1. Consultar Paciente\n";
        menuConsulta += "2. Consultar Médico\n";
        menuConsulta += "3. Consultar Empleado Eventual\n";
        menuConsulta += "4. Consultar Empleado por Planilla\n";
        menuConsulta += "Ingrese una opción\n";

        int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuConsulta));
        String documento = JOptionPane.showInputDialog("Ingrese el documento a consultar:");

        switch (opcion) {
            case 1:
                Paciente paciente = miModeloDatos.consultarPacientePorDocumento(documento);
                if (paciente != null)
                    paciente.imprimirDatosPersona("Paciente encontrado:\n");
                break;
            case 2:
                Medico medico = miModeloDatos.consultarMedicoPorDocumento(documento);
                if (medico != null)
                    medico.imprimirDatosPersona("Médico encontrado:\n");
                break;
            case 3:
                EmpleadoEventual empEv = miModeloDatos.consultarEmpleadoEventualPorDocumento(documento);
                if (empEv != null)
                    empEv.imprimirDatosPersona("Empleado Eventual encontrado:\n");
                break;
            case 4:
                EmpleadoPlantilla empPl = miModeloDatos.consultarEmpleadoPorPlantillaPorDocumento(documento);
                if (empPl != null)
                    empPl.imprimirDatosPersona("Empleado por Planilla encontrado:\n");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    private void imprimirInformacion() {

        String menuImprimir = "MENU IMPRESIONES\n";
        menuImprimir += "1. Listar Pacientes\n";
        menuImprimir += "2. Listar Empleados Eventuales\n";
        menuImprimir += "3. Listar Empleados Por Planilla\n";
        menuImprimir += "4. Listar Medicos\n";
        menuImprimir += "5. Listar Citas Programdas\n";
        menuImprimir += "Ingrese una opcion\n";

        System.out.println("***************************************************************************");

        int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));

        switch (opcion) {
            case 1:
                miModeloDatos.imprimirPacientes();
                break;
            case 2:
                miModeloDatos.imprimirEmpleadosEventuales();
                break;
            case 3:
                miModeloDatos.imprimirEmpledosPorPlantilla();
                break;
            case 4:
                miModeloDatos.imprimirMedicos();
                break;
            case 5:
                miModeloDatos.imprimirCitasMedicasProgramadas();
                break;
            default:
                System.out.println("No existe esa opción");
                break;
        }
    }
}