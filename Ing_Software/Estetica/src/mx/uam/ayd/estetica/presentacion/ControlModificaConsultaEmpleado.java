package mx.uam.ayd.estetica.presentacion;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;
import mx.uam.ayd.estetica.negocio.ServicioTrabajo;

public class ControlModificaConsultaEmpleado {
	private ServicioEmpleado servicioEmpleado;
	private ServicioTrabajo servicioTrabajo;//******

	public ControlModificaConsultaEmpleado(ServicioEmpleado servicioEmpleado, ServicioTrabajo servicioTrabajo) {
		this.servicioEmpleado= servicioEmpleado;
		this.servicioTrabajo= servicioTrabajo;
	}
	
	public void inicia() {
		//inicia la ventana del caso de uso
		VentanaModificaConsultaEmpleado VMCE =  new VentanaModificaConsultaEmpleado(this);
		/*hace visible la ventana de Empleados*/
		VMCE.setVisible(true);		
	}
	

	
	public Empleado buscaEmpleado(String nombreEmpleado) {
		return servicioEmpleado.buscaEmpleado(nombreEmpleado);
	}

	public Empleado[] dameEmpleados() {
		return servicioEmpleado.dameEmpleados();
	}

	public boolean quitaEmpleado(int id) {
		return servicioEmpleado.quitaEmpleado(id);
	}
		
	public boolean actualizaEmpleado(Empleado empleado, int id) {
		return servicioEmpleado.actualizaEmpleado(empleado, id);
	}

	public void empleadoDelMes() {
		// TODO Auto-generated method stub
		VentanaEmpleadoDelMes VEM = new VentanaEmpleadoDelMes(this);
		VEM.setVisible(true);
	}
	
	public double[] dameCostoTrabajos(int id) {
		return servicioTrabajo.dameCostoTrabajos(id);
		
	}
	
	public double calculaSalario(double[] salarios) {
		double salario=120;
		for(int i=0; i<salarios.length;i++) {
			salario=salario +(salarios[i]*0.3);
		}
		return salario;
	}
	
	public void actualizaSalario(double salario, int idEmpleado) {
		servicioEmpleado.actualizaSalario(salario, idEmpleado);
	}
	
	public int dameNumeroTrabajos(int id) {

		return servicioTrabajo.dameNumeroTrabajos(id);
	}
}