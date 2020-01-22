package mx.uam.ayd.estetica.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.persistencia.ManejadorBD;


/**
 * Esta clase representa un Registro de empleados
 *
 *
 */
public class DAOEmpleado implements DAOEmpleadoContrato {


	/**
	 * Constructor de la clase
	 */
	public DAOEmpleado() {

	}

	/**
	 * Permite agregar un empleado al registro
	 * @return true si el empleado se agrego exitosamente, false sino
	 */
	public boolean añadirEmpleado(Empleado empleado) {

		int llave;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement.execute("insert into Empleado values (DEFAULT,'"+empleado.dameNombre()+"','"+empleado.dameApellido()+"','"+empleado.dameDomicilio()+"','"+empleado.dameFecha()+"',"+empleado.dameSueldo()+")",Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    llave = rs.getInt(1);
			    empleado.cambiaId(llave); // Asigna la llave al empleado
			    
			}
			return true;
		} catch (SQLException e) {

			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Permite quitar un empleado a la librería
	 * @return true si el empleado se quito exitosamente, false sino
	 */
	// metodo que quita cita recive un id  este metodo se creo para encontrar la cita a partir de su id
	public boolean quitaEmpleado(int id) {

		int resultado = 0;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			resultado = statement.executeUpdate("DELETE FROM Empleado WHERE idEmpleado="+id);

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
	public Empleado buscaEmpleado(String nombre) {

		Empleado empleado = null;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Empleado WHERE nombre='"+nombre+"'");

			if(rs.next())
			{
				// Crea una nueva instancia del objeto
				empleado = new Empleado(rs.getString("nombre"));
				empleado.cambiaId(rs.getInt(1));// Asigna la llave al empleado
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleado;

	}

	/**
	 * Permite buscar un empleado en el registro por medio del id
	 * @return el empleado si el empleado se encontro exitosamente, null sino
	 */
	public Empleado buscaEmpleado(int id) {

		Empleado empleado = null;
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Empleado WHERE idEmpleado="+id);

			if(rs.next())
			{
				// Crea una nueva instancia del objeto
				empleado = new Empleado(rs.getString("nombre"));
				empleado.cambiaId(id);// Asigna la llave al empleado
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleado;

	}

	/**
	 * Regresa los empleados del registro como un arreglo de empleados
	 * @return el arreglo de empleados
	 */
	public Empleado[] dameEmpleados() {

		ArrayList <Empleado> empleadosTemp = new ArrayList <Empleado>();

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Empleado");

			while(rs.next())
			{
				// Crea una nueva instancia del objeto
				Empleado empleado = new Empleado(rs.getString("nombre"),rs.getString("apellido"),rs.getString("domicilio"),rs.getString("fecha"), rs.getDouble("sueldo") );
				empleado.cambiaId(rs.getInt(1));// Asigna la llave al empleado
				empleadosTemp.add(empleado);
			}

			Empleado empleadosTempArreglo[]=new Empleado[empleadosTemp.size()];
			empleadosTemp.toArray(empleadosTempArreglo);
			return empleadosTempArreglo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * Regresa numero de empleados en el registro
	 * @return un entero con el numero de empleados
	 */
	public int cuantosEmpleados() {
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

	
	/*metodo agregado */
	public boolean actualizaEmpleado(Empleado empleado, int id) {

		int resultado = 0;
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			/*solo actualizare el nombre*/
			resultado = statement.executeUpdate("UPDATE Empleado set nombre='"+empleado.dameNombre()+"', "
																  + "apellido='"+empleado.dameApellido()+"', "
																  + "domicilio='"+empleado.dameDomicilio()+"', "
																  + "fecha='"+empleado.dameFecha()+"' , "
																  + "sueldo="+empleado.dameSueldo()+" "
																  + "WHERE idEmpleado="+id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(resultado == 0) {
			return false;
		} else {
			return true;
		}
		
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
}


