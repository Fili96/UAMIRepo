package mx.uam.ayd.estetica.modelo;

public class Cuenta {
	
	//Stributos
	private int idCuenta;
	private String nombre;
	private String contraseña;
	private Empleado empleado;

	public Cuenta(String nombre, Empleado empleado, String contraseña) {
		this.idCuenta=idCuenta;
		this.nombre=nombre;
		this.contraseña=contraseña;
		this.empleado=empleado;
	}
	
	public int dameId() {
		return idCuenta;
	}
	
	public void cambiaId(int id) {
		this.idCuenta = id;
	}
	
	public String dameNombre() {
		return nombre;
	}
	
	public void cambiaNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String dameContraseña() {
		return contraseña;
	}
	
	public void cambiaContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public Empleado dameEmpleado() {
		return empleado;
	}
	
	public void cambiaEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


}
