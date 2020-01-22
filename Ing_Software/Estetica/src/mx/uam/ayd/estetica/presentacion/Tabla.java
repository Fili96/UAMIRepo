package mx.uam.ayd.estetica.presentacion;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JTable{
	

	public void modeloTabla(JTable tabla, Object[][] datos, Object[] cabecera) {
		
		tabla.setDefaultRenderer(Object.class, new Render());
		
		DefaultTableModel modelo = new DefaultTableModel(datos,cabecera) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tabla.setModel(modelo);
		tabla.setRowHeight(20);
		
		
	}
	
}
