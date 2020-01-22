package mx.uam.ayd.estetica.modelo;


public class Proveedor {
	
	/******Atributos*********/
	private int id;
	private String nombre;
	
/*adding in software engineering*/

	private String domicilio;
	private String descripcion;
	private String telefono;
	/*********************   Constructor  ******************************/
	
	public Proveedor(String nombre,String descripcion, String domicilio,String telefono){
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.domicilio=domicilio;
		this.telefono=telefono;
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


	/*****descripcion*****/
	public String dameDescripcion() {
		return descripcion;
	}

	public void cambiaDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/*****domicilio*****/
	public String dameDomicilio() {
		return domicilio;
	}

	public void cambiaDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	/*****telefono*****/

	public String dameTelefono() {
		return telefono;
	}

	public void cambiaTelefono(String telefono) {
		this.telefono = telefono;
	}

	

	
}
