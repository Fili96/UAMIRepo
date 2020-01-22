package Carrera;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Animal extends Thread {
    
    String nombre;
    int meta;
    static int pos=0;
    int retardo;
    JLabel lab_sh;
    JPanel panel_sh;

    Animal(String nombre, int meta,int retardo, JLabel label,JPanel panel) {
        this.nombre = nombre;
        this.meta = meta;
        this.retardo=retardo;
        lab_sh=label;
        panel_sh=panel;
    }

    @Override
    public void run() {
        
        for (int i = 0; i < meta-128; i++) {
            lab_sh.setLocation(i, 0);
            try {
                sleep(retardo);
            } catch (Exception ex) {
                System.out.println("Error al hacerlos mas lentos");
            }
        }
        
        pos++;
        lab_sh.setLocation(0, 0);
        lab_sh.setText(nombre+ "llego en la posicion "+ pos);
        
        if(pos==3){
            pos=0;
        }
        

    }
}
