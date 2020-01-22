package mx.uam.ayd.estetica.presentacion;

import java.util.ArrayList;

import javax.swing.JButton;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.modelo.Trabajo;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;
import mx.uam.ayd.estetica.negocio.ServicioProducto;
import mx.uam.ayd.estetica.negocio.ServicioTrabajo;

public class ControlModificaConsultaTrabajo {
	
	/**
	 * Servicios Requeridos
	 */
	private ServicioTrabajo servicioTrabajo;
	private ServicioEmpleado servicioEmpleado;
	private ServicioProducto servicioProducto;
	private JButton jButtonModificar;
	private JButton jButtonColocar;

	/**
	 * Constructor de la clase
	 */
	public ControlModificaConsultaTrabajo(ServicioTrabajo servicioTrabajo, ServicioEmpleado servicioEmpleado,ServicioProducto servicioProducto) {
		this.servicioTrabajo = servicioTrabajo;
		this.servicioEmpleado = servicioEmpleado;
		this.servicioProducto= servicioProducto;
	}

	/**
	 * inicia la vista del caso de uso
	 */
	public void inicia() {
		VentanaModificaConsultaTrabajo ventanaConsultaTrabajo = new VentanaModificaConsultaTrabajo(this);
		ventanaConsultaTrabajo.setVisible(true);
	}

	/**
	 * permite regresar una matriz de tipo object
	 * con los datos de los trabajos
	 */
	public Object[][] dameTrabajos() {

		ArrayList<Object[]> trabajosTemp = new ArrayList<>();//lista de trabajos temporales
		jButtonModificar = new JButton("Modificar");
		jButtonModificar.setName("mod");
		jButtonColocar = new JButton("Colocar");
		jButtonColocar.setName("col");

		//por cada trabajo en el registro  se crea un arreglo de tipo object con sus datos
		//y se agrega a la lista temporal de trabajos
		for (Trabajo t : servicioTrabajo.dameTrabajos() ) {
			
			Object [] aux = { t.dameId(), t.dameNombre(),t.dameEmpleado().dameNombre(),t.dameDescripcion(),t.dameMonto()
					,t.dameFecha(),t.dameProducto().dameNombre(),t.damePzaUsadas(),jButtonColocar,jButtonModificar
					};
			
			trabajosTemp.add(aux);
		}
		//se convierte la lista de trabajos temporales a una matriz
		Object[][] trabajos = new Object[trabajosTemp.size()][];
		int i = 0;
		for (Object[] s : trabajosTemp) {
			trabajos[i] = s;
			i++;
		}

		return trabajos;
	}
	
	/**
	 * Regresa los empleados del registro como un arreglo de empleados
	 * @return el arreglo de empleados
	 */
	public Empleado[] dameEmpleados() {
		return servicioEmpleado.dameEmpleados();
	}
	
	/**
	 * permite regresar un arreglo de cadenas
	 * con los nombres de los empleados
	 */
	public String[] dameNombreEmpleados(Empleado[] empleados) {
		ArrayList<String> lista = new ArrayList<>();
		for(Empleado e : empleados) {
			lista.add(e.dameNombre());
		}
		String[] nombres = new String[lista.size()];
		return lista.toArray(nombres);
	}
	/**
	 * Regresa los Productos de la libreria como un arreglo de Productos
	 * @return el arreglo de Productos
	 */
	public Producto[] dameProductos() {
		return servicioProducto.dameProductos();
	}
	/**
	 * permite regresar un arreglo de cadenas
	 * con los nombres de los productos
	 */
	public String[] dameNombreProductos(Producto[] productos) {
		ArrayList<String> lista = new ArrayList<>();
		for(Producto p : productos) {
			lista.add(p.dameNombre());
		}
		String[] nombres = new String[lista.size()];
		return lista.toArray(nombres);
	}
	/**
	 * Permite buscar un Producto del inventario por su nombre
	 * @return Producto si el material se encontro exitosamente, null si no
	 */
	public Producto buscaProducto(String nombreProducto) {
		// TODO Auto-generated method stub
		return servicioProducto.buscaProducto(nombreProducto);
	}
	/**
	 * Permite buscar un empleado en el registro por medio del id
	 * @return el empleado si el empleado se encontro exitosamente, null sino
	 */
	public Empleado buscaEmpleado(String nombreEmpleado) {
		// TODO Auto-generated method stub
		return servicioEmpleado.buscaEmpleado(nombreEmpleado);
	}
	/*
	 * regresa un boleano que indica que la actualizacion fue correcta o no
	 * @return true si la actualizacion fue exitosa
	 */
	public boolean actualizaTrabajo(int id, String servicio, Empleado empleado, String descripcion, double monto,
			String fecha, Producto producto, int pzaUsadas) {
		
		return servicioTrabajo.actualizaTrabajo(id,servicio,empleado,descripcion,monto,fecha,producto,pzaUsadas);
	}
	
}
