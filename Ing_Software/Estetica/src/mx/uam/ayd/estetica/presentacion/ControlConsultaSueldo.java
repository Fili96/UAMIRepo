package mx.uam.ayd.estetica.presentacion;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Trabajo;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;
import mx.uam.ayd.estetica.negocio.ServicioTrabajo;
import mx.uam.ayd.estetica.persistencia.DAOEmpleado;
import mx.uam.ayd.estetica.persistencia.DAOTrabajo;

public class ControlConsultaSueldo {
	
	private ServicioEmpleado ServicioEmpleado;
	private ServicioTrabajo ServicioTrabajo;

	public ControlConsultaSueldo(ServicioEmpleado ServicioEmpleado, ServicioTrabajo ServicioTrabajo) {
		this.ServicioEmpleado = ServicioEmpleado;
		this.ServicioTrabajo = ServicioTrabajo;
	}
	
	public void inicia() {
		//inica ventana consulta sueldo
		VentanaConsultaSueldo VCS = new VentanaConsultaSueldo(this);
		VCS.setVisible(true);
	}

	public Empleado[] dameEmpleados() {
		return ServicioEmpleado.dameEmpleados();
	}
	
	public double[] dameCostoTrabajos(int id) {
		return ServicioTrabajo.dameCostoTrabajos(id);
		
	}
	
	public void actualizaSalario(double salario, int idEmpleado) {
		ServicioEmpleado.actualizaSalario(salario, idEmpleado);
	}
	
	public double calculaSalario(double[] salarios) {
		double salario=120;
		for(int i=0; i<salarios.length;i++) {
			salario=salario +(salarios[i]*0.3);
		}
		return salario;
	}

}
