package mx.uam.ayd.estetica.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mx.uam.ayd.estetica.modelo.Cuenta;

public interface DAOCuentaContrato {

	public boolean añadirCuenta(Cuenta cuenta);
	public boolean quitaCuenta(int id);
	public Cuenta buscaCuenta(int id);
	public int cuantasCuentas();
	public Cuenta[] dameCuentas();
	public boolean actualizaCuenta(Cuenta cuenta, int id);
	public boolean buscaCuenta(String usuario, String contraseña);
}
