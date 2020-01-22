package mx.uam.ayd.estetica.presentacion;

import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.negocio.ServicioProducto;

public class ControlAñadirInventario {
	private ServicioProducto servicioProducto;

	public ControlAñadirInventario(ServicioProducto servicioProducto) {
		this.servicioProducto = servicioProducto;
	}
      //llama al servicio regresa tru si se añadio producto al inventario 
	public boolean añadirProducto(Producto producto) {
		
		return servicioProducto.añadirProducto(producto);
	}
	
	
	
	//inicia la ventana añadir inventario desde aplicacion 
	public void inicia() {
		 VentanaAñadirInventario VAI = new VentanaAñadirInventario(this);
		 VAI.setVisible(true);
		
	}
}
