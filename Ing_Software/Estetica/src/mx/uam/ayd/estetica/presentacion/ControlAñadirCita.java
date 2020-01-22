package mx.uam.ayd.estetica.presentacion;

import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Cita;
import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.negocio.ServicioCita;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;

public class ControlAñadirCita {
	/**   DECLARACION DE ATRIBUTOS**/
	private ServicioCita servicioCita;
	private ServicioEmpleado servicioEmpleado;
	
	
	/** CONTRUCTOR DONDE SE INICIALIZACION**/
	public ControlAñadirCita(ServicioCita servicioCita, ServicioEmpleado servicioEmpleado){
		this.servicioCita=servicioCita;
		this.servicioEmpleado = servicioEmpleado;
	}
	
	public void inicia() {
		/** inicia la ventana del caso de uso **/
		VentanaAñadirCita VAC = new VentanaAñadirCita(this);
		VAC.setVisible(true);
	}
	
	public boolean añadirCita(Empleado empleado, String nombreCliente, String descripcion, String fecha){
		return servicioCita.añadirCita(empleado,nombreCliente,descripcion,fecha);
	}
	
	public Cita buscaCita(String nombreCliente){
		return servicioCita.buscaCita(nombreCliente);
	}
	
	public Empleado buscaEmpleado(String nombreEmpleado) {
		return servicioEmpleado.buscaEmpleado(nombreEmpleado);
	}
	
	
	public Empleado[] dameEmpleados() {		
		return servicioEmpleado.dameEmpleados();
		
	}
	
	public String[] dameEmpleadosNombre(Empleado [] empleados) {
		ArrayList<String> lista = new ArrayList<>();
		 for(Empleado emp:empleados) {
			 lista.add(emp.dameNombre());
		 }
		 String[] nombres = new String[lista.size()];
		 return lista.toArray(nombres);
		 
	}
	
	
	
}