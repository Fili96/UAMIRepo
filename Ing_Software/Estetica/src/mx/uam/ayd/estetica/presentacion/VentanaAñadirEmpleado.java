package mx.uam.ayd.estetica.presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaAñadirEmpleado extends JFrame {
	
	private JPanel contentPane;
	private JLabel jLabelNombreEmpleado;
	private JTextField jTextFieldnombreEmpleado;
	private JLabel jLabelApellidoEmpleado;
	private JLabel jLabelDia;
	private JLabel jLabelMes;
	private JLabel jLabelAño;
	private JTextField jTextFieldApellidoEmpleado;
	private JButton jButtonRegresar;
	private JComboBox jComboBoxDia;
	private JComboBox jComboBoxMes;
	private JComboBox jComboBoxAño;
	private JButton jButtonAceptar;
	private JLabel jLabelDomicilio;
	private JLabel jLabelCalleyNum;
	private JTextField jTextFieldCalleyNum;
	private JLabel jLabelColonia;
	private JTextField jTextFieldColonia;
	private JLabel jLabelFechaIngreso;
	
	
	public VentanaAñadirEmpleado(ControlAñadirEmpleado controlAñadirEmpleado) {
		/*********************  CONFIGURACION DE LA VENTANA  ******************************/
		getContentPane().setLayout(null);
		setTitle("Añadir Empleado");
		setSize(650, 367);
		setLocationRelativeTo(null);
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

		/*** ETIQUETA *************/
		jLabelNombreEmpleado = new JLabel("Nombre");
		jLabelNombreEmpleado.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelNombreEmpleado.setBounds(12, 12, 163, 15);
		contentPane.add(jLabelNombreEmpleado);

		jLabelApellidoEmpleado = new JLabel("Apellido");
		jLabelApellidoEmpleado.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelApellidoEmpleado.setBounds(350, 12, 163, 15);
		contentPane.add(jLabelApellidoEmpleado);
		
		/*** CAMPO DE TEXTO QUE RECIBE EL NOMBRE DEL CLIENTE  *************/
		
		jTextFieldnombreEmpleado = new JTextField();
		jTextFieldnombreEmpleado.setBounds(150, 10, 180, 24);
		contentPane.add(jTextFieldnombreEmpleado);
		jTextFieldnombreEmpleado.setColumns(10);
		
		jTextFieldApellidoEmpleado = new JTextField();
		jTextFieldApellidoEmpleado.setBounds(430, 10, 180, 24);
		contentPane.add(jTextFieldApellidoEmpleado);
		jTextFieldApellidoEmpleado.setColumns(10);
		
		jLabelDomicilio = new JLabel("Domicilio");
		jLabelDomicilio.setFont(new Font("Dialog", Font.BOLD, 17));
		jLabelDomicilio.setBounds(12, 50, 163, 15);
		contentPane.add(jLabelDomicilio);
		
		jLabelCalleyNum = new JLabel("Calle y numero");
		jLabelCalleyNum.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelCalleyNum.setBounds(12, 70, 175, 15);
		contentPane.add(jLabelCalleyNum);
		
		jTextFieldCalleyNum = new JTextField();
		jTextFieldCalleyNum.setBounds(150, 70, 460, 24);
		contentPane.add(jTextFieldCalleyNum);
		jTextFieldCalleyNum.setColumns(10);
		
		jLabelColonia = new JLabel("Colonia");
		jLabelColonia.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelColonia.setBounds(12, 110, 163, 15);
		contentPane.add(jLabelColonia);
		
		jTextFieldColonia = new JTextField();
		jTextFieldColonia.setBounds(150, 110, 460, 24);
		contentPane.add(jTextFieldColonia);
		jTextFieldColonia.setColumns(10);
		
	
		
		jLabelFechaIngreso = new JLabel("Fecha de ingreso");
		jLabelFechaIngreso.setFont(new Font("Dialog", Font.BOLD, 17));
		jLabelFechaIngreso.setBounds(12, 220, 163, 18);
		contentPane.add(jLabelFechaIngreso);
		
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
		jComboBoxDia.setBounds(420, 220, 51, 24);
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
							{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"}
					));		
					
					break;
				case 2:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
							"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28"}
					));					
					break;
				case 3:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
							"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"}
					));					
					break;
				case 4:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
						    "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30"}
					));					
					break;
				case 5:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
							"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"}
					));					
					break;
				case 6:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
							"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30"}
					));					
					break;
				case 7:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
							"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"}
					));					
					break;
				case 8:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
							"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"}
					));					
					break;
				case 9:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
							"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30"}
					));					
					break;
				case 10:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
								"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"}
					));					
					break;
				case 11:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
								"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30"}
					));					
					break;
				case 12:
					jComboBoxDia.setModel(new DefaultComboBoxModel(new String[]
							{
								"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
							"11", "12", "13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"}
					));					
					break;
				
				}
				
			}
		});
		jComboBoxMes.setBounds(250, 220, 113, 24);
		contentPane.add(jComboBoxMes);
		
		
		/*** Toma el año del sistema y sumamos 1 ****/
		jComboBoxAño = new JComboBox();
		jComboBoxAño.setModel(new DefaultComboBoxModel(new String[] {String.valueOf(horaSistema.get(Calendar.YEAR)),
				String.valueOf(horaSistema.get(Calendar.YEAR)+1), String.valueOf(horaSistema.get(Calendar.YEAR)+2), 
				String.valueOf(horaSistema.get(Calendar.YEAR)+3)}));
		jComboBoxAño.setBounds(530, 220, 70, 24);
		contentPane.add(jComboBoxAño);
		
		/*** CONFIGURACION DE LA ETIQUETA   *************/
		jLabelDia = new JLabel("Dia");
		jLabelDia.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelDia.setBounds(380,220, 70, 15);
		contentPane.add(jLabelDia);
		                    
		/*** CONFIGURACION DE LA ETIQUETA   *************/
		jLabelMes = new JLabel("Mes");
		jLabelMes.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelMes.setBounds(200, 220, 70, 15);
		contentPane.add(jLabelMes);
		
		/*** CONFIGURACION DE LA ETIQUETA   *************/
		jLabelAño = new JLabel("Año");
		jLabelAño.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabelAño.setBounds(490, 220, 70, 15);
		contentPane.add(jLabelAño);

		
		

				
		/*** BOTON ACEPTAR DONDE SE AñADE EL EMPLEADO Y VERIFICA QUE LOS CAMPOS NO ESTEN VACIOS *************/
		
		jButtonAceptar = new JButton("Añadir");
		jButtonAceptar.setBounds(120, 296, 117, 25);
		contentPane.add(jButtonAceptar);
		jButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String nombreEmpleado = jComboBoxSeleccionarEmpleado.getSelectedItem().toString();
				String nombreEmpleado = jTextFieldnombreEmpleado.getText();
				String apellidoEmpleado = jTextFieldApellidoEmpleado.getText();
				String domicilio = jTextFieldCalleyNum.getText()+" Col: "+ jTextFieldColonia.getText();
				//String telefonos = "Fijo: "+jTextFieldFijo.getText()+" Celular: "+jTextFieldCelular.getText();
				String dia=String.valueOf(jComboBoxDia.getSelectedItem());
				String mes=String.valueOf(jComboBoxMes.getSelectedIndex());
				String año=String.valueOf(jComboBoxAño.getSelectedItem());				
				//String hora=jComboBoxHora.getSelectedItem().toString();
				//String minutos= jComboBoxMinutos.getSelectedItem().toString();
				String fechaIngreso = año+"-"+mes+"-"+dia;
				System.out.println("fecha ingreso ="+fechaIngreso);
				
				if(nombreEmpleado.equals("") || apellidoEmpleado.equals("")||jTextFieldCalleyNum.getText().equals("")|| jTextFieldColonia.equals("")|| mes.equals("0") || dia.equals("") || año.equals("")){
					JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos");
					
				}else{
					
					boolean añadido=controlAñadirEmpleado.añadirEmpleado(nombreEmpleado, apellidoEmpleado, domicilio, fechaIngreso,0.0);
					
					if (añadido == true) {
						JOptionPane.showMessageDialog(null, "El empleado se añadio correctamente");
						controlAñadirEmpleado.finaliza();
						//jTextAreaDescripcion.setText("");
						//jTextFieldnombreCliente.setText("");						
						
					} else {
						JOptionPane.showMessageDialog(null, "Error al añadir la cita");
					}
				}				
			}				
		});//Fin del evento
	}

}
