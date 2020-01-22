import java.util.Arrays;
import java.util.LinkedList;

public class Colas_GLL {

    private LinkedList<Nodos_BFS> info = new LinkedList<>();

    public Colas_GLL() {

    }
  void remueve(int a){
        info.remove(a);
    }
    
    boolean pertecealista(Nodos_BFS nodo) {
        Nodos_BFS nodoactual;
        for (int a = 0; a < info.size(); a++) {
            nodoactual = info.get(a);
            if (nodo.ciudad.equals(nodoactual.ciudad)) {
            return true;
            } 
        }
        return false;
    }

    public void Encolar(Nodos_BFS x) {
        info.addLast(x);
    }

    public Nodos_BFS obtener_nodo(int i) {
        return info.get(1);
    }

    
    

    public Nodos_BFS Desencolar() {
        if (Esvacia()) {
            return null;
        }
        return info.poll();
    }

    public boolean Esvacia() {
        return info.isEmpty();
    }

    public String imprimir() {
        return info.toString();
    }

    public void HazNula() {
        info.clear();
    }

    public int tamano() {
        return info.size();
    }



}
