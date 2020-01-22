package mx.uam.ayd.estetica.negocio;

import mx.uam.ayd.estetica.modelo.Cita;
import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.persistencia.DAOCita;

public class ServicioCita {
	private DAOCita daoCita;
	public ServicioCita(DAOCita daoCita) {
		this.daoCita=daoCita;
	}
	public boolean añadirCita(Empleado empleado, String nombreCliente, String descripcion, String fecha) {
		
		return daoCita.añadirCita(new Cita(empleado,nombreCliente,fecha,descripcion));
	}
	public int cuantasCitas() {
		return daoCita.cuantasCitas();
	}
	public Cita buscaCita(String nombreCliente) {
		// TODO Auto-generated method stub
		return daoCita.buscaCita(nombreCliente);
	}
	public Cita[] dameCitas() {
		// Si hubiera logica de negocio se aplicara aqui
		return daoCita.dameCitas();
	}

	public boolean actualizaCita(Cita cita, int id) {
		
		return daoCita.actualizaCita(cita, id);
	}
	//quita cita recibe el id de la cita a eliminar
	public boolean quitaCita(int id) {
		return daoCita.quitaCita(id);
	}
	
}
