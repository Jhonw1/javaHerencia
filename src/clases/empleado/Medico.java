package clases.empleado;

import javax.swing.JOptionPane;

public class Medico extends EmpleadoPlanilla {
	
	private String especialidad;
	private int numeroDeConsultorio;
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		
		datos="Especialidad: " + especialidad + "\n";
		datos+="Numero De Consultorio " +numeroDeConsultorio + "\n";
		
		System.out.println(datos);
	}
	
	@Override
	public void registrarDatos() {
		try {
			super.registrarDatos();
			
			especialidad=JOptionPane.showInputDialog("Ingrese su especialidad");
			numeroDeConsultorio=Integer.parseInt(JOptionPane.showInputDialog("Num de consultorio"));
		} catch (Exception e) {
			System.out.println("Hubo Un Error, Al parcer ingresaste un dato incorrecto");
			return;
		}
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public int getNumeroDeConsultorio() {
		return numeroDeConsultorio;
	}
	public void setNumeroDeConsultorio(int numeroDeConsultorio) {
		this.numeroDeConsultorio = numeroDeConsultorio;
	}

}