
import java.util.Arrays;


public class Nodo_BFS {
	
	int arreglo[]=new int[4];
	Nodo_BFS padre;
	Nodo_BFS hijos[];
	
	
	public Nodo_BFS(int [] arreglo) {
		this.arreglo=arreglo;
		this.padre=null;
		this.hijos=null;
		sethijos(null,null);
	}

	void sethijos(Nodo_BFS[] hijos, Nodo_BFS nodo){
		this.hijos=hijos;
		if(this.hijos!=null){
			for(Nodo_BFS aux: hijos){
				aux.padre=nodo;
			}
		}
	}
	
	String getarregloencadena(int[] arreglo){
        return Arrays.toString(arreglo);
    }
	
}
