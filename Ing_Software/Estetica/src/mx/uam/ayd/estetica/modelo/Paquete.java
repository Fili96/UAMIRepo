package mx.uam.ayd.estetica.modelo;

public class Paquete {

	String puntos;
	String nombrePaquete;
	String descripcion;
	int id;

	public Paquete(String nombrePaquete,String puntos , String descripcion) {
		this.nombrePaquete = nombrePaquete;
		this.puntos = puntos;
		this.descripcion = descripcion;

	}

	public String dameNombrePaquete() {
		return nombrePaquete;
	}

	public String dameDescripcion() {
		return descripcion;
	}

	public void cambiaDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String damePuntos() {
		return puntos;
	}

	public void cambiaId(int id) {
		this.id = id;
	}

	public int dameId() {
		return id;
	}

}
