
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class PuzleLineal_SG_BFS {

    // Busqueda por Amplitud, ya debe recibir un arreglo aleatorio
    static Nodo_BFS BusquedaPorAmplitud(int[] estado_inicial) {

        boolean Encontrado = false;
        int[] solucion = {1, 2, 3, 4};
        String solucion_cadena = Arrays.toString(solucion);

        Nodo_BFS nodo;

        ColasGLL nodos_frontera = new ColasGLL();
        ColasGLL nodos_visitados = new ColasGLL();

        Nodo_BFS nodoinicial = new Nodo_BFS(estado_inicial);

        nodos_frontera.Encolar(nodoinicial);

        while ((Encontrado == false) & (nodos_frontera.Esvacia() != true)) {
            nodo = nodos_frontera.Desencolar();

            nodos_visitados.Encolar(nodo);

            if (nodo.getarregloencadena(nodo.arreglo).equals(solucion_cadena)) {

                Encontrado = true;

                return nodo;

            } else {

                int[] dato_nodo = nodo.arreglo;

                // operador izquierdo
                int[] arregloizquierdo = {dato_nodo[1], dato_nodo[0], dato_nodo[2], dato_nodo[3]};
                Nodo_BFS hijo_izq = new Nodo_BFS(arregloizquierdo);

                if ((nodos_frontera.pertecealista(hijo_izq) == false)
                        & (nodos_visitados.pertecealista(hijo_izq) == false)) {

                    nodos_frontera.Encolar(hijo_izq);
                }

                // operador central
                int[] arreglocentral = {dato_nodo[0], dato_nodo[2], dato_nodo[1], dato_nodo[3]};

                Nodo_BFS hijo_central = new Nodo_BFS(arreglocentral);

                if ((nodos_frontera.pertecealista(hijo_central) == false)
                        & (nodos_visitados.pertecealista(hijo_central) == false)) {

                    nodos_frontera.Encolar(hijo_central);
                }

                // operador derecho
                int[] arregloderecho = {dato_nodo[0], dato_nodo[1], dato_nodo[3], dato_nodo[2]};
                Nodo_BFS hijo_der = new Nodo_BFS(arregloderecho);

                if ((nodos_frontera.pertecealista(hijo_der) == false)
                        & (nodos_visitados.pertecealista(hijo_der) == false)) {

                    nodos_frontera.Encolar(hijo_der);
                }

                Nodo_BFS[] N = {hijo_izq, hijo_central, hijo_der};

                nodo.sethijos(N, nodo);

            }

        }

        return null;

    }

    static String imprimir_busqueda_BFS(int[] estado_inicial) {

        LinkedList<Nodo_BFS> pila = new LinkedList<>();
        Nodo_BFS nodo = new Nodo_BFS(estado_inicial);

        Nodo_BFS nodo_solucion = BusquedaPorAmplitud(estado_inicial);
        Nodo_BFS aux = nodo_solucion;

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
        return ("La solucion en amplitud es: "+cad);

    }
    
    
    
}
