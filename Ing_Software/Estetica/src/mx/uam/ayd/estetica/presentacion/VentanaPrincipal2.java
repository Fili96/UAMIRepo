package mx.uam.ayd.estetica.presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.estetica.Aplicacion2;
import mx.uam.ayd.estetica.ControlLogin;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class VentanaPrincipal2 extends JFrame {

	/*********************   control  ******************************/
	private JPanel contentPane;
	private Aplicacion2 control;
	private JLabel jLabelInventario;
	private JLabel jLabelAgenda;
	private JLabel jLabelServicio;
	private JButton jButtonAñadirInventario;
	private JButton jButtonAñadirCita; 
	private JButton jButtonAñadirTrabajo;
	private JButton jButtonVenderProducto;
	private JButton BtnSalir;
	
	File ruta_agenda = new File("icons/Agenda.png");
	File ruta_producto = new File("icons/producto.png");
	File ruta_ventas = new File("icons/ventas.png");
	File ruta_trabajos = new File("icons/trabajo.png");
	
	private ImageIcon img_Producto = new ImageIcon(ruta_producto.getAbsolutePath());
	private ImageIcon img_Ventas = new ImageIcon(ruta_ventas.getAbsolutePath());
	private ImageIcon img_Agenda = new ImageIcon(ruta_agenda.getAbsolutePath());
	private ImageIcon img_Trabajos = new ImageIcon(ruta_trabajos.getAbsolutePath());
	
	/*********************   Constructor  ******************************/
	public VentanaPrincipal2(Aplicacion2 control) {
		this.control = control;

		/******   Init de la Ventana Principal  ******/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(422, 451);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);

		jLabelInventario = new JLabel("Inventario");
		jLabelInventario.setFont(new Font("Dialog", Font.BOLD, 16));
		jLabelInventario.setBounds(159, 12, 96, 15);
		contentPane.add(jLabelInventario);

		jLabelAgenda = new JLabel("Agenda");
		jLabelAgenda.setFont(new Font("Dialog", Font.BOLD, 16));
		jLabelAgenda.setBounds(176, 117, 96, 15);
		contentPane.add(jLabelAgenda);

		jLabelServicio = new JLabel("Servicio");
		jLabelServicio.setFont(new Font("Dialog", Font.BOLD, 16));
		jLabelServicio.setBounds(159, 242, 96, 15);
		contentPane.add(jLabelServicio);

		/***********************   BOTONES Y EVENTOS  *************************/
		
		/******   INVENTARIO  ******/
		//AñADIR
		jButtonAñadirInventario = new JButton();
		jButtonAñadirInventario.setIcon(img_Producto);
		jButtonAñadirInventario.setBackground(null);
		jButtonAñadirInventario.setBorder(null);
		jButtonAñadirInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.añadirInventario();
			}
		});
		jButtonAñadirInventario.setBounds(29, 38, 114, 66);
		contentPane.add(jButtonAñadirInventario);

		//VenderProducto
		jButtonVenderProducto = new JButton();
		jButtonVenderProducto.setIcon(img_Ventas);
		jButtonVenderProducto.setBackground(null);
		jButtonVenderProducto.setBorder(null);
		jButtonVenderProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.venderProducto();
			}
		});
		jButtonVenderProducto.setBounds(159, 39, 153, 66);
		contentPane.add(jButtonVenderProducto);
				
		/******   CITAS  ******/
		//AñADIR
		jButtonAñadirCita = new JButton();
		jButtonAñadirCita.setIcon(img_Agenda);
		jButtonAñadirCita.setBackground(null);
		jButtonAñadirCita.setBorder(null);
		jButtonAñadirCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.añadirCita();
			}
		});
		jButtonAñadirCita.setBounds(159, 148, 85, 66);
		contentPane.add(jButtonAñadirCita);

		/******   TRABAJO  ******/
		//AñADIR
		jButtonAñadirTrabajo = new JButton();
		jButtonAñadirTrabajo.setIcon(img_Trabajos);
		jButtonAñadirTrabajo.setBackground(null);
		jButtonAñadirTrabajo.setBorder(null);
		jButtonAñadirTrabajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.añadirTrabajo();
			}
		});
		jButtonAñadirTrabajo.setBounds(148, 273, 114, 66);
		contentPane.add(jButtonAñadirTrabajo);
		
		BtnSalir = new JButton("Salir");
		BtnSalir.addActionListener(eventoSalir);
		BtnSalir.setBounds(310, 360, 80, 30);
		BtnSalir.setBackground(Color.RED);
		contentPane.add(BtnSalir);
	}
	
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