package test.mx.uam.ayd.estetica.persistencia;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.modelo.Trabajo;
import mx.uam.ayd.estetica.persistencia.DAOTrabajoContrato;

public class DAOTrabajoSustituto implements DAOTrabajoContrato{

	public DAOTrabajoSustituto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean añadirTrabajo(Trabajo trabajo) {
		
		return true;
	}

	@Override
	public boolean quitaTrabajo(Trabajo trabajo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Trabajo buscaTrabajo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trabajo[] dameTrabajos() {
		//Creamos un arreglo de trabajos que se regresara al servicio 
		Trabajo[] trabajos = new Trabajo[2];
		//creamos trabajos para meterlos en el arreglo
		//primero creamos al empleado para enviarlo al constructor
		Empleado empleado = new Empleado("Jean");
		empleado.cambiaId(0);
		
		//Tambien creamos los productos
		Producto producto = new Producto("Tinte", "patito", 5, 50);
		
		//llenamos el arreglo
		trabajos[0]= new Trabajo("Tinte", empleado, "Se usaron varios tintes", 250.0, "2017-10-09", producto, 2);
		trabajos[1]= new Trabajo("Corte", empleado, "corte normal", 50.0, "2017-10-09", null, 0);		
		//llenamos el arreglo
		return trabajos;
	}

	@Override
	public int cuantosTrabajos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean actualizaTrabajo(Trabajo trabajo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double[] dameCostoTrabajos(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trabajo[] dameTrabajosEmpleado(int id) {
		return null;
	}

}
