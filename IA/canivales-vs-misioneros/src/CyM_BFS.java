import java.util.Arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class CyM_BFS {

    // Busqueda por Amplitud
    public static Nodo_BFS BusquedaPorAmplitud() {

        boolean Encontrado = false;
        int[] estado_inicial = {3, 3, 0, 0, 0};
        int[] estado_solucion1 = {0, 0, 1, 3, 3};
        String estado_solucion_cadena1 = Arrays.toString(estado_solucion1);

        Nodo_BFS nodo_actual;

        ColasGLL nodos_frontera = new ColasGLL();
        ColasGLL nodos_visitados = new ColasGLL();

        Nodo_BFS nodo_inicial = new Nodo_BFS(estado_inicial);
        nodos_frontera.Encolar(nodo_inicial);

        while ((Encontrado == false) & (nodos_frontera.Esvacia() != true)) {
            nodo_actual = nodos_frontera.Desencolar();


            if (Arrays.toString(nodo_actual.arreglo).equals(estado_solucion_cadena1)) {
                return nodo_actual;

            } else {

                int CI = nodo_actual.arreglo[0];
                int MI = nodo_actual.arreglo[1];
                int balsa = nodo_actual.arreglo[2];
                int CD = nodo_actual.arreglo[3];
                int MD = nodo_actual.arreglo[4];

                nodos_visitados.Encolar(nodo_actual);

                int[] dato_nodo = nodo_actual.arreglo;

                switch (balsa) {
                    case 0:
                        //no haya mas o menos misioneros y canibales
                        if ((MI > 3) || (MI < 0) || (CI > 3) || (CI < 0) || (MD > 3) || (MD < 0) || (CD > 3) || (CD < 0)) {
                            break;
                        } else {
                            //no haya mas canibales que misioneros a la izquierda
                            if ((MI != 0) && (MI < CI)) {
                                break;
                            } else {
                                //no haya mas canibales que misioneros a la derecha
                                if ((MD != 0) && (MD < CD)) {
                                    break;
                                } else {

                                    // operador cruzar 1 canibal y 1 misionero
                                    int[] arreglo_operacion1 = {dato_nodo[0] - 1, dato_nodo[1] - 1, 1, dato_nodo[3] + 1, dato_nodo[4] + 1};
                                    Nodo_BFS canibal1minisionero1 = new Nodo_BFS(arreglo_operacion1);

                                    if ((nodos_frontera.pertecealista(canibal1minisionero1) == false) && (nodos_visitados.pertecealista(canibal1minisionero1) == false)) {
                                        nodos_frontera.Encolar(canibal1minisionero1);

                                    }

                                    // operador2 cruzar 2 canibal y 0 misionero
                                    int[] arreglo_operacion2 = {dato_nodo[0] - 2, dato_nodo[1], 1, dato_nodo[3] + 2, dato_nodo[4]};
                                    Nodo_BFS canibal1minisionero2 = new Nodo_BFS(arreglo_operacion2);

                                    if ((nodos_frontera.pertecealista(canibal1minisionero2) == false) && (nodos_visitados.pertecealista(canibal1minisionero2) == false)) {
                                        nodos_frontera.Encolar(canibal1minisionero2);
                                    }

                                    // operador3 cruzar 0 canibal y 2 misionero
                                    int[] arreglo_operacion3 = {dato_nodo[0], dato_nodo[1] - 2, 1, dato_nodo[3], dato_nodo[4] + 2};
                                    Nodo_BFS canibal1minisionero3 = new Nodo_BFS(arreglo_operacion3);

                                    if ((nodos_frontera.pertecealista(canibal1minisionero3) == false) && (nodos_visitados.pertecealista(canibal1minisionero3) == false)) {
                                        nodos_frontera.Encolar(canibal1minisionero3);
                                    }

                                    // operador4 cruzar 1 canibal y 0 misionero
                                    int[] arreglo_operacion4 = {dato_nodo[0] - 1, dato_nodo[1], 1, dato_nodo[3] + 1, dato_nodo[4]};
                                    Nodo_BFS canibal1minisionero4 = new Nodo_BFS(arreglo_operacion4);

                                    if ((nodos_frontera.pertecealista(canibal1minisionero4) == false) && (nodos_visitados.pertecealista(canibal1minisionero4) == false)) {
                                        nodos_frontera.Encolar(canibal1minisionero4);
                                    }

                                    // operador5 cruzar 0 canibal y 1 misionero
                                    int[] arreglo_operacion5 = {dato_nodo[0], dato_nodo[1] - 1, 1, dato_nodo[3], dato_nodo[4] + 1};
                                    Nodo_BFS canibal1minisionero5 = new Nodo_BFS(arreglo_operacion5);

                                    if ((nodos_frontera.pertecealista(canibal1minisionero5) == false) && (nodos_visitados.pertecealista(canibal1minisionero5) == false)) {
                                        nodos_frontera.Encolar(canibal1minisionero5);
                                    }

                                    Nodo_BFS[] N = {canibal1minisionero1, canibal1minisionero2, canibal1minisionero3, canibal1minisionero4, canibal1minisionero5};
                                    nodo_actual.sethijos(N, nodo_actual);
                                    break;
                                }
                            }
                        }
                    case 1:

                        if ((MI > 3) || (MI < 0) || (CI > 3) || (CI < 0) || (MD > 3) || (MD < 0) || (CD > 3) || (CD < 0)) {
                            break;
                        } else {
                            if ((MI != 0) && (MI < CI)) {
                                break;
                            } else {
                                if ((MD != 0) && (MD < CD)) {
                                    break;
                                } else {
                                    // operador6 cruzar 1 canibal y 1 misionero
                                    int[] arreglo_operacion6 = {dato_nodo[0] + 1, dato_nodo[1] + 1, 0, dato_nodo[3] - 1, dato_nodo[4] - 1};
                                    Nodo_BFS canibal1minisionero6 = new Nodo_BFS(arreglo_operacion6);

                                    if ((nodos_frontera.pertecealista(canibal1minisionero6) == false) && (nodos_visitados.pertecealista(canibal1minisionero6) == false)) {
                                        nodos_frontera.Encolar(canibal1minisionero6);
                                    }

                                    // operador7 cruzar 2 canibal y 0 misionero
                                    int[] arreglo_operacion7 = {dato_nodo[0] + 2, dato_nodo[1], 0, dato_nodo[3] - 2, dato_nodo[4]};
                                    Nodo_BFS canibal1minisionero7 = new Nodo_BFS(arreglo_operacion7);

                                    if ((nodos_frontera.pertecealista(canibal1minisionero7) == false) && (nodos_visitados.pertecealista(canibal1minisionero7) == false)) {
                                        nodos_frontera.Encolar(canibal1minisionero7);
                                    }

                                    // operador8 cruzar 0 canibal y 2 misionero
                                    int[] arreglo_operacion8 = {dato_nodo[0], dato_nodo[1] + 2, 0, dato_nodo[3], dato_nodo[4] - 2};
                                    Nodo_BFS canibal1minisionero8 = new Nodo_BFS(arreglo_operacion8);

                                    if ((nodos_frontera.pertecealista(canibal1minisionero8) == false) && (nodos_visitados.pertecealista(canibal1minisionero8) == false)) {
                                        nodos_frontera.Encolar(canibal1minisionero8);

                                    }

                                    // operador9 cruzar 1 canibal y 0 misionero
                                    int[] arreglo_operacion9 = {dato_nodo[0] + 1, dato_nodo[1], 0, dato_nodo[3] - 1, dato_nodo[4]};
                                    Nodo_BFS canibal1minisionero9 = new Nodo_BFS(arreglo_operacion9);

                                    if ((nodos_frontera.pertecealista(canibal1minisionero9) == false) && (nodos_visitados.pertecealista(canibal1minisionero9) == false)) {
                                        nodos_frontera.Encolar(canibal1minisionero9);

                                    }

                                    // operador10 cruzar 0 canibal y 1 misionero
                                    int[] arreglo_operacion10 = {dato_nodo[0], dato_nodo[1] + 1, 0, dato_nodo[3], dato_nodo[4] - 1};
                                    Nodo_BFS canibal1minisionero10 = new Nodo_BFS(arreglo_operacion10);

                                    if ((nodos_frontera.pertecealista(canibal1minisionero10) == false) && (nodos_visitados.pertecealista(canibal1minisionero10) == false)) {
                                        nodos_frontera.Encolar(canibal1minisionero10);

                                    }
                                    Nodo_BFS[] N2 = {canibal1minisionero6, canibal1minisionero7, canibal1minisionero8, canibal1minisionero9, canibal1minisionero10};
                                    nodo_actual.sethijos(N2, nodo_actual);
                                    break;
                                }
                            }

                        }
                }

            }

        }

        return null;

    }

    public static void main(String[] args) {

        LinkedList<Nodo_BFS> pila = new LinkedList<>();
        int[] estado_inicial = {3, 3, 0, 0, 0};
        Nodo_BFS nodo = new Nodo_BFS(estado_inicial);

        Nodo_BFS nodo_solucion = BusquedaPorAmplitud();
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
        System.out.println("La solucion en amplitud es: " + cad);
    }

}
