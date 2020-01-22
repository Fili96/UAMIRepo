package mx.uam.ayd.estetica.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mx.uam.ayd.estetica.modelo.Cita;


import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaModificaConsultaCita extends JFrame {
	
	/********************************************/
	/******** COMPONENTES ***********/
	/******** Y ***********/
	/******** ATRIBUTOS GLOBALES ***********/
	/********************************************/

	private JPanel jPanelContenedor;
	private JTable jTableCitas;
	private JScrollPane scrollPaneContenedorTablaInventario;
	private JButton jButtonGuardar;
	private JButton jButtonCancelarCita;
	private JButton jButtonRegresar;
	private String[] encabezadosJTable;	
	private ArrayList<Cita> listaCitas;
	
	private DefaultTableModel modeloJTable = new DefaultTableModel() { //se define el modelo que ocupará la tabla
		Class[] types = new Class[] {
				// definimos los tipos que va a aceptar cada celda
				java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class 
				};

		// Función que asignará el tipo de campo que asignaste previamente
		public Class getColumnClass(int columnIndex) {
			return types[columnIndex];
		}
	};

	

	/********************************************/
	/******** CONSTRUCTOR ***************/
	/********************************************/
	
	public VentanaModificaConsultaCita(ControlModificaConsultaCita CMCC) {
		setType(Type.UTILITY);
		setTitle("Citas");
		setBackground(Color.WHITE);	
		
		/********************************************/
		/************* INICIALIZADOR Y *********************/
		/*** CONFIGURACION DE LOS COMPONENTES *************/
		/********************************************/
		
		
		/**************Array de productos temporal, **************/
		/***** utilizado para almacenar la informacion de la base de datos **/
		listaCitas = new ArrayList<Cita>(Arrays.asList(CMCC.dameCitas()));

		jPanelContenedor = new JPanel();
		jPanelContenedor.setBackground(Color.WHITE);
		
		
		/*** EVITA QUE SE PUEDA EDITAR LOS ID *************/
		jTableCitas = new JTable(modeloJTable) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return colIndex != 0;
			}
		};


		/*** CONFIGURACION DE JTABLE *************/
		jTableCitas.setFillsViewportHeight(true);
		jTableCitas.setBackground(Color.WHITE);
		jTableCitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Selecciona un indice de la lista a la vez
		scrollPaneContenedorTablaInventario = new JScrollPane(); 
		
		/*** CONFIGURACION DE BOTONES *************/
		jButtonGuardar = new JButton("Guardar");
		jButtonGuardar.setBackground(new Color(0, 204, 204));
		jButtonGuardar.setBounds(50, 287, 105, 25);
		
		jButtonCancelarCita= new JButton("Cancelar Cita");
		jButtonCancelarCita.setBackground(new Color(0, 204, 204));
		jButtonCancelarCita.setBounds(280, 287, 150, 25);
		
		jButtonRegresar = new JButton("Regresar");
		jButtonRegresar.setBackground(new Color(51, 204, 255));
		jButtonRegresar.setBounds(170, 287, 100, 25);
		
		/*** ENCABEZADO DE LA TABLA ***/	
		encabezadosJTable = new String[] { "Id", "Empleado", "Cliente", "Fecha", "Descripcion" };

		

		/** configuraciones graficas de los componentes **/
		jPanelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPanelContenedor);
		jPanelContenedor.setLayout(null);

		scrollPaneContenedorTablaInventario.setBounds(12, 47, 427, 228);	
		
		/** agregamos los encabezados al jtable **/

		modeloJTable.setColumnIdentifiers(encabezadosJTable); 
		
		
		setBounds(100, 100, 459, 358);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		

		jTableCitas.getColumnModel().getColumn(3).setPreferredWidth(116); // armamos el jtable, pegamos toda la
																				// informacion
		scrollPaneContenedorTablaInventario.setViewportView(jTableCitas); // agreamos un scrollaljtable

		// agregamos todos los elemntos al contenedor

		jPanelContenedor.add(scrollPaneContenedorTablaInventario);
		jPanelContenedor.add(jButtonGuardar);
		jPanelContenedor.add(jButtonRegresar);
		jPanelContenedor.add(jButtonCancelarCita);
		
		/* ETIQUETA DONDE SE PONE EL TITULO DE LA VENTANA */
		JLabel jLabelTitulo = new JLabel("Citas:");
		jLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTitulo.setForeground(new Color(105, 105, 105));
		jLabelTitulo.setBackground(new Color(0, 0, 0));
		jLabelTitulo.setFont(new Font("DejaVu Serif", Font.BOLD, 20));
		jLabelTitulo.setBounds(12, 14, 145, 15);
		jPanelContenedor.add(jLabelTitulo);

		/*
		 * for que crea cada fila para el jTable, con la informacion recuperada de la
		 * base de datos
		 */
		
		for (int i = 0; i < listaCitas.size(); i++) {
			Object[] nuevaFilaJTable = { listaCitas.get(i).dameId(),listaCitas.get(i).dameEmpleado().dameNombre(), listaCitas.get(i).dameNombreCliente(),
					listaCitas.get(i).dameFecha(), listaCitas.get(i).dameDescripcion() };

			modeloJTable.addRow(nuevaFilaJTable); // agregamos la fila al jTable
		}

		
		/** EVENTO QUE CIERRA LA VENTANA **/

		jButtonRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});

		/** EVENTO QUE GUARDA LA MODIFICACION REALIZADA EN ALGUNA FILA  **/
		jButtonGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = jTableCitas.getSelectedRow();
				
				if(filaSeleccionada != 0){
					int dialogResult = JOptionPane.showConfirmDialog(null,
							"Has modificado la linea " + (filaSeleccionada + 1) + "¿Deseas guardar los cambios?");
					if (dialogResult == JOptionPane.YES_OPTION) {
						try {
	
							// creamos un producto temporal con la informacion modificada en el jTable, para
							// poder pasarselo como parametro al Control
							Cita tempCitas = new Cita(
									CMCC.buscaEmpleado(jTableCitas.getValueAt(filaSeleccionada, 1).toString()+""),
									jTableCitas.getValueAt(filaSeleccionada, 2).toString() + "",
									jTableCitas.getValueAt(filaSeleccionada, 3).toString() + "",
									jTableCitas.getValueAt(filaSeleccionada, 4).toString() + ""
									
									);
	
							/** le pasamos al metoro actualizaProducto, del control, el nuevo Producto, con**/
							/** la informacion obtenida en el jtable**/
							/** asi como el identidicador (id), del producto original, que deseamos sea**/
							/** modificado **/
	
							if (CMCC.actualizaCita(tempCitas,
									
									Integer.parseInt(jTableCitas.getValueAt(filaSeleccionada, 0).toString() + ""))) {
								/* actualiza la jTable */
	
								// al terminar la actualizacion en la base de datos, "refrescamos" el jTable de
								// la vista
								// creamos un arreglo con la nueva informacion del producto modificado para
								// pasarselo al jtable
								Object[] filaModificada = {
										Integer.parseInt(jTableCitas.getValueAt(filaSeleccionada, 0).toString() + ""),
										tempCitas.dameEmpleado().dameNombre(), 
										tempCitas.dameNombreCliente(), 
										tempCitas.dameFecha(),
										tempCitas.dameDescripcion() };
	
								modeloJTable.removeRow(filaSeleccionada); // borramos la fila q se modifico
								modeloJTable.addRow(filaModificada); // creamos una nueva fila, con la informacion cambiada
							}
						} catch (Exception error) {
							System.out.println("ocurrio un error al intentar actualizar");
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "Seleciona un renglon");
				}
				
				
			}
		});
		
		/** EVENTO QUE cancela LA MODIFICACION REALIZADA EN ALGUNA FILA **/
		jButtonCancelarCita.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//selecciona la fila a eliminar y te regresa la fila seleccionada
				int filaSeleccionada = jTableCitas.getSelectedRow();
                
				//control llama a quita citas que recibe el id de la cita
				//se obtiene el ide de la cita seleccionada
				//se remueve la cita y se actualiza la tabla en ventana
				CMCC.quitaCita(Integer.parseInt(jTableCitas.getValueAt(filaSeleccionada, 0).toString() + ""));
				modeloJTable.removeRow((filaSeleccionada)); // borramos la fila q se modifico
		
				
			}
		});

	}// fin del constructor
}