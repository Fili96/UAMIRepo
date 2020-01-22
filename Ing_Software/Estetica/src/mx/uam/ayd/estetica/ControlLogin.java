package mx.uam.ayd.estetica;

import javax.swing.JOptionPane;

import mx.uam.ayd.estetica.modelo.Cuenta;
import mx.uam.ayd.estetica.negocio.ServicioCuenta;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;
import mx.uam.ayd.estetica.negocio.ServicioTrabajo;
import mx.uam.ayd.estetica.persistencia.DAOCuentas;
import mx.uam.ayd.estetica.persistencia.DAOEmpleado;
import mx.uam.ayd.estetica.persistencia.DAOTrabajo;
//import mx.uam.ayd.estetica.presentacion.ControlEmpleadoDelmes;
import mx.uam.ayd.estetica.presentacion.VentanaEmpleadoDelMes;

public class ControlLogin {
	
	private DAOCuentas daoCuenta;
	private ServicioCuenta servicioCuenta;

	public ControlLogin() {
		
		//inicializamos el DAOCuenta
		daoCuenta = new DAOCuentas();
		//inicializamos los Servicios
		servicioCuenta = new ServicioCuenta(daoCuenta);
		
	}
	
	//inicia la ventana login
	public void inicia() {
		new VentanaLogin(this);
	}
	
	//arranca el SISTEMA
	public static void main(String[] args) {
		ControlLogin ctrlLogin = new ControlLogin();
		ctrlLogin.inicia();
	}

	public boolean validaCuentaAdmin(String usuario, String contraseña) {
		if(servicioCuenta.validaCuentaAdmin(usuario, contraseña)) {
			Aplicacion app = new Aplicacion();
			app.inicia();
			return true;
		}
		return false;
	}

	public boolean validaCuentaUsuario(String usuario, String contraseña) {
		if(servicioCuenta.validaCuentaUsuario(usuario, contraseña)) {
			Aplicacion2 app = new Aplicacion2();
			app.inicia();
			return true;
		}
		return false;
		
	}
}