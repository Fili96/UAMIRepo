package mx.uam.ayd.estetica.presentacion;

import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.negocio.ServicioProducto;

public class ControlModificaConsultaInventario {
	private ServicioProducto servicioProducto;

	public ControlModificaConsultaInventario(ServicioProducto servicioProducto) {
		/*inicializamos el servicio*/
		this.servicioProducto = servicioProducto;
	}
	
	public void inicia() {
		//inicia la ventana del caso de uso
		VentanaModificaConsultaInventario VMCI = new VentanaModificaConsultaInventario(this);		
		/*hace visible la ventana*/
		VMCI.setVisible(true);
	}

	/*metodo que regresa productos, llama al servicio*/
	public Producto[] dameProductos() {
		return servicioProducto.dameProductos();
	}

	/*metodo que actualiza producto, llama al servicio*/
	public boolean actualizaProducto(Producto producto, int id) {
		return servicioProducto.actualizaProducto(producto, id);
	}

	
	
}
