package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoPlanilla extends Empleado {
	
	private double salarioMensual;
	private double porcentajeAdicionalPorHoraExtra;
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		
		datos="Salario Mensual: " + salarioMensual + "\n";
		datos+="Porcentaje Adicional Por Hora Extra: " + porcentajeAdicionalPorHoraExtra + "\n";
		
		System.out.println(datos);
	}
	
	@Override
	public void registrarDatos() {
		try {
			super.registrarDatos();
			salarioMensual= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario mensual"));
			porcentajeAdicionalPorHoraExtra= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el porcentaje adicional por hora extra"));
		} catch (Exception e) {
			System.out.println("Hubo Un Error, Al parcer ingresaste un dato incorrecto");
			return;
		}

		
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