package clases;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Paciente extends Persona {
    private int numeroHistoriaClínica;
    private String sexo;
    private String grupoSanguineo;
    private ArrayList<String> listaMedicamentosAlergico;

    @Override
    public void registrarDatos() {

        // Se llama al metodo para continuar lleando los datos
        super.registrarDatos();

        // Se llena los datos especificos del paciente
        listaMedicamentosAlergico = new ArrayList<String>();
        numeroHistoriaClínica = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la historia clinica"));
        sexo = JOptionPane.showInputDialog("Ingrese el sexo");
        grupoSanguineo = JOptionPane.showInputDialog("Ingrese el grupo sanguineo");

        String pregunta = JOptionPane.showInputDialog("¿Es alergico a algun medicamento? ingrese si o no");

        if(pregunta.equalsIgnoreCase("si")){
            String medicamento = "";
            String continuar = "";
            
            do{
                medicamento = JOptionPane.showInputDialog("Ingrese el nombre del medicamento al que es alergico");
                listaMedicamentosAlergico.add(medicamento);

                continuar = JOptionPane.showInputDialog("Ingrese si, si desea continuar");
            }while(continuar.equalsIgnoreCase("si"));
        }

    }

    @Override
    public void imprimirDatosPersona(String datos){
        super.imprimirDatosPersona(datos);

        datos="Numero Historia Clinica: "+numeroHistoriaClínica+"\n";
        datos+="Sexo: "+sexo+"\n";
        datos+="Grupo Sanguineo: "+grupoSanguineo+"\n";

        if(listaMedicamentosAlergico.size()>0){
            datos+="Lista de Medicamentos a los que es Alergico\n";
            for(int i = 0; i < listaMedicamentosAlergico.size(); i++){
                datos+="\t"+listaMedicamentosAlergico.get(i)+"\n";
            }
        } else {
            datos+="El paciente, no es alergico a ningun medicamento";
        }

        System.out.println(datos);
    }

    public int getNumeroHistoriaClínica() {
        return numeroHistoriaClínica;
    }

    public void setNumeroHistoriaClínica(int numeroHistoriaClínica) {
        this.numeroHistoriaClínica = numeroHistoriaClínica;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public ArrayList<String> getListaMedicamentosAlergico() {
        return listaMedicamentosAlergico;
    }

    public void setListaMedicamentosAlergico(ArrayList<String> listaMedicamentosAlergico) {
        this.listaMedicamentosAlergico = listaMedicamentosAlergico;
    }
}