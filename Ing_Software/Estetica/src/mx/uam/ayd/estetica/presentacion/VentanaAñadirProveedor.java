package mx.uam.ayd.estetica.presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaAñadirProveedor extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel jLabelNombreProveedor;
	private JTextField jTextFieldnombreProveedor;
	private JLabel jLabelDescripcion;
	private JTextField jTextFieldDescripcion;
	private JButton jButtonRegresar;

	private JButton jButtonAñadir;
	private JLabel jLabelDomicilio;
	private JLabel jLabelCalleyNum;
	private JTextField jTextFieldCalleyNum;	
	private JLabel jLabelTelefono;
	private JTextField jTextFieldTelefono;	
	
	
	public VentanaAñadirProveedor(ControlAñadirProveedor controlAñadirProveedor) {
		/*********************  CONFIGURACION DE LA VENTANA  ******************************/
		getContentPane().setLayout(null);
		setTitle("Añadir Proveedor");
		setSize(650, 367);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		/********************************************/
		/************* INICIALIZADOR Y *********************/
		/*** CONFIGURACION DE LOS COMPONENTES *************/
		/********************************************/

		/*** ETIQUETA *************/
		jLabelNombreProveedor = new JLabel("Nombre");
		jLabelNombreProveedor.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelNombreProveedor.setBounds(12, 12, 163, 15);
		contentPane.add(jLabelNombreProveedor);	

		jLabelDescripcion = new JLabel("Descripcion");
		jLabelDescripcion.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelDescripcion.setBounds(12, 50, 163, 15);
		contentPane.add(jLabelDescripcion);
		
		jLabelDomicilio = new JLabel("Domicilio");
		jLabelDomicilio.setFont(new Font("Dialog", Font.BOLD, 17));
		jLabelDomicilio.setBounds(12, 150, 163, 15);
		contentPane.add(jLabelDomicilio);
		

		jLabelCalleyNum = new JLabel("Calle y numero");
		jLabelCalleyNum.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelCalleyNum.setBounds(12, 170, 175, 15);
		contentPane.add(jLabelCalleyNum);
		
		
		jLabelTelefono = new JLabel("Telefono");
		jLabelTelefono.setFont(new Font("Dialog", Font.BOLD, 17));
		jLabelTelefono.setBounds(12, 220, 163, 18);
		contentPane.add(jLabelTelefono);
		
		/*** CAMPO DE TEXTO QUE RECIBE EL NOMBRE DEL CLIENTE  *************/
		
		jTextFieldnombreProveedor = new JTextField();
		jTextFieldnombreProveedor.setBounds(150, 10, 460, 24);
		contentPane.add(jTextFieldnombreProveedor);
		jTextFieldnombreProveedor.setColumns(10);
		

		
		jTextFieldCalleyNum = new JTextField();
		jTextFieldCalleyNum.setBounds(150, 170, 460, 24);
		contentPane.add(jTextFieldCalleyNum);
		jTextFieldCalleyNum.setColumns(10);
		
		jTextFieldDescripcion = new JTextField();
		jTextFieldDescripcion.setBounds(150, 70, 460, 50);
		contentPane.add(jTextFieldDescripcion);
		jTextFieldDescripcion.setColumns(10);
		
		
		
		
		jTextFieldTelefono = new JTextField();
		jTextFieldTelefono.setBounds(150, 220, 200, 24);
		contentPane.add(jTextFieldTelefono);
		jTextFieldTelefono.setColumns(10);
		
		/*** BOTON QUE REGRESA A LA VENTANA PRINCIPAL  *************/
		jButtonRegresar = new JButton("Regresar");
		jButtonRegresar.setBounds(370, 296, 117, 25);
		jButtonRegresar.setBackground(new Color(0, 191, 255));
		jButtonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}				
		});//Fin del evento
		contentPane.add(jButtonRegresar);
		
		
		
		/*** BOTON Añadir DONDE SE AñADE EL EMPLEADO Y VERIFICA QUE LOS CAMPOS NO ESTEN VACIOS *************/
		
		jButtonAñadir = new JButton("Añadir");
		jButtonAñadir.setBounds(150, 296, 117, 25);
		jButtonAñadir.setBackground(Color.GREEN);
		contentPane.add(jButtonAñadir);
		jButtonAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String nombreEmpleado = jComboBoxSeleccionarEmpleado.getSelectedItem().toString();
				String nombreProveedor = jTextFieldnombreProveedor.getText();
				//String apellidoEmpleado = jTextFieldApellidoProveedor.getText();
				String domicilio = jTextFieldCalleyNum.getText();
				String descripcion = jTextFieldDescripcion.getText();
				String telefono = jTextFieldTelefono.getText();
				
				
				if(nombreProveedor.equals("") || descripcion.equals("")||domicilio.equals("")|| telefono.equals("")){
					JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos");
					
				}else{
					
					boolean añadido=controlAñadirProveedor.añadirProveedor(nombreProveedor, descripcion, domicilio, telefono);
					
					if (añadido == true) {
						JOptionPane.showMessageDialog(null, "El proveedor se añadio correctamente");
						jTextFieldDescripcion.setText("");
						jTextFieldCalleyNum.setText("");
						jTextFieldnombreProveedor.setText("");
						jTextFieldTelefono.setText("");
						controlAñadirProveedor.finaliza();
											
						
					} else {
						JOptionPane.showMessageDialog(null, "Error al añadir la cita");
					}
				}				
			}				
		});//Fin del evento
	}

}
