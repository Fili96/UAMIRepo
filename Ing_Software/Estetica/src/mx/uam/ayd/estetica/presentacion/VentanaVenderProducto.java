package mx.uam.ayd.estetica.presentacion;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.modelo.Venta;

import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class VentanaVenderProducto extends JFrame{

	
	//Variables/componentes globales
	ControlVenderProducto ctrlVender;
	
	JLabel lbl_Producto;
	JComboBox cb_nombre;
	JLabel lbl_Marca;
	JLabel marca;
	JLabel lbl_Precio;
	JLabel precio;
	JLabel lbl_PzasSobrantes;
	JLabel piezas;
	JLabel lblPzasAVender;
	JComboBox comboBox;
	JButton btnVender;
	JButton btnCancelar;
	
	Producto productos[];
	Producto producto;
	
	
	//Constructor
	public VentanaVenderProducto(ControlVenderProducto ctrlVender) {
		this.ctrlVender = ctrlVender;
		setTitle("Vender Producto");
		getContentPane().setLayout(null);
		setSize(348, 300);
		setLocationRelativeTo(null);
		initialize();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}

	//inicio del Contenido del Frame
	private void initialize() {
		
		//llenado
		lbl_Producto = new JLabel("Producto");
		cb_nombre = new JComboBox();
		lbl_Marca = new JLabel("Marca:");
		marca = new JLabel();
		lbl_Precio = new JLabel("Precio:");
		precio = new JLabel();
		lbl_PzasSobrantes = new JLabel("Pza(s) sobrantes: ");
		piezas = new JLabel();
		lblPzasAVender = new JLabel("Pza(s) a Vender:");
		comboBox = new JComboBox();
		btnVender = new JButton("Vender");
		btnCancelar = new JButton("Cancelar");
		
		
		
		//diseño
		
		productos= ctrlVender.dameProductos();
		
		//nombre del producto
		lbl_Producto.setBounds(50, 31, 70, 15);
		cb_nombre.setModel(new DefaultComboBoxModel(ctrlVender.dameProductosNombre(productos)));
		cb_nombre.setBounds(138, 26, 150, 24);
		
		producto = ctrlVender.dameProducto(cb_nombre.getSelectedItem().toString(), productos);
		
		//nombre de la marca
		lbl_Marca.setBounds(60, 78, 70, 15);
		marca.setText(producto.dameMarca());
		marca.setBounds(138, 78, 162, 15);
		
		//cantidad del precio
		lbl_Precio.setBounds(60, 105, 70, 15);
		precio.setText(Integer.toString(producto.damePrecio()));
		precio.setBounds(138, 105, 162, 15);
		
		//cantidad de las piezas existentes
		lbl_PzasSobrantes.setBounds(60, 139, 130, 15);
		piezas.setText(Integer.toString(producto.damePzaExistencia()));
		piezas.setBounds(202, 139, 70, 15);
		
		//cantidad de las piezas a vender
		lblPzasAVender.setBounds(60, 178, 130, 15);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox.setBounds(193, 173, 53, 24);
		
		btnVender.setBounds(38, 220, 117, 25);
		btnCancelar.setBounds(193, 220, 117, 25);
		
		//Declaracion de Eventos
		btnVender.addActionListener(eventoVender);
		btnCancelar.addActionListener(eventoCancelar);
		cb_nombre.addItemListener(changeclick);
		comboBox.addItemListener(changeclick);
		
		//Agregacion de componentes
		getContentPane().add(lbl_Producto);
		getContentPane().add(cb_nombre);
		getContentPane().add(lbl_Marca);
		getContentPane().add(marca);
		getContentPane().add(lbl_Precio);
		getContentPane().add(precio);
		getContentPane().add(lbl_PzasSobrantes);
		getContentPane().add(piezas);
		getContentPane().add(btnVender);
		getContentPane().add(btnCancelar);
		getContentPane().add(lblPzasAVender);
		getContentPane().add(comboBox);
	}
	
	//Eventos
	ActionListener eventoVender = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			String nombre = cb_nombre.getSelectedItem().toString();
			String marca2 = marca.getText();
			int total = Integer.valueOf(precio.getText());
			int pzaExistente = Integer.valueOf(piezas.getText());
			int pzaVendida = Integer.parseInt(comboBox.getSelectedItem().toString());

			if (pzaExistente < pzaVendida) {
				JOptionPane.showMessageDialog(null, "No hay piezas suficientes en el inventario");
			}

			else {

				int confirmar = JOptionPane.showConfirmDialog(null, "LOS DATOS SON CORRECTOS?");

				if (confirmar == JOptionPane.YES_OPTION) {

					Producto prod= ctrlVender.buscaProducto(nombre,marca2);
					boolean bandera = ctrlVender.añadirVentaProducto(new Venta(prod, pzaVendida,total));

					if (bandera) {

						Producto aux = ctrlVender.buscaProducto(producto.dameNombre(), producto.dameMarca());
						ctrlVender.actualizaPiezasExistentes((prod.damePzaExistencia() - pzaVendida), prod.dameId());
						JOptionPane.showMessageDialog(null, "La Venta ha sido completada");
						dispose();
					} else
						JOptionPane.showMessageDialog(null, "HA HABIDO UN ERROR EN LA VENTA");

				}

			}
		}
	};
	
	ActionListener eventoCancelar = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			
		}
	};
	
	ItemListener changeclick = new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			//selecciona la marca,precio,piezas existentes de acuerdo al producto en el combobox
			if(e.getSource()==cb_nombre) {
				
					marca.setText(ctrlVender.buscaProductoMarca(e.getItem().toString(), productos));
					int precioProd = ctrlVender.buscaProductoPrecio(cb_nombre.getSelectedItem().toString(), productos);
					int pzasVend= Integer.valueOf(comboBox.getSelectedItem().toString());
					int total = precioProd*pzasVend; 
					precio.setText(Integer.toString(total));
					piezas.setText(Integer.toString(ctrlVender.buscaProductoPzaExistente(e.getItem().toString(), productos)));
				
			}
			
			if(e.getSource()==comboBox) {
				int precioProd = ctrlVender.buscaProductoPrecio(cb_nombre.getSelectedItem().toString(), productos);
				int pzasVend= Integer.valueOf(comboBox.getSelectedItem().toString());
				int total = precioProd*pzasVend; 
				precio.setText(Integer.toString(total));
			}

		}
	};

	
}
