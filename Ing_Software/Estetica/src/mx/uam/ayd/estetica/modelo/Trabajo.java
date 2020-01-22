package mx.uam.ayd.estetica.modelo;

public class Trabajo {

	/****** Atributos *********/
	private int id;
	private String nombre;
	private Empleado empleado;
	private String descripcion;
	private double monto;
	private String fecha;
	private Producto producto;
	private int pzaUsadas;

	/********************* Constructor ******************************/
	public Trabajo(String nombre, Empleado empleado, String descripcion, double monto, String fecha, Producto producto,
			int pzaUsadas) {
		this.nombre = nombre;
		this.empleado = empleado;
		this.descripcion = descripcion;
		this.monto = monto;
		this.fecha = fecha;
		this.producto = producto;
		this.pzaUsadas = pzaUsadas;
	}

	/********************* SETs y GETs ******************************/

	/****** id *********/
	public int dameId() {
		return id;
	}

	public void cambiaId(int id) {
		this.id = id;
	}

	/****** nombre *********/

	public String dameNombre() {
		return nombre;
	}

	public void cambiaNombre(String nombre) {
		this.nombre = nombre;
	}

	/****** piezas usadas *********/

	public int damePzaUsadas() {
		return pzaUsadas;
	}

	public void cambiaPzaUsadas(int pzaUsadas) {
		this.pzaUsadas = pzaUsadas;
	}

	/****** producto *********/

	public Producto dameProducto() {
		return producto;
	}

	public void cambiaProducto(Producto producto) {
		this.producto = producto;
	}

	/****** fecha *********/
	public String dameFecha() {
		return fecha;
	}

	public String dameDescripcion() {
		return descripcion;
	}

	/****** empleado *********/
	public Empleado dameEmpleado() {
		return empleado;
	}

	public double dameMonto() {
		return monto;
	}

	/****** monto *********/
	public boolean cambiaMonto(double monto) {
		if (monto > 0) {
			this.monto = monto;
			return true;
		} else {
			return false;
		}
	}

	/****** descripcion *********/
	public void cambiaDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void cambiaEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String dameTipo() {
		return fecha;
	}

}
