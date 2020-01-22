package mx.uam.ayd.estetica.modelo;

import java.util.Date;

public class Empleado {
	
	/******Atributos*********/
	private int id;
	private String nombre;
	
/*adding in software engineering*/
	
	private String apellido;
	private String domicilio;
	private String fecha;
	private double sueldo;

	/*********************   Constructor  ******************************/
	
	public Empleado(String nombre,String apellido,String domicilio,String fecha,double sueldo) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.domicilio=domicilio;
		this.fecha=fecha;
		this.sueldo=sueldo;
	}

	public Empleado(String nombre) {
		this.nombre=nombre;
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

	/*adding in S.E.*/
	/******apellido*****/
	
	public String dameApellido() {
		return apellido;
	}

	public void cambiaApellido(String apellido) {
		this.apellido = apellido;
	}

	/*****domicilio*****/
	public String dameDomicilio() {
		return domicilio;
	}

	public void cambiaDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	/*****fecha ingreso*****/

	public String dameFecha() {
		return fecha;
	}

	public void cambiaFecha(String fecha) {
		this.fecha = fecha;
	}

	/***** sueldo*****/
	public double dameSueldo() {
		return sueldo;
	}

	public void cambiaSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
}
