package mx.uam.ayd.estetica.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.persistencia.ManejadorBD;


/**
 * Esta clase representa una inventario de Productos
 *
 */
public class DAOProducto {


	/*********************   Constructor  ******************************/
	public DAOProducto() {

	}

	/**
	 * Permite Añadir un Producto a la inventario
	 * @return true si el Producto se agrego exitosamente, false sino
	 */
	public boolean añadirProducto(Producto producto) {

		int llave;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement.execute("insert into Producto values (DEFAULT,'"+producto.dameNombre()+"','"+producto.dameMarca()+"',"+producto.damePzaExistencia()+","+producto.damePrecio()+")",Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    llave = rs.getInt(1);
			    producto.cambiaId(llave); // Asigna la llave al producto
			}
			return true;
		} catch (SQLException e) {

			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Permite quitar un Producto al inventario
	 * @return true si el Producto se quito exitosamente, false sino
	 */
	public boolean quitaProducto(Producto producto) {

		int resultado = 0;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			resultado = statement.executeUpdate("DELETE FROM Producto WHERE nombre='"+producto.dameNombre()+"' AND marca ='"+producto.dameMarca()+"'");

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
	 * Permite buscar un Producto del inventario por su nombre
	 * @return Producto si el material se encontro exitosamente, null si no
	 */
	public Producto buscaProducto(String nombre) {

		Producto producto = null;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Producto WHERE nombre='"+nombre+"'");

			if(rs.next())
			{
				// Crea una nueva instancia del objeto
				producto = new Producto(rs.getString("nombre"), rs.getString("marca"), rs.getInt("pzaExistencia"), rs.getInt("precio"));
				producto.cambiaId(rs.getInt(1));// Asigna la llave al producto
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;

	}
	/**
	 * Permite buscar un Producto del inventario por su nombre y marca
	 * @return Producto si el material se encontro exitosamente, null si no
	 */
	public Producto buscaProducto(String nombre, String marca) {

		Producto producto = null;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Producto WHERE nombre='"+nombre+"' AND marca='"+marca+"'");

			if(rs.next())
			{
				// Crea una nueva instancia del objeto
				producto = new Producto(rs.getString("nombre"), rs.getString("marca"), rs.getInt("pzaExistencia"), rs.getInt("precio"));
				producto.cambiaId(rs.getInt(1));// Asigna la llave al producto
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;

	}

	/**
	 * Permite buscar un Producto del inventario por su id
	 * @return Producto si el material se encontro exitosamente, null si no
	 */
	public Producto buscaProducto(int id) {

		Producto producto = null;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Producto WHERE idProducto="+id);

			if(rs.next())
			{
				// Crea una nueva instancia del objeto
				producto = new Producto(rs.getString("nombre"), rs.getString("marca"), rs.getInt("pzaExistencia"), rs.getInt("precio"));
				producto.cambiaId(id);// Asigna la llave al producto
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;

	}

	/**
	 * Regresa los Productos de la libreria como un arreglo de Productos
	 * @return el arreglo de Productos
	 */
	public Producto[] dameProductos() {

		ArrayList <Producto> productosTemp = new ArrayList <Producto>();

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Producto");

			while(rs.next())
			{
				// Crea una nueva instancia del objeto
				Producto producto = new Producto(rs.getString("nombre"), rs.getString("marca"), rs.getInt("pzaExistencia"), rs.getInt("precio"));
				producto.cambiaId(rs.getInt(1));// Asigna la llave a cada producto
				productosTemp.add(producto);
			}

			Producto productosTempArreglo[]=new Producto[productosTemp.size()];
			productosTemp.toArray(productosTempArreglo);
			return productosTempArreglo;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * Regresa numero de productos en el inventario
	 * @return un entero con el numero de Productos
	 */
	public int cuantosProductos() {
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM Producto");
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
	public boolean actualizaProducto(Producto producto, int id) {

		int resultado = 0;
		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			/*solo actualizare el nombre*/
			resultado = statement.executeUpdate("UPDATE Producto set nombre='"+producto.dameNombre()+"', marca='"+producto.dameMarca()+"', "
					+ "pzaExistencia="+producto.damePzaExistencia()+" WHERE idProducto="+id);

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
	 * Permite actualizar las piezas de un producto tras su uso en el trabajo
	 * @return true si el trabajo se agrego exitosamente, false sino
	 */
	public boolean actualizaPiezasExistentes(int piezas, int id) {
		int resultado = 0;
		
		System.out.println("piezas nuevas: "+piezas);

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			resultado = statement.executeUpdate("UPDATE Producto SET pzaExistencia="+piezas+" WHERE idProducto="+id);
			System.out.println(resultado);
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


