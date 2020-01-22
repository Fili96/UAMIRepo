package mx.uam.ayd.estetica.presentacion;
import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Cuenta;
import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.negocio.ServicioCuenta;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;

public class ControlAñadirCuenta {

	private ServicioCuenta servicioCuenta;
	private ServicioEmpleado servicioEmpleado;
	
	public ControlAñadirCuenta(ServicioCuenta servicioCuenta, ServicioEmpleado servicioEmpleado) {
		this.servicioCuenta=servicioCuenta;
		this.servicioEmpleado=servicioEmpleado;
	}
	
	public void inicia() {
		VentanaAñadirCuenta vistaCuenta = new VentanaAñadirCuenta(this);
		vistaCuenta.setVisible(true);
	}
	
	public Empleado[] dameEmpleados() {
		return servicioEmpleado.dameEmpleados();
	}
	
	public String[] dameEmpleadosNombre(Empleado[] empleados) {
		ArrayList<String> lista = new ArrayList<>();
		for (Empleado emp : empleados) {
			lista.add(emp.dameNombre());
		}
		String[] nombres = new String[lista.size()];
		return lista.toArray(nombres);

	}
	
	public Empleado buscaEmpleado(String nombreEmpleado, Empleado[] empleados) {

		for (Empleado e : empleados) {
			if (e.dameNombre().equals(nombreEmpleado)) {
				return e;
			}
		}

		return null;
	}
	
	public boolean añadirCuenta(String nombre, Empleado empleado, String contraseña) {
		return servicioCuenta.añadirCuenta(nombre, empleado, contraseña);
	}

}
