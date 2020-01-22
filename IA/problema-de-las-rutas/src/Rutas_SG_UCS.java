
import java.util.HashMap;

public class Rutas_SG_UCS {

    static HashMap< String, HashMap<String, Integer>> conexiones = new HashMap<>();

    static String[] Acapulco_conexiones = {"Toluca", "DF", "Cuernavaca"};
    static int[] costos_Acapulco = {388, 382, 291};
    static String[] Toluca_conexiones = {"Queretaro", "DF", "Acapulco"};
    static int[] costos_Toluca = {196, 60, 388};
    static String[] Puebla_conexiones = {"Huatulco", "DF", "Veracruz"};
    static int[] costos_Puebla = {569, 134, 273};
    static String[] Cuernavaca_conexiones = {"DF", "Acapulco"};
    static int[] costos_Cuernavaca = {49, 291};
    static String[] Huatulco_conexiones = {"Puebla", "DF"};
    static int[] costos_Huatulco = {569, 695};
    static String[] Veracruz_conexiones = {"Puebla", "DF"};
    static int[] costos_Veracruz = {273, 397};
    static String[] Queretaro_conexiones = {"Toluca", "DF"};
    static int[] costos_Queretaro = {196, 218};
    static String[] Pachuca_conexiones = {"DF", "Poza Rica"};
    static int[] costos_Pachuca = {90, 183};
    static String[] Poza_Rica_conexiones = {"Pachuca", "DF"};
    static int[] costos_Poza_Rica = {183, 276};
    static String[] DF_conexiones = {"Toluca", "Acapulco", "Cuernavaca", "Queretaro", "Pachuca", "Poza Rica", "Veracruz", "Puebla", "Huatulco"};
    static int[] costos_DF = {60, 382, 49, 218, 90, 276, 397, 134, 695};

    static HashMap<String, Integer> Acapulco_Hash = new HashMap<>();
    static HashMap<String, Integer> Toluca_Hash = new HashMap<>();
    static HashMap<String, Integer> Cuernavaca_Hash = new HashMap<>();
    static HashMap<String, Integer> Huatulco_Hash = new HashMap<>();
    static HashMap<String, Integer> Puebla_Hash = new HashMap<>();
    static HashMap<String, Integer> Veracruz_Hash = new HashMap<>();
    static HashMap<String, Integer> Queretaro_Hash = new HashMap<>();
    static HashMap<String, Integer> Pachuca_Hash = new HashMap<>();
    static HashMap<String, Integer> Poza_Rica_Hash = new HashMap<>();
    static HashMap<String, Integer> DF_Hash = new HashMap<>();

    static ColasGLL_Ordenada nodos_frontera;

    static Nodos_BFS BusquedaCosteUniforme(String estado_inicial, String estado_solucion) {

        boolean Encontrado = false;

        Nodos_BFS nodo_actual;

        nodos_frontera = new ColasGLL_Ordenada();
        Colas_GLL nodos_visitados = new Colas_GLL();

        for (int i = 0; i < 3; i++) {
            Acapulco_Hash.put(Acapulco_conexiones[i], costos_Acapulco[i]);
            Toluca_Hash.put(Toluca_conexiones[i], costos_Toluca[i]);
            Puebla_Hash.put(Puebla_conexiones[i], costos_Puebla[i]);
        }

        for (int i = 0; i < 2; i++) {
            Cuernavaca_Hash.put(Cuernavaca_conexiones[i], costos_Cuernavaca[i]);
            Huatulco_Hash.put(Huatulco_conexiones[i], costos_Huatulco[i]);
            Veracruz_Hash.put(Veracruz_conexiones[i], costos_Veracruz[i]);
            Queretaro_Hash.put(Queretaro_conexiones[i], costos_Queretaro[i]);
            Pachuca_Hash.put(Pachuca_conexiones[i], costos_Pachuca[i]);
            Poza_Rica_Hash.put(Poza_Rica_conexiones[i], costos_Poza_Rica[i]);

        }

        for (int i = 0; i < 9; i++) {
            DF_Hash.put(DF_conexiones[i], costos_DF[i]);
        }

        conexiones.put("Acapulco", Acapulco_Hash);
        conexiones.put("Toluca", Toluca_Hash);
        conexiones.put("Cuernavaca", Cuernavaca_Hash);
        conexiones.put("Huatulco", Huatulco_Hash);
        conexiones.put("Puebla", Puebla_Hash);
        conexiones.put("Veracruz", Veracruz_Hash);
        conexiones.put("Queretaro", Queretaro_Hash);
        conexiones.put("Pachuca", Pachuca_Hash);
        conexiones.put("Poza Rica", Poza_Rica_Hash);
        conexiones.put("DF", DF_Hash);

        // conexiones.keySet().stream().forEach((String Key)->{
        //   System.out.println("clave: "+ Key +" valor "+ conexiones.get(Key));    
        // });
        Nodos_BFS nodo_inicial = new Nodos_BFS(estado_inicial);

        nodos_frontera.Encolar_Ordenado(nodo_inicial);
        int cont = 0;
        while ((Encontrado == false) & (nodos_frontera.Esvacia() != true)) {
            cont++;
            nodo_actual = nodos_frontera.Desencolar();
            nodos_visitados.Encolar(nodo_actual);

            if (nodo_actual.ciudad.equals(estado_solucion)) {
                nodo_actual.pasos = cont;
                return nodo_actual;

            } else {

                int tamaño = conexiones.get(nodo_actual.ciudad).keySet().size();
                Nodos_BFS[] ciudades_hijas = new Nodos_BFS[tamaño];
                int i = 0;
                for (String ciudad : conexiones.get(nodo_actual.ciudad).keySet()) {
                    Nodos_BFS hijo = new Nodos_BFS(ciudad);
                    ciudades_hijas[i] = hijo;
                    hijo.costo = (nodo_actual.costo + conexiones.get(nodo_actual.ciudad).get(hijo.ciudad));

                    if ((nodos_visitados.pertecealista(hijo) == false) && (nodos_frontera.pertecealista(hijo) == false)) {
                        nodos_frontera.Encolar_Ordenado(hijo);
                    }

                    if ((nodos_visitados.pertecealista(hijo) == false) && (nodos_frontera.pertecealista(hijo) == true)) {

                        Nodos_BFS aux=nodo_actual;
                        
                        for (Nodos_BFS n : nodos_frontera.get_estructura()) {

                            if ((n.ciudad.equals(hijo.ciudad)) && (n.costo > hijo.costo)) {
                                aux = n;
                                break;
                            }

                        }

                        if (aux.ciudad.equals(hijo.ciudad)) {
                            nodos_frontera.remueve_nodo(nodo_actual);
                            nodos_frontera.Encolar_Ordenado(hijo);
                        }
                    }

                    i++;
                }

                nodo_actual.sethijos(ciudades_hijas, nodo_actual);
            }

        }
        return null;
    }

}

//Nodos_BFS aux;
//for (int j = 0; j < nodos_frontera.tamano(); j++) {
//  aux = nodos_frontera.obtener_nodo(j);
//if (aux.ciudad.equals(nodo_actual.ciudad)) {
//  if (aux.costo < nodo_actual.costo) {
//    nodos_frontera.remueve(j);
// }
//  }
// }
                        //nodos_frontera.Encolar_Ordenado(hijo);
