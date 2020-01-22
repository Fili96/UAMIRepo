package mx.uam.ayd.estetica.negocio;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Paquete;
import mx.uam.ayd.estetica.persistencia.DAOEmpleado;
import mx.uam.ayd.estetica.persistencia.DAOPaquete;

public class ServicioPaquete {

	public DAOPaquete daopaquete;

	public ServicioPaquete(DAOPaquete daopaquete) {
		this.daopaquete = daopaquete;
	}

	public Paquete[] damePaquetes(String puntosPaquete) {
		System.out.println("i mary servicio");
		return daopaquete.damePaquetes(puntosPaquete);
	}

	public Paquete buscaEmpleado(String nombreEmpleado) {
		return daopaquete.buscaPaquete(nombreEmpleado);
	}

	public Paquete buscaPaquete(String nombrePaquete) {
		return daopaquete.buscaPaquete(nombrePaquete);
	}

}
