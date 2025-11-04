package clases_empleado;

import javax.swing.JOptionPane;

public class EmpleadoPlantilla extends Empleado{

    private double salarioMensual;
    private double porcentajeAdicionalPorHoraExtra;

    @Override
    public void registrarDatos(){
        super.registrarDatos();

        salarioMensual = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario mensual"));
        porcentajeAdicionalPorHoraExtra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el porcentaje Adicional por Hora Extra"));
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        super.imprimirDatosPersona(datos);

        datos = "Salario Mensual: "+ salarioMensual + "\n";
        datos += "Porcentaje Adicional Por Hora Extra: "+ porcentajeAdicionalPorHoraExtra + "\n";

        System.out.println(datos);
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }
    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }
    public double getPorcentajeAdicionalPorHoraExtra() {
        return porcentajeAdicionalPorHoraExtra;
    }
    public void setPorcentajeAdicionalPorHoraExtra(double porcentajeAdicionalPorHoraExtra) {
        this.porcentajeAdicionalPorHoraExtra = porcentajeAdicionalPorHoraExtra;
    }
}