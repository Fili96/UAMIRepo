package Juego_del_Gato;

public class Clase_Gato {

    private int ganador;
    private final int[][] tablero_gato = new int[3][3];
    private final int[] coordenadas = new int[2];

    public void NuevaPartida() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero_gato[i][j] = -1;
            }
        }
        ganador = -1;
    }

    public void pulsaCasillaHumano(int i, int j) {

        if ((i >= 0 && j < 3) && (tablero_gato[i][j] == -1)) {
            if (ganador == -1) {
                tablero_gato[i][j] = 0;
                ganador = ganarPartida();
                PonerX();

            }
        }

    }

    public boolean finPartida() {
        return (EsTableroLleno() || ganarPartida() != -1);
    }

    public void ImprimirMatriz(int[][] x) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(x[i][j]);
            }
            System.out.println("");

        }
        System.out.println("");

    }

    public int ganarPartida() {
        // CHECA GANADOR EN DIAGONAL  \
        if (tablero_gato[0][0] != -1 && tablero_gato[1][1] == tablero_gato[0][0] && tablero_gato[2][2] == tablero_gato[0][0]) {
            return tablero_gato[0][0];
        }
        // CHECA GANADOR EN DIAGONAL  /
        if (tablero_gato[0][2] != -1 && tablero_gato[1][1] == tablero_gato[0][2] && tablero_gato[2][0] == tablero_gato[0][2]) {
            return tablero_gato[0][2];
        }

        // CHECA GANADOR EN LAS LINEAS
        for (int i = 0; i < 3; i++) {
            if (tablero_gato[i][0] != -1 && tablero_gato[i][1] == tablero_gato[i][0] && tablero_gato[i][2] == tablero_gato[i][0]) {
                return tablero_gato[i][0];
            }
        }
        // CHECA GANADOR EN LAS COLUMNAS
        for (int i = 0; i < 3; i++) {
            if (tablero_gato[0][i] != -1 && tablero_gato[1][i] == tablero_gato[0][i] && tablero_gato[2][i] == tablero_gato[0][i]) {
                return tablero_gato[0][i];
            }
        }
        //EMPATE
        return -1;
    }

    public boolean EsTableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero_gato[i][j] == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void PonerX() {
        if (!finPartida()) {
            int f = 0;
            int c = 0;
            int aux;
            int v = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tablero_gato[i][j] == -1) {
                        tablero_gato[i][j] = 1;
                        aux = min();
                        /*despues de las llenadas con "0" y "X", empieza a quitar las fichas y una
                        vez quitadas, el ultimo valor guardado en aux se compara y si entra guarda
                        las coordenadas*/
                        if (aux > v) {
                            v = aux;
                            f = i;
                            c = j;
                        }
                        tablero_gato[i][j] = -1;
                    }
                }
            }
            tablero_gato[f][c] = 1;
            coordenadas[0] = f;
            coordenadas[1] = c;
        }
        ganador = ganarPartida();
    }

    public int max() {
        if (finPartida()) {//si tablero lleno o hay un ganador
            if (ganarPartida() != -1) {//si hay un ganador
                return -1;
            } else {
                return 0;
            }
        }
        int v = Integer.MIN_VALUE;
        int aux;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero_gato[i][j] == -1) {
                    tablero_gato[i][j] = 1;
                    aux = min();
                    if (aux > v) {
                        v = aux;
                    }
                    tablero_gato[i][j] = -1;
                }
            }

        }
        return v;
    }

    public int min() {
        if (finPartida()) {//si tablero lleno o hay un ganador
            if (ganarPartida() != -1) {//si hay un ganador regresa 1
                return 1;
            } else {
                return 0;
            }
        }
        int v = Integer.MAX_VALUE;
        int aux;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero_gato[i][j] == -1) {
                    tablero_gato[i][j] = 0;
                    aux = max();
                    if (aux < v) {
                        v = aux;
                    }
                    tablero_gato[i][j] = -1;
                }
            }
        }
        return v;
    }

    public void pulsaCasillaHumano_facil(int i, int j) {

        if ((i >= 0 && j < 3) && (tablero_gato[i][j] == -1)) {
            if (ganador == -1) {
                tablero_gato[i][j] = 0;
                ganador = ganarPartida();
                PonerX_facil();

            }
        }

    }

    public void PonerX_facil() {
        if (!finPartida()) {
            int f = 0;
            int c = 0;
           
           
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tablero_gato[i][j] == -1) {
                        tablero_gato[i][j] = 1;
                        
                            f = i;
                            c = j;
                        
                        tablero_gato[i][j] = -1;
                    }
                }
            }
            tablero_gato[f][c] = 1;
            coordenadas[0] = f;
            coordenadas[1] = c;
        }
        ganador = ganarPartida();
    }

   

    

    public int[][] getTablero() {
        return tablero_gato;
    }

    public int getGanador() {
        return ganador;
    }

    public int[] getCoordenadas() {
        return coordenadas;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }

}
