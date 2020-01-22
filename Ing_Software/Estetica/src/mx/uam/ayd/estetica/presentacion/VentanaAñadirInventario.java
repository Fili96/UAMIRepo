package mx.uam.ayd.estetica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.estetica.modelo.Producto;

public class VentanaAñadirInventario extends JFrame {


	private static final long serialVersionUID = 1L;
	private ControlAñadirInventario CAI; 
	private JPanel contentPane;
	private JTextField JTextFieldNombre;
	private JTextField JTextFieldMarca;
	private JTextField JTextFieldCantidad;
	private JTextField textField_precio;
	private JButton jButtonAñadir;
    private JButton jButtonRegresar;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 *///la ventana recive un control
	public VentanaAñadirInventario(ControlAñadirInventario CAI) {
		this.CAI=CAI;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 424, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextFieldNombre = new JTextField();
		JTextFieldNombre.setBounds(200, 28, 114, 19);
		panel.add(JTextFieldNombre);
		JTextFieldNombre.setColumns(10);
		
		JTextFieldMarca = new JTextField();
		JTextFieldMarca.setBounds(200, 79, 114, 19);
		panel.add(JTextFieldMarca);
		JTextFieldMarca.setColumns(10);
		
		JTextFieldCantidad = new JTextField();
		JTextFieldCantidad.setBounds(200, 130, 114, 19);
		panel.add(JTextFieldCantidad);
		JTextFieldCantidad.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(120, 30, 70, 15);
		panel.add(lblNewLabel);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(120, 81, 70, 15);
		panel.add(lblMarca);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(120, 132, 70, 15);
		panel.add(lblNewLabel_1);
		
		
		jButtonAñadir = new JButton("Añadir");
		
		jButtonAñadir.setBounds(51, 201, 117, 25);
		panel.add(jButtonAñadir);
		jButtonAñadir.addActionListener(EventoAñadir);
		
		
	    jButtonRegresar = new JButton("Regresar");
		jButtonRegresar.setBounds(279, 201, 117, 25);
		panel.add(jButtonRegresar);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(120, 163, 70, 15);
		panel.add(lblPrecio);
		
		textField_precio = new JTextField();
		textField_precio.setBounds(200, 161, 114, 19);
		panel.add(textField_precio);
		jButtonRegresar.addActionListener(EventoCancelar);
	}
	//Evento de boton añadir a inventario 
ActionListener EventoAñadir = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			if(JTextFieldNombre.getText().equals("") || (JTextFieldMarca.getText().equals(""))|| (JTextFieldCantidad.getText().equals(""))){
				JOptionPane.showMessageDialog(null, "Es necesario llenar los campos"); 
		
		//envia mensaje de error si no se han llenado todos los campos
		
       	}
		else {//si todos los campos estan llenos
			
			//recupera la informacion que introduce el usuario 
		String nombre=JTextFieldNombre.getText();
		System.out.println("hasta qui va bien  "+nombre);
	    String marca=JTextFieldMarca.getText();
		System.out.println("hasta qui va bien"+marca);
		int pzaExistencia = Integer.parseInt(String.valueOf(JTextFieldCantidad.getText()));
		System.out.println("hasta qui va bien"+pzaExistencia);
		int precio = Integer.parseInt(String.valueOf(textField_precio.getText()));
		System.out.println("hasta qui va bien"+precio);
		
		
		//pasa los datos ingresados por el usuario como parametros al metodo añadir producto del control 
		
		boolean añadido= CAI.añadirProducto( new Producto(nombre, marca, pzaExistencia,precio));
		if(añadido){
			//si se añadio entonces envia un mensaje
			JOptionPane.showMessageDialog(null, "Se añadio a inventario exitosamente");
		}
			
			
			
			
		}
		
	}};	
	

	
ActionListener EventoCancelar = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {	
			dispose();
		}};

}
