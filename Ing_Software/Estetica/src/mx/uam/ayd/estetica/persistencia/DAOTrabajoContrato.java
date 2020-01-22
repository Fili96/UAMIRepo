package mx.uam.ayd.estetica.persistencia;

import mx.uam.ayd.estetica.modelo.Trabajo;

public interface DAOTrabajoContrato {

	public boolean añadirTrabajo(Trabajo trabajo);
	public boolean quitaTrabajo(Trabajo trabajo);
	public Trabajo buscaTrabajo(int id);
	public Trabajo[] dameTrabajos();
	public int cuantosTrabajos();
	public boolean actualizaTrabajo(Trabajo trabajo);
	public double[] dameCostoTrabajos(int id);
	public Trabajo[] dameTrabajosEmpleado(int id);
}
