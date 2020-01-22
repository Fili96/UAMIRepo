import java.util.Arrays;
import java.util.LinkedList;

public class PilasGLL {

private LinkedList <Nodo_DFS> info= new LinkedList<Nodo_DFS>();
	
	public PilasGLL(){
		
	}
	
	void push(Nodo_DFS x){
		info.addFirst(x);
	}
	
	Nodo_DFS obtenerNodo(int i){
		return info.get(i);
	}
	
	Nodo_DFS pop(){
		if(!Esvacia()){
			return info.poll();
		}
		return null;
	}
	
	boolean Esvacia(){
		return info.isEmpty();
	}

	String imprimir(){
		return info.toString();
	}
	
	void Haznula(){
		info.clear();
	}
	
	int Tamaño(){
		return info.size();
	}
        
        public void visitados() {
        for (int j = 0; j < info.size(); j++) {
            System.out.println("soy visitados y tengo a " + Arrays.toString(info.get(j).arreglo));
        }
    }
	
	boolean pertecealista(Nodo_DFS nodo) {
        Nodo_DFS nodoactual;
        for (int i = 0; i < info.size(); i++) {
            nodoactual = info.get(i);
            if (Arrays.toString(nodo.arreglo).equals(Arrays.toString(nodoactual.arreglo))) {
            return true;
            } 
        }
        return false;
    }
	
}


