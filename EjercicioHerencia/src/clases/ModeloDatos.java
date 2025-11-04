package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import clases_empleado.EmpleadoEventual;
import clases_empleado.EmpleadoPlantilla;
import clases_empleado.Medico;


public class ModeloDatos {
    
    HashMap<String, Paciente> pacientesMap;
    HashMap<String, EmpleadoPlantilla> empleadosPlanillaMap;
    HashMap<String, EmpleadoEventual> empleadoEventualMap;
    HashMap<String, Medico> medicosMap;
    ArrayList<CitaMedica> citasList;

    public ModeloDatos(){
        pacientesMap = new HashMap<String, Paciente>();
        empleadosPlanillaMap = new HashMap<String, EmpleadoPlantilla>();
        medicosMap = new HashMap<String, Medico>();
        empleadoEventualMap = new HashMap<String, EmpleadoEventual>();
        citasList=new ArrayList<CitaMedica>();
    }

    public void registrarPersona(Paciente miPaciente) {
        String dni = miPaciente.geNumeroDeDNI();

        if(pacientesMap.containsKey(dni)) {
            System.out.println("El paciente ya está registrado.");
            return;
        }
        pacientesMap.put(dni, miPaciente);
        System.out.println("Paciente registrado satisfactoriamente.");
    }

    public void registrarPersona(EmpleadoPlantilla miEmpPlantilla){
        String dni = miEmpPlantilla.geNumeroDeDNI();

        if(empleadosPlanillaMap.containsKey(dni)) {
            System.out.println("El empleado por plantilla ya está registrado.");
            return;
        }
        empleadosPlanillaMap.put(dni, miEmpPlantilla);
        System.out.println("Empleado por plantilla registrado satisfactoriamente.");
    }

    public void registrarPersona(EmpleadoEventual miEmpEventual) {
        String dni = miEmpEventual.geNumeroDeDNI();

        if(empleadoEventualMap.containsKey(dni)) {
            System.out.println("El empleado eventual ya está registrado.");
            return;
        }
        empleadoEventualMap.put(dni, miEmpEventual);
        System.out.println("Empleado eventual registrado satisfactoriamente.");
    }

    public void registrarPersona(Medico miMedico) {
        String dni = miMedico.geNumeroDeDNI();
        
        if(medicosMap.containsKey(dni)) {
            System.out.println("El medico ya está registrado.");
            return;
        }
        medicosMap.put(dni, miMedico);
        System.out.println("Medico registrado satisfactoriamente.");
    }

    public Paciente consultarPacientePorDocumento(String documento) {
        if (pacientesMap.containsKey(documento)) {
            return pacientesMap.get(documento);
        } else {
            System.out.println("No se encontró ningún paciente");
            return null;
        }
    }

    public EmpleadoEventual consultarEmpleadoEventualPorDocumento(String documento) {
        if (empleadoEventualMap.containsKey(documento)) {
            return empleadoEventualMap.get(documento);
        } else {
            System.out.println("No se encontró ningún empleado eventual");
            return null;
        }
    }

    public EmpleadoPlantilla consultarEmpleadoPorPlantillaPorDocumento(String documento) {
        if (empleadosPlanillaMap.containsKey(documento)) {
            return empleadosPlanillaMap.get(documento);
        } else {
            System.out.println("No se encontró ningún empleado por planilla con el documento: " + documento);
            return null;
        }
    }

    public Medico consultarMedicoPorDocumento(String documento) {
        if (medicosMap.containsKey(documento)) {
            return medicosMap.get(documento);
        } else {
            System.out.println("No se encontró ningún médico");
            return null;
        }
    }

    public void imprimirPacientes(){
        String msj = "PACIENTES REGISTRADO\n";
        Iterator<String> iterator = pacientesMap.keySet().iterator();

        while(iterator.hasNext()) {
            String clave = iterator.next();
            pacientesMap.get(clave).imprimirDatosPersona(msj);
        }

        if(pacientesMap.isEmpty()){
            System.out.println("No hay pacientes registrados");
            return;
        }
        System.out.println("\n -----Lista_Pacientes -----");
        for(Paciente paciente : pacientesMap.values()){
            paciente.imprimirDatosPersona(msj);
        }
    }

    public void imprimirEmpleadosEventuales(){
        String msj = "EMPLEADOS EVENTUALES REGISTRADOS\n";

        for(String clave : empleadoEventualMap.keySet()){
            empleadoEventualMap.get(clave).imprimirDatosPersona(msj);
        }

        if(empleadoEventualMap.isEmpty()){
            System.out.println("No hay empleados eventuales registrados");
            return;
        }
        System.out.println("\n ----- Lista de Empleados Eventuales -----");
        for(EmpleadoEventual empleadoEventual : empleadoEventualMap.values()){
            empleadoEventual.imprimirDatosPersona(msj);
        }
    }

    public void imprimirEmpledosPorPlantilla(){
        String msj = "EMPLEADOS POR PLANILLA REGISTRADOS\n";

        for(EmpleadoPlantilla empleadoPlantilla : empleadosPlanillaMap.values()){
            empleadoPlantilla.imprimirDatosPersona(msj);
        }
        if(empleadosPlanillaMap.isEmpty()){
            System.out.println("No hay empleados por plantilla registrados");
            return;
        }
        System.out.println("\n ----- Lista de Empleados por Plantilla ----");
        for(EmpleadoPlantilla empleadoPlantilla : empleadosPlanillaMap.values()){
            if(empleadoPlantilla instanceof Medico){
                System.out.println("-" + empleadoPlantilla.getNombre() + " (Medico)");
            }else{
                System.out.println("-" + empleadoPlantilla.getNombre() + " (Empleado por Plantilla)");
            }
            empleadoPlantilla.imprimirDatosPersona(msj);
        }
    }

    public void imprimirMedicos(){
        String msj = "MEDICOS REGISTRADOS\n";

        for(Map.Entry<String, Medico> elemento : medicosMap.entrySet()){
            //System.out.println("key = " +elemento.getKey()+ ", Value = "+ elemento.getValue());
            //medicosMap.get(elemento.getKey()).imprimirDatosPersonales(msj);
            elemento.getValue().imprimirDatosPersona(msj);
        }
        if(medicosMap.isEmpty()){
            System.out.println("No hay medicos registrados");
            return;
        }
        System.out.println("\n ----- Lista de Medicos -----");
        for(Medico medico : medicosMap.values()){
            medico.imprimirDatosPersona(msj);
        }
    }

    public Medico consultarMedicoPorNombre(String nombreMedico) {
        for (Medico medico : medicosMap.values()) {
            if(medico.getNombre().equalsIgnoreCase(nombreMedico)) {
                return medico;//Al retornar automaticamente termina el ciclo
            }
        }

        //En caso de no encontrar ningun medico retorna null
        return null;
    }

    public void registrarCitaMedica(CitaMedica miCita) {
        citasList.add(miCita);
        System.out.println("Se ha registrado la cita exitosamente\n");
        System.out.println(miCita.informacionCitaMedica());
    }

    public void imprimirCitasMedicasProgramadas() {
        String msj="CITAS MEDICAS PROGRAMADAS\n";
        CitaMedica miCita=null;

        System.out.println(msj+"\n");

        if (citasList.size()>0) {
            for (int i = 0; i < citasList.size(); i++) {
                miCita=citasList.get(i);
                System.out.println(miCita.informacionCitaMedica());
            }
        } else {
            System.out.println("No exiten citas programadas");
        }
    }
}