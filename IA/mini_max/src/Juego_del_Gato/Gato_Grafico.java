package Juego_del_Gato;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gato_Grafico extends JFrame implements ActionListener {

    JPanel panel_tablero;
    JButton[][] botones;
    JButton reiniciar;
    Clase_Gato obj = new Clase_Gato();
    ImageIcon circulo;
    ImageIcon equis;
    boolean facil;

    public Gato_Grafico() {
        setTitle("Juego del Gato");
        setSize(410, 500);
        setLayout(null);
        setResizable(false);
        inicio();
        obj.NuevaPartida();

        reiniciar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent xD) {

                int desicion = JOptionPane.showConfirmDialog(null, "<html>Modo Facil= Yes<br>Modo Dificil= No</html>");
                if (desicion == JOptionPane.YES_OPTION) {
                    facil = true;
                } else {
                    facil = false;
                }

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        botones[i][j].setEnabled(true);
                        botones[i][j].setIcon(null);
                        botones[i][j].setBackground(null);
                    }
                }
                obj.NuevaPartida();
            }
        });

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Gato_Grafico();
    }

    private void inicio() {
        panel_tablero = new JPanel();
        botones = new JButton[3][3];
        reiniciar = new JButton("Reiniciar");
        circulo = new ImageIcon(getClass().getResource("circulo.png"));
        equis = new ImageIcon(getClass().getResource("equis.png"));
        this.add(panel_tablero);
        this.add(reiniciar);

        panel_tablero.setBounds(5, 5, 400, 400);
        panel_tablero.setBorder(BorderFactory.createEtchedBorder());
        panel_tablero.setLayout(new GridLayout(3, 3, 8, 8));

        reiniciar.setBounds(155, 420, 100, 30);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j] = new JButton();
                panel_tablero.add(botones[i][j]);
                botones[i][j].addActionListener(this);

            }
        }
    }

    public void juegoTerminado() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setEnabled(false);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (facil == false) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (e.getSource() == botones[i][j]) {
                        botones[i][j].setIcon(circulo);
                        botones[i][j].setEnabled(false);
                        botones[i][j].setBackground(Color.WHITE);
                        obj.pulsaCasillaHumano(i, j);
                        int f = obj.getCoordenadas()[0];
                        int c = obj.getCoordenadas()[1];
                        botones[f][c].setIcon(equis);
                        botones[f][c].setEnabled(false);
                        botones[f][c].setBackground(Color.YELLOW);
                        if (obj.getGanador() == 0) {
                            JOptionPane.showMessageDialog(null, "Ganaste!!");
                            juegoTerminado();
                        } else if (obj.getGanador() == 1) {
                            JOptionPane.showMessageDialog(null, "Perdiste!!");
                            juegoTerminado();
                        }

                    }
                }
            }
        }
        
        if(facil==true){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (e.getSource() == botones[i][j]) {
                        botones[i][j].setIcon(circulo);
                        botones[i][j].setEnabled(false);
                        botones[i][j].setBackground(Color.WHITE);
                        obj.pulsaCasillaHumano_facil(i, j);
                        int f = obj.getCoordenadas()[0];
                        int c = obj.getCoordenadas()[1];
                        botones[f][c].setIcon(equis);
                        botones[f][c].setEnabled(false);
                        botones[f][c].setBackground(Color.YELLOW);
                        if (obj.getGanador() == 0) {
                            JOptionPane.showMessageDialog(null, "Ganaste!!");
                            juegoTerminado();
                        } else if (obj.getGanador() == 1) {
                            JOptionPane.showMessageDialog(null, "Perdiste!!");
                            juegoTerminado();
                        }

                    }
                }
            }
        }
        
        if ((obj.EsTableroLleno()) && (obj.getGanador() == -1)) {
            JOptionPane.showMessageDialog(null, "Empate");
            juegoTerminado();
        }

    }

}
