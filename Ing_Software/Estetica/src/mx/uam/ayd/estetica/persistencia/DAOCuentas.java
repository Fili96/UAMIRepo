package mx.uam.ayd.estetica.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Cita;
import mx.uam.ayd.estetica.modelo.Cuenta;
import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Producto;

public class DAOCuentas implements DAOCuentaContrato{

	public DAOCuentas() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean añadirCuenta(Cuenta cuenta) {

		int llave;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement.execute("insert into Cuenta values (DEFAULT,'"+cuenta.dameNombre()+"',"+cuenta.dameEmpleado().dameId()+",'"+cuenta.dameContraseña()+"')",Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    llave = rs.getInt(1);
			    cuenta.cambiaId(llave); // Asigna la llave al producto
			}
			return true;
		} catch (SQLException e) {

			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	
	
	
	// metodo que quita cita recive un id  este metodo se creo para encontrar la cita a partir de su id
	public boolean quitaCuenta(int id) {

		int resultado = 0;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			resultado = statement.executeUpdate("DELETE FROM Cuenta WHERE idCuenta="+id);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(resultado == 0) {
			return false;
		} else {
			return true;
		}

	}
	
	/**
	 * Permite buscar una cita del registro por id
	 * @return la cita si la cita se encontro exitosamente, null sino
	 */
	public Cuenta buscaCuenta(int id) {

		Cuenta cuenta = null;
		DAOEmpleado daoEmpleado = new DAOEmpleado();
		
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Cuenta WHERE idCuenta="+id);

			Empleado empleado =daoEmpleado.buscaEmpleado(rs.getInt("idEmpleado"));
			
			
			if(rs.next())
			{
				cuenta= new Cuenta(rs.getString("nombre"),empleado,rs.getString("contraseña"));
				cuenta.cambiaId(id); // Asigna la llave ala cita
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cuenta;

	}

	
	
	public int cuantasCuentas() {
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM Cuenta");
			if (rs.next()) {
		        return rs.getInt(1);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	

	

	

	/**
	 * Regresa las citas  de agendadas en el registro como un arreglo de citas
	 * @return el arreglo de citas
	 */
	public Cuenta[] dameCuentas() {

		ArrayList <Cuenta> cuentasTemp = new ArrayList <Cuenta>();
		DAOEmpleado daoEmpleado = new DAOEmpleado();
		DAOProducto daoProducto = new DAOProducto();

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Cuenta");
			
			
			while(rs.next())
			{
				Empleado empleado =daoEmpleado.buscaEmpleado(rs.getInt("idEmpleado"));
				// Crea una nueva instancia del objeto
				Cuenta cuenta= new Cuenta(rs.getString("nombre"),empleado,rs.getString("contraseña"));
				cuenta.cambiaId(rs.getInt(1));// Asigna la llave ala cita
				cuentasTemp.add(cuenta);
			}

			Cuenta cuentasTempArreglo[]=new Cuenta[cuentasTemp.size()];
			cuentasTemp.toArray(cuentasTempArreglo);
			return cuentasTempArreglo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


		
	/*METODO QUE ACTUALIZA CADA CAMPO DE TEXTO EN DONDE SE REALICE ALGUNA MODIFICACION */
	public boolean actualizaCuenta(Cuenta cuenta, int id) {

		int resultado = 0;
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			/*solo actualizare el nombre*/
			resultado = statement.executeUpdate("UPDATE Cuenta set idEmpleado="+cuenta.dameEmpleado().dameId()+", nombreCuenta='"+cuenta.dameNombre()+"',contraseña='"+cuenta.dameContraseña()+"'  WHERE idCuenta="+id);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(resultado == 0) {
			return false;
		} else {
			return true;
		}
		
	}
	
	public boolean buscaCuenta(String usuario, String contraseña) {


		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement.execute("SELECT * FROM Cuenta WHERE nombre='"+usuario+"' AND contraseña = '"+contraseña+"'");
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			
			return true;
		} catch (SQLException e) {
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

		
	
	
	
	
	
	

}
