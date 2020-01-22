package mx.uam.ayd.estetica.presentacion;

import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Paquete;
import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;
import mx.uam.ayd.estetica.negocio.ServicioPaquete;
import mx.uam.ayd.estetica.negocio.ServicioProducto;
import mx.uam.ayd.estetica.negocio.ServicioTrabajo;

public class ControlAñadirTrabajo {

	/**
	 * Servicios Requeridos
	 */

	private ServicioTrabajo servicioTrabajo;
	private ServicioEmpleado servicioEmpleado;
	ServicioProducto servicioProducto;
	ServicioPaquete servicioPaquete;

	/**
	 * Constructor de la clase
	 */
	public ControlAñadirTrabajo(ServicioTrabajo servicioTrabajo, ServicioEmpleado servicioEmpleado,
			ServicioProducto servicioProducto, ServicioPaquete servicioPaquete) {

		this.servicioTrabajo = servicioTrabajo;
		this.servicioEmpleado = servicioEmpleado;
		this.servicioProducto = servicioProducto;
		this.servicioPaquete = servicioPaquete;
	}

	/**
	 * inicia la vista del caso de uso
	 */
	public void inicia() {
		VentanaAñadirTrabajo vistatrabajo = new VentanaAñadirTrabajo(this);
		vistatrabajo.setVisible(true);
	}

	/**
	 * Regresa los empleados del registro como un arreglo de empleados
	 * 
	 * @return el arreglo de empleados
	 */
	public Empleado[] dameEmpleados() {
		return servicioEmpleado.dameEmpleados();
	}

	// reresa los paquetes disponibles para las promociones
	public Paquete[] damePaquetes(String puntosPaquete) {
		System.out.println("i mary control");
		return servicioPaquete.damePaquetes(puntosPaquete);
	}

	public Double descuentos(String puntos, Double monto) {
		double coti=-1;
		
		if (puntos == "1-15") {
			coti = (15 * 100 / monto);
			
			return coti;
		}
		if (puntos == "15-20") {
			coti = (20 * 100 / monto);
			
			return coti;
		}
		if (puntos == "20-30") {
			coti = (35 * 100 / monto);
			
			return coti;
		}
		return coti;
			}

	/**
	 * permite regresar un arreglo de cadenas con los nombres de los empleados
	 */
	public String[] dameEmpleadosNombre(Empleado[] empleados) {
		ArrayList<String> lista = new ArrayList<>();
		for (Empleado emp : empleados) {
			lista.add(emp.dameNombre());
		}
		String[] nombres = new String[lista.size()];
		return lista.toArray(nombres);

	}

	// ***************************************************************************
	public String[] damePaquetesPuntos(Paquete[] paquetes) {
		System.out.println("paquetes puntos de control");
		ArrayList<String> lista = new ArrayList<String>();
		if(paquetes.length>0) {	for (int i = 0; i < paquetes.length; i++) {
			lista.add(paquetes[i].dameNombrePaquete().trim());

		}String[] nombrespaq = new String[lista.size()];
		lista.toArray(nombrespaq);
		return nombrespaq;
		}
		
		else {
			System.out.println("no ay nada");
			return null;
		}
        

	}

	
	
	public String[] damePaqueteDescripcion(Paquete paquete) {
		System.out.println("descripcion paquete");
		ArrayList<String> lista = new ArrayList<String>();
		
		lista.add(paquete.dameDescripcion());

		String[] nombrespaq = new String[lista.size()];
		lista.toArray(nombrespaq);
		return nombrespaq;
		
		
		}
        

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Paquete buscaPaquete(String nombrePaquete) {
		return servicioPaquete.buscaPaquete(nombrePaquete);
	}

	/**
	 * Regresa los productos del registro como un arreglo de productos
	 * 
	 * @return el arreglo de productos
	 */
	public Producto[] dameProductos() {

		return servicioProducto.dameProductos();
	}

	/**
	 * permite regresar un arreglo de cadenas con los nombres de los productos
	 */
	public String[] dameProductosNombre(Producto[] productos) {
		ArrayList<String> lista = new ArrayList<>();
		for (Producto p : productos) {
			if (p.damePzaExistencia() > 0) {
				lista.add(p.dameNombre());
			}

		}
		String[] nombres = new String[lista.size()];
		return lista.toArray(nombres);
	}

	/**
	 * busca y regresa el nombre de una marca por medio del nombre del producto
	 * 
	 * @param productos
	 */
	public String buscaProductoMarca(String nombre, Producto[] productos) {
		for (Producto p : productos) {
			if (p.dameNombre().equals(nombre)) {
				return p.dameMarca();
			}
		}
		return null;
	}

	/**
	 * busca y regresa un empleado por medio del nombre del empleado
	 */
	public Empleado buscaEmpleado(String nombreEmpleado, Empleado[] empleados) {

		for (Empleado e : empleados) {
			if (e.dameNombre().equals(nombreEmpleado)) {
				return e;
			}
		}

		return null;
	}

	/**
	 * busca y regresa un producto por medio de su nombre y marca
	 */
	public Producto buscaProducto(String nombreProducto, String marcaProducto, Producto[] productos) {
		for (Producto p : productos) {
			if ((p.dameNombre().equals(nombreProducto)) && (p.dameMarca().equals(marcaProducto))) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Permite añadir un trabajo al Registro
	 * 
	 * @return true si el trabajo se agrego exitosamente, false sino
	 */
	public boolean añadirTrabajo(String nombreservicio, Empleado empleado, String descripcion, double monto,
			String fecha, Producto producto, int pzs_usadas) {
		return servicioTrabajo.añadirTrabajo(nombreservicio, empleado, descripcion, monto, fecha, producto, pzs_usadas);
	}

	/**
	 * Permite actualizar las piezas de un producto tras su uso en el trabajo
	 * 
	 * @return true si el trabajo se agrego exitosamente, false sino
	 */
	public boolean actualizaPiezasExistentes(int piezas, int id) {
		return servicioProducto.actualizaPiezasExistentes(piezas, id);

	}
}
