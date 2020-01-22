package mx.uam.ayd.estetica.presentacion;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.estetica.modelo.Empleado;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAñadirCuenta extends JFrame {

	private ControlAñadirCuenta controlAñadirCuenta;
	private Empleado[] empleados;
	
	private JPanel contentPane;
	private JTextField JTextFieldNombre;
	private JTextField JTextFieldContraseña;
	private JLabel JLabelNombre;
	private JLabel JLabelContraseña;
	private JLabel JLabelEncabezado;
	private JComboBox JcomboBoxEmpleados;
	private JButton JButtonAñadir;
	private JButton JButtonRegresar;
	
	public VentanaAñadirCuenta(ControlAñadirCuenta controlAñadirCuenta) {
		this.controlAñadirCuenta=controlAñadirCuenta;
		//Configuracion de la ventana
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 455, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		//Configuracion de los componentes
		JButtonAñadir = new JButton("Añadir");
		JButtonAñadir.setBounds(56, 250, 117, 25);
		contentPane.add(JButtonAñadir);
		
		JTextFieldNombre = new JTextField();
		JTextFieldNombre.setBounds(234, 85, 151, 19);
		contentPane.add(JTextFieldNombre);
		JTextFieldNombre.setColumns(10);
		
		JLabelNombre = new JLabel("Nombre de cuenta :");
		JLabelNombre.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 13));
		JLabelNombre.setBounds(56, 89, 138, 15);
		contentPane.add(JLabelNombre);
		
		JLabelContraseña = new JLabel("Contraseña :");
		JLabelContraseña.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 13));
		JLabelContraseña.setBounds(78, 136, 102, 15);
		contentPane.add(JLabelContraseña);
		
		JLabelEncabezado = new JLabel("Crea una nueva Cuenta");
		JLabelEncabezado.setFont(new Font("MathJax_Math", Font.BOLD | Font.ITALIC, 18));
		JLabelEncabezado.setBounds(99, 12, 242, 40);
		contentPane.add(JLabelEncabezado);
		
		JTextFieldContraseña = new JTextField();
		JTextFieldContraseña.setBounds(234, 132, 151, 19);
		contentPane.add(JTextFieldContraseña);
		JTextFieldContraseña.setColumns(10);
		
		
		JcomboBoxEmpleados = new JComboBox();
		JcomboBoxEmpleados.setBounds(231, 188, 102, 24);
		empleados = controlAñadirCuenta.dameEmpleados();
		JcomboBoxEmpleados.setModel(new DefaultComboBoxModel(controlAñadirCuenta.dameEmpleadosNombre(empleados)));
		
		
		contentPane.add(JcomboBoxEmpleados);
		
		JLabel JLabelEmpleado = new JLabel("Empleado");
		JLabelEmpleado.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 13));
		JLabelEmpleado.setBounds(138, 195, 102, 15);
		contentPane.add(JLabelEmpleado);
		
		JButtonRegresar = new JButton("Regresar");
		JButtonRegresar.setBounds(243, 250, 117, 25);
		contentPane.add(JButtonRegresar);
		
		//Eventos de los botones
		JButtonAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JLabelNombre.getText().equals("") || JLabelContraseña.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Termina de llenar los datos");
				}else {
				String nombre = JTextFieldNombre.getText();
				String nombreEmpleado = JcomboBoxEmpleados.getSelectedItem().toString();
				Empleado empleado = controlAñadirCuenta.buscaEmpleado(nombreEmpleado, empleados);
				String contraseña = JTextFieldContraseña.getText();
				if(controlAñadirCuenta.añadirCuenta(nombre, empleado, contraseña)) {
					JOptionPane.showMessageDialog(null, "Se ha añadido correctamente");
				}
			}
			}
		});
		
		JButtonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}