package Carrera;

import java.util.Random;

public class CG extends javax.swing.JFrame {

    Animal flash;
    Animal superman;
    Animal batman;
    int rf,rs,rb;

    public CG() {

        initComponents();
        setLocationRelativeTo(null);
    }

    public void numsAleat(){
       int n=3;  //numero de elementos
       int k=n;  //auxiliar;
        int[] numeros=new int[n];
        int[] resultado=new int[n];
        Random rnd=new Random();
        int res; 
        //se rellena una matriz ordenada del 3 al 5
        for(int i=0;i<n;i++){
            numeros[i]=i+3;
        }
        
        for(int i=0;i<n;i++){
            res=rnd.nextInt(k);            
            resultado[i]=numeros[res];
            numeros[res]=numeros[k-1];
            k--;
            
        }
        rf=resultado[0];
        rs=resultado[1];
        rb=resultado[2];
       
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        p_flash = new javax.swing.JPanel();
        L_flash = new javax.swing.JLabel();
        p_superman = new javax.swing.JPanel();
        L_superman = new javax.swing.JLabel();
        p_batman = new javax.swing.JPanel();
        L_batman = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boton.setText("Comenzar");
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });

        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.setLayout(new java.awt.GridLayout(3, 1));

        L_flash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Carrera/flash.png"))); // NOI18N

        javax.swing.GroupLayout p_flashLayout = new javax.swing.GroupLayout(p_flash);
        p_flash.setLayout(p_flashLayout);
        p_flashLayout.setHorizontalGroup(
            p_flashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_flashLayout.createSequentialGroup()
                .addComponent(L_flash)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        p_flashLayout.setVerticalGroup(
            p_flashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_flashLayout.createSequentialGroup()
                .addComponent(L_flash)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel.add(p_flash);

        L_superman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Carrera/superman.png"))); // NOI18N

        javax.swing.GroupLayout p_supermanLayout = new javax.swing.GroupLayout(p_superman);
        p_superman.setLayout(p_supermanLayout);
        p_supermanLayout.setHorizontalGroup(
            p_supermanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_supermanLayout.createSequentialGroup()
                .addComponent(L_superman)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        p_supermanLayout.setVerticalGroup(
            p_supermanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_supermanLayout.createSequentialGroup()
                .addComponent(L_superman)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel.add(p_superman);

        L_batman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Carrera/batman.png"))); // NOI18N

        javax.swing.GroupLayout p_batmanLayout = new javax.swing.GroupLayout(p_batman);
        p_batman.setLayout(p_batmanLayout);
        p_batmanLayout.setHorizontalGroup(
            p_batmanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_batmanLayout.createSequentialGroup()
                .addComponent(L_batman)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        p_batmanLayout.setVerticalGroup(
            p_batmanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_batmanLayout.createSequentialGroup()
                .addComponent(L_batman)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel.add(p_batman);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(boton)
                .addContainerGap(288, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(boton)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActionPerformed

        numsAleat();
      
        flash = new Animal("Flash", 606,rf, L_flash, p_flash);
        superman = new Animal("Superman", 606,rs, L_superman, p_superman);
        batman = new Animal("Batman", 606,rb, L_batman, p_batman);
        
        flash.start();
        superman.start();
        batman.start();
   
        L_flash.setText("");
        L_superman.setText("");
        L_batman.setText("");

        
    }//GEN-LAST:event_botonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CG().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L_batman;
    private javax.swing.JLabel L_flash;
    private javax.swing.JLabel L_superman;
    private javax.swing.JButton boton;
    private javax.swing.JPanel p_batman;
    private javax.swing.JPanel p_flash;
    private javax.swing.JPanel p_superman;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
