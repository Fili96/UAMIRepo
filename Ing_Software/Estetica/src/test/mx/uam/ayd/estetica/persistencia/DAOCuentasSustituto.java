package test.mx.uam.ayd.estetica.persistencia;

import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Cuenta;
import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.persistencia.DAOCuentaContrato;

public class DAOCuentasSustituto implements DAOCuentaContrato{

	@Override
	public boolean añadirCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean quitaCuenta(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cuenta buscaCuenta(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cuantasCuentas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cuenta[] dameCuentas() {
		Empleado emp = new Empleado("nombre", "apellido", "la purisima", "27-03-18", 300.5);
		
		Cuenta c1 = new Cuenta("fili xD", emp, "filiberto");
		Cuenta c2 = new Cuenta("emp2", emp, "123");
		
		Cuenta[] arreglo = {c1,c2};
	
		return arreglo;
	}

	@Override
	public boolean actualizaCuenta(Cuenta cuenta, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buscaCuenta(String usuario, String contraseña) {
		// TODO Auto-generated method stub
		return false;
	}

}
