import java.util.Arrays;

public class CyM_DFS_Recursivo {
    public static void main(String[]args){
        PilasGLL pila =new PilasGLL();
	 PilasGLL visitados =  new PilasGLL();
		int[] estado_inicial = { 0, 0, 1, 3,3 };
		Nodo_DFS nodo_inicial = new Nodo_DFS(estado_inicial);
		int[] solucion = { 3, 3, 0, 0,0 };
		

		Nodo_DFS nodo_solucion = Recursivo(nodo_inicial, solucion, visitados);
		Nodo_DFS aux = nodo_solucion;

		while (aux.padre != null) {
			pila.push(aux);
			aux = aux.padre;
		}

		pila.push(nodo_inicial);

		System.out.print("La solucion por profundidad recursiva es: ");

		while (pila.Esvacia()!= true) {
			aux = pila.pop();
			System.out.print(Arrays.toString(aux.arreglo));
		}
    }

    private static Nodo_DFS Recursivo(Nodo_DFS nodo_inicial, int[] solucion, PilasGLL visitados) {

        visitados.push(nodo_inicial);
		

		if (Arrays.toString(nodo_inicial.arreglo).equals(Arrays.toString(solucion))) {
			return nodo_inicial;
		} else {

                int CI = nodo_inicial.arreglo[0];
                int MI = nodo_inicial.arreglo[1];
                int balsa = nodo_inicial.arreglo[2];
                int CD = nodo_inicial.arreglo[3];
                int MD = nodo_inicial.arreglo[4];
                
                int[] dato_nodo = nodo_inicial.arreglo;
                
                 switch (balsa) {
                    case 0:
                        //no haya mas o menos misioneros y canibales
                        if ((MI > 3) || (MI < 0) || (CI > 3) || (CI < 0) || (MD > 3) || (MD < 0) || (CD > 3) || (CD < 0)) {
                           return null;
                        } else {
                            //no haya mas canibales que misioneros a la izquierda
                            if ((MI != 0) && (MI < CI)) {
                                return null;
                            } else {
                                //no haya mas canibales que misioneros a la derecha
                                if ((MD != 0) && (MD < CD)) {
                                    return null;
                                } else {

                                    // operador cruzar 1 canibal y 1 misionero
                                    int[] arreglo_operacion1 = {dato_nodo[0] - 1, dato_nodo[1] - 1, 1, dato_nodo[3] + 1, dato_nodo[4] + 1};
                                    Nodo_DFS canibal1minisionero1 = new Nodo_DFS(arreglo_operacion1);


                                    // operador2 cruzar 2 canibal y 0 misionero
                                    int[] arreglo_operacion2 = {dato_nodo[0] - 2, dato_nodo[1], 1, dato_nodo[3] + 2, dato_nodo[4]};
                                    Nodo_DFS canibal1minisionero2 = new Nodo_DFS(arreglo_operacion2);


                                    // operador3 cruzar 0 canibal y 2 misionero
                                    int[] arreglo_operacion3 = {dato_nodo[0], dato_nodo[1] - 2, 1, dato_nodo[3], dato_nodo[4] + 2};
                                    Nodo_DFS canibal1minisionero3 = new Nodo_DFS(arreglo_operacion3);


                                    // operador4 cruzar 1 canibal y 0 misionero
                                    int[] arreglo_operacion4 = {dato_nodo[0] - 1, dato_nodo[1], 1, dato_nodo[3] + 1, dato_nodo[4]};
                                    Nodo_DFS canibal1minisionero4 = new Nodo_DFS(arreglo_operacion4);


                                    // operador5 cruzar 0 canibal y 1 misionero
                                    int[] arreglo_operacion5 = {dato_nodo[0], dato_nodo[1] - 1, 1, dato_nodo[3], dato_nodo[4] + 1};
                                    Nodo_DFS canibal1minisionero5 = new Nodo_DFS(arreglo_operacion5);


                                    Nodo_DFS[] N = {canibal1minisionero1, canibal1minisionero2, canibal1minisionero3, canibal1minisionero4, canibal1minisionero5};
                                    nodo_inicial.sethijos(N, nodo_inicial);
                                    break;
                                }
                            }
                        }
                    case 1:

                        if ((MI > 3) || (MI < 0) || (CI > 3) || (CI < 0) || (MD > 3) || (MD < 0) || (CD > 3) || (CD < 0)) {
                           return null;
                        } else {
                            if ((MI != 0) && (MI < CI)) {
                               return null;
                            } else {
                                if ((MD != 0) && (MD < CD)) {
                                    return null;
                                } else {
                                    // operador6 cruzar 1 canibal y 1 misionero
                                    int[] arreglo_operacion6 = {dato_nodo[0] + 1, dato_nodo[1] + 1, 0, dato_nodo[3] - 1, dato_nodo[4] - 1};
                                    Nodo_DFS canibal1minisionero6 = new Nodo_DFS(arreglo_operacion6);

                                    // operador7 cruzar 2 canibal y 0 misionero
                                    int[] arreglo_operacion7 = {dato_nodo[0] + 2, dato_nodo[1], 0, dato_nodo[3] - 2, dato_nodo[4]};
                                    Nodo_DFS canibal1minisionero7 = new Nodo_DFS(arreglo_operacion7);

                                    // operador8 cruzar 0 canibal y 2 misionero
                                    int[] arreglo_operacion8 = {dato_nodo[0], dato_nodo[1] + 2, 0, dato_nodo[3], dato_nodo[4] - 2};
                                    Nodo_DFS canibal1minisionero8 = new Nodo_DFS(arreglo_operacion8);

                                    // operador9 cruzar 1 canibal y 0 misionero
                                    int[] arreglo_operacion9 = {dato_nodo[0] + 1, dato_nodo[1], 0, dato_nodo[3] - 1, dato_nodo[4]};
                                    Nodo_DFS canibal1minisionero9 = new Nodo_DFS(arreglo_operacion9);

                                    // operador10 cruzar 0 canibal y 1 misionero
                                    int[] arreglo_operacion10 = {dato_nodo[0], dato_nodo[1] + 1, 0, dato_nodo[3], dato_nodo[4] - 1};
                                    Nodo_DFS canibal1minisionero10 = new Nodo_DFS(arreglo_operacion10);

                                    Nodo_DFS[] N2 = {canibal1minisionero6, canibal1minisionero7, canibal1minisionero8, canibal1minisionero9, canibal1minisionero10};
                                    nodo_inicial.sethijos(N2, nodo_inicial);
                                    break;
                                }
                            }

                        }
                }
                
			for (Nodo_DFS aux : nodo_inicial.gethijos()) {
				//System.out.println("hijo "+Arrays.toString(aux.arreglo));
				if (visitados.pertecealista(aux) == false) {
					Nodo_DFS nodo_solucion = Recursivo(aux, solucion, visitados);
					if (nodo_solucion != null) 
						return nodo_solucion;
					
				}

			}

		}
		
		return null;
    }
    
}
