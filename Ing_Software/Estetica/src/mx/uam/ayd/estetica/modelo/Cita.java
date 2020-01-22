package mx.uam.ayd.estetica.modelo;

public class Cita {
	
	/******Atributos*********/
	private int id;
	private Empleado empleado;
	private String nombreCliente;
	private String descripcion;
	private String fecha;

	/*********************   Constructor  ******************************/
	public Cita(Empleado empleado,String nombreCliente, String fecha, String descripcion) {
		this.empleado= empleado;
		this.nombreCliente = nombreCliente;
		this.descripcion = descripcion;
		this.fecha=fecha;
		
	}
	
	/*********************   SETs y GETs  ******************************/
	
	/******id*********/
	public int dameId() {
		return id;
	}

	public void cambiaId(int id) {
		this.id = id;
	}
	
	/******Empleado*********/
	
	public Empleado dameEmpleado() {
		return empleado;
	}
	
	public void cambiaEmpleado(Empleado empleado) {
		this.empleado=empleado;
	}
	
	/******nombreCliente*********/
	
	public String dameNombreCliente() {
		return nombreCliente;
	}

	public void cambiaNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	/******descripcion*********/
	
	public String dameDescripcion() {
		return descripcion;
	}

	public void cambiaDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/******fecha*********/
	
	public String dameFecha() {
		return fecha;
	}

	public void cambiaFecha(String fecha) {
		this.fecha = fecha;
	}
	
}