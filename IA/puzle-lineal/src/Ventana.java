
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Ventana extends javax.swing.JFrame {

    Color amarillo = new Color(255, 255, 0);
    static int arreglo_estado_inicial[] = ArregloAleatorio();
    static int[] solucion = {1, 2, 3, 4};

    public Ventana() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_fondo = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        num1 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        num2 = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        num3 = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        num4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        generar_config = new javax.swing.JLabel();
        aleatoria = new javax.swing.JLabel();
        label_encontrar_soluciion = new javax.swing.JLabel();
        DFS = new javax.swing.JButton();
        empezar = new javax.swing.JButton();
        BFS = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        forma_manual = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invertir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultados = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        panel_fondo.setBackground(new java.awt.Color(255, 51, 51));
        panel_fondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        titulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        titulo.setText("Puzle Lineal");

        panel1.setBackground(new java.awt.Color(102, 102, 255));
        panel1.setForeground(new java.awt.Color(255, 255, 255));

        num1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        num1.setForeground(new java.awt.Color(255, 255, 255));
        num1.setText(entero_a_cadena(arreglo_estado_inicial[0]));
        num1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        num1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                num1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(num1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(num1)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        panel2.setBackground(new java.awt.Color(102, 102, 255));

        num2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        num2.setForeground(new java.awt.Color(255, 255, 255));
        num2.setText(entero_a_cadena(arreglo_estado_inicial[1]));
        num2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        num2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                num2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(num2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(num2)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        panel3.setBackground(new java.awt.Color(102, 102, 255));

        num3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        num3.setForeground(new java.awt.Color(255, 255, 255));
        num3.setText(entero_a_cadena(arreglo_estado_inicial[2]));
        num3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        num3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                num3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(num3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(num3)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        panel4.setBackground(new java.awt.Color(102, 102, 255));

        num4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        num4.setForeground(new java.awt.Color(255, 255, 255));
        num4.setText(entero_a_cadena(arreglo_estado_inicial[3]));
        num4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        num4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                num4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(num4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(num4)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        generar_config.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        generar_config.setForeground(new java.awt.Color(255, 255, 255));
        generar_config.setText("Generar configuracion");

        aleatoria.setText("Aleatoria");

        label_encontrar_soluciion.setText("Encontrar solucion con busqueda ciega");

        DFS.setText("Busqueda ciega DFS");
        DFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DFSActionPerformed(evt);
            }
        });

        empezar.setText("Empezar");
        empezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empezarActionPerformed(evt);
            }
        });

        BFS.setText("Busqueda ciega BFS");
        BFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(generar_config)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(aleatoria)
                                .addGap(30, 30, 30)
                                .addComponent(empezar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_encontrar_soluciion)))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BFS)
                    .addComponent(DFS))
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generar_config)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aleatoria)
                    .addComponent(empezar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_encontrar_soluciion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BFS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DFS)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        forma_manual.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        forma_manual.setForeground(new java.awt.Color(0, 0, 0));
        forma_manual.setText("Resolver de Forma Manual");

        jLabel1.setText("Operadores Validos:");

        jLabel2.setText("Mover  Izquierdo (Casilla 1 y 2)");

        jLabel3.setText("Mover  Central     (Casilla 2 y 3)");

        jLabel4.setText("Mover  Derecho   (Casilla 3 y 4)");

        invertir.setText("Invertir Casillas");
        invertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(forma_manual)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(invertir)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(forma_manual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(invertir)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        resultados.setColumns(20);
        resultados.setRows(5);
        jScrollPane1.setViewportView(resultados);

        javax.swing.GroupLayout panel_fondoLayout = new javax.swing.GroupLayout(panel_fondo);
        panel_fondo.setLayout(panel_fondoLayout);
        panel_fondoLayout.setHorizontalGroup(
            panel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fondoLayout.createSequentialGroup()
                .addGroup(panel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_fondoLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_fondoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_fondoLayout.createSequentialGroup()
                                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_fondoLayout.createSequentialGroup()
                                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_fondoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        panel_fondoLayout.setVerticalGroup(
            panel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(titulo)
                .addGap(45, 45, 45)
                .addGroup(panel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void num1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_num1MouseClicked

        if ((num3.getForeground() == amarillo) || (num4.getForeground() == amarillo)) {
            num1.setForeground(Color.WHITE);
            num2.setForeground(Color.WHITE);
            num3.setForeground(Color.WHITE);
            num4.setForeground(Color.WHITE);
        }
        num1.setForeground(amarillo);


    }//GEN-LAST:event_num1MouseClicked

    private void num2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_num2MouseClicked
        if (num4.getForeground() == amarillo) {
            num1.setForeground(Color.WHITE);
            num2.setForeground(Color.WHITE);
            num3.setForeground(Color.WHITE);
            num4.setForeground(Color.WHITE);
        }

        num2.setForeground(amarillo);


    }//GEN-LAST:event_num2MouseClicked

    private void num3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_num3MouseClicked

        if (num1.getForeground() == amarillo) {
            num1.setForeground(Color.WHITE);
            num2.setForeground(Color.WHITE);
            num3.setForeground(Color.WHITE);
            num4.setForeground(Color.WHITE);
        }

        num3.setForeground(amarillo);


    }//GEN-LAST:event_num3MouseClicked

    private void num4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_num4MouseClicked

        if ((num1.getForeground() == amarillo) || (num2.getForeground() == amarillo)) {
            num1.setForeground(Color.WHITE);
            num2.setForeground(Color.WHITE);
            num3.setForeground(Color.WHITE);
            num4.setForeground(Color.WHITE);
        }

        num4.setForeground(amarillo);


    }//GEN-LAST:event_num4MouseClicked

    private void invertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertirActionPerformed

        if (Arrays.toString(arreglo_estado_inicial).equals(Arrays.toString(solucion))) {
            JOptionPane.showMessageDialog(panel_fondo, "Tienes suerte, ya esta Resuelto!!, intenta empezar de nuevo");
        } else {
            //Cambios num1 y num2
            if ((num2.getForeground() == amarillo) && (num1.getForeground() == amarillo)) {

                String aux = num1.getText();
                num1.setText(num2.getText());
                num2.setText(aux);
                int aux1 = arreglo_estado_inicial[0];
                arreglo_estado_inicial[0] = arreglo_estado_inicial[1];
                arreglo_estado_inicial[1] = aux1;
                if (Arrays.toString(arreglo_estado_inicial).equals(Arrays.toString(solucion))) {
                    JOptionPane.showMessageDialog(panel_fondo, "Felicidades");
                }
                //pinto
                num1.setForeground(Color.white);
                num2.setForeground(Color.white);

            }

            // Cambios num 2 y num3
            if ((num3.getForeground() == amarillo) && (num2.getForeground() == amarillo)) {

                String aux = num2.getText();
                num2.setText(num3.getText());
                num3.setText(aux);
                int aux1 = arreglo_estado_inicial[1];
                arreglo_estado_inicial[1] = arreglo_estado_inicial[2];
                arreglo_estado_inicial[2] = aux1;
                if (Arrays.toString(arreglo_estado_inicial).equals(Arrays.toString(solucion))) {
                    JOptionPane.showMessageDialog(panel_fondo, "Felicidades");
                }
                //pinto
                num3.setForeground(Color.white);
                num2.setForeground(Color.white);

            }

            if ((num3.getForeground() == amarillo) && (num4.getForeground() == amarillo)) {

                String aux = num3.getText();
                num3.setText(num4.getText());
                num4.setText(aux);
                int aux1 = arreglo_estado_inicial[2];
                arreglo_estado_inicial[2] = arreglo_estado_inicial[3];
                arreglo_estado_inicial[3] = aux1;
                if (Arrays.toString(arreglo_estado_inicial).equals(Arrays.toString(solucion))) {
                    JOptionPane.showMessageDialog(panel_fondo, "Felicidades");
                }
                //pinto
                num3.setForeground(Color.white);
                num4.setForeground(Color.white);

            }
        }

    }//GEN-LAST:event_invertirActionPerformed

    private void empezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empezarActionPerformed
        resultados.setText(" ");
        arreglo_estado_inicial = ArregloAleatorio();
        num1.setText(entero_a_cadena(arreglo_estado_inicial[0]));
        num2.setText(entero_a_cadena(arreglo_estado_inicial[1]));
        num3.setText(entero_a_cadena(arreglo_estado_inicial[2]));
        num4.setText(entero_a_cadena(arreglo_estado_inicial[3]));
    }//GEN-LAST:event_empezarActionPerformed

    private void BFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFSActionPerformed
        String resultado= PuzleLineal_SG_BFS.imprimir_busqueda_BFS(arreglo_estado_inicial);
        resultados.setText(resultado);
        num1.setText("1");
        num2.setText("2");
        num3.setText("3");
        num4.setText("4");
        
    }//GEN-LAST:event_BFSActionPerformed

    private void DFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DFSActionPerformed
        String resultado= PuzleLineal_SG_DFS.imprimir_busqueda_DFS(arreglo_estado_inicial);
        resultados.setText(resultado);
         num1.setText("1");
        num2.setText("2");
        num3.setText("3");
        num4.setText("4");
    }//GEN-LAST:event_DFSActionPerformed

    // arreglo aleatorio entre 1 y 4
    static int[] ArregloAleatorio() {

        int k = 4; // auxiliar;
        int[] resultado = new int[4];
        int[] numeros = new int[4];
        Random rnd = new Random();
        int num_alet;

        // se rellena una matriz ordenada del 1 al 4
        for (int i = 0; i < 4; i++) {
            numeros[i] = i + 1;
        }

        for (int i = 0; i < 4; i++) {
            num_alet = rnd.nextInt(k);
            resultado[i] = numeros[num_alet];
            numeros[num_alet] = numeros[k - 1];
            k--;

        }
        return resultado;
    }

    String entero_a_cadena(int x) {
        return Integer.toString(x);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BFS;
    private javax.swing.JButton DFS;
    private javax.swing.JLabel aleatoria;
    private javax.swing.JButton empezar;
    private javax.swing.JLabel forma_manual;
    private javax.swing.JLabel generar_config;
    private javax.swing.JButton invertir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_encontrar_soluciion;
    private javax.swing.JLabel num1;
    private javax.swing.JLabel num2;
    private javax.swing.JLabel num3;
    private javax.swing.JLabel num4;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel_fondo;
    private javax.swing.JTextArea resultados;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

}
