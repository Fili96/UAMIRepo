package mx.uam.ayd.estetica.persistencia;

import mx.uam.ayd.estetica.modelo.Proveedor;

public interface DAOProveedorContrato {
	
	public boolean añadirProveedor(Proveedor proveedor);
	public Proveedor buscaProveedor(String nombre);	
	public boolean quitaProveedor(Proveedor proveedor);
	public Proveedor buscaProveedor(int id);
	public Proveedor[] dameProveedor();
	public int cuantosProveedores();
	public void actualizaSalario(double salario, int idEmpleado);
	public boolean quitaProveedor(int id);

}
