
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
	
	int Tama�o(){
		return info.size();
	}
	
	boolean pertecealista(Nodo_BFS nodo) {
        Nodo_BFS nodoactual;
        for (int i = 0; i < info.size(); i++) {
            nodoactual = info.get(i);
            if (nodo.getarregloencadena(nodo.arreglo).equals(nodoactual.getarregloencadena(nodoactual.arreglo))) {
            return true;
            } 
        }
        return false;
    }
}