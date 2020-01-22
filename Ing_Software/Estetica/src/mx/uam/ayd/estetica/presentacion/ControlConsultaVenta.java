package mx.uam.ayd.estetica.presentacion;

import java.util.ArrayList;

import javax.swing.JButton;

import mx.uam.ayd.estetica.modelo.Trabajo;
import mx.uam.ayd.estetica.modelo.Venta;
import mx.uam.ayd.estetica.negocio.ServicioProducto;

public class ControlConsultaVenta {

	ServicioProducto servicioProducto;
	
	public ControlConsultaVenta(ServicioProducto servicioProducto) {
		this.servicioProducto=servicioProducto;
	}

	public void inicia() {
		VentanaConsultarVenta obj = new VentanaConsultarVenta(this);
		obj.setVisible(true);
	}

	public Object[][] dameVentas() {
		
		ArrayList<Object[]> ventasTemp = new ArrayList<>();//lista de ventas temporales

		//por cada trabajo en el registro  se crea un arreglo de tipo object con sus datos
		//y se agrega a la lista temporal de trabajos
		for (Venta v : servicioProducto.dameVentas() ) {
			
			Object [] aux = { v.dameId(), v.dameProducto().dameNombre(), v.dameProducto().dameMarca(),
							  v.dameProducto().damePrecio(),v.damePzaVendida(),v.dameTotal()};
			
			ventasTemp.add(aux);
		}
		//se convierte la lista de ventas temporales a una matriz
		Object[][] ventas = new Object[ventasTemp.size()][];
		int i = 0;
		for (Object[] s : ventasTemp) {
			ventas[i] = s;
			i++;
		}

		return ventas;
		
	}

}
