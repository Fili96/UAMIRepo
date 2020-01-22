package mx.uam.ayd.estetica.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.modelo.Trabajo;
import mx.uam.ayd.estetica.modelo.Venta;


public class DAOVentaProducto {

	/**
	 * Permite Añadir un Producto a la inventario
	 * @return true si el Producto se agrego exitosamente, false sino
	 */
	public boolean añadirVentaProducto(Venta venta) {

		int llave;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement.execute("insert into VentaProducto values (DEFAULT,"+venta.dameProducto().dameId()+","+venta.damePzaVendida()+","+venta.dameTotal()+")",Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    llave = rs.getInt(1);
			    venta.cambiaId(llave); // Asigna la llave al producto
			}
			return true;
		} catch (SQLException e) {

			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa las ventas del registro como un arreglo de ventas
	 * 
	 * @return el arreglo de ventas
	 */
	public Venta[] dameVentas() {

		ArrayList<Venta> ventasTemp = new ArrayList<>();
		DAOProducto daoProducto = new DAOProducto();

		Producto producto;
		int idProducto;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM VentaProducto");

			while (rs.next()) {

				idProducto = rs.getInt("idProducto");
				producto = daoProducto.buscaProducto(idProducto);

				// Crea una nueva instancia del objeto

				Venta venta = new Venta(producto, rs.getInt("pzaVendida"),rs.getInt("total"));
				venta.cambiaId(rs.getInt(1));// Asigna la llave al trabajo
				ventasTemp.add(venta);
			}

			Venta ventasTempArreglo[] = new Venta[ventasTemp.size()];
			ventasTemp.toArray(ventasTempArreglo);
			return ventasTempArreglo;
		} catch (SQLException e) {
			System.out.println("fallo el query");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
