import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import clases.CitaMedica;
import clases.ModeloDatos;
import clases.Paciente;
import clases.empleado.Empleado;
import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;

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
		menu += "4. Imprimir Informacion\n";
		menu += "5. Salir\n\n";
		menu += "Ingrese una opcion\n";

		int opcion = 0;

		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (opcion) {
			case 1:
				try {
					registrarPaciente();

				} catch (Exception e) {
					System.out.println("Ingresaste algo incorrecto");
				}
				break;
			case 2:
				try {
					registrarEmpleado();
				} catch (Exception e) {
					System.out.println("Ingresaste algo incorrecto");
				}
				break;
			case 3:
				try {

					registrarCitaMedica();
				} catch (Exception e) {
					System.out.println("Ingresaste algo incorrecto");
				}
				break;
			case 4:
				try {

					imprimirInformacion();
				} catch (Exception e) {
					System.out.println("Ingresaste algo incorrecto");
				}
				break;
			case 5:
				System.out.println("El sistema ha terminado");
				break;
			default:
				System.out.println("No existe el codigo, verifique nuevamente");
				break;
			}

		} while (opcion != 5);

	}

	private void registrarPaciente() {
		Paciente miPaciente = new Paciente();
		miPaciente.registrarDatos();

		miModeloDatos.registrarPersona(miPaciente);
	}

	private void imprimirInformacion() {

		String menuImprimir = "MENU IMPRESIONES\n";
		menuImprimir += "1. Listar Pacientes\n";
		menuImprimir += "2. Listar Empleados Eventuales\n";
		menuImprimir += "3. Listar Empleados Por Planilla\n";
		menuImprimir += "4. Listar Medicos\n";
		menuImprimir += "5. Listar Citas Programadas\n";
		menuImprimir += "6. Buscar\n";
		menuImprimir += " Ingrese una opcion\n";

		System.out.println("***************************************");

		int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));

		switch (opcion) {
		case 1:
			if (validarPaciente(miModeloDatos.pacientesMap)) {
				try {

					miModeloDatos.imprimirPacientes();
				} catch (Exception e) {
					System.out.println("Ingresaste algo incorrecto");
				}
			}
			break;
		case 2:
			if (validarEmpleadosEventual(miModeloDatos.empleadosEventualMap)) {
				try {
					miModeloDatos.imprimirEmpleadosEventuales();
				} catch (Exception e) {
					System.out.println("Ingresaste algo incorrecto");
					}
				}
			break;
		case 3:
			if (validarEmpleadosPlanilla(miModeloDatos.empleadosPlanillaMap)) {
				try {
					miModeloDatos.imprimirEmpleadosPorPlanilla();
				} catch (Exception e) {
					System.out.println("Ingresaste algo incorrecto");
				}

			}
			break;
		case 4:
			if (validarMedico(miModeloDatos.medicosMap)) {
				try {

					miModeloDatos.imprimirMedicos();
				} catch (Exception e) {
					System.out.println("Ingresaste algo incorrecto");
				}
			}
			break;
		case 5:
			if (validarCitas(miModeloDatos.citasList)) {
				try {

					miModeloDatos.imprimirCitasMedicasProgramadas();
				} catch (Exception e) {
					System.out.println("Ingresaste algo incorrecto");
				}
			}
			break;
		case 6:
			buscar();
			break;
		default:
			System.out.println("No existe la opcion");
			break;
		}

	}

	private void buscar() {
		// TODO Auto-generated method stub
		
		String menu = "1. Buscar Paciente\n" 
					+"2. Buscar Medico\n"
				+ "3. Buscar Empleado\n"
				+ "Ingrese una opcion";
		
		int opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		switch (opc) {
		case 1:
				if (busqueda(miModeloDatos.pacientesMap)) {
					JOptionPane.showMessageDialog(null, "Se encontro");
				}
			break;
		case 2:
			if (busqueda1(miModeloDatos.medicosMap)) {
				JOptionPane.showMessageDialog(null, "Se encontro");
			}
			break;
		case 3:
			if (busqueda2(miModeloDatos.empleadosEventualMap)) {
				JOptionPane.showMessageDialog(null, "Se encontro");
			}
			if (busqueda3(miModeloDatos.empleadosPlanillaMap)) {
				JOptionPane.showMessageDialog(null, "Se encontro");
			}
			break;

		default:
			break;
		}
		
		
		
		
		
		
	}
	
	private Boolean busqueda(HashMap<String, Paciente> map) {
		String search = JOptionPane.showInputDialog("Ingrese el id");
		for(String a:map.keySet()) {
			if (a.equals(search)) return true;
		}
		return false;
	}
	private Boolean busqueda1(HashMap<String, Medico> map) {
		String search = JOptionPane.showInputDialog("Ingrese el id");
		for(String a:map.keySet()) {
			if (a.equals(search)) return true;
		}
		return false;
	}
	private Boolean busqueda2(HashMap<String, EmpleadoEventual> map) {
		String search = JOptionPane.showInputDialog("Ingrese el id");
		for(String a:map.keySet()) {
			if (a.equals(search)) return true;
		}
		return false;
	}
	private Boolean busqueda3(HashMap<String, EmpleadoPlanilla> map) {
		String search = JOptionPane.showInputDialog("Ingrese el id");
		for(String a:map.keySet()) {
			if (a.equals(search)) return true;
		}
		return false;
	}

	public boolean validarPaciente(HashMap<String, Paciente> pacientes) {
		if (pacientes.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tiene que ingresar datos");
			return false;
		}
		return true;
	}

	public boolean validarEmpleadosEventual(HashMap<String, EmpleadoEventual> empleadoEventual) {
		if (empleadoEventual.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tiene que ingresar datos");
			return false;
		}
		return true;
	}

	public boolean validarEmpleadosPlanilla(HashMap<String, EmpleadoPlanilla> empleadoPlanilla) {
		if (empleadoPlanilla.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tiene que ingresar datos");
			return false;
		}
		return true;
	}

	public boolean validarMedico(HashMap<String, Medico> medico) {
		if (medico.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tiene que ingresar datos");
			return false;
		}
		return true;
	}

	public boolean validarCitas(ArrayList<CitaMedica> cita) {
		if (cita.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tiene que ingresar datos");
			return false;
		}
		return true;
	}

	private void registrarEmpleado() {
		String menuTipoEmpleado = "Registro de Empleado\n";
		menuTipoEmpleado += "1. Empleado eventual\n";
		menuTipoEmpleado += "2. Empleado por Planilla\n";
		menuTipoEmpleado += "Seleccione el tipo de empleado a registrar\n";

		int tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));

		switch (tipoEmpleado) {
		case 1:
			try {
				EmpleadoEventual miEmpleadoEventual = new EmpleadoEventual();
				miEmpleadoEventual.registrarDatos();
				miModeloDatos.registrarPersona(miEmpleadoEventual);
			} catch (Exception e) {
				System.out.println("Hubo un error");
			}
			break;
		case 2:
			String resp = JOptionPane
					.showInputDialog("Ingrese si, si es un medico, de lo contrario es otro tipo de empleado");
			if (resp.equalsIgnoreCase("si")) {
				try {
					Medico miMedico = new Medico();
					miMedico.registrarDatos();
					miModeloDatos.registrarPersona(miMedico);
				} catch (Exception e) {
					System.out.println("Hubo une error");
				}
			} else {
				try {
					EmpleadoPlanilla miEmpleadoPlanilla = new EmpleadoPlanilla();
					miEmpleadoPlanilla.registrarDatos();
					miModeloDatos.registrarPersona(miEmpleadoPlanilla);
				} catch (Exception e) {
					System.out.println("Hubo un error");
				}
			}

			break;

		default:
			System.out.println("El tipo de empleado no es valido, intentelo nuevamente");
			break;
		}

	}

	private void registrarCitaMedica() {
		Paciente pacienteEncontrado;
		try {
			
			String documentoPaciente = JOptionPane.showInputDialog("Ingrese el documento del paciente");
			pacienteEncontrado = miModeloDatos.consultarPacientePorDocumento(documentoPaciente);
		} catch(Exception e) {
			System.out.println("Ingresaste un valor nulo");
			pacienteEncontrado = null;
		}
		try {

			if (pacienteEncontrado != null) {
				String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del medico");
				Medico medicoEncotrado = miModeloDatos.consultarMedicoPorNombre(nombreMedico);

				if (medicoEncotrado != null) {
					String servicio = JOptionPane.showInputDialog("Ingrese el servicio o motivo de la consulta");
					String fechaConsulta = JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
					String horaConsulta = JOptionPane.showInputDialog("Ingrese la hora de la consulta");

					String lugar = "La cita sera en el consultorio " + medicoEncotrado.getNumeroDeConsultorio();
					CitaMedica miCita = new CitaMedica(pacienteEncontrado, medicoEncotrado, servicio, fechaConsulta,
							horaConsulta, lugar);
					miModeloDatos.registrarCitaMedica(miCita);
				} else {
					System.out.println("El medico no se encuentra registrado en el sistema");
				}

			} else {
				System.out.println("El paciente no se encuentra registrado en el sistema");
			}
		} catch (Exception e) {
			System.out.println("Algo salio mal");
		}

	}

}
