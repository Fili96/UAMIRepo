package mx.uam.ayd.estetica.modelo;

public class Venta {
	
	
	/******Atributos*********/
	private int id;
	private Producto producto;
	private int pzaVendida;
	private int total;
	
	/*********************   Constructor  ******************************/

	public Venta(Producto producto, int pzaVendida, int total) {
		this.producto=producto;
		this.pzaVendida=pzaVendida;
		this.total=total;
	}
	
	/*********************   SETs y GETs  ******************************/
	
	/******id*********/
	
	public void cambiaId(int id) {
		this.id=id;
		
	}
	
	public int dameId() {
		return id;
		
	}
	
	/******Producto*********/
	
	
	public Producto dameProducto(){
		return producto;
	}
	
	public void cambiaProducto(Producto producto){
		this.producto=producto;
	}
	
	
	/******pzaVendida*********/

	public int damePzaVendida() {
		return pzaVendida;
	}


	public void cambiaPzaVendida(int pzaVendida) {
		this.pzaVendida = pzaVendida;
	}

	/******total*********/

	public int dameTotal() {
		return total;
	}


	public void cambiaTotal(int total) {
		this.total = total;
	}
	
}
