package clases_empleado;

import javax.swing.JOptionPane;

public class EmpleadoEventual extends Empleado {

    private double honoriosPorHora;
    private String fechaTerminoContrato;

    @Override
    public void registrarDatos() {
        super.registrarDatos();

        honoriosPorHora = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario Mensual"));
        fechaTerminoContrato = JOptionPane.showInputDialog("Ingrese fecha de nacimiento (dd/mm/aaaa)");
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        super.imprimirDatosPersona(datos);

        datos = "Honorarios por hora: " + honoriosPorHora + "\n";
        datos += "Fecha Termino del contrato: " + fechaTerminoContrato + "\n";

        System.out.println(datos);
    }

    public double getHonoriosPorHora() {
        return honoriosPorHora;
    }
    public void setHonoriosPorHora(double honoriosPorHora) {
        this.honoriosPorHora = honoriosPorHora;
    }
    public String getFechaTerminoContrato() {
        return fechaTerminoContrato;
    }
    public void setFechaTerminoContrato(String fechaTerminoContrato) {
        this.fechaTerminoContrato = fechaTerminoContrato;
    }
}