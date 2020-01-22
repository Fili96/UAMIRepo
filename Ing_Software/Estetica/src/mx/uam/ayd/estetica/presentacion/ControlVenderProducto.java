package mx.uam.ayd.estetica.presentacion;
import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.modelo.Venta;
import mx.uam.ayd.estetica.negocio.ServicioProducto;
public class ControlVenderProducto {

	
	//Servicios requeridos
	ServicioProducto servicioProducto;

	/**
	 * Constructor
	 */
	public ControlVenderProducto(ServicioProducto servicioProducto) {
		this.servicioProducto = servicioProducto;
	}
	
	/**
	 * inicia la vista del caso de uso
	 */
	public void inicia() {
		VentanaVenderProducto vistaVender = new VentanaVenderProducto(this);
		vistaVender.setVisible(true);
	}
	
	/**
	 * Regresa los productos del registro como un arreglo de productos
	 * @return el arreglo de productos
	 */
	public Producto[] dameProductos() {
		
		 return servicioProducto.dameProductos();
	}
	
	/**
	 * permite regresar un arreglo de cadenas
	 * con los nombres de los productos
	 */
	public String[] dameProductosNombre(Producto[] productos) {
		ArrayList<String> lista = new ArrayList<>();
		 for(Producto p: productos ) {
			 if(p.damePzaExistencia()>0) {
				 lista.add(p.dameNombre()); 
			 }
			
		 }
		 String[] nombres = new String[lista.size()];
		 return lista.toArray(nombres);
	}
	
	/**
	 * Regresa un producto por medio
	 * de su nombre
	 */
	public Producto dameProducto(String nombreProducto, Producto[] productos) {
		for(Producto p : productos) {
			if (p.dameNombre().equals(nombreProducto)) {
				return p;
			}
		}
		return null;
	}
	
	
	/**
	 * busca y regresa el nombre de una marca por medio
	 * del nombre del producto
	 * @param productos 
	 */
	public String buscaProductoMarca(String nombre, Producto[] productos) {
		for(Producto p : productos) {
			if(p.dameNombre().equals(nombre)) {
				return p.dameMarca();
			}
		}
		return null;
	}

	/**
	 * busca y regresa el precio de un producto
	 * @param productos 
	 */
	public int buscaProductoPrecio(String nombre, Producto[] productos) {
		for(Producto p : productos) {
			if(p.dameNombre().equals(nombre)) {
				return p.damePrecio();
			}
		}
		return -1000;
	}
	
	/**
	 * busca y regresa las piezas en existencia de un producto
	 * @param productos 
	 */
	public int buscaProductoPzaExistente(String nombre, Producto[] productos) {
		for(Producto p : productos) {
			if(p.dameNombre().equals(nombre)) {
				return p.damePzaExistencia();
			}
		}
		return -1000;
	}
	
	/**
	 * busca y regresa un producto por medio
	 * de su nombre y marca desde la base de datos
	 */
	public Producto buscaProducto(String nombreProducto, String marcaProducto) {
		return servicioProducto.buscaProducto(nombreProducto, marcaProducto);
	}
	
	
	/**
	 * Permite añadir una venta al Registro
	 * @return true si el trabajo se agrego exitosamente, false sino
	 */
	public boolean añadirVentaProducto(Venta venta) {
		return servicioProducto.añadirVentaProducto(venta);
	}

	/**
	 * Permite actualizar las piezas de un producto tras su uso en el trabajo
	 * @return true si el trabajo se agrego exitosamente, false sino
	 */
	public boolean actualizaPiezasExistentes(int piezas, int id) {
		return servicioProducto.actualizaPiezasExistentes(piezas, id);
		
	}
	
}
