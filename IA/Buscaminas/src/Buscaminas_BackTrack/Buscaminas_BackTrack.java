package Buscaminas_BackTrack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Buscaminas_BackTrack extends JFrame implements ActionListener {

    JMenuBar barra;
    JMenu Juego;
    JMenuItem item_juego_nuevo;
    JMenuItem item_opciones;
    JMenuItem item_salir;
    static JPanel tablero;
    static JButton[][] botones;
    static int filas;
    static int columnas;
    static int bombas;
    JLabel label1;
    Opciones opc_dialog;
    static ImageIcon cero;
    static ImageIcon uno;
    static ImageIcon dos;
    static ImageIcon tres;
    static ImageIcon cuatro;
    static ImageIcon cinco;
    static ImageIcon seis;
    static ImageIcon siete;
    static ImageIcon ocho;
    static ImageIcon b;

    Buscaminas_BackTrack(int filas, int columnas, int bombas) {
        this.filas = filas;
        this.columnas = columnas;
        this.bombas = bombas;
        //config frame
        setTitle("Buscaminas");
        InicializarComponentes();
        tama�oPorNiveles(filas, columnas);
        iniciarTablero();
        poner_bombas();
        contarBombas();
        setLocationRelativeTo(null);

        //Eventos
        item_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        item_juego_nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                iniciarTablero();
                poner_bombas();
                contarBombas();

            }
        });

        item_opciones.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//fin constructor

    public void InicializarComponentes() {
        //Llenado
        ImageIcon icono_juego = new ImageIcon(getClass().getResource("nuevo_juego_icono.png"));
        ImageIcon icono_opciones = new ImageIcon(getClass().getResource("opciones_icono.png"));
        ImageIcon icono_salir = new ImageIcon(getClass().getResource("salir_icono.png"));
        cero = new ImageIcon(getClass().getResource("cero.png"));
        uno = new ImageIcon(getClass().getResource("uno.png"));
        dos = new ImageIcon(getClass().getResource("dos.png"));
        tres = new ImageIcon(getClass().getResource("tres.png"));
        cuatro = new ImageIcon(getClass().getResource("cuatro.png"));
        cinco = new ImageIcon(getClass().getResource("cinco.png"));
        seis = new ImageIcon(getClass().getResource("seis.png"));
        siete = new ImageIcon(getClass().getResource("siete.png"));
        ocho = new ImageIcon(getClass().getResource("ocho.png"));
        b = new ImageIcon(getClass().getResource("b.png"));
        barra = new JMenuBar();
        Juego = new JMenu("Juego");
        item_juego_nuevo = new JMenuItem("Nuevo Juego", icono_juego);
        item_opciones = new JMenuItem("Opciones", icono_opciones);
        item_salir = new JMenuItem("Salir", icono_salir);
        tablero = new JPanel();
        botones = new JButton[filas][columnas];
        label1 = new JLabel("Buscaminas");

        //Agregados a FRAME
        setJMenuBar(barra);
        add(tablero, BorderLayout.CENTER);
        add(label1, BorderLayout.NORTH);

        //Menu
        barra.add(Juego);
        Juego.add(item_juego_nuevo);
        Juego.addSeparator();
        Juego.add(item_opciones);
        Juego.addSeparator();
        Juego.add(item_salir);

        //Aceleradores
        item_juego_nuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
        item_opciones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        item_salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));

        //etiqueta titulo
        label1.setHorizontalAlignment((int) CENTER_ALIGNMENT);

        //config Tablero
        tablero.setLayout(new GridLayout(filas, columnas));

        //config botones
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                botones[i][j] = new JButton();
                tablero.add(botones[i][j]);
                botones[i][j].addActionListener(this);
            }
        }
    }

    private void tama�oPorNiveles(int filas, int columnas) {

        //tamaño personalizado
        if ((filas >= 9) && (filas <= 16)) {

            if ((columnas >= 9) && (columnas <= 16)) {

                if (columnas > filas) {
                    setSize(320, 270);
                } else if (columnas < filas) {
                    setSize(270, 320);
                } else if (columnas == filas) {
                    setSize(320, 320);
                }

            } else {

                if ((columnas >= 16) && (columnas <= 30)) {
                    if (columnas > filas) {
                        setSize(600, 400);
                    }
                }
            }
        }
        //tamaño 9x9
        if ((filas == 9) && (columnas == 9)) {
            setSize(250, 300);
        }

        //tamaño16x16
        if ((filas == 16) && (columnas == 16)) {
            setSize(400, 400);
        }
        //tamaño16x30
        if ((filas == 16) && (columnas == 30)) {
            setSize(700, 500);
        }

    }

    public static void poner_bombas() {
        Random r = new Random();
        for (int x = 0; x < bombas; x++) {
            int g = r.nextInt(filas);
            int h = r.nextInt(columnas);
            if (botones[g][h].getText() != "b") {
                botones[g][h].setText("b");
            } else {
                x--;
            }
        }
    }

    public static void iniciarTablero() {

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                botones[i][j].setIcon(null);
                botones[i][j].setText("0");
                Font font = new Font("Agency FB", Font.BOLD, 0);
                botones[i][j].setFont(font);
                botones[i][j].setBackground(Color.BLUE);
                botones[i][j].setEnabled(true);
            }
        }
    }

    public static void juegoTerminado() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                botones[i][j].setEnabled(false);
                botones[i][j].setBackground(Color.GRAY);
            }
        }
        JOptionPane.showMessageDialog(tablero, "Juego Terminado");
        
    }

    public static void contarBombas() {
        int i, j, cant;
        for (i = 0; i < filas; i++) {
            for (j = 0; j < columnas; j++) {
                if (botones[i][j].getText().equals("0")) {
                    cant = contarCordenada(i, j);
                    botones[i][j].setText(String.valueOf(cant));

                }
            }
        }
    }

    public static void mostrarSolucion() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                switch (botones[i][j].getText()) {
                    case "b":
                        botones[i][j].setIcon(b);

                        break;
                    case "0":
                        botones[i][j].setIcon(cero);
                        break;
                    case "1":
                        botones[i][j].setIcon(uno);
                        break;
                    case "2":
                        botones[i][j].setIcon(dos);
                        break;
                    case "3":
                        botones[i][j].setIcon(tres);
                        break;
                    case "4":
                        botones[i][j].setIcon(cuatro);
                        break;
                    case "5":
                        botones[i][j].setIcon(cinco);
                        break;
                    case "6":
                        botones[i][j].setIcon(seis);
                        break;
                    case "7":
                        botones[i][j].setIcon(siete);
                        break;
                    case "8":
                        botones[i][j].setIcon(ocho);
                        break;
                }
                if (botones[i][j].getText().equals(" ")) {
                    botones[i][j].setIcon(cero);
                }
            }
        }
    }

    static int contarCordenada(int fila, int columna) {

        int total = 0;

        // crea el cuadrito
        // caso superior izquierda
        if (fila - 1 >= 0 && columna - 1 >= 0) {
            if (botones[fila - 1][columna - 1].getText().equals("b")) {
                total++;
            }
        }

        // caso superior central
        if (fila - 1 >= 0) {
            if (botones[fila - 1][columna].getText().equals("b")) {
                total++;
            }
        }

        // caso superior derecha
        if (fila - 1 >= 0 && columna + 1 < columnas) {
            if (botones[fila - 1][columna + 1].getText().equals("b")) {
                total++;
            }
        }
        // caso izquierda
        if (columna - 1 >= 0) {
            if (botones[fila][columna - 1].getText().equals("b")) {
                total++;
            }
        }
        // caso derecha
        if (columna + 1 < columnas) {
            if (botones[fila][columna + 1].getText().equals("b")) {
                total++;
            }
        }
        // caso inferior izquierda
        if (fila + 1 < filas && columna - 1 >= 0) {
            if (botones[fila + 1][columna - 1].getText().equals("b")) {
                total++;
            }
        }
        // caso inferior central
        if (fila + 1 < filas) {
            if (botones[fila + 1][columna].getText().equals("b")) {
                total++;
            }
        }
        // caso inferior derecha
        if (fila + 1 < filas && columna + 1 < columnas) {
            if (botones[fila + 1][columna + 1].getText().equals("b")) {
                total++;
            }
        }

        return total;
    }

    public void recorrer(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            switch (botones[fila][columna].getText()) {
                case "0":
                    botones[fila][columna].setText(" ");
                    botones[fila][columna].setBackground(Color.YELLOW);
                    recorrer(fila - 1, columna - 1);
                    recorrer(fila - 1, columna);
                    recorrer(fila - 1, columna + 1);
                    recorrer(fila, columna - 1);
                    recorrer(fila, columna + 1);
                    recorrer(fila + 1, columna - 1);
                    recorrer(fila + 1, columna);
                    recorrer(fila + 1, columna + 1);
                    break;
                case "1":
                    botones[fila][columna].setIcon(uno);
                    botones[fila][columna].setBackground(Color.yellow);
                    break;
                case "2":
                    botones[fila][columna].setIcon(dos);
                    botones[fila][columna].setBackground(Color.yellow);
                    break;
                case "3":
                    botones[fila][columna].setIcon(tres);
                    botones[fila][columna].setBackground(Color.yellow);
                    break;
                case "4":
                    botones[fila][columna].setIcon(cuatro);
                    botones[fila][columna].setBackground(Color.yellow);
                    break;
                case "5":
                    botones[fila][columna].setIcon(cinco);
                    botones[fila][columna].setBackground(Color.yellow);
                    break;
                case "6":
                    botones[fila][columna].setIcon(seis);
                    botones[fila][columna].setBackground(Color.yellow);
                    break;
                case "7":
                    botones[fila][columna].setIcon(siete);
                    botones[fila][columna].setBackground(Color.yellow);
                    break;
                case "8":
                    botones[fila][columna].setIcon(ocho);
                    botones[fila][columna].setBackground(Color.yellow);
                    break;

            }
        }
    }

    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (e.getSource() == botones[i][j]) {
                    switch (botones[i][j].getText()) {
                        case "b":
                            botones[i][j].setIcon(b);
                            botones[i][j].setBackground(Color.red);
                            JOptionPane.showMessageDialog(null, "booom!!");
                            mostrarSolucion();
                            juegoTerminado();
                            break;
                        case "0":
                            recorrer(i, j);
                            break;
                        case "1":
                            botones[i][j].setIcon(uno);
                            botones[i][j].setBackground(Color.yellow);
                            break;
                        case "2":
                            botones[i][j].setIcon(dos);
                            botones[i][j].setBackground(Color.yellow);
                            break;
                        case "3":
                            botones[i][j].setIcon(tres);
                            botones[i][j].setBackground(Color.yellow);
                            break;
                        case "4":
                            botones[i][j].setIcon(cuatro);
                            botones[i][j].setBackground(Color.yellow);
                            break;
                        case "5":
                            botones[i][j].setIcon(cinco);
                            botones[i][j].setBackground(Color.yellow);
                            break;
                        case "6":
                            botones[i][j].setIcon(seis);
                            botones[i][j].setBackground(Color.yellow);
                            break;
                        case "7":
                            botones[i][j].setIcon(siete);
                            botones[i][j].setBackground(Color.yellow);
                            break;
                        case "8":
                            botones[i][j].setIcon(ocho);
                            botones[i][j].setBackground(Color.yellow);
                            break;
                    }
                }
            }
        }
        int cont_NObomb = 0;
        for (int a = 0; a < filas; a++) {
            for (int b = 0; b < columnas; b++) {

                if (botones[a][b].getBackground() == Color.YELLOW) {
                    cont_NObomb++;
                    if (cont_NObomb == ((filas * columnas) - bombas)) {
                        JOptionPane.showMessageDialog(null, "Has Ganado!!");
                    }
                }

            }
        }
        
        if (e.getSource() == item_opciones) {
            Opciones opc_dialog = new Opciones(this, true);

        }
    }

    public static void main(String[] args) {

        new Buscaminas_BackTrack(9, 9, 10);

    }

}
