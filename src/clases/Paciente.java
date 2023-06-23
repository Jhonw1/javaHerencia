package clases;

import java.rmi.AccessException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Paciente extends Persona {

	private int numeroHistoricoClinica;
	private String sexo;
	private String grupoSanguineo;
	private ArrayList<String> listaMedicamentosAlergico;

	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);

		datos = "Numero Historial Clinica: " + numeroHistoricoClinica + "\n";
		datos += "Sexo: " + sexo + "\n";
		datos += "Grupo Sanguineo: " + grupoSanguineo + "\n";

		if (listaMedicamentosAlergico.size() > 0) {
			datos += "Lista de Medicamentos a los que es Alergico\n";
			for (int i = 0; i < listaMedicamentosAlergico.size(); i++) {
				datos += "\t" + listaMedicamentosAlergico.get(i) + "\n";
			}
		} else {
			datos += "El paciente, no es alergico a ningun medicamento";
		}

		System.out.println(datos);
	}

	@Override
	public void registrarDatos() {
		String pregunta;
		try {
			super.registrarDatos();
		} catch (Exception e) {
			System.out.println("Hubo Un Error, Al parcer ingresaste un dato incorrecto");
			return;
		}
		try {
			listaMedicamentosAlergico = new ArrayList<String>();
			numeroHistoricoClinica = Integer
					.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la historia clinica"));
			sexo = JOptionPane.showInputDialog("Ingrese el sexo");
			grupoSanguineo = JOptionPane.showInputDialog("Ingrese el grupo sanguineo");
			
			pregunta = JOptionPane.showInputDialog("ï¿½Es alergico a algun medicamento? ingrese si o no");
			
		} catch (Exception e) {
			System.out.println("Hubo Un Error");
			pregunta = "no";
			return;
		}
			if (pregunta.equalsIgnoreCase("si")) {
				String medicamento = "";
				String continuar = "";
				
				do {
					medicamento = JOptionPane.showInputDialog("Ingrese el nombre del medicamento al que es alergico");
					listaMedicamentosAlergico.add(medicamento);
					
					continuar = JOptionPane.showInputDialog("Ingrese si, si desea continuar");
					
				} while (continuar.equalsIgnoreCase("si"));
			}

	}

	public int getNumeroHistoricoClinica() {
		return numeroHistoricoClinica;
	}

	public void setNumeroHistoricoClinica(int numeroHistoricoClinica) {
		this.numeroHistoricoClinica = numeroHistoricoClinica;
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