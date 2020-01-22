package mx.uam.ayd.estetica.presentacion;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConsultarVenta extends JFrame{

	//*******Variables Globales********//
	ControlConsultaVenta ctrlConsultaVenta;
	private Tabla tabla;
	private JScrollPane scrollPane;
	private JButton btnRegresar;
	private JLabel lblVentasDeProductos;

	/**
	 * Create the application.
	 */
	public VentanaConsultarVenta(ControlConsultaVenta ctrlConsultaVenta) {
		this.ctrlConsultaVenta= ctrlConsultaVenta;
		setTitle("Consultar Venta");
		setSize(546, 389);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		lblVentasDeProductos = new JLabel("VENTAS DE PRODUCTOS");
		tabla = new Tabla();
		tabla.setBackground(Color.WHITE);
		scrollPane = new JScrollPane();
		btnRegresar = new JButton("Regresar");
		
		/*** Config label titulo*****/
		
		lblVentasDeProductos.setFont(new Font("Dialog", Font.BOLD, 15));
		lblVentasDeProductos.setBounds(109, 12, 205, 31);
		
		/*** Config tabla*****/
		
		Object[] cabecera = { "id", "Nombre", "Marca", "Precio", "Pzas", "Total" };
		Object[][] datos =ctrlConsultaVenta.dameVentas();
		tabla.modeloTabla(tabla, datos, cabecera);
		
		scrollPane.setBounds(12, 55, 503, 242);
		scrollPane.setViewportView(tabla);
		
		/*** Config boton*****/
		btnRegresar.setBounds(388, 309, 117, 25);
		btnRegresar.addActionListener(eventoRegresar);
		
		
		getContentPane().add(lblVentasDeProductos);
		getContentPane().add(scrollPane);
		getContentPane().add(btnRegresar);

	}
	
	ActionListener eventoRegresar = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	};
}
