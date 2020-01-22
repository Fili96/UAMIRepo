
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Rutas_SG_BFS {

    static HashMap<String, String[]> conexiones = new HashMap<>();

    static String[] Acapulco_conexiones = {"DF", "Toluca", "Cuernavaca"};
    static String[] Toluca_conexiones = {"Queretaro", "DF", "Acapulco"};
    static String[] Cuernavaca_conexiones = {"DF", "Acapulco"};
    static String[] Huatulco_conexiones = {"Puebla", "DF"};
    static String[] Puebla_conexiones = {"Huatulco", "DF", "Veracruz"};
    static String[] Veracruz_conexiones = {"Puebla", "DF"};
    static String[] Queretaro_conexiones = {"Toluca", "DF"};
    static String[] Pachuca_conexiones = {"DF", "Poza Rica"};
    static String[] Poza_Rica_conexiones = {"Pachuca", "DF"};
    static String[] DF_conexiones = {"Toluca", "Acapulco", "Cuernavaca", "Poza Rica", "Pachuca", "Huatulco", "Queretaro", "Veracruz", "Puebla",};

    static Nodos_BFS BusquedaPorAmplitud(String estado_inicial, String estado_solucion) {

        boolean Encontrado = false;

        Nodos_BFS nodo_actual;

        Colas_GLL nodos_frontera = new Colas_GLL();
        Colas_GLL nodos_visitados = new Colas_GLL();

        conexiones.put("Acapulco", Acapulco_conexiones);
        conexiones.put("Toluca", Toluca_conexiones);
        conexiones.put("Cuernavaca", Cuernavaca_conexiones);
        conexiones.put("Huatulco", Huatulco_conexiones);
        conexiones.put("Puebla", Puebla_conexiones);
        conexiones.put("Veracruz", Veracruz_conexiones);
        conexiones.put("Queretaro", Queretaro_conexiones);
        conexiones.put("Pachuca", Pachuca_conexiones);
        conexiones.put("Poza Rica", Poza_Rica_conexiones);
        conexiones.put("DF", DF_conexiones);
        
        

        Nodos_BFS nodo_inicial = new Nodos_BFS(estado_inicial);

        nodos_frontera.Encolar(nodo_inicial);
        int cont = 0;

        while ((Encontrado == false) & (nodos_frontera.Esvacia() != true)) {

            cont++;
            nodo_actual = nodos_frontera.Desencolar();
            nodos_visitados.Encolar(nodo_actual);

            if (nodo_actual.ciudad.equals(estado_solucion)) {
                nodo_actual.pasos = cont;
                return nodo_actual;

            } else {

                int tamaño = conexiones.get(nodo_actual.ciudad).length;
                Nodos_BFS[] ciudades_hijas = new Nodos_BFS[tamaño];
                int i = 0;
                for (String ciudad : conexiones.get(nodo_actual.ciudad)) {
                    Nodos_BFS hijo = new Nodos_BFS(ciudad);
                    ciudades_hijas[i] = hijo;

                    if ((nodos_frontera.pertecealista(hijo) == false) && (nodos_visitados.pertecealista(hijo) == false)) {
                        nodos_frontera.Encolar(hijo);
                    }
                    i++;
                }

                nodo_actual.sethijos(ciudades_hijas, nodo_actual);

            }

        }

        return null;

    }

   
    
}
