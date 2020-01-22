package mx.uam.ayd.estetica.negocio;

import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.modelo.Venta;
import mx.uam.ayd.estetica.persistencia.DAOProducto;
import mx.uam.ayd.estetica.persistencia.DAOVentaProducto;

public class ServicioProducto {
	
	//inicializa Daos
	private DAOProducto daoProducto;
	private DAOVentaProducto daoVentaProducto;

	/**
	 * Constructor
	 */
	public ServicioProducto(DAOProducto daoProducto, DAOVentaProducto daoVentaProducto) {
		this.daoProducto = daoProducto;
		this.daoVentaProducto = daoVentaProducto;
	}

	/**
	 * @return un producto dela base de datos por medio del nombre
	 */
	public Producto buscaProducto(String nombre) {
		
		return daoProducto.buscaProducto(nombre);
	}
	
	/**
	 * @return true si el producto se añadio correctamente, false si no
	 */
	public boolean añadirProducto(Producto producto) {
		
		return daoProducto.añadirProducto(producto);
	}
	
	/**
	 * @return un producto de la base de datos por medio del nombre y marca del producto
	 */
	public Producto buscaProducto(String nombreProducto, String marcaProducto) {
		return daoProducto.buscaProducto(nombreProducto, marcaProducto);
	}
	
	/**
	 * Regresa los productos del registro como un arreglo de productos
	 * @return el arreglo de productos, null si falla
	 */	
	public Producto[] dameProductos() {
		// Si hubiera lógica de negocio se aplicaría aquí
		return daoProducto.dameProductos();
	}
	
	/**
	 * @return true si el producto se actualizo correctamente, false si no
	 */
	public boolean actualizaProducto(Producto producto, int id) {
		return daoProducto.actualizaProducto(producto, id);
	}
	
	/**
	 * @return true si la pieza del producto se añadio correctamente, false si no
	 */
	public boolean actualizaPiezasExistentes(int piezas, int id) {
		
		return daoProducto.actualizaPiezasExistentes(piezas,id);
	}

	/**
	 * @return true si la venta del producto se añadio correctamente, false si no
	 */
	public boolean añadirVentaProducto(Venta ven) {
		 
		return daoVentaProducto.añadirVentaProducto(ven);
	}

	/**
	 * Regresa las ventas del registro como un arreglo de ventas
	 * @return el arreglo de trabajos
	 */
	public Venta[] dameVentas() {
		return daoVentaProducto.dameVentas();
	}
	

}
