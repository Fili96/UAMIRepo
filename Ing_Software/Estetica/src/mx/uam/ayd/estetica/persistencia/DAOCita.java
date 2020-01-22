package mx.uam.ayd.estetica.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.modelo.Trabajo;
import mx.uam.ayd.estetica.modelo.Cita;
import mx.uam.ayd.estetica.persistencia.ManejadorBD;


/**
 * Esta clase representa una Registro de Citas 
 *
 *
 */
public class DAOCita {


	/**
	 * Constructor de la clase
	 */
	public DAOCita() {

	}

	/**
	 * Permite agendar una cita
	 * @return true si la Cita se agrego exitosamente, false sino
	 */
	public boolean añadirCita(Cita cita) {

		int llave;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement.execute("insert into Cita values (DEFAULT,"+cita.dameEmpleado().dameId()+",'"+cita.dameNombreCliente()+"','"+cita.dameFecha()+"','"+cita.dameDescripcion()+"')",Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    llave = rs.getInt(1);
			    cita.cambiaId(llave); // Asigna la llave ala cita
			}
			return true;
		} catch (SQLException e) {

			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Permite quitar una cita del registro
	 * @return true si la cita se quito exitosamente, false sino
	 */
	public boolean quitaCita(Cita cita) {

		int resultado = 0;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			resultado = statement.executeUpdate("DELETE FROM Cita WHERE idCita= '"+cita.dameId()+"'");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(resultado == 0) {
			return false;
		} else {
			return true;
		}

	}
	
	
	
	// metodo que quita cita recive un id  este metodo se creo para encontrar la cita a partir de su id
	public boolean quitaCita(int id) {

		int resultado = 0;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			resultado = statement.executeUpdate("DELETE FROM Cita WHERE idCita="+id);

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
	public Cita buscaCita(int id) {

		Cita cita = null;
		DAOEmpleado daoEmpleado = new DAOEmpleado();
		
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Cita WHERE idCita="+id);

			Empleado empleado =daoEmpleado.buscaEmpleado(rs.getInt("idEmpleado"));
			
			
			if(rs.next())
			{
				cita= new Cita(empleado,rs.getString("nombreCliente"),rs.getString("fecha"),rs.getString("descripcion"));
				cita.cambiaId(id); // Asigna la llave ala cita
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cita;

	}

	
	
	public int cuantasCitas() {
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM Cita");
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
	 * Permite buscar una cita del registro por nombre del cliente
	 * @return el objeto cita si la cita se encontro exitosamente, null sino
	 */
	public Cita buscaCita(String nombreEmpleado) {

		Cita cita = null;
		DAOEmpleado daoEmpleado = new DAOEmpleado();
		
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Cita WHERE nombreEmpleado="+nombreEmpleado);

			Empleado empleado =daoEmpleado.buscaEmpleado(rs.getInt("idEmpleado"));
			
			
			if(rs.next())
			{
				cita= new Cita(empleado,rs.getString("nombreCliente"),rs.getString("fecha"),rs.getString("descripcion"));
				//cita.cambiaId(id); // Asigna la llave ala cita
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cita;

	}
	

	

	/**
	 * Regresa las citas  de agendadas en el registro como un arreglo de citas
	 * @return el arreglo de citas
	 */
	public Cita[] dameCitas() {

		ArrayList <Cita> citasTemp = new ArrayList <Cita>();
		DAOEmpleado daoEmpleado = new DAOEmpleado();
		DAOProducto daoProducto = new DAOProducto();

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Cita");
			
			
			while(rs.next())
			{
				Empleado empleado =daoEmpleado.buscaEmpleado(rs.getInt("idEmpleado"));
				// Crea una nueva instancia del objeto
				Cita cita= new Cita(empleado,rs.getString("nombreCliente"),rs.getString("fecha"),rs.getString("descripcion"));
				cita.cambiaId(rs.getInt(1));// Asigna la llave ala cita
				citasTemp.add(cita);
			}

			Cita citasTempArreglo[]=new Cita[citasTemp.size()];
			citasTemp.toArray(citasTempArreglo);
			return citasTempArreglo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


		
	/*METODO QUE ACTUALIZA CADA CAMPO DE TEXTO EN DONDE SE REALICE ALGUNA MODIFICACION */
	public boolean actualizaCita(Cita cita, int id) {

		int resultado = 0;
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			/*solo actualizare el nombre*/
			resultado = statement.executeUpdate("UPDATE Cita set idEmpleado="+cita.dameEmpleado().dameId()+", nombreCliente='"+cita.dameNombreCliente()+"',fecha='"+cita.dameFecha()+"',descripcion='"+cita.dameDescripcion()+"'  WHERE idCita="+id);

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





