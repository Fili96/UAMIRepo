
import java.util.Arrays;
import java.util.LinkedList;

public class PuzleLineal_SG_DFS {

    // Busqueda por Amplitud, ya debe recibir un arreglo aleatorio
    static Nodo_DFS BusquedaPorProfundidad(int[] estado_inicial) {

        boolean Encontrado = false;
        int[] solucion = {1, 2, 3, 4};
        String solucion_cadena = Arrays.toString(solucion);

        Nodo_DFS nodo;

        PilasGLL nodos_frontera = new PilasGLL();
        PilasGLL nodos_visitados = new PilasGLL();

        Nodo_DFS nodoinicial = new Nodo_DFS(estado_inicial);

        nodos_frontera.push(nodoinicial);

        while ((Encontrado == false) & (nodos_frontera.Esvacia() != true)) {
            nodo = nodos_frontera.pop();

            nodos_visitados.push(nodo);

            if (nodo.getarregloencadena(nodo.arreglo).equals(solucion_cadena)) {

                Encontrado = true;
                return nodo;

            } else {

                int[] dato_nodo = nodo.arreglo;

                // operador izquierdo
                int[] arregloizquierdo = {dato_nodo[1], dato_nodo[0], dato_nodo[2], dato_nodo[3]};
                Nodo_DFS hijo_izq = new Nodo_DFS(arregloizquierdo);

                if ((nodos_frontera.pertecealista(hijo_izq) == false)
                        && (nodos_visitados.pertecealista(hijo_izq) == false)) {
                    nodos_frontera.push(hijo_izq);
                }

                // operador central
                int[] arreglocentral = {dato_nodo[0], dato_nodo[2], dato_nodo[1], dato_nodo[3]};

                Nodo_DFS hijo_central = new Nodo_DFS(arreglocentral);

                if ((nodos_frontera.pertecealista(hijo_central) == false)
                        && (nodos_visitados.pertecealista(hijo_central) == false)) {
                    nodos_frontera.push(hijo_central);
                }
// operador derecho
                int[] arregloderecho = {dato_nodo[0], dato_nodo[1], dato_nodo[3], dato_nodo[2]};
                Nodo_DFS hijo_der = new Nodo_DFS(arregloderecho);

                if ((nodos_frontera.pertecealista(hijo_der) == false)
                        && (nodos_visitados.pertecealista(hijo_der) == false)) {
                    nodos_frontera.push(hijo_der);
                }

                Nodo_DFS[] N = {hijo_izq, hijo_central, hijo_der};
                nodo.sethijos(N, nodo);

            }

        }

        return null;

    }

    static String imprimir_busqueda_DFS(int[] estado_inicial) {

        LinkedList<Nodo_DFS> pila = new LinkedList<>();
        Nodo_DFS nodo = new Nodo_DFS(estado_inicial);

        Nodo_DFS nodo_solucion = BusquedaPorProfundidad(estado_inicial);
        Nodo_DFS aux = nodo_solucion;

        while (aux.padre != null) {
            pila.addFirst(aux);
            aux = aux.padre;
        }

        pila.addFirst(nodo);

        String cad = " ";
        while (pila.isEmpty() != true) {
            aux = pila.poll();
            cad = cad + Arrays.toString(aux.arreglo);

        }
        return ("La solucion en profundidad es: " + cad);

    }

}
