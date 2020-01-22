package test.mx.uam.ayd.estetica.persistencia;
import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.persistencia.DAOEmpleadoContrato;

public class DAOEmpleadoSustituto implements DAOEmpleadoContrato {
	
	public boolean actualizaEmpleado(Empleado empleado, int id) {
		// crear un empleado temporal, será el empleado ya existente 
		
		Empleado empleadoPrueba = new Empleado("Daniel", "Cruz", "Cnop izt 36", "2017-12-19", 180);
		
		//simulamos el cambio de datos del empleado prueba
		
		//cambia la TODA la informacion del empleado ya almacenado en la BD (suposicion)
		//por la informacion del empleado recibido como argumento.
		empleadoPrueba = empleado;

		// le asignamos un id, de prueba, fijo.
		empleadoPrueba.cambiaId(25);
		
		//el caso de prueba consistira en validar si el empleado a cambiar existia, y si se pudo realizar el cambio
		//esto ultimo lo daremos por hecho
		
		return (empleadoPrueba.dameId()==id);
		
			
	}

	@Override
	public boolean añadirEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean quitaEmpleado(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Empleado buscaEmpleado(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado buscaEmpleado(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado[] dameEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cuantosEmpleados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void actualizaSalario(double salario, int idEmpleado) {
		// TODO Auto-generated method stub
		
	}
	
}


