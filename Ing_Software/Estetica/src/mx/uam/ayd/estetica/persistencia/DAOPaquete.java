package mx.uam.ayd.estetica.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Paquete;
import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.modelo.Trabajo;

public class DAOPaquete {

	public DAOPaquete() {

	}

	/**
	 * Permite buscar un empleado en el registro por medio del nombre
	 * 
	 * @return el empleado si el empleado se encontro exitosamente, null sino
	 */
	public Paquete buscaPaquete(String nombre) {

		Paquete paquete = null;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Paquete WHERE nombrePaquete='" + nombre + "'");

			if (rs.next()) {
				// Crea una nueva instancia del objeto
				paquete = new Paquete(rs.getString("puntos"), rs.getString("nombrePaquete"),
						rs.getString("descripcion"));
				paquete.cambiaId(rs.getInt(1));// Asigna la llave al empleado
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paquete;

	}

	/**
	 * Regresa los empleados del registro como un arreglo de empleados
	 * 
	 * @return el arreglo de empleados
	 */
	public Paquete[] damePaquetes(String puntosPaquete) {
		System.out.println("dao");
		ArrayList<Paquete> paquetesTemp = new ArrayList<Paquete>();

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Paquete WHERE puntos ='" +puntosPaquete.trim()+ "'");

			while (rs.next()) {
				// Crea una nueva instancia del objeto
				Paquete paquete = new Paquete(rs.getString("nombrePaquete"), rs.getString("descripcion"),rs.getString("puntos"));
				paquete.cambiaId(rs.getInt(1));// Asigna la llave al empleado
				paquetesTemp.add(paquete);
			}

			Paquete paquetesTempArreglo[] = new Paquete[paquetesTemp.size()];
			paquetesTemp.toArray(paquetesTempArreglo);
			return paquetesTempArreglo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Regresa numero de empleados en el registro
	 * 
	 * @return un entero con el numero de empleados
	 */

}
