import java.util.Arrays;
import java.util.LinkedList;

public class ColasGLL_Ordenada {

    private LinkedList<Nodos_BFS> info = new LinkedList<>();

    public ColasGLL_Ordenada() {

    }
    
    
    LinkedList<Nodos_BFS> get_estructura(){
        return info;
        
    }
    
    int Indicenodo(Nodos_BFS x){
        return info.indexOf(x);
    }

   void remueve(int a){
        info.remove(a);
    }
   void remueve_nodo(Nodos_BFS nodo){
        info.remove(nodo);
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

    public void Encolar_Ordenado(Nodos_BFS val) {
        if(info.size()==0){
            info.add(val);
        }else if(info.get(0).getcosto()>val.getcosto()){
            info.add(0, val);
        }else if(info.get(info.size()-1).getcosto()<val.getcosto()){
            info.add(info.size(), val);
        }else{
            int i=0;
            while(info.get(i).getcosto()<val.getcosto()){
                i++;
            }
            info.add(1, val);
        }
        
    }

    public Nodos_BFS obtener_nodo(int i) {
        return info.get(i);
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

