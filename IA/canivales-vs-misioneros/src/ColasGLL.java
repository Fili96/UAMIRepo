import java.util.Arrays;
import java.util.LinkedList;

public class ColasGLL {
	
	private LinkedList <Nodo_BFS> info= new LinkedList<Nodo_BFS>();
	
	public ColasGLL(){
		
	}
	
	void Encolar(Nodo_BFS x){
		info.addLast(x);
	}
	
	Nodo_BFS obtenerNodo(int i){
		return info.get(i);
	}
	
	Nodo_BFS Desencolar(){
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
	
	boolean pertecealista(Nodo_BFS nodo) {
        Nodo_BFS nodoactual;
        for (int i = 0; i < info.size(); i++) {
            nodoactual = info.get(i);
            if (Arrays.toString(nodo.arreglo).equals(Arrays.toString(nodoactual.arreglo))) {
            return true;
            } 
        }
        return false;
    }
        
         public void visitados() {
        for (int j = 0; j < info.size(); j++) {
            System.out.println("soy visitados y tengo a " + Arrays.toString(info.get(j).arreglo));
        }
    }
}
