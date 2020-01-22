package mx.uam.ayd.estetica.presentacion;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.estetica.modelo.Empleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;


public class VentanaAñadirCita extends JFrame {
	/********************************************/
	/******** COMPONENTES ***********/
	/******** Y ***********/
	/******** ATRIBUTOS GLOBALES ***********/
	/********************************************/

	private JPanel contentPane;
	private JTextField jTextFieldnombreCliente;
	private JLabel jLabelNombreCliente;
	private JComboBox jComboBoxSeleccionarEmpleado;
	private JLabel jLabelSeleccionarEmpleado;
	private JTextArea jTextAreaDescripcion;
	private JLabel jLabelDescripcion;
	private JButton jButtonRegresar;
	private JComboBox jComboBoxDia;
	private JComboBox jComboBoxMes;
	private JLabel jLabelDia;
	private JLabel jLabelMes;
	private JLabel jLabelAño;
	private JLabel jLabelHora;
	private JComboBox jComboBoxAño;
	private JComboBox jComboBoxHora;
	private JComboBox jComboBoxMinutos;
	private JButton jButtonAceptar;
	private Empleado[] empleados;

	/********************************************/
	/******** CONSTRUCTOR ***************/
	/********************************************/
	
	public VentanaAñadirCita(ControlAñadirCita controlAñadirCita) {
		/*********************  CONFIGURACION DE LA VENTANA  ******************************/
		getContentPane().setLayout(null);
		setTitle("Añadir Cita");
		setBounds(100, 100, 595, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**  Insatancia para obtener la fecha del sistema **/
		Calendar horaSistema = Calendar.getInstance();
		
		/********************************************/
		/************* INICIALIZADOR Y *********************/
		/*** CONFIGURACION DE LOS COMPONENTES *************/
		/********************************************/

		/*** ETIQUETA  *************/
		jLabelNombreCliente = new JLabel("Nombre del cliente");
		jLabelNombreCliente.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelNombreCliente.setBounds(12, 12, 163, 15);
		contentPane.add(jLabelNombreCliente);
		
		/*** CAMPO DE TEXTO QUE RECIBE EL NOMBRE DEL CLIENTE  *************/
		
		jTextFieldnombreCliente = new JTextField();
		jTextFieldnombreCliente.setBounds(193, 10, 357, 24);
		contentPane.add(jTextFieldnombreCliente);
		jTextFieldnombreCliente.setColumns(10);
		
		/*** CONFIGURACION DEL COMBOBOX Y RECUPERACION DE EMPLEADO  *************/
		
		jComboBoxSeleccionarEmpleado = new JComboBox();
		jComboBoxSeleccionarEmpleado.setBounds(32, 85, 150, 24);
		empleados = controlAñadirCita.dameEmpleados();
		jComboBoxSeleccionarEmpleado.setModel(new DefaultComboBoxModel(controlAñadirCita.dameEmpleadosNombre(empleados)));
		contentPane.add(jComboBoxSeleccionarEmpleado);
		
		jLabelSeleccionarEmpleado = new JLabel("Seleccionar Empleado");
		jLabelSeleccionarEmpleado.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelSeleccionarEmpleado.setBounds(22, 58, 190, 15);
		contentPane.add(jLabelSeleccionarEmpleado);
		
		/*** AREA DE TEXTO QUE RECIBE LA DESCRIPCION DEL TRABAJO QUE SE REALIZARA   *************/
		
		jTextAreaDescripcion = new JTextArea();
		jTextAreaDescripcion.setBounds(37, 191, 521, 83);
		contentPane.add(jTextAreaDescripcion);
		
		jLabelDescripcion = new JLabel("Descripcion");
		jLabelDescripcion.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelDescripcion.setBounds(35, 164, 150, 15);
		contentPane.add(jLabelDescripcion);
		
		/*** BOTON QUE REGRESA A LA VENTANA PRINCIPAL  *************/
		jButtonRegresar = new JButton("Regresar");
		jButtonRegresar.setBounds(319, 296, 117, 25);
		jButtonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}				
		});//Fin del evento
		contentPane.add(jButtonRegresar);
		
		/*** SE ENLISTAN LOS DIAS DEPENDIENDO EL MES ELEGIDO  *************/
		jComboBoxDia = new JComboBox();
		jComboBoxDia.setBounds(349, 85, 51, 24);
		contentPane.add(jComboBoxDia);
		
		
		/***** EVENTO DEL COMBOBOX****/
		/***  Dependiendo el mes que se seleccione se enlistara los dias correspondientes al mes****/
		jComboBoxMes = new JComboBox();
		jComboBoxMes.setModel(new DefaultComboBoxModel(new String[] {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		jComboBoxMes.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				int mes=jComboBoxMes.getSelectedIndex();
				
				switch(mes){
				case 1:					
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"}
					));		
					
					break;
				case 2:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
							"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28"}
					));					
					break;
				case 3:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
							"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"}
					));					
					break;
				case 4:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
						    "--","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30"}
					));					
					break;
				case 5:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
								"--","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"}
					));					
					break;
				case 6:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
								"--","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30"}
					));					
					break;
				case 7:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
								"--","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"}
					));					
					break;
				case 8:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
								"--","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"}
					));					
					break;
				case 9:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
								"--","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30"}
					));					
					break;
				case 10:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
								"--","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"}
					));					
					break;
				case 11:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
								"--","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30"}
					));					
					break;
				case 12:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
								"--","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"}
					));					
					break;
				
				}
				
			}
		});
		jComboBoxMes.setBounds(213, 85, 113, 24);
		contentPane.add(jComboBoxMes);
		
		/*** CONFIGURACION DE LA ETIQUETA   *************/
		jLabelDia = new JLabel("Dia");
		jLabelDia.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelDia.setBounds(349, 58, 70, 15);
		contentPane.add(jLabelDia);
		
		/*** CONFIGURACION DE LA ETIQUETA   *************/
		jLabelMes = new JLabel("Mes");
		jLabelMes.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelMes.setBounds(257, 58, 70, 15);
		contentPane.add(jLabelMes);
		
		/*** CONFIGURACION DE LA ETIQUETA   *************/
		jLabelAño = new JLabel("Año");
		jLabelAño.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelAño.setBounds(450, 58, 70, 15);
		contentPane.add(jLabelAño);

		/*** CONFIGURACION DE LA ETIQUETA   *************/
		jLabelHora = new JLabel("Hora de la Cita");
		jLabelHora.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelHora.setBounds(193, 141, 117, 15);
		contentPane.add(jLabelHora);
		
		/***** EVENTO DEL COMBOBOX DEL AñO****/
		/*** Toma el año del sistema y sumamos 1 ****/
		jComboBoxAño = new JComboBox();
		jComboBoxAño.setModel(new DefaultComboBoxModel(new String[] {String.valueOf(horaSistema.get(Calendar.YEAR)),
				String.valueOf(horaSistema.get(Calendar.YEAR)+1), String.valueOf(horaSistema.get(Calendar.YEAR)+2), 
				String.valueOf(horaSistema.get(Calendar.YEAR)+3)}));
		jComboBoxAño.setBounds(450, 85, 70, 24);
		contentPane.add(jComboBoxAño);
		
		/*** CONFIGURACION DE COMBOBOX DONDE SE ENLISTA LAS HORAS EN FORMATO DE 24 HRAS  *************/
		jComboBoxHora = new JComboBox();
		jComboBoxHora.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		jComboBoxHora.setBounds(328, 136, 57, 24);
		contentPane.add(jComboBoxHora);
		
		/*** CONFIGURACION DEL COMBOBOX CON MINUTOS ESPECIFICOS  *************/
		jComboBoxMinutos = new JComboBox();
		jComboBoxMinutos.setModel(new DefaultComboBoxModel(new String[] {"", "00", "15", "30", "45"}));
		jComboBoxMinutos.setBounds(414, 136, 57, 24);
		contentPane.add(jComboBoxMinutos);
				
		/*** BOTON ACEPTAR DONDE SE AñADE LA CITA Y VERIFICA QUE LOS CAMPOS NO ESTEN VACIOS *************/
		
		jButtonAceptar = new JButton("Añadir");
		jButtonAceptar.setBounds(120, 296, 117, 25);
		contentPane.add(jButtonAceptar);
		jButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreEmpleado = jComboBoxSeleccionarEmpleado.getSelectedItem().toString();
				String nombreCliente = jTextFieldnombreCliente.getText();
				String descripcion = jTextAreaDescripcion.getText();
				String dia=String.valueOf(jComboBoxDia.getSelectedItem());
				String mes=String.valueOf(jComboBoxMes.getSelectedIndex());
				String año=String.valueOf(jComboBoxAño.getSelectedItem());				
				String hora=jComboBoxHora.getSelectedItem().toString();
				String minutos= jComboBoxMinutos.getSelectedItem().toString();
				String fecha = año+"-"+mes+"-"+dia+" "+hora+":"+minutos+":00";
				
				
				if(nombreCliente.equals("") || descripcion.equals("") || dia.equals("")|| mes.equals("")||hora.equals("")||minutos.equals("")){
					JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos");
				}else{
					
					boolean añadido=controlAñadirCita.añadirCita(controlAñadirCita.buscaEmpleado(nombreEmpleado), nombreCliente, descripcion,fecha);
					if (añadido == true) {
						JOptionPane.showMessageDialog(null, "La cita se añadio correctamente");
						jTextAreaDescripcion.setText("");
						jTextFieldnombreCliente.setText("");						
						
					} else {
						JOptionPane.showMessageDialog(null, "Error al añadir la cita");
					}
				}				
			}				
		});//Fin del evento
				
	}
}