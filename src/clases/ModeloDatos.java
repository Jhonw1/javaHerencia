package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;

public class ModeloDatos {

	public HashMap<String, Paciente> pacientesMap;
	public HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
	public HashMap<String, EmpleadoEventual> empleadosEventualMap;
	public HashMap<String, Medico> medicosMap;
	public ArrayList<CitaMedica> citasList;

	public ModeloDatos() {
		pacientesMap = new HashMap<String, Paciente>();
		empleadosPlanillaMap = new HashMap<String, EmpleadoPlanilla>();
		medicosMap = new HashMap<String, Medico>();
		empleadosEventualMap = new HashMap<String, EmpleadoEventual>();
		citasList = new ArrayList<CitaMedica>();

	}

	public void registrarPersona(Paciente miPaciente) {
		if (!pacientesMap.containsKey(miPaciente.getNumeroDeDNI())) {
			pacientesMap.put(miPaciente.getNumeroDeDNI(), miPaciente);
			System.out.println("Se ha registrado el paciente " + miPaciente.getNombre() + " satisfactoriamente");
		} else {
			System.out.println("No fue posible registrar al paciente, el DNI ya existe en la lista");
		}
	}

	public void registrarPersona(EmpleadoPlanilla miEmpleadoPlanilla) {
		if (!empleadosPlanillaMap.containsKey(miEmpleadoPlanilla.getNumeroDeDNI())) {

			empleadosPlanillaMap.put(miEmpleadoPlanilla.getNumeroDeDNI(), miEmpleadoPlanilla);
			System.out.println("Se ha registrado el empleado por planilla " + miEmpleadoPlanilla.getNombre()
					+ " satisfactoriamente");
		} else {
			System.out.println("No fue posible registrar al empleado, el DNI ya existe en la lista");
		}
	}

	public void registrarPersona(Medico miMedico) {
		if (!medicosMap.containsKey(miMedico.getNumeroDeDNI())) {
			medicosMap.put(miMedico.getNumeroDeDNI(), miMedico);
			System.out.println("Se ha registrado el médico " + miMedico.getNombre() + " satisfactoriamente");

		} else {
			System.out.println("No fue posible registrar al médico, el DNI ya existe en la lista");
		}
	}

	public void registrarPersona(EmpleadoEventual miEmpleadoEventual) {
		if (!empleadosEventualMap.containsKey(miEmpleadoEventual.getNumeroDeDNI())) {
			empleadosEventualMap.put(miEmpleadoEventual.getNumeroDeDNI(), miEmpleadoEventual);
			System.out.println(
					"Se ha registrado el empleado eventual " + miEmpleadoEventual.getNombre() + " satisfactoriamente");
		} else {
			System.out.println("No fue posible registrar al empleado, el DNI ya existe en la lista");
		}
	}

	public void imprimirPacientes() {
		String msj = "PACIENTES REGISTRADOS\n";
		Iterator<String> iterador = pacientesMap.keySet().iterator();

		while (iterador.hasNext()) {

			String clave = iterador.next();
			pacientesMap.get(clave).imprimirDatosPersona(msj);
		}
	}

	public void imprimirEmpleadosEventuales() {
		String msj = "EMPLEADOS EVENTUALES REGISTRADOS\n";

		for (String clave : empleadosEventualMap.keySet()) {
			empleadosEventualMap.get(clave).imprimirDatosPersona(msj);
		}
	}

	public void imprimirEmpleadosPorPlanilla() {
		String msj = "EMPLEADOS POR PLANILLA REGISTRADOS\n";

		for (EmpleadoPlanilla empleadoPlanilla : empleadosPlanillaMap.values()) {
			empleadoPlanilla.imprimirDatosPersona(msj);
		}
		System.out.println("Lista De Médicos");
		if (!medicosMap.isEmpty())
			imprimirMedicos();
	}

	public void imprimirMedicos() {
		String msj = "MÉDICOS REGISTRADOS\n";

		for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {
			elemento.getValue().imprimirDatosPersona(msj);
		}
	}

	public Paciente consultarPacientePorDocumento(String documentoPaciente) {
		Paciente miPaciente = null;

		if (pacientesMap.containsKey(documentoPaciente)) {
			miPaciente = pacientesMap.get(documentoPaciente);
		}

		return miPaciente;
	}

	public Medico consultarMedicoPorNombre(String nombreMedico) {

		for (Medico medico : medicosMap.values()) {

			if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
				return medico;

			}
		}

		return null;
	}

	public void registrarCitaMedica(CitaMedica miCita) {
		citasList.add(miCita);
		System.out.println("Se ha registrado la cita exitosamente\n");
		System.out.println(miCita.informacionCitaMedica());
	}

	public void imprimirCitasMedicasProgramadas() {
		String msj = "CITAS MÉDICAS PROGRAMADAS\n";
		CitaMedica miCita = null;

		System.out.println(msj + "\n");

		if (citasList.size() > 0) {
			for (int i = 0; i < citasList.size(); i++) {
				miCita = citasList.get(i);
				System.out.println(miCita.informacionCitaMedica());
			}
		} else {
			System.out.println("No existen citas programadas");
		}
	}

}
