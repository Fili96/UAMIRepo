package mx.uam.ayd.estetica.modelo;

public class Producto {
	
	/******Atributos*********/
	private int id;
	private String nombre;
	private String marca;
	private int pzaExistencia;
	private int precio;
	
	/*********************   Constructor  ******************************/

	public Producto(String nombre, String marca, int pzaExistencia, int precio) {
		this.nombre=nombre;
		this.marca=marca;
		this.pzaExistencia=pzaExistencia;
		this.precio=precio;
	}
	
	/*********************   SETs y GETs  ******************************/
	
	/******id*********/
	
	public void cambiaId(int id) {
		this.id=id;
		
	}
	
	public int dameId() {
		return id;
		
	}
	
	/******nombre*********/
	
	public String dameNombre() {
		return nombre;
	}


	public void cambiaNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/******marca*********/
	
	public String dameMarca() {
		return marca;
	}


	public void cambiaMarca(String marca) {
		this.marca = marca;
	}
	
	/******pzaExistencia*********/

	public int damePzaExistencia() {
		return pzaExistencia;
	}


	public void cambiaPzaExistencia(int pzaExistencia) {
		this.pzaExistencia = pzaExistencia;
	}
	
	/******precio*********/

	public int damePrecio() {
		return precio;
	}


	public void cambiaPrecio(int pzaExistencia) {
		this.precio = precio;
	}

}
