package mx.uam.ayd.estetica;

import mx.uam.ayd.estetica.negocio.ServicioCita;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;
import mx.uam.ayd.estetica.negocio.ServicioPaquete;
import mx.uam.ayd.estetica.negocio.ServicioProducto;
import mx.uam.ayd.estetica.negocio.ServicioTrabajo;
import mx.uam.ayd.estetica.persistencia.DAOCita;
import mx.uam.ayd.estetica.persistencia.DAOEmpleado;
import mx.uam.ayd.estetica.persistencia.DAOPaquete;
import mx.uam.ayd.estetica.persistencia.DAOProducto;
import mx.uam.ayd.estetica.persistencia.DAOTrabajo;
import mx.uam.ayd.estetica.persistencia.DAOVentaProducto;
import mx.uam.ayd.estetica.presentacion.ControlAñadirCita;
import mx.uam.ayd.estetica.presentacion.ControlAñadirInventario;
import mx.uam.ayd.estetica.presentacion.ControlAñadirTrabajo;
import mx.uam.ayd.estetica.presentacion.ControlVenderProducto;
import mx.uam.ayd.estetica.presentacion.VentanaPrincipal2;

public class Aplicacion2 {
	//declaramos los DAOS
	//private DAOCuenta daoCuenta;
	private DAOEmpleado daoEmpleado;
	private DAOProducto daoProducto;
	private DAOTrabajo daoTrabajo;
	private DAOCita daoCita;
	private DAOVentaProducto daoVentaProducto;
	private DAOPaquete daoPaquete;
	//declaramos los servicios
	//private ServicioCuenta daoServicio;
	private ServicioEmpleado servicioEmpleado;
	private ServicioProducto servicioProducto;
	private ServicioTrabajo servicioTrabajo;
	private ServicioCita servicioCita;
	private ServicioPaquete servicioPaquete;

	public Aplicacion2(/*DAOCuenta daoCuenta, ServicioCuenta servicioCuenta*/) {
		//inicializamos los DAOS
		//this.daoCuenta=daoCuenta;
		daoEmpleado = new DAOEmpleado();
		daoProducto = new DAOProducto();
		daoTrabajo = new DAOTrabajo();
		daoCita = new DAOCita();
		daoVentaProducto = new DAOVentaProducto();
		daoPaquete = new DAOPaquete();
		
		//inicializamos los Servicios
		//this.servicioCuenta=servicioCuenta;
		servicioEmpleado = new ServicioEmpleado(daoEmpleado);
		servicioProducto = new ServicioProducto(daoProducto, daoVentaProducto);
		servicioTrabajo = new ServicioTrabajo(daoTrabajo);
		servicioCita = new ServicioCita(daoCita);
		servicioPaquete = new ServicioPaquete(daoPaquete);

	}
		
	
	//inicia la ventana principal
	public void inicia() {
		VentanaPrincipal2 VP = new VentanaPrincipal2(this);
		VP.setVisible(true);
		

	}
	/*********************   CU-AñADIR INVENTARIO  ******************************/
	public void añadirInventario() {
		ControlAñadirInventario CAI = new ControlAñadirInventario(servicioProducto);
		CAI.inicia();
	}
	
	/*********************   CU-AñADIR TRABAJO  ******************************/
	public void añadirTrabajo() {
		ControlAñadirTrabajo CAT = new ControlAñadirTrabajo(servicioTrabajo,servicioEmpleado,servicioProducto,servicioPaquete);
		CAT.inicia();//arranca el control para  Añadir Trabajo
	}	
	
	/*********************   CU-AñADIR CITA  ******************************/
	public void añadirCita() {
		ControlAñadirCita CAC = new ControlAñadirCita(servicioCita, servicioEmpleado);
		CAC.inicia();
	}

	/*********************   CU-VENDER PRODUCTO  ******************************/
	public void venderProducto() {
		ControlVenderProducto CVP = new ControlVenderProducto(servicioProducto);
		CVP.inicia();
		
	}
	

	
	
	
}