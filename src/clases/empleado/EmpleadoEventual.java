package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoEventual extends Empleado {

	
	private double honorariosPorHora;
	private String fechaTerminoContrato;
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		
		datos="Honorarios por Hora: " + honorariosPorHora + "\n";
		datos+="Fecha Termino del Contrato: " + fechaTerminoContrato + "\n";
		
		System.out.println(datos);
	}
	
	
	@Override
	public void registrarDatos(){
		try {
			super.registrarDatos();
		
		honorariosPorHora= Double.parseDouble(JOptionPane.showInputDialog("Ingrese salario mensual"));
		fechaTerminoContrato= JOptionPane.showInputDialog("Ingrese fecha de nacimiento (dd/mm/aaaa");
		} catch (Exception e) {
			System.out.println("Hubo Un Error, Al parcer ingresaste un dato incorrecto");
			return;
		}
	}
	
	
	public double getHonorariosPorHora() {
		return honorariosPorHora;
	}
	public void setHonorariosPorHora(double honorariosPorHora) {
		this.honorariosPorHora = honorariosPorHora;
	}
	public String getFechaTerminoContrato() {
		return fechaTerminoContrato;
	}
	public void setFechaTerminoContrato(String fechaTerminoContrato) {
		this.fechaTerminoContrato = fechaTerminoContrato;
	}
	
	
}
