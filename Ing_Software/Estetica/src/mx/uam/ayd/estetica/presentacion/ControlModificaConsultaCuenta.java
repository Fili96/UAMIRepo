package mx.uam.ayd.estetica.presentacion;


import mx.uam.ayd.estetica.modelo.Cuenta;
import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.negocio.ServicioCuenta;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;


public class ControlModificaConsultaCuenta {
	private ServicioCuenta servicioCuenta;
	private ServicioEmpleado servicioEmpleado;//******

	public ControlModificaConsultaCuenta(ServicioCuenta servicioCuenta , ServicioEmpleado servicioEmpleado) {
		this.servicioCuenta = servicioCuenta;
		this.servicioEmpleado= servicioEmpleado;
	}
	
	public void inicia() {
		//inicia la ventana del caso de uso
		VentanaModificaConsultaCuenta VMCC = new VentanaModificaConsultaCuenta(this);
		VMCC.setVisible(true);		
	}
	//dame citas
	public Cuenta[] dameCuentas() {
		return servicioCuenta.dameCuentas();
	}
	
	public Empleado buscaEmpleado(int id) {
		return servicioEmpleado.buscaEmpleado(id);
	}
	
	public Empleado buscaEmpleado(String nombreEmpleado) {
		return servicioEmpleado.buscaEmpleado(nombreEmpleado);
	}
	//actualiza cita
	public boolean actualizaCuenta(Cuenta cuenta, int id) {
		return servicioCuenta.actualizaCuenta(cuenta, id);
	}
	//quita cita que manda el id de la cita 
	public boolean quitaCuenta(int id) {
		return servicioCuenta.quitaCuenta(id);
	}
	
	
}