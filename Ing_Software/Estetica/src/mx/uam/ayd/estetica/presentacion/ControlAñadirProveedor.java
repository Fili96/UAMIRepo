package mx.uam.ayd.estetica.presentacion;


import mx.uam.ayd.estetica.modelo.Proveedor;
import mx.uam.ayd.estetica.negocio.ServicioProveedor;

public class ControlAñadirProveedor {
	/**   DECLARACION DE ATRIBUTOS**/
	private ServicioProveedor servicioProveedor;
	private VentanaAñadirProveedor VAP;
	
	/** CONTRUCTOR DONDE SE INICIALIZACION**/
	public ControlAñadirProveedor(ServicioProveedor servicioProveedor){
		this.servicioProveedor = servicioProveedor;

	}
	
	public void inicia() {
		/** inicia la ventana del caso de uso **/
		VAP = new VentanaAñadirProveedor(this);
		VAP.setVisible(true);
	}
	
	public void finaliza() {
		
	}
	
	public boolean añadirProveedor(String nombre,String descripcion, String domicilio, String telefono) {
		
		return servicioProveedor.añadirProveedor(nombre,descripcion,domicilio,telefono);
	}
}
