public class Nodos_BFS {
    
    int costo=0;
    int pasos=0;
    Nodos_BFS padre;
    Nodos_BFS hijos[];
    String ciudad;
    
    Nodos_BFS(String ciudad){
        this.ciudad=ciudad;
        this.hijos=null;
        this.padre=null;
        sethijos(null, null); 
    }

    void sethijos(Nodos_BFS[] hijos, Nodos_BFS nodo) {
        this.hijos = hijos;
        if (this.hijos != null) {
            for (Nodos_BFS aux : hijos) {
                aux.padre = nodo;
            }
        }
    }
    
    int getcosto(){
        return costo;
    }
    
    void setcosto(int costo){
        this.costo=costo;
    }
}