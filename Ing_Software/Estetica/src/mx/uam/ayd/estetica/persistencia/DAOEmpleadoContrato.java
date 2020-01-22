package mx.uam.ayd.estetica.persistencia;
import mx.uam.ayd.estetica.modelo.Empleado;

public interface DAOEmpleadoContrato {
	
	public boolean añadirEmpleado(Empleado empleado);
	public boolean quitaEmpleado(int id);
	public Empleado buscaEmpleado(String nombre);
	public Empleado buscaEmpleado(int id);
	public Empleado[] dameEmpleados();
	public int cuantosEmpleados();
	public boolean actualizaEmpleado(Empleado empleado, int id);	
	public void actualizaSalario(double salario, int idEmpleado);
	
}


