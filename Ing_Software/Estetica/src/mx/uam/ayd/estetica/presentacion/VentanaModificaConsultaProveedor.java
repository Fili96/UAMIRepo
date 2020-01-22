package mx.uam.ayd.estetica.presentacion;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mx.uam.ayd.estetica.modelo.Proveedor;

public class VentanaModificaConsultaProveedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	/* declaracion de componentes usados */
	private JPanel jPanelContenedor;
	private ControlModificaConsultaProveedor CCP;
	private JTable jTableProveedores;
	private JScrollPane scrollPaneContenedorTablaProveedor;
	//private JButton jButtonEliminar;
	private JButton jButtonRegresar;
	private String[] encabezadosJTable;
	private JLabel jLabelTitulo;
	// array que almacenara los proveedores
	private ArrayList<Proveedor> listaProveedores;

	/* modelo utilizado en el diseño de la tabla */
	private DefaultTableModel modeloJTable = new DefaultTableModel() { // se define el modelo que ocupará la tabla
		Class[] types = new Class[] {
				// definimos los tipos que va a aceptar cada celda
				java.lang.Integer.class, java.lang.String.class, java.lang.String.class,java.lang.String.class ,java.lang.String.class  };

		// Función que asignará el tipo de campo que asignaste previamente
		public Class getColumnClass(int columnIndex) {
			return types[columnIndex];
		}
	};

	public VentanaModificaConsultaProveedor(ControlModificaConsultaProveedor CCP) {
		
		setType(Type.UTILITY);
		setTitle("Proveedores");
		setBackground(Color.WHITE);
		setSize(900, 358);
		setLocationRelativeTo(null);
		this.CCP = CCP;

		/* inicializacion de componentes */
		jPanelContenedor = new JPanel();
		jPanelContenedor.setBackground(Color.WHITE);
		jTableProveedores = new JTable(modeloJTable) {
			// evitamos q se pueda editar algunas columnas, nos interesa que no se pueda
			// modificar el id
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return colIndex != 0;
			}
		};

		/* configuracion de las ventanas */
		jTableProveedores.setFillsViewportHeight(true);
		jTableProveedores.setBackground(Color.WHITE);
		jTableProveedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneContenedorTablaProveedor = new JScrollPane();
		jButtonRegresar = new JButton("Regresar");
		jButtonRegresar.setBackground(new Color(51, 204, 255));
		encabezadosJTable = new String[] { "ID","Nombre Proveedor", "Domicilio", "Descripcion","Telefono"};

		/*
		 * array de provedores temporal, utilizado para almacenar la informacion de la
		 * base de datos
		 */
		listaProveedores = new ArrayList<Proveedor>(Arrays.asList(CCP.dameProveedor()));

		/* configuraciones graficas de los componentes */
		jPanelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPanelContenedor);
		jPanelContenedor.setLayout(null);

		/* scroll que contiene la tabla */
		scrollPaneContenedorTablaProveedor.setBounds(12, 47, 870, 228);

		
		jButtonRegresar.setBounds(780, 287, 100, 25);

		modeloJTable.setColumnIdentifiers(encabezadosJTable); // agregamos los encambezados al jtable

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		jTableProveedores.getColumnModel().getColumn(0).setPreferredWidth(3); // armamos el jtable, pegamos toda la

		jTableProveedores.getColumnModel().getColumn(1).setPreferredWidth(25);// informacion
	

		scrollPaneContenedorTablaProveedor.setViewportView(jTableProveedores);// informacion
																				// agreamos un scrollaljtable


		// agregamos todos los elemntos al contenedor

		jPanelContenedor.add(scrollPaneContenedorTablaProveedor);
		jPanelContenedor.add(jButtonRegresar);

		/* estilo del titulo */

		
		jLabelTitulo = new JLabel("Proveedores:");

		jLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTitulo.setForeground(new Color(105, 105, 105));
		jLabelTitulo.setBackground(new Color(0, 0, 0));
		jLabelTitulo.setFont(new Font("DejaVu Serif", Font.BOLD, 20));
		jLabelTitulo.setBounds(12, 12, 212, 15);
		jPanelContenedor.add(jLabelTitulo);

		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/* variable que almacenara el numero de la fila seleccionada */
				int filaSeleccionada = jTableProveedores.getSelectedRow();

				/* dialogo que pide confirmacion de cambios */
				int dialogResult = JOptionPane.showConfirmDialog(null,
						"¿Deseas eliminar al empleado de la linea? " + (filaSeleccionada + 1));
				/* si se acepta el dialogo, hacemos la accion de modificar */
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {

							CCP.quitaProveedor(Integer.parseInt(jTableProveedores.getValueAt(filaSeleccionada, 0).toString() + ""));
							modeloJTable.removeRow((filaSeleccionada)); // borramos la fila q se modifico
														
					
					} catch (Exception error) {
						System.out.println("ocurrio un error al intentar eliminar");
					}
				}
				
				
			}
		});
		btnEliminar.setBackground(Color.RED);
		btnEliminar.setBounds(614, 287, 117, 25);
		jPanelContenedor.add(btnEliminar);


		/*
		 * for que crea cada fila para el jTable, con la informacion recuperada de la
		 * base de datos
		 */
		
		for (int i = 0; i < listaProveedores.size(); i++) {
	
				/* arma la tabla que agregara al jtable */
				Object[] nuevaFilaJTable = { listaProveedores.get(i).dameId(), listaProveedores.get(i).dameNombre(),listaProveedores.get(i).dameDomicilio(),listaProveedores.get(i).dameDescripcion(),listaProveedores.get(i).dameTelefono()};

				/* agrega una nueva fila al jtable */
				modeloJTable.addRow(nuevaFilaJTable); // agregamos la fila al jTable
			
		}

		/* eventos */

		jButtonRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // oculta la ventana
			}
		});


	}// fin del constructor

}
