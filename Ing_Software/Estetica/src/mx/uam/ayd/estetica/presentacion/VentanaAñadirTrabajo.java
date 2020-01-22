package mx.uam.ayd.estetica.presentacion;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Paquete;
import mx.uam.ayd.estetica.modelo.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;

public class VentanaAñadirTrabajo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/********************************************/
	/******** COMPONENTES ***********/
	/******** Y ***********/
	/******** ATRIBUTOS GLOBALES ***********/
	/********************************************/

	private ControlAñadirTrabajo ctrlAñadirTrabajo;;
	private Empleado[] empleados;
	private Producto[] productos;

	private JPanel panel;
	private JLabel jLabelEstilista;
	private JLabel jLabelFechayHora;
	private JLabel jLabelFechayHora2;
	private JLabel jLabelProducto;
	private JLabel jLabelDescripcion;
	private JLabel jLabelMonto;
	private JLabel jLabelMarca;
	private JLabel jLabelPiezas;
	private JLabel jLabelServicio;
	private JTextField jTextFieldServicio;
	private JTextField jTextFieldMonto;
	private JTextField jTextFieldMarca;
	private JComboBox<?> jComboBoxEmpleado;
	private JComboBox<?> jComboBoxProducto;
	private JComboBox<?> jComboBoxPiezas;
	private JCheckBox jCheckBoxProducto;
	private JTextArea jTextAreaDescripcion;
	private JScrollPane scrollPane;
	private JButton jButtonAñadir;
	private JButton jButtonCancelar;
	// nuevos componentes
	private JPanel panel_2;
	private JCheckBox chckbxValidarpromo;
	private JLabel lblPuntos;
	private JLabel lblPaquete;
	private JLabel lblCotizacion;
	private JComboBox<?> comboBoxpuntos;
	private JComboBox<?> comboBoxPaquetes;
	private JTextField textFieldCotizacion;
	private JTextArea descripcionPaquete;
	private JButton btnValidarpromo;
	

	private Paquete[] paquetes;
	private JLabel lblMontosinpromo;
	private JTextField txtMontosinpromo;
	private JButton btnNewButton ;
	
	

	/********************************************/
	/******** CONSTRUCTOR ***************/
	/********************************************/

	public VentanaAñadirTrabajo(ControlAñadirTrabajo ctrlAñadirTrabajo) {
		getContentPane().setBackground(Color.WHITE);

		this.ctrlAñadirTrabajo = ctrlAñadirTrabajo;
		setTitle("Añadir Trabajo");
		setBounds(100, 100, 836, 442);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		initialize();
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	/********************************************/
	/******** INICIALIZADOR *************/
	/********************************************/

	private void initialize() {

		// llenado de componentes
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		jLabelEstilista = new JLabel("Estilista");
		jLabelFechayHora = new JLabel("Fecha y Hora");
		jLabelFechayHora2 = new JLabel();
		jLabelProducto = new JLabel("Producto");
		jLabelDescripcion = new JLabel("Descripcion");
		jLabelMonto = new JLabel("Monto");
		jLabelMarca = new JLabel("Marca");
		jLabelPiezas = new JLabel("Pieza(s)");
		jLabelServicio = new JLabel("Servicio");
		jTextFieldServicio = new JTextField("");
		jTextFieldMonto = new JTextField("");
		jTextFieldMarca = new JTextField("");
		jTextFieldMarca = new JTextField("");
		jComboBoxEmpleado = new JComboBox();
		jComboBoxEmpleado.setBackground(Color.WHITE);
		jComboBoxProducto = new JComboBox();
		jComboBoxProducto.setBackground(Color.WHITE);
		jComboBoxPiezas = new JComboBox();
		jComboBoxPiezas.setBackground(Color.WHITE);
		jCheckBoxProducto = new JCheckBox("Productos utilizados");
		jCheckBoxProducto.setBackground(Color.WHITE);
		jTextAreaDescripcion = new JTextArea("");
		scrollPane = new JScrollPane();
		jButtonAñadir = new JButton("Añadir");
		jButtonCancelar = new JButton("Regresar");

		// config Estilista
		jLabelEstilista.setBounds(27, 25, 70, 15);
		jComboBoxEmpleado.setBounds(99, 20, 108, 24);
		// agrega nombres de los empleados al combobox
		empleados = ctrlAñadirTrabajo.dameEmpleados();
		jComboBoxEmpleado.setModel(new DefaultComboBoxModel(ctrlAñadirTrabajo.dameEmpleadosNombre(empleados)));

		// config fecha y hora
		Calendar fecha = Calendar.getInstance();
		String hora = String.valueOf(fecha.get(Calendar.HOUR));
		String minuto = String.valueOf(fecha.get(Calendar.MINUTE));
		String dia = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
		String mes = String.valueOf(fecha.get(Calendar.MONTH));
		String año = String.valueOf(fecha.get(Calendar.YEAR));

		jLabelFechayHora2.setText(año + "-" + mes + "-" + dia + "   " + hora + ":" + minuto + " ");
		jLabelFechayHora.setBounds(27, 65, 92, 15);
		jLabelFechayHora2.setBounds(37, 94, 217, 24);

		// config descripcion
		jLabelDescripcion.setBounds(272, 25, 92, 15);
		scrollPane.setBounds(268, 52, 240, 98);
		scrollPane.setViewportView(jTextAreaDescripcion);

		// config servicio
		jLabelServicio.setBounds(27, 130, 70, 15);
		jTextFieldServicio.setBounds(93, 130, 114, 19);

		// config monto
		jLabelMonto.setBounds(27, 161, 70, 15);
		jTextFieldMonto.setBounds(93, 159, 114, 19);

		// config checkbox
		jCheckBoxProducto.setBounds(26, 196, 181, 23);

		// config panel
		panel.setBorder(
				new TitledBorder(null, "Informacion del Producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(27, 239, 452, 102);
		panel.setLayout(null);
		jLabelProducto.setBounds(63, 25, 70, 15);
		jComboBoxProducto.setBounds(12, 52, 172, 24);
		// agrega nombres de productos al combobox
		productos = ctrlAñadirTrabajo.dameProductos();
		jComboBoxProducto.setModel(new DefaultComboBoxModel(ctrlAñadirTrabajo.dameProductosNombre(productos)));
		jComboBoxProducto.setEnabled(false);
		jTextFieldMarca.setBounds(199, 52, 169, 19);
		// guarda el nombre la marca del producto
		String marca = ctrlAñadirTrabajo.buscaProductoMarca(jComboBoxProducto.getSelectedItem().toString(), productos);
		jTextFieldMarca.setText(marca);
		jTextFieldMarca.setEditable(false);
		jTextFieldMarca.setEnabled(false);
		jLabelMarca.setBounds(243, 25, 70, 15);
		jLabelPiezas.setBounds(370, 25, 70, 15);
		jComboBoxPiezas.setBounds(380, 52, 60, 24);
		jComboBoxPiezas.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		jComboBoxPiezas.setEnabled(false);

		// config botones
		jButtonAñadir.setBounds(122, 364, 117, 25);
		jButtonCancelar.setBounds(272, 364, 117, 25);

		// EVENTOS******************************************************************************************
		jCheckBoxProducto.addActionListener(eventoCheckbox);
		jComboBoxProducto.addItemListener(changeclick);
		jButtonAñadir.addActionListener(eventoBtnAñadir);
		jButtonCancelar.addActionListener(eventoBtnCancelar);
		
		// nuevos

		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(541, 117, 265, 272);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		lblPuntos = new JLabel("puntos");
		lblPuntos.setBackground(SystemColor.activeCaption);
		lblPuntos.setForeground(new Color(0, 0, 0));
		lblPuntos.setBounds(32, 28, 73, 15);
		panel_2.add(lblPuntos);
		lblPuntos.setEnabled(false);

		lblPaquete = new JLabel("paquetes");
		lblPaquete.setBounds(32, 68, 70, 15);
		panel_2.add(lblPaquete);
		lblPaquete.setEnabled(false);

		

		chckbxValidarpromo = new JCheckBox("validarPromo");
		chckbxValidarpromo.setForeground(SystemColor.activeCaption);
		chckbxValidarpromo.setBounds(541, 73, 129, 23);
		chckbxValidarpromo.setEnabled(true);
		getContentPane().add(chckbxValidarpromo);

		comboBoxpuntos = new JComboBox();
		comboBoxpuntos.setBounds(142, 24, 95, 24);
		panel_2.add(comboBoxpuntos);
		comboBoxpuntos.setModel((new DefaultComboBoxModel(new String[] { "1-15", "15-20", "20-30" })));
		comboBoxpuntos.setSelectedIndex(-1);
		comboBoxpuntos.setEnabled(false);
		
		

		comboBoxPaquetes = new JComboBox();
		comboBoxPaquetes.setBounds(142, 63, 95, 24);
		panel_2.add(comboBoxPaquetes);
		comboBoxPaquetes.setEnabled(false);

		
		
		

		
		
		
		

		btnValidarpromo = new JButton("validarPromo");
		btnValidarpromo.setBackground(new Color(153, 204, 255));
		btnValidarpromo.setBounds(106, 186, 141, 25);
		panel_2.add(btnValidarpromo);
		btnValidarpromo.setEnabled(false);

		lblMontosinpromo = new JLabel("Monto sin promocion");
		lblMontosinpromo.setBackground(SystemColor.activeCaption);
		lblMontosinpromo.setBounds(32, 126, 148, 15);
		panel_2.add(lblMontosinpromo);
		lblMontosinpromo.setEnabled(false);

		txtMontosinpromo = new JTextField();
		txtMontosinpromo.setBounds(32, 153, 127, 19);
		panel_2.add(txtMontosinpromo);
		txtMontosinpromo.setColumns(10);
		txtMontosinpromo.setEnabled(false);
		
		btnNewButton = new JButton("Cancelar");
		btnNewButton.setEnabled(false);	
		btnNewButton.setBounds(130, 235, 112, 25);
		panel_2.add(btnNewButton);
		
				
		
		

		chckbxValidarpromo.addActionListener(eventovalidar);
		comboBoxpuntos.addItemListener(comboxpuntosS);
		btnValidarpromo.addActionListener(eventobtnAñadirPromo);
		btnNewButton.addActionListener(eventocancelarpromo);
		
		// adds de componentes
		getContentPane().add(jLabelFechayHora);
		getContentPane().add(jLabelEstilista);
		getContentPane().add(jComboBoxEmpleado);
		getContentPane().add(jLabelFechayHora2);
		getContentPane().add(jLabelDescripcion);
		getContentPane().add(scrollPane);
		getContentPane().add(jLabelMonto);
		getContentPane().add(jLabelServicio);
		getContentPane().add(jTextFieldServicio);
		getContentPane().add(jTextFieldMonto);
		getContentPane().add(jCheckBoxProducto);
		getContentPane().add(panel);
		panel.add(jLabelProducto);
		panel.add(jComboBoxProducto);
		panel.add(jTextFieldMarca);
		panel.add(jLabelMarca);
		panel.add(jLabelPiezas);
		panel.add(jComboBoxPiezas);
		getContentPane().add(jButtonAñadir);
		getContentPane().add(jButtonCancelar);

	}// fin inicializar

	/********************************************/
	/********** EVENTOS *****************/
	/********************************************/

	ActionListener eventobtnAñadirPromo = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			    if(txtMontosinpromo.getText().trim().isEmpty()==false) {
				  
                double montos = Double.parseDouble((txtMontosinpromo.getText().trim()));
				System.out.println("eTyyyyyyyyyyy"+txtMontosinpromo.getText().trim());
				String m  = (comboBoxpuntos.getSelectedItem().toString().trim());
				double mf=montos-ctrlAñadirTrabajo.descuentos(m, montos);
				
				String cadena  = String.valueOf(mf);
				
									
				jTextFieldMonto.setText(cadena);
				montos=Double.parseDouble(cadena);
				jTextFieldServicio.setText(comboBoxPaquetes.getSelectedItem().toString().trim());
				String des=ctrlAñadirTrabajo.buscaPaquete(comboBoxPaquetes.getSelectedItem().toString()).dameDescripcion();
				jTextAreaDescripcion.setText(des);
				String dp=jTextAreaDescripcion.getText();
				jTextAreaDescripcion.setText(jTextAreaDescripcion.getText()+" "+dp);
				JOptionPane.showMessageDialog(null,"Se a validado CORRECTAMENTE la promocion ");
				}
			    else {
			    	if((txtMontosinpromo.getText()).isEmpty()==true) {
			    		JOptionPane.showMessageDialog(null,"ADVERTENCIA: llenar campo Monto ");
			    	}
			    }

		}
	};

	ActionListener eventovalidar = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("soy validar");
			if (chckbxValidarpromo.isSelected() == true ) {
				comboBoxpuntos.setEnabled(true);
				btnNewButton.setEnabled(true);	
				}
			
			else {
				
				btnValidarpromo.setEnabled(false);
				comboBoxpuntos.setEnabled(false);
				comboBoxPaquetes.setEnabled(false);
				txtMontosinpromo.setEnabled(false);
				btnNewButton.setEnabled(false);	
				
				
			}	
			

		}
	};
	
	
	
	ActionListener eventocancelarpromo = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("scancelarpromo");
			jTextFieldServicio.setText("");
			
		
				
				
				jTextAreaDescripcion.setText("");
				jTextFieldServicio.setText("");	
				jTextFieldMonto.setText("              ");
				btnValidarpromo.setEnabled(false);
				comboBoxpuntos.setEnabled(false);
				comboBoxPaquetes.setEnabled(false);
				txtMontosinpromo.setEnabled(false);
			
			
		}
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	ItemListener comboxpuntosS = new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			if (comboBoxpuntos.getSelectedIndex()!=-1) {
				
				comboBoxPaquetes.setEnabled(true);
				String m  = (comboBoxpuntos.getSelectedItem().toString().trim());
			  	System.out.println("m puntos1 "+m);
                comboBoxPaquetes.setModel(new DefaultComboBoxModel(ctrlAñadirTrabajo.damePaquetesPuntos(ctrlAñadirTrabajo.damePaquetes(m))));
        
				String p = comboBoxPaquetes.getSelectedItem().toString().trim();
				
				String msp= txtMontosinpromo.getText().trim(); 
				jTextFieldMonto.setText(msp);
				txtMontosinpromo.setEnabled(true);
				System.out.println("m puntos "+m );
				
				
				btnValidarpromo.setEnabled(true);
					
					
				
				

			}
			comboBoxpuntos.setSelectedItem(-1);
			comboBoxPaquetes.setSelectedIndex(-1);;
		}
	};

	// viejos

	ActionListener eventoCheckbox = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (jCheckBoxProducto.isSelected() == true) {
				jComboBoxProducto.setEnabled(true);
				jTextFieldMarca.setEnabled(true);
				jComboBoxPiezas.setEnabled(true);
			} else {

				jComboBoxProducto.setEnabled(false);
				jTextFieldMarca.setEnabled(false);
				jComboBoxPiezas.setEnabled(false);
			}

		}
	};

	ActionListener eventoBtnAñadir = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {

				// CAMPOS VACIOS
				if ((jTextFieldMonto.getText().equals("")) || (jTextFieldServicio.getText().equals("")||(jTextAreaDescripcion.getText().isEmpty()==true) )) {
					JOptionPane.showMessageDialog(null, "Es necesario llenar los campos");
				} else {

					String nombreservicio = jTextFieldServicio.getText();
					String nombreEmpleado = jComboBoxEmpleado.getSelectedItem().toString();
					Empleado empleado = ctrlAñadirTrabajo.buscaEmpleado(nombreEmpleado, empleados);
					String descripcion = jTextAreaDescripcion.getText();
					double monto = Double.parseDouble(jTextFieldMonto.getText().trim());
					String fecha = jLabelFechayHora2.getText();
					fecha = fecha.substring(0, fecha.indexOf(" "));
					String nombreProducto = jComboBoxProducto.getSelectedItem().toString();
					String marcaProducto = jTextFieldMarca.getText();
					Producto producto = ctrlAñadirTrabajo.buscaProducto(nombreProducto, marcaProducto, productos);
					int pzs_usadas = Integer.parseInt(jComboBoxPiezas.getSelectedItem().toString());

					// EL MONTO ES MENOR O IGUAL A 0
					if (Double.parseDouble(jTextFieldMonto.getText()) <= 0) {
						JOptionPane.showMessageDialog(null, "Verifica que la cantidad del monto sea correcta");
					}

					// NO HAY SUFUCIENTES PIEZAS DEL PRODUCTO EN EL INVENTARIO
					if (producto.damePzaExistencia() - pzs_usadas < 0) {
						JOptionPane.showMessageDialog(null, "ADVERTENCIA: solo hay " + producto.damePzaExistencia()
								+ " " + producto.dameNombre() + " en el inventario");
					}

					// SE CUMPLEN TODAS LAS EXCEPCIONES PREEVISTAS
					if ((Double.parseDouble(jTextFieldMonto.getText()) > 0)
							&& (producto.damePzaExistencia() - pzs_usadas >= 0)) {

						if (jCheckBoxProducto.isSelected() == false) {
							System.out.println("perra");
							producto = ctrlAñadirTrabajo.buscaProducto("ninguno", "ninguno", productos);
							pzs_usadas = 0;
						}

						boolean añadido = ctrlAñadirTrabajo.añadirTrabajo(nombreservicio, empleado, descripcion, monto,
								fecha, producto, pzs_usadas);

						dispose();

						if (añadido == true) {
							// SE ACTUALIZAN LAS PIEZAS EXISTENTES DEL PRODUCTO
							if (!(producto.dameNombre().equals("ninguno"))) {
								ctrlAñadirTrabajo.actualizaPiezasExistentes(producto.damePzaExistencia() - pzs_usadas,
										producto.dameId());
							}
							JOptionPane.showMessageDialog(null, "Trabajo añadido");
						} else {
							JOptionPane.showMessageDialog(null, "Error al Añadir Trabajo");
						}
					}
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Metiste mal el monto");
			}
		}
	};

	ActionListener eventoBtnCancelar = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			dispose();

		}
	};

	ItemListener changeclick = new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// selecciona la marca de acuerdo al producto y la escribe en el textfield
			if (jComboBoxProducto.getSelectedItem().equals(e.getItem())) {
				String marca = ctrlAñadirTrabajo.buscaProductoMarca(e.getItem().toString(), productos);
				jTextFieldMarca.setText(marca);
			}

		}
	};
	private JScrollPane scrollPane_1;
}
