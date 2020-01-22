package mx.uam.ayd.estetica;

import mx.uam.ayd.estetica.negocio.ServicioCita;
import mx.uam.ayd.estetica.negocio.ServicioCuenta;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;
import mx.uam.ayd.estetica.negocio.ServicioProducto;
import mx.uam.ayd.estetica.negocio.ServicioProveedor;
import mx.uam.ayd.estetica.negocio.ServicioTrabajo;
import mx.uam.ayd.estetica.persistencia.DAOCita;
import mx.uam.ayd.estetica.persistencia.DAOCuentas;
import mx.uam.ayd.estetica.persistencia.DAOEmpleado;
import mx.uam.ayd.estetica.persistencia.DAOProducto;
import mx.uam.ayd.estetica.persistencia.DAOProveedor;
import mx.uam.ayd.estetica.persistencia.DAOTrabajo;
import mx.uam.ayd.estetica.persistencia.DAOVentaProducto;
import mx.uam.ayd.estetica.presentacion.ControlAñadirCuenta;
import mx.uam.ayd.estetica.presentacion.ControlAñadirEmpleado;
import mx.uam.ayd.estetica.presentacion.ControlAñadirProveedor;
import mx.uam.ayd.estetica.presentacion.ControlConsultaSueldo;
import mx.uam.ayd.estetica.presentacion.ControlConsultaVenta;
import mx.uam.ayd.estetica.presentacion.ControlModificaConsultaProveedor;
import mx.uam.ayd.estetica.presentacion.ControlModificaConsultaCita;
import mx.uam.ayd.estetica.presentacion.ControlModificaConsultaCuenta;
import mx.uam.ayd.estetica.presentacion.ControlModificaConsultaEmpleado;
import mx.uam.ayd.estetica.presentacion.ControlModificaConsultaInventario;
import mx.uam.ayd.estetica.presentacion.ControlModificaConsultaTrabajo;
import mx.uam.ayd.estetica.presentacion.VentanaPrincipal;

public class Aplicacion {
	//declaramos los DAOS
	//private DAOCuenta daoCuenta;
	private DAOEmpleado daoEmpleado;
	private DAOProducto daoProducto;
	private DAOTrabajo daoTrabajo;
	private DAOCita daoCita;
	private DAOVentaProducto daoVentaProducto;
	private DAOProveedor daoProveedor;
	private DAOCuentas daoCuenta;

	//declaramos los servicios
	//private ServicioCuenta daoServicio;
	private ServicioEmpleado servicioEmpleado;
	private ServicioProducto servicioProducto;
	private ServicioTrabajo servicioTrabajo;
	private ServicioCita servicioCita;
	private ServicioProveedor servicioProveedor;
	private ServicioCuenta servicioCuenta;

	public Aplicacion(/*DAOCuenta daoCuenta, ServicioCuenta servicioCuenta*/) {
		//inicializamos los DAOS
		//this.daoCuenta=daoCuenta;
		daoEmpleado = new DAOEmpleado();
		daoProducto = new DAOProducto();
		daoTrabajo = new DAOTrabajo();
		daoCita = new DAOCita();
		daoVentaProducto = new DAOVentaProducto();
		daoProveedor = new DAOProveedor();
		daoCuenta=new DAOCuentas();
		
		//inicializamos los Servicios
		//this.servicioCuenta=servicioCuenta;
		servicioEmpleado = new ServicioEmpleado(daoEmpleado);
		servicioCuenta = new ServicioCuenta(daoCuenta);
		
		servicioProducto = new ServicioProducto(daoProducto,daoVentaProducto);
		servicioTrabajo = new ServicioTrabajo(daoTrabajo);
		servicioCita = new ServicioCita(daoCita);
		servicioProveedor = new ServicioProveedor(daoProveedor);

	}
		
	
	//inicia la ventana principal
	public void inicia() {
		VentanaPrincipal VP = new VentanaPrincipal(this);
		VP.setVisible(true);
		

	}
	
	/*********************   CU-CONSULTA CITA  ******************************/
	/*********************   CU-MODIFICA CITA  ******************************/
	public void modificaConsultaCita() {
		
		ControlModificaConsultaCita CMCC = new ControlModificaConsultaCita(servicioCita, servicioEmpleado);
		CMCC.inicia();
	}
	
	/*********************   CU-CONSULTA INVENTARIO  ******************************/
	/*********************   CU-MODIFICA INVENTARIO  ******************************/
	public void modificaConsultaInventario() {
		
			ControlModificaConsultaInventario CMCI = new ControlModificaConsultaInventario(servicioProducto);
			CMCI.inicia(); // solo muestra ventana

		
	}
	
	/*********************   CU-CONSULTA TRABAJO  ******************************/
	/*********************   CU-MODIFICA TRABAJO  ******************************/
	public void modificaConsultaTrabajo() {
				
		ControlModificaConsultaTrabajo CMCT = new ControlModificaConsultaTrabajo(servicioTrabajo,servicioEmpleado,servicioProducto);
		CMCT.inicia();//arranca el control para  Añadir Trabajo
		
	}	
	
	/*********************   CU-AñADIR EMPLEADO  ******************************/
	public void añadirEmpleado() {
				
		ControlAñadirEmpleado CAT = new ControlAñadirEmpleado(servicioEmpleado);
		CAT.inicia();//arranca el control para  Añadir Trabajo
		
	}
	
	/*********************   CU-CONSULTA EMPLEADO  ******************************/
	/*********************   CU-MODIFICA EMPLEADO  ******************************/
	public void modificaConsultaEmpleado() {
				
		ControlModificaConsultaEmpleado CMCE = new ControlModificaConsultaEmpleado(servicioEmpleado, servicioTrabajo);
		CMCE.inicia();//arranca el control para  Añadir Trabajo
		
	}	
	
	public void consultaSalario() {
		ControlConsultaSueldo CCS = new ControlConsultaSueldo(servicioEmpleado, servicioTrabajo);
		CCS.inicia();
	}
	
	/*********************   CU-AÑADIR PROVEEDOR  ******************************/
	public void añadirProveedor() {
				
		ControlAñadirProveedor CAP = new ControlAñadirProveedor(servicioProveedor);
		CAP.inicia();//arranca el control para  Añadir Trabajo
		
	}
	
	/*********************   CU-CONSULTAR PROVEEDOR  ******************************/
	public void consultarProveedor() {
				
		ControlModificaConsultaProveedor CCP = new ControlModificaConsultaProveedor(servicioProveedor);
		CCP.inicia();//arranca el control para  Añadir Trabajo
		
	}
	
	/*********************   CU-CONSULTA VENTA  ******************************/
	public void consultaVenta() {
		ControlConsultaVenta CCV = new ControlConsultaVenta(servicioProducto);
		CCV.inicia();
	}
	
	public void añadirCuenta() {
		ControlAñadirCuenta CAC = new ControlAñadirCuenta(servicioCuenta, servicioEmpleado);
		CAC.inicia();
	}
	
	public void eliminarCuenta() {
		ControlModificaConsultaCuenta CEC = new ControlModificaConsultaCuenta(servicioCuenta, servicioEmpleado);
		CEC.inicia();
	}
	
	
	
		
	
	
	
}