package mx.uam.ayd.estetica.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Proveedor;
import mx.uam.ayd.estetica.persistencia.ManejadorBD;


/**
 * Esta clase representa un Registro de proveedores
 *
 *
 */
public class DAOProveedor implements DAOProveedorContrato{


	/**
	 * Constructor de la clase
	 */
	public DAOProveedor() {

	}

	/**
	 * Permite agregar un proveedor al registro
	 * @return true si el proveedor se agrego exitosamente, false sino
	 */
	public boolean añadirProveedor(Proveedor proveedor) {

		int llave;
		
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement.execute("insert into Proveedor values (DEFAULT,'"+proveedor.dameNombre()+"','"+proveedor.dameDescripcion()+"','"+proveedor.dameDomicilio()+"','"+proveedor.dameTelefono()+"')",Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    llave = rs.getInt(1);
			    proveedor.cambiaId(llave); // Asigna la llave al empleado
			    
			}
			return true;
		} catch (SQLException e) {

			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Permite quitar un proveedor a la librería
	 * @return true si el proveedor se quito exitosamente, false sino
	 */
	public boolean quitaProveedor(Proveedor proveedor) {

		int resultado = 0;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			resultado = statement.executeUpdate("DELETE FROM Proveedor WHERE nombre='"+proveedor.dameNombre()+"'");

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
	 * Permite buscar un empleado en el registro por medio del nombre
	 * @return el empleado si el empleado se encontro exitosamente, null sino
	 */
	public Proveedor buscaProveedor(String nombre) {

		Proveedor proveedor = null;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Proveedor WHERE nombre='"+nombre+"'");

			if(rs.next())
			{
				// Crea una nueva instancia del objeto
				proveedor = new Proveedor(rs.getString("nombre"),rs.getString("descripcion"),rs.getString("domicilio"), rs.getString("telefono"));
				proveedor.cambiaId(rs.getInt(1));// Asigna la llave al empleado
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proveedor;

	}

	/**
	 * Permite buscar un proveedor en el registro por medio del id
	 * @return el proveedor si el proveedor se encontro exitosamente, null sino
	 */
	public Proveedor buscaProveedor(int id) {

		Proveedor proveedor = null;
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Proveedor WHERE idProveedor="+id);

			if(rs.next())
			{
				// Crea una nueva instancia del objeto
				proveedor = new Proveedor(rs.getString("nombre"),rs.getString("descripcion"),rs.getString("domicilio"), rs.getString("telefono"));
				proveedor.cambiaId(id);// Asigna la llave al empleado
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proveedor;

	}

	/**
	 * Regresa los proveedor del registro como un arreglo de proveedor
	 * @return el arreglo de proveedor
	 */
	public Proveedor[] dameProveedor() {

		ArrayList <Proveedor> proveedorTemp = new ArrayList <Proveedor>();

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Proveedor");

			while(rs.next())
			{
				// Crea una nueva instancia del objeto
				Proveedor proveedor = new Proveedor(rs.getString("nombreProveedor"),rs.getString("descripcion"),rs.getString("domicilio"),rs.getString("telefono"));
				proveedor.cambiaId(rs.getInt(1));// Asigna la llave al empleado
				proveedorTemp.add(proveedor);
			}

			Proveedor proveedorTempArreglo[]=new Proveedor[proveedorTemp.size()];
			proveedorTemp.toArray(proveedorTempArreglo);
			return proveedorTempArreglo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * Regresa numero de proveedores en el registro
	 * @return un entero con el numero de empleados
	 */
	public int cuantosProveedores() {
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM Empleado");
			if (rs.next()) {
		        return rs.getInt(1);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public void actualizaSalario(double salario, int idEmpleado) {
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			/*solo actualizare el salario*/
			statement.executeUpdate("UPDATE Empleado set sueldo ="+salario+" WHERE idEmpleado="+idEmpleado);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public boolean quitaProveedor(int id) {

		int resultado = 0;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			resultado = statement.executeUpdate("DELETE FROM Proveedor WHERE idProveedor="+id);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(resultado == 0) {
			return false;
		} else {
			return true;
		}

	}
	
}


