package mx.uam.ayd.estetica.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Cita;
import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.modelo.Trabajo;
import mx.uam.ayd.estetica.persistencia.ManejadorBD;

/**
 * Esta clase representa un Registro de Servicios
 *
 *
 */
public class DAOTrabajo implements DAOTrabajoContrato{

	/**
	 * Constructor de la clase
	 */
	public DAOTrabajo() {

	}

	/**
	 * Permite agregar un trabajo a la Registro
	 * 
	 * @return true si el trabajo se agrego exitosamente, false sino
	 */
	public boolean añadirTrabajo(Trabajo trabajo) {

		int llave;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement.execute("insert into Trabajo values (DEFAULT,'" + trabajo.dameNombre() + "',"
					+ trabajo.dameEmpleado().dameId() + ",'" + trabajo.dameDescripcion() + "'," + trabajo.dameMonto()
					+ ",'" + trabajo.dameFecha() + "'," + trabajo.dameProducto().dameId() + ","
					+ trabajo.damePzaUsadas() + ")", Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
				llave = rs.getInt(1);
				System.out.println("llave: " + llave);
				trabajo.cambiaId(llave); // Asigna la llave al trabajo
			}
			return true;
		} catch (SQLException e) {

			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Permite quitar un trabajo en el registro
	 * 
	 * @return true si el trabajo se quito exitosamente, false sino
	 */
	public boolean quitaTrabajo(Trabajo trabajo) {

		int resultado = 0;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			resultado = statement.executeUpdate("DELETE FROM Trabajo WHERE idTrabajo= '" + trabajo.dameId() + "'");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (resultado == 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Permite buscar un trabajo en el registro por medio del id
	 * 
	 * @return el trabajo si el trabajo se encontro exitosamente, null sino
	 */
	public Trabajo buscaTrabajo(int id) {

		Trabajo trabajo = null;
		DAOEmpleado daoEmpleado = new DAOEmpleado();
		DAOProducto daoProducto = new DAOProducto();

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Trabajo WHERE idTrabajo=" + id);

			Empleado empleado = daoEmpleado.buscaEmpleado(rs.getInt("idEmpleado"));
			Producto producto = daoProducto.buscaProducto(rs.getInt("idProducto"));

			if (rs.next()) {
				trabajo = new Trabajo(rs.getString("nombre"), empleado, rs.getString("descripcion"),
						rs.getDouble("monto"), rs.getString("fecha"), producto, rs.getInt("pzaUsadas"));
				trabajo.cambiaId(id);// Asigna la llave al trabajo
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trabajo;

	}

	/**
	 * Regresa los trabajos del registro como un arreglo de trabajos
	 * 
	 * @return el arreglo de trabajos
	 */
	public Trabajo[] dameTrabajos() {

		ArrayList<Trabajo> trabajosTemp = new ArrayList<Trabajo>();
		DAOEmpleado daoEmpleado = new DAOEmpleado();
		DAOProducto daoProducto = new DAOProducto();

		Empleado empleado;
		Producto producto;
		int idEmpleado;
		int idProducto;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Trabajo");

			while (rs.next()) {
				idEmpleado = rs.getInt("idEmpleado");
				empleado = daoEmpleado.buscaEmpleado(idEmpleado);

				idProducto = rs.getInt("idProducto");
				producto = daoProducto.buscaProducto(idProducto);

				// Crea una nueva instancia del objeto

				Trabajo trabajo = new Trabajo(rs.getString("nombre"), empleado, rs.getString("descripcion"),
						rs.getDouble("monto"), rs.getString("fecha"), producto, rs.getInt("pzaUsadas"));
				trabajo.cambiaId(rs.getInt(1));// Asigna la llave al trabajo
				trabajosTemp.add(trabajo);
			}

			Trabajo trabajosTempArreglo[] = new Trabajo[trabajosTemp.size()];
			trabajosTemp.toArray(trabajosTempArreglo);
			return trabajosTempArreglo;
		} catch (SQLException e) {
			System.out.println("fallo el query");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Regresa numero de trabajos en el registro
	 * 
	 * @return un entero con el numero de trabajos
	 */
	public int cuantosTrabajos() {
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM Trabajo");
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * regresa un boleano que indica que la actualizacion fue correcta o no
	 * 
	 * @return true si la actualizacion fue exitosa
	 */
	public boolean actualizaTrabajo(Trabajo trabajo) {

		int resultado = 0;

		int idEmpleado = trabajo.dameEmpleado().dameId();
		int idProducto = trabajo.dameProducto().dameId();

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados

			resultado = statement.executeUpdate("UPDATE Trabajo set nombre='" + trabajo.dameNombre() + "', idEmpleado="
					+ idEmpleado + ", descripcion='" + trabajo.dameDescripcion() + "', monto=" + trabajo.dameMonto()
					+ ", fecha='" + trabajo.dameFecha() + "', idProducto=" + idProducto + ", pzaUsadas="
					+ trabajo.damePzaUsadas() + " WHERE idTrabajo=" + trabajo.dameId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (resultado == 0) {
			return false;
		} else {
			return true;
		}

	}
	
	public double[] dameCostoTrabajos(int id) {
		DAOEmpleado daoempleado = new DAOEmpleado();
		double[] costos = new double[cuantosTrabajos()];
		
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT monto FROM Trabajo WHERE idEmpleado="+id);
			int i=0;
			while(rs.next())
			{
				costos[i]=rs.getDouble("monto");
				i++;
			}

			return costos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public Trabajo[] dameTrabajosEmpleado(int id) {

		ArrayList<Trabajo> trabajosTemp = new ArrayList<Trabajo>();
		DAOEmpleado daoEmpleado = new DAOEmpleado();
		DAOProducto daoProducto = new DAOProducto();

		Empleado empleado;
		Producto producto;
		int idEmpleado;
		int idProducto;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Trabajo Where idEmpleado="+id);

			while (rs.next()) {
				idEmpleado = rs.getInt("idEmpleado");
				empleado = daoEmpleado.buscaEmpleado(idEmpleado);

				idProducto = rs.getInt("idProducto");
				producto = daoProducto.buscaProducto(idProducto);

				// Crea una nueva instancia del objeto

				Trabajo trabajo = new Trabajo(rs.getString("nombre"), empleado, rs.getString("descripcion"),
						rs.getDouble("monto"), rs.getString("fecha"), producto, rs.getInt("pzaUsadas"));
				trabajo.cambiaId(rs.getInt(1));// Asigna la llave al trabajo
				trabajosTemp.add(trabajo);
			}

			Trabajo trabajosTempArreglo[] = new Trabajo[trabajosTemp.size()];
			trabajosTemp.toArray(trabajosTempArreglo);
			return trabajosTempArreglo;
		} catch (SQLException e) {
			System.out.println("fallo el query");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
