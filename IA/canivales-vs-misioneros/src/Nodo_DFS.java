import java.util.Arrays;

public class Nodo_DFS {
	
	int arreglo[]=new int[5];
	Nodo_DFS padre;
	Nodo_DFS hijos[];
	
	
	public Nodo_DFS(int [] arreglo) {
		this.arreglo=arreglo;
		this.padre=null;
		this.hijos=null;
		sethijos(null,null);
	}

	void sethijos(Nodo_DFS[] hijos, Nodo_DFS nodo){
		this.hijos=hijos;
		if(this.hijos!=null){
			for(Nodo_DFS aux: hijos){
				aux.padre=nodo;
			}
		}
	}
        
        Nodo_DFS [] gethijos(){
            return this.hijos;
        }

}

