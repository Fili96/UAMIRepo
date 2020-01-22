package Buscaminas_BackTrack;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Opciones extends JDialog implements ActionListener {

    Buscaminas_BackTrack obj;
    JButton boton_cancelar, boton_aceptar;
    JPanel panel_niveles, panel_personalizado, principiante, intermedio, avanzado, botones, P_alto, P_ancho, P_minas;
    JRadioButton r_principiante, r_medio, r_avanzado, r_personalizado;
    JLabel dificultad, l_ancho, l_alto, l_minas;
    JTextField Alto, Ancho, Minas;
    ButtonGroup buttonGroup;

    Opciones(JFrame padre, Boolean modal) {
        super(padre, modal);
        padre.setVisible(false);
        setSize(600, 400);
        setLayout(new GridLayout(1, 2));
        setLocationRelativeTo(null);

        //llenado
        buttonGroup = new ButtonGroup();
        boton_cancelar = new JButton("Cancelar");
        boton_aceptar = new JButton("Aceptar");
        panel_niveles = new JPanel();
        panel_personalizado = new JPanel();
        principiante = new JPanel();
        intermedio = new JPanel();
        avanzado = new JPanel();
        botones = new JPanel();
        P_alto = new JPanel();
        P_ancho = new JPanel();
        P_minas = new JPanel();
        r_principiante = new JRadioButton("<html>Principiante<br>10 Minas<br>Cuadricula de 9x9 Casillas</html>", true);
        r_medio = new JRadioButton("<html>Medio<br>40 Minas<br>Cuadricula de 16x16 Casillas</html>");
        r_avanzado = new JRadioButton("<html>Avanzado<br>99 Minas<br>Cuadricula de 16x30 Casillas</html>");
        r_personalizado = new JRadioButton("Personalizado");
        dificultad = new JLabel("Dificultad                                                  ");
        l_alto = new JLabel("Alto (9-16)");
        l_ancho = new JLabel("Ancho (9-30)");
        l_minas = new JLabel("Minas 10-668");
        Alto = new JTextField("                  ");
        Ancho = new JTextField("                 ");
        Minas = new JTextField("                 ");

        //agregados a Dialog
        add(panel_niveles);
        add(panel_personalizado);

        //config panel_niveles
        panel_niveles.setLayout(new GridLayout(3, 1));
        panel_niveles.setBackground(Color.red);
        panel_niveles.add(principiante);
        panel_niveles.add(intermedio);
        panel_niveles.add(avanzado);

        //  principiante.setBackground(Color.ORANGE);
        principiante.add(dificultad);
        principiante.add(r_principiante);

        //intermedio.setBackground(Color.MAGENTA);
        intermedio.add(r_medio);

        //avanzado.setBackground(Color.GREEN);
        avanzado.add(r_avanzado);

        //config panel_personalizado
        panel_personalizado.setLayout(new GridLayout(5, 1));
        panel_personalizado.setBackground(Color.blue);
        panel_personalizado.add(r_personalizado);
        panel_personalizado.add(P_alto);
        P_alto.add(l_alto);
        l_alto.setEnabled(false);
        P_alto.add(Alto);
        Alto.setEnabled(false);
        panel_personalizado.add(P_ancho);
        P_ancho.add(l_ancho);
        l_ancho.setEnabled(false);
        P_ancho.add(Ancho);
        Ancho.setEnabled(false);
        panel_personalizado.add(P_minas);
        P_minas.add(l_minas);
        l_minas.setEnabled(false);
        P_minas.add(Minas);
        Minas.setEnabled(false);
        panel_personalizado.add(botones);
        botones.add(boton_aceptar);
        botones.add(boton_cancelar);

        buttonGroup.add(r_principiante);
        buttonGroup.add(r_medio);
        buttonGroup.add(r_avanzado);
        buttonGroup.add(r_personalizado);

        r_personalizado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (r_personalizado.isSelected() == true) {
                    l_alto.setEnabled(true);
                    Alto.setEnabled(true);
                    Alto.setText("");
                    l_ancho.setEnabled(true);
                    Ancho.setEnabled(true);
                    Ancho.setText("");
                    l_minas.setEnabled(true);
                    Minas.setEnabled(true);
                    Minas.setText("");
                }

            }
        });
        boton_aceptar.addActionListener(this);
        boton_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                padre.setVisible(true);
                dispose();
            }
        });
        
        setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton_aceptar) {

            if (r_principiante.isSelected() == true) {
                obj = new Buscaminas_BackTrack(9, 9, 10);
                this.dispose();
            }

            if (r_medio.isSelected() == true) {
                obj = new Buscaminas_BackTrack(16, 16, 40);
                this.dispose();
            }

            if (r_avanzado.isSelected() == true) {
                obj = new Buscaminas_BackTrack(16, 30, 99);
                this.dispose();
            }

            if (r_personalizado.isSelected() == true) {

                try {
                    int a = Integer.parseInt(Alto.getText().trim());
                    int b = Integer.parseInt(Ancho.getText().trim());
                    int c = Integer.parseInt(Minas.getText().trim());

                    if ((a < 9) || (a > 16)) {
                        JOptionPane.showMessageDialog(null, "Numero de filas incorrecto");
                    }

                    if ((b < 9) || (b > 30)) {
                        JOptionPane.showMessageDialog(null, "Numero de columnas incorrecto");

                    }

                    if ((c < 10) || (c > 668)) {
                        JOptionPane.showMessageDialog(null, "Numero de minas incorrecto");
                    }

                    if (((a >= 9) && (a <= 16)) && ((b >= 9) && (b <= 30)) && ((c >= 10) && (c <= 668))&&(a*b>c)) {

                        obj = new Buscaminas_BackTrack(a, b, c);
                        this.dispose();

                    }
                    
                    if(a*b<=c){
                        JOptionPane.showMessageDialog(null, "Demasiadas minas para el juego");
                    }

                } catch (Exception excepcion) {
                    if (Alto.getText().equals("") || Ancho.getText().equals("") || Minas.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Hay campos vacios");
                    } else {
                        JOptionPane.showMessageDialog(null, "Verifica que tu eleccion sea con numeros");
                    }
                }

            }
        }

    }

}
