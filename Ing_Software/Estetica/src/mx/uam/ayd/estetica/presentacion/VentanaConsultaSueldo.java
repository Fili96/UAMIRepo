package mx.uam.ayd.estetica.presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.CSS;

import mx.uam.ayd.estetica.modelo.Empleado;

public class VentanaConsultaSueldo extends JFrame{
	private JPanel jPanelContenedor;
	private JTable jTableInventario;
	private JScrollPane scrollPaneContenedorTablaInventario;
	private String[] encabezadosJTable;
	private JLabel jLabelTitulo;
	private ControlConsultaSueldo CCS;
	
	private DefaultTableModel modeloJTable = new DefaultTableModel() { // se define el modelo que ocupará la tabla
		Class[] types = new Class[] {
				// definimos los tipos que va a aceptar cada celda
				java.lang.Integer.class, java.lang.String.class };

		// Función que asignará el tipo de campo que asignaste previamente
		public Class getColumnClass(int columnIndex) {
			return types[columnIndex];
		}
	};
	
	public VentanaConsultaSueldo(ControlConsultaSueldo CCS){
		this.CCS=CCS;
		jPanelContenedor = new JPanel();
		jPanelContenedor.setBackground(Color.WHITE);
		jTableInventario = new JTable(modeloJTable) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return colIndex != 0;
			}
		};
		
		jTableInventario.setFillsViewportHeight(true);
		jTableInventario.setBackground(Color.WHITE);
		jTableInventario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneContenedorTablaInventario = new JScrollPane();
		encabezadosJTable = new String[] { "Empleado", "Sueldo" };
		
		jPanelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPanelContenedor);
		jPanelContenedor.setLayout(null);

	    
		scrollPaneContenedorTablaInventario.setBounds(20, 45, 370, 210);

		modeloJTable.setColumnIdentifiers(encabezadosJTable); // agregamos los encambezados al jtable

		
		jTableInventario.getColumnModel().getColumn(1).setPreferredWidth(116); // armamos el jtable, pegamos toda la
		// informacion
		scrollPaneContenedorTablaInventario.setViewportView(jTableInventario); // agreamos un scrollaljtable

		// agregamos todos los elemntos al contenedor

		jPanelContenedor.add(scrollPaneContenedorTablaInventario);
		jLabelTitulo = new JLabel("Estetica duarte");
		jLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTitulo.setForeground(new Color(105, 105, 105));
		jLabelTitulo.setBackground(new Color(0, 0, 0));
		jLabelTitulo.setFont(new Font("DejaVu Serif", Font.BOLD, 20));
		jLabelTitulo.setBounds(12, 12, 145, 15);
		jPanelContenedor.add(jLabelTitulo);
		
		//llenado del table
		//Optenemos a todos los empleados y los guardamos en un arreglo
		Empleado[] empleados= CCS.dameEmpleados();
		for(int i=0;i<empleados.length;i++) {
			//Por cada empleado sacamos los trabajos que han hecho
			double[] salarios = CCS.dameCostoTrabajos(empleados[i].dameId());
			//una vez que los tenemos calculamos el salario de los empleados
			double salario = CCS.calculaSalario(salarios);
			CCS.actualizaSalario(salario, empleados[i].dameId());
			Object[] nuevaFilaJTable = {empleados[i].dameNombre(), salario};
			modeloJTable.addRow(nuevaFilaJTable);
		}
		setBounds(100, 100, 425, 340);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setType(Type.UTILITY);
		setTitle("Sueldo");
		setBackground(Color.WHITE);
	}

	
	

}
