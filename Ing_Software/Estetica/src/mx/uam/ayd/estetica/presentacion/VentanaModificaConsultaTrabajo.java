package mx.uam.ayd.estetica.presentacion;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Producto;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaModificaConsultaTrabajo extends JFrame {
	
	/*********************   control  ******************************/

	private ControlModificaConsultaTrabajo controlModificaConsultaTrabajo;

	/*********************   Componentes  ******************************/
	
	private JTextField jTextFieldServicio;
	private JComboBox jComboBoxEmpleado;
	private JTextField jTextFieldDescripcion;
	private JTextField jTextFieldMonto;
	private JTextField jTextFieldFecha;
	private JTextField jTextFieldPiezas;
	private JComboBox jComboBoxProducto;
	private JLabel jLabelServicio;
	private JLabel jLabelEmpleado;
	private JLabel jLabelDescripcion;
	private JLabel jLabelFecha;
	private JLabel jLabelMonto;
	private JLabel jLabelProducto;
	private JLabel jLabelPzasUsadas;
	private Tabla tabla;
	private JScrollPane scrollPane;
	 
	
	/*********************   Constructor  ******************************/
	public VentanaModificaConsultaTrabajo(ControlModificaConsultaTrabajo controlModificaConsultaTrabajo) {
		getContentPane().setBackground(Color.WHITE);
		this.controlModificaConsultaTrabajo = controlModificaConsultaTrabajo;
		setTitle("Consulta-Modifica Trabajo");
		getContentPane().setLayout(null);
		setBounds(100, 100, 952, 334);
		initialize();
	}

	/*********************   inicializacion de componentes  ******************************/
	private void initialize() {

		//llenado
		jTextFieldServicio = new JTextField();
		jComboBoxEmpleado = new JComboBox();
		jTextFieldDescripcion = new JTextField();
		jTextFieldMonto = new JTextField();
		jTextFieldFecha = new JTextField();
		jTextFieldPiezas = new JTextField();
		jComboBoxProducto = new JComboBox();
		jLabelServicio = new JLabel("Servicio");
		jLabelEmpleado = new JLabel("Empleado");
		jLabelDescripcion = new JLabel("Descripcion");
		jLabelFecha = new JLabel("Fecha");
		jLabelMonto = new JLabel("Monto");
		jLabelProducto = new JLabel("Producto");
		jLabelPzasUsadas = new JLabel("Pza(s) Usadas");
		tabla = new Tabla();
		tabla.setBackground(Color.WHITE);
		scrollPane = new JScrollPane();
		Empleado [] empleados;  
		Producto [] productos;
		empleados=controlModificaConsultaTrabajo.dameEmpleados();
		productos=controlModificaConsultaTrabajo.dameProductos();
		jComboBoxEmpleado.setModel(new DefaultComboBoxModel<>(controlModificaConsultaTrabajo.dameNombreEmpleados(empleados)));
		jComboBoxProducto.setModel(new DefaultComboBoxModel<>(controlModificaConsultaTrabajo.dameNombreProductos(productos)));
		// config labels
		jLabelServicio.setBounds(24, 38, 70, 15);
		jLabelEmpleado.setBounds(150, 38, 70, 15);
		jLabelDescripcion.setBounds(276, 38, 114, 15);
		jLabelFecha.setBounds(533, 38, 70, 15);
		jLabelMonto.setBounds(402, 38, 70, 15);
		jLabelProducto.setBounds(659, 38, 70, 15);
		jLabelPzasUsadas.setBounds(785, 38, 114, 15);

		// config textfields
		jTextFieldServicio.setBounds(24, 65, 114, 19);
		jComboBoxEmpleado.setBounds(150, 65, 114, 19);
		jTextFieldDescripcion.setBounds(276, 65, 114, 19);
		jTextFieldMonto.setBounds(402, 65, 114, 19);
		jTextFieldFecha.setBounds(533, 65, 114, 19);
		jTextFieldPiezas.setBounds(785, 65, 114, 19);
		jComboBoxProducto.setBounds(659, 65, 114, 19);

		/******   config tabla  ******/
		
		// datos para llenar la tabla
		Object[] cabecera = { "id", "Servicio", "Empleado", "Descripcion", "Monto", "Fecha", "Producto", "Pza Usadas", "Colocar","Accion" };
		Object[][] datos =controlModificaConsultaTrabajo.dameTrabajos();
		scrollPane.setBounds(24, 96, 889, 163);
		//evento de tabla
		tabla.addMouseListener(eventoTabla);
		//se agrega el modelo a la tabla
		tabla.modeloTabla(tabla, datos, cabecera);
		//se agrega tabla al area con scroll
		scrollPane.setViewportView(tabla);
		
		//agregaciones
		getContentPane().add(scrollPane);
		getContentPane().add(jTextFieldServicio);
		getContentPane().add(jComboBoxEmpleado);
		getContentPane().add(jTextFieldDescripcion);
		getContentPane().add(jTextFieldMonto);
		getContentPane().add(jTextFieldFecha);
		getContentPane().add(jTextFieldPiezas);
		getContentPane().add(jComboBoxProducto);
		getContentPane().add(jLabelServicio);
		getContentPane().add(jLabelEmpleado);
		getContentPane().add(jLabelDescripcion);
		getContentPane().add(jLabelFecha);
		getContentPane().add(jLabelMonto);
		getContentPane().add(jLabelProducto);
		getContentPane().add(jLabelPzasUsadas);
		
		JButton jButtonRegresar = new JButton("Regresar");
		jButtonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		jButtonRegresar.setBackground(new Color(0, 191, 255));
		jButtonRegresar.setHorizontalAlignment(SwingConstants.RIGHT);
		jButtonRegresar.setBounds(785, 263, 99, 25);
		getContentPane().add(jButtonRegresar);
		
	}
	
	/*********************   EVENTOS  ******************************/

	MouseListener eventoTabla = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent evt) {
			
			//se obtiene las coordenadas en la tabla
			int column = tabla.getColumnModel().getColumnIndexAtX(evt.getX());
			int row = evt.getY() / tabla.getRowHeight();
			//las coordenadas estan en el rango de los botones
			if (row < tabla.getRowCount() && row >= 0 && column < tabla.getColumnCount() && column >= 0) {
				Object value = tabla.getValueAt(row, column);
				//el objeto para el evento es un boton
				if (value instanceof JButton) {
					((JButton) value).doClick();
					JButton boton = (JButton) value;
					
					
					//empieza evento botones colocar
					if(boton.getName().equals("col")) {
						
						jTextFieldServicio.setText(tabla.getValueAt( row, 1).toString());
						jTextFieldDescripcion.setText(tabla.getValueAt( row, 3).toString());
						jTextFieldMonto.setText(tabla.getValueAt( row, 4).toString());
						jTextFieldFecha.setText(tabla.getValueAt( row, 5).toString());
						jTextFieldPiezas.setText(tabla.getValueAt( row, 7).toString());
						
					}
					
					//si el boton tiene de nombre "mod" se hace el evento del boton
					if (boton.getName().equals("mod")) {
						//empieza el evento del boton
						int id = Integer.valueOf(tabla.getValueAt(row, 0).toString());
						String servicio = jTextFieldServicio.getText();
						String nombreEmpleado = jComboBoxEmpleado.getSelectedItem().toString();
						Empleado empleado= controlModificaConsultaTrabajo.buscaEmpleado(nombreEmpleado);
						String descripcion = jTextFieldDescripcion.getText();
						double monto = Double.parseDouble(jTextFieldMonto.getText());
						String fecha = jTextFieldFecha.getText();
						String nombreProducto = jComboBoxProducto.getSelectedItem().toString();
						Producto producto= controlModificaConsultaTrabajo.buscaProducto(nombreProducto);
						int pzaUsadas = Integer.parseInt(jTextFieldPiezas.getText());
						
						int dialogresult=JOptionPane.showConfirmDialog(null, "�Estas seguro que quieres modificar los datos?");
						
						if(dialogresult==JOptionPane.YES_OPTION) {
							//actualiza los datos
							boolean modificado= controlModificaConsultaTrabajo.actualizaTrabajo(id, servicio, empleado, descripcion, monto, fecha, producto,
									pzaUsadas);
							if(modificado== true) {
								JOptionPane.showMessageDialog(null,"se han modificado los datos");
								tabla.setValueAt(servicio, row, 1);
								tabla.setValueAt(empleado.dameNombre(), row, 2);
								tabla.setValueAt(descripcion, row, 3);
								tabla.setValueAt(monto, row, 4);
								tabla.setValueAt(fecha, row, 5);
								tabla.setValueAt(producto.dameNombre(), row, 6);
								tabla.setValueAt(pzaUsadas, row, 7);
							}

						}
					//termina el evento del boton
					}
				}
			}

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
}
