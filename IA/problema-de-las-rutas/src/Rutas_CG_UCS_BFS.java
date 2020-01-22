
import java.util.Arrays;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Rutas_CG_UCS_BFS extends javax.swing.JFrame {

    public Rutas_CG_UCS_BFS() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        radios = new javax.swing.JPanel();
        r_amplitud = new javax.swing.JRadioButton();
        r_costeU = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt1 = new javax.swing.JTextArea();
        comenzar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbx_final = new javax.swing.JComboBox<>();
        cbx_inicial = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Problema de las Rutas");
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        radios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup2.add(r_amplitud);
        r_amplitud.setText("Busqueda en Amplitud (BFS)");

        buttonGroup2.add(r_costeU);
        r_costeU.setText("Busqueda de Coste Uniforme (UCS)");

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel3.setText("Metodo de Busqueda");

        javax.swing.GroupLayout radiosLayout = new javax.swing.GroupLayout(radios);
        radios.setLayout(radiosLayout);
        radiosLayout.setHorizontalGroup(
            radiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radiosLayout.createSequentialGroup()
                .addGroup(radiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r_costeU)
                    .addComponent(r_amplitud))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, radiosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        radiosLayout.setVerticalGroup(
            radiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radiosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(r_amplitud)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(r_costeU)
                .addContainerGap())
        );

        getContentPane().add(radios, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 72, -1, 100));

        txt1.setEditable(false);
        txt1.setColumns(20);
        txt1.setRows(5);
        jScrollPane2.setViewportView(txt1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 740, -1));

        comenzar.setText("Comenzar Busqueda");
        comenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comenzarActionPerformed(evt);
            }
        });
        getContentPane().add(comenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Estado inicial:");

        jLabel5.setText("Estado Final:");

        cbx_final.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir Ciudad", "Acapulco", "Toluca", "Cuernavaca", "Huatulco", "Puebla", "Veracruz", "Queretaro", "Pachuca", "Poza Rica", "DF" }));

        cbx_inicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir Ciudad", "Acapulco", "Toluca", "Cuernavaca", "Huatulco", "Puebla", "Veracruz", "Queretaro", "Pachuca", "Poza Rica", "DF" }));

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Seleccionar estado Inicial y Final");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbx_final, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(cbx_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbx_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbx_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jLabel6.getAccessibleContext().setAccessibleParent(this);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, -1, 120));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Purisa", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("PROBLEMA DE LAS RUTAS");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jLabel2.getAccessibleContext().setAccessibleParent(this);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 380, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/onepiece.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comenzarActionPerformed
        txt1.setText(" ");

        LinkedList<Nodos_BFS> pila = new LinkedList<>();

        String estado_inicial = cbx_inicial.getSelectedItem().toString();
        String estado_final = cbx_final.getSelectedItem().toString();

        if (r_amplitud.isSelected() == true) {

            if ((estado_inicial == "Elegir Ciudad") || (estado_final == "Elegir Ciudad")) {
                JOptionPane.showMessageDialog(jLabel1, "Selecciona Correctamente las ciudades");
            } else {

                Nodos_BFS nodo = new Nodos_BFS(estado_inicial);
                long tiempo_ini = System.currentTimeMillis();
                Nodos_BFS nodo_solucion = Rutas_SG_BFS.BusquedaPorAmplitud(estado_inicial, estado_final);
                long tiempo_fin = System.currentTimeMillis();
                long tiempo = tiempo_fin - tiempo_ini;
                Nodos_BFS aux = nodo_solucion;

                while (aux.padre != null) {
                    pila.addFirst(aux);
                    aux = aux.padre;
                }

                pila.addFirst(nodo);

                String cad = "";
                while (pila.isEmpty() != true) {
                    aux = pila.poll();
                    cad = cad + aux.ciudad + " -> ";

                }
                txt1.setText("La solucion en amplitud es: " + cad + "\nNum. de pasos: " + nodo_solucion.pasos + "\nTiempo: " + tiempo + " ms");
            }
        }

        if ((r_amplitud.isSelected() == false) && (r_costeU.isSelected() == false)) {
            JOptionPane.showMessageDialog(jLabel1, "Selecciona un metodo de busqueda");
        }

        if (r_costeU.isSelected() == true) {

            if ((estado_inicial == "Elegir Ciudad") || (estado_final == "Elegir Ciudad")) {
                JOptionPane.showMessageDialog(jLabel1, "Selecciona Correctamente las ciudades");
            } else {

                Nodos_BFS nodo = new Nodos_BFS(estado_inicial);
                long tiempo_ini = System.currentTimeMillis();
                Nodos_BFS nodo_solucion = Rutas_SG_UCS.BusquedaCosteUniforme(estado_inicial, estado_final);
                long tiempo_fin = System.currentTimeMillis();
                long tiempo = tiempo_fin - tiempo_ini;
                Nodos_BFS aux = nodo_solucion;

                while (aux.padre != null) {
                    pila.addFirst(aux);
                    aux = aux.padre;
                }

                pila.addFirst(nodo);

                String cad = "";
                while (pila.isEmpty() != true) {
                    aux = pila.poll();
                    cad = cad + aux.ciudad + " -> ";

                }
                txt1.setText("La solucion con coste es: " + cad + " con peso de " + nodo_solucion.costo + " km."+ "\nNum. de pasos: " + nodo_solucion.pasos + "\nTiempo: " + tiempo + " ms");
            }
        }


    }//GEN-LAST:event_comenzarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Rutas_CG_UCS_BFS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rutas_CG_UCS_BFS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rutas_CG_UCS_BFS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rutas_CG_UCS_BFS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rutas_CG_UCS_BFS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbx_final;
    private javax.swing.JComboBox<String> cbx_inicial;
    private javax.swing.JButton comenzar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton r_amplitud;
    private javax.swing.JRadioButton r_costeU;
    private javax.swing.JPanel radios;
    private javax.swing.JTextArea txt1;
    // End of variables declaration//GEN-END:variables
}
