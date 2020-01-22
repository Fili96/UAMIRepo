package mx.uam.ayd.estetica.negocio;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.persistencia.DAOEmpleado;
import mx.uam.ayd.estetica.persistencia.DAOEmpleadoContrato;

public class ServicioEmpleado {
	private DAOEmpleadoContrato daoEmpleado;
	
	public ServicioEmpleado(DAOEmpleadoContrato daoEmpleado) {
		this.daoEmpleado=daoEmpleado;
	}
	public boolean añadirEmpleado(String nombreEmpleado, String apellidoEmpleado, String domicilio, String fechaIngreso, double sueldo) {
		//Como parametro el metodo añadir empleado recibe un 
		return daoEmpleado.añadirEmpleado(new Empleado(nombreEmpleado, apellidoEmpleado, domicilio, fechaIngreso, sueldo));
	}

	public Empleado[] dameEmpleados() {
		return daoEmpleado.dameEmpleados();
	}

	public Empleado buscaEmpleado(String nombreEmpleado) {
		return daoEmpleado.buscaEmpleado(nombreEmpleado);
	}
	
	public Empleado buscaEmpleado(int id) {
		return daoEmpleado.buscaEmpleado(id);
	}
	
	public void actualizaSalario(double salario, int idEmpleado) {
		daoEmpleado.actualizaSalario(salario, idEmpleado);
	}
	
	public boolean quitaEmpleado(int id) {
		return daoEmpleado.quitaEmpleado(id);
	}
	
	public boolean actualizaEmpleado(Empleado empleado, int id) {
		return daoEmpleado.actualizaEmpleado(empleado, id);
	}
	
}
