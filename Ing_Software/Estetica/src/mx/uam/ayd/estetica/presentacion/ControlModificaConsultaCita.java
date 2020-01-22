package mx.uam.ayd.estetica.presentacion;

import mx.uam.ayd.estetica.modelo.Cita;
import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.negocio.ServicioCita;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;

public class ControlModificaConsultaCita {
	private ServicioCita servicioCita;
	private ServicioEmpleado servicioEmpleado;//******

	public ControlModificaConsultaCita(ServicioCita servicioCita , ServicioEmpleado servicioEmpleado) {
		this.servicioCita = servicioCita;
		this.servicioEmpleado= servicioEmpleado;
	}
	
	public void inicia() {
		//inicia la ventana del caso de uso
		VentanaModificaConsultaCita VMCC = new VentanaModificaConsultaCita(this);
		/*hace visible la ventana de Citas*/
		VMCC.setVisible(true);		
	}
	
	public Cita[] dameCitas() {
		return servicioCita.dameCitas();
	}
	
	public Empleado buscaEmpleado(int id) {
		return servicioEmpleado.buscaEmpleado(id);
	}
	
	public Empleado buscaEmpleado(String nombreEmpleado) {
		return servicioEmpleado.buscaEmpleado(nombreEmpleado);
	}
	
	public boolean actualizaCita(Cita cita, int id) {
		return servicioCita.actualizaCita(cita, id);
	}
	//quita cita que manda el id de la cita 
	public boolean quitaCita(int id) {
		return servicioCita.quitaCita(id);
	}
	
	
}