package mx.uam.ayd.estetica.presentacion;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Render extends DefaultTableCellRenderer{
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, 
			boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		if(value instanceof JButton) {
			return (JButton) value;
		}
		
		if(value instanceof JComboBox) {
			return (JComboBox<?>) value;
		}
		
		if(value instanceof JCheckBox) {
			return (JCheckBox) value;
		}
		
		if(value instanceof JRadioButton) {
			return (JRadioButton) value;
		}
		
		
		
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
	
}

