package mx.uam.ayd.estetica.presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.estetica.Aplicacion;
import mx.uam.ayd.estetica.ControlLogin;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {

	/********************   Recursos  *****************************/
	private JPanel contentPane;
	private Aplicacion control;
	private JLabel jLabelInventario;
	private JLabel jLabelAgenda;
	private JLabel jLabelServicio;
	private JLabel jLabelEmpleado;
	
	private JButton BtnConsultarInventario;
	private JButton BtnConsultarVenta;
	private JButton BtnConsultarCita;
	private JButton BtnConsultarTrabajo;
	private JButton BtnAñadirEmpleado;
	private JButton BtnConsultarEmpleado;
	private JButton BtnConsultarSalario;
	private JButton BtnAñadirProveedor;
	private JButton BtnConsultaProveedor;
	private JButton BtnAñadirCuenta;
	private JButton BtnConsultaCuenta;
	
	//Rutas
	File ruta_agenda = new File("icons/Agenda.png");
	File ruta_producto = new File("icons/producto.png");
	File ruta_ventas = new File("icons/ventas.png");
	File ruta_trabajos = new File("icons/trabajo.png");
	File ruta_anadirempleado = new File("icons/anadiremp.png");
	File ruta_reunionEmp = new File("icons/reunion.png");
	File ruta_sueldo = new File("icons/sueldo.png");
	File ruta_proveedor = new File("icons/proveedor.png");
	File ruta_anadirusuario= new File("icons/agusuario.png");
	File ruta_usuario = new File("icons/usuarios.png");
	File ruta_consultaproveedor = new File("icons/consultaProveedores.png");
	
	private ImageIcon img_Agenda = new ImageIcon(ruta_agenda.getAbsolutePath());
	private ImageIcon img_Producto = new ImageIcon(ruta_producto.getAbsolutePath());
	private ImageIcon img_Ventas = new ImageIcon(ruta_ventas.getAbsolutePath());
	private ImageIcon img_Trabajos = new ImageIcon(ruta_trabajos.getAbsolutePath());
	private ImageIcon img_AnadirEmpleado = new ImageIcon(ruta_anadirempleado.getAbsolutePath());
	private ImageIcon img_reunionEmp = new ImageIcon(ruta_reunionEmp.getAbsolutePath());
	private ImageIcon img_Sueldo = new ImageIcon(ruta_sueldo.getAbsolutePath());
	private ImageIcon img_Proveedor = new ImageIcon(ruta_proveedor.getAbsolutePath());
	private ImageIcon img_AnadirUsuario = new ImageIcon(ruta_anadirusuario.getAbsolutePath());
	private ImageIcon img_Usuario = new ImageIcon(ruta_usuario.getAbsolutePath());
	private ImageIcon img_ConsultaProveedor = new ImageIcon(ruta_consultaproveedor.getAbsolutePath());
	
	
	/*********************   Constructor  ******************************/
	public VentanaPrincipal(Aplicacion control) {
		this.control = control;

		/******   Diseño Ventana Principal  ******/
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(558, 724);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/***************************************************************************/
		/*********************** CONFIGURACION DE LABELS  **************************/
		/***************************************************************************/
		
		//LABELS TITULO
		jLabelInventario = new JLabel("Inventario");
		jLabelInventario.setFont(new Font("Dialog", Font.BOLD, 20));
		jLabelInventario.setBounds(205, 12, 143, 37);
		contentPane.add(jLabelInventario);

		jLabelAgenda = new JLabel("Agenda");
		jLabelAgenda.setFont(new Font("Dialog", Font.BOLD, 20));
		jLabelAgenda.setBounds(220, 143, 108, 30);
		contentPane.add(jLabelAgenda);

		jLabelServicio = new JLabel("Servicio");
		jLabelServicio.setFont(new Font("Dialog", Font.BOLD, 20));
		jLabelServicio.setBounds(220, 270, 96, 30);
		contentPane.add(jLabelServicio);
		
		jLabelEmpleado = new JLabel("Empleados");
		jLabelEmpleado.setFont(new Font("Dialog", Font.BOLD, 20));
		jLabelEmpleado.setBounds(198, 409, 150, 28);
		contentPane.add(jLabelEmpleado);
		
		//LABELS NOMBRES
		JLabel label_producto = new JLabel("producto");
		label_producto.setBounds(240, 120, 70, 15);
		contentPane.add(label_producto);
		
		JLabel label_proveedor = new JLabel("<html><body>Nuevo <br>proveedor</body></html>");
		label_proveedor.setBounds(107, 120, 130, 30);
		contentPane.add(label_proveedor);
		
		JLabel label_consultarProveedor = new JLabel("Proveedores");
		label_consultarProveedor.setBounds(340, 120, 95, 15);
		contentPane.add(label_consultarProveedor);
		
		
		JLabel label_agenda = new JLabel("agenda");
		label_agenda.setBounds(240, 250, 64, 15);
		contentPane.add(label_agenda);
		
		JLabel label_trabajos = new JLabel("trabajos");
		label_trabajos.setBounds(180, 385, 70, 15);
		contentPane.add(label_trabajos);
		
		JLabel label_ventas = new JLabel("ventas");
		label_ventas.setBounds(300, 382, 70, 15);
		contentPane.add(label_ventas);
		
		JLabel label_nuevoEmpleado = new JLabel("Nuevo Empleado");
		label_nuevoEmpleado.setBounds(82, 519, 130, 15);
		contentPane.add(label_nuevoEmpleado);
		
		JLabel label_empleados = new JLabel("Empleados");
		label_empleados.setBounds(230, 519, 86, 15);
		contentPane.add(label_empleados);
		
		JLabel label_sueldo = new JLabel("Sueldo");
		label_sueldo.setBounds(350, 519, 70, 15);
		contentPane.add(label_sueldo);
		
		JLabel label_cuentas = new JLabel("Cuentas");
		label_cuentas.setBounds(310, 620, 70, 15);
		contentPane.add(label_cuentas);
		
		JLabel label_nuevaCuenta = new JLabel("Nueva Cuenta");
		label_nuevaCuenta.setBounds(160, 620, 108, 15);
		contentPane.add(label_nuevaCuenta);
		
		/***************************************************************************/
		/*********************** CONFIGURACION DE BOTONES  *************************/
		/***************************************************************************/
		
		//llenado de botones
		BtnConsultarInventario = new JButton();
		BtnConsultarCita = new JButton();
		BtnConsultarTrabajo = new JButton();
		BtnAñadirEmpleado = new JButton();
		BtnConsultarEmpleado = new JButton();
		BtnConsultarSalario = new JButton();
		BtnAñadirProveedor = new JButton();
		BtnConsultaProveedor = new JButton();
		BtnAñadirCuenta = new JButton();
		BtnConsultaCuenta = new JButton();
		BtnConsultarVenta = new JButton();
		JButton BtnSalir = new JButton("Salir");
		
		
		/******   DISEÑO INVENTARIO  ******/
		
		//CONSULTAR-MODIFICA INVENTARIO
		BtnConsultarInventario.addActionListener(eventoModificaConsultarInventario);
		BtnConsultarInventario.setBounds(235, 48, 90, 60);
		BtnConsultarInventario.setBackground(null);
		BtnConsultarInventario.setBorder(null);
		BtnConsultarInventario.setIcon(img_Producto);
		
		//AñADIR PROVEDOR
		BtnAñadirProveedor.addActionListener(eventoAñadirProveedor);
		BtnAñadirProveedor.setBounds(107, 48, 73, 60);
		BtnAñadirProveedor.setBackground(null);
		BtnAñadirProveedor.setBorder(null);
		BtnAñadirProveedor.setIcon(img_Proveedor);

		
		//CONSULTA PROVEDOR
		BtnConsultaProveedor.addActionListener(eventoConsultaProveedor);
		BtnConsultaProveedor.setBounds(340, 48, 73, 60);
		BtnConsultaProveedor.setBackground(null);
		BtnConsultaProveedor.setBorder(null);
		BtnConsultaProveedor.setIcon(img_ConsultaProveedor);

		/******   DISEÑO AGENDA  ******/

		//CONSULTA-MODIFICA-ELIMINA CITA
		BtnConsultarCita.addActionListener(eventoModificaConsultarCancelaCita);
		BtnConsultarCita.setBounds(230, 182, 73, 60);
		BtnConsultarCita.setBackground(null);
		BtnConsultarCita.setBorder(null);
		BtnConsultarCita.setIcon(img_Agenda);


		/****** DISEÑO  SERVICIO  ******/

		//CONSULTA- MODIFICA TRABAJO
		BtnConsultarTrabajo.addActionListener(eventoModificaConsultarTrabajo);
		BtnConsultarTrabajo.setBounds(174, 317, 73, 66);
		BtnConsultarTrabajo.setBackground(null);
		BtnConsultarTrabajo.setBorder(null);
		BtnConsultarTrabajo.setIcon(img_Trabajos);
		
		//CONSULTA VENTA
		BtnConsultarVenta.addActionListener(eventoConsultaVenta);
		BtnConsultarVenta.setBounds(280, 312, 85, 71);
		BtnConsultarVenta.setBackground(null);
		BtnConsultarVenta.setBorder(null);
		BtnConsultarVenta.setIcon(img_Ventas);
		
		/****** DISEÑO  EMPLEADOS  ******/
		
		//AñADIR EMPLEADO
		BtnAñadirEmpleado.addActionListener(eventoAñadirEmpleado);
		BtnAñadirEmpleado.setBounds(107, 449, 64, 64);
		BtnAñadirEmpleado.setBackground(null);
		BtnAñadirEmpleado.setBorder(null);
		BtnAñadirEmpleado.setIcon(img_AnadirEmpleado);
		
		//CONSULTAR-ELIMINA EMPLEADO
		BtnConsultarEmpleado.addActionListener(eventoModificaConsultaEmpleado);
		BtnConsultarEmpleado.setBounds(226, 449, 77, 64);
		BtnConsultarEmpleado.setBackground(null);
		BtnConsultarEmpleado.setBorder(null);
		BtnConsultarEmpleado.setIcon(img_reunionEmp);
		
		//Consultar sueldo
		BtnConsultarSalario.addActionListener(eventoConsultaSalario);
		BtnConsultarSalario.setBounds(340, 449, 85, 64);
		BtnConsultarSalario.setBackground(null);
		BtnConsultarSalario.setBorder(null);
		BtnConsultarSalario.setIcon(img_Sueldo);
		
		//AñADIR CUENTA
		BtnAñadirCuenta.addActionListener(eventoAñadirCuenta);
		BtnConsultaCuenta.setBounds(304, 546, 73, 73);
		BtnAñadirCuenta.setBackground(null);
		BtnAñadirCuenta.setBorder(null);
		BtnAñadirCuenta.setIcon(img_AnadirUsuario);
		
		//Consulta-ELIMINA CUENTAS
		BtnConsultaCuenta.addActionListener(eventoEliminarCuenta);
		BtnAñadirCuenta.setBounds(174, 546, 73, 73);
		BtnConsultaCuenta.setBackground(null);
		BtnConsultaCuenta.setBorder(null);
		BtnConsultaCuenta.setIcon(img_Usuario);
		
		/****** DISEÑO SALIR  ******/
		BtnSalir.addActionListener(eventoSalir);
		BtnSalir.setBounds(410, 654, 117, 25);
		BtnSalir.setBackground(Color.RED);
		
		//agregado de botones Inventario
		contentPane.add(BtnConsultarInventario);
		contentPane.add(BtnAñadirProveedor);
		contentPane.add(BtnConsultaProveedor);////*******
		
		//agregado de botones Citas
		contentPane.add(BtnConsultarCita);
		
		//agregado de botones Trabajo
		contentPane.add(BtnConsultarTrabajo);
		contentPane.add(BtnConsultarVenta);
		
		//agregado de botones Empleado
		contentPane.add(BtnAñadirEmpleado);
		contentPane.add(BtnConsultarEmpleado);
		contentPane.add(BtnConsultarSalario);
		contentPane.add(BtnAñadirCuenta);
		contentPane.add(BtnConsultaCuenta);
		
		
		//agregado de boton salir
		contentPane.add(BtnSalir);
		
	}	
	
	/***************************************************************************/
	/*********************** EVENTOS DE LOS BOTONES  *************************/
	/***************************************************************************/
	
	//EVENTOS INVENTARIO
	
	ActionListener eventoModificaConsultarInventario = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			control.modificaConsultaInventario();
		}
	};
	
	ActionListener eventoAñadirProveedor = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			control.añadirProveedor();
		}
	};
	
	ActionListener eventoConsultaProveedor = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			control.consultarProveedor();
		}
	};
	
	//EVENTOS CITAS
	
	ActionListener eventoModificaConsultarCancelaCita = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			control.modificaConsultaCita();
		}
	};
	
	
	//EVENTOS TRABAJO
	
	ActionListener eventoModificaConsultarTrabajo = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			control.modificaConsultaTrabajo();
		}
	};
	
	ActionListener eventoConsultaVenta = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			control.consultaVenta();
		}
	};
	
	//EVENTOS EMPLEADO
	
	ActionListener eventoAñadirEmpleado = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			control.añadirEmpleado();
		}
	};
	
	
	ActionListener eventoModificaConsultaEmpleado = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			control.modificaConsultaEmpleado();
		}
	};
	
	
	ActionListener eventoConsultaSalario = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			control.consultaSalario();
		}
	}; 
	

	ActionListener eventoAñadirCuenta = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			control.añadirCuenta();
		}
	};
	
	ActionListener eventoEliminarCuenta = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			control.eliminarCuenta();
		}
	};
	
	/****** EVENTO SALIR*******/
	
	ActionListener eventoSalir = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
			ControlLogin obj = new ControlLogin();
			obj.inicia();
		}
	};
}
	
