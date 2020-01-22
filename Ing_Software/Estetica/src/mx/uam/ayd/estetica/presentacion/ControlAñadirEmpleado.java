package mx.uam.ayd.estetica.presentacion;


import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;

public class ControlAñadirEmpleado {
	/**   DECLARACION DE ATRIBUTOS**/
	private ServicioEmpleado servicioEmpleado;
	private VentanaAñadirEmpleado VAE;
	
	/** CONTRUCTOR DONDE SE INICIALIZACION**/
	public ControlAñadirEmpleado(ServicioEmpleado servicioEmpleado){
		this.servicioEmpleado = servicioEmpleado;
		this.servicioEmpleado = servicioEmpleado;
	}
	
	public void inicia() {
		/** inicia la ventana del caso de uso **/
		VAE = new VentanaAñadirEmpleado(this);
		VAE.setVisible(true);
	}
	
	public void finaliza() {
		
	}
	
	public boolean añadirEmpleado(String nombreEmpleado,String apellidoEmpleado, String domicilio, String fechaIngreso, double sueldo) {
		Empleado empleados []= servicioEmpleado.dameEmpleados();
		for(Empleado emp : empleados) {
			
			if(emp.dameNombre().equalsIgnoreCase(nombreEmpleado) && emp.dameApellido().equalsIgnoreCase(apellidoEmpleado)) {
				
				return false;
				
			}
		}
		
		return servicioEmpleado.añadirEmpleado(nombreEmpleado, apellidoEmpleado, domicilio, fechaIngreso, sueldo);
	}
}
