package mx.uam.ayd.estetica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class VentanaLogin extends JFrame {

	private ControlLogin ctrlLogin;

	JLabel usuario;
	JLabel contraseña;
	JLabel label_foto = new JLabel();
	JTextField tf_usuario;
	JPasswordField tf_contraseña;
	JButton ingresar;
	JButton salir;

	public VentanaLogin(ControlLogin ctrlLogin) {

		this.ctrlLogin = ctrlLogin;

		setTitle("Login");
		setSize(296, 310);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		llenadoInit();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void llenadoInit() {

		usuario = new JLabel("Usuario: ");
		contraseña = new JLabel("Contraseña: ");
		tf_usuario = new JTextField("");
		tf_contraseña = new JPasswordField();
		ingresar = new JButton("Ingresar");
		salir = new JButton("Salir");
		
		//diseño foto
		File ruta_imagenLogin = new File("icons/login.png");
		ImageIcon imagenLogin = new ImageIcon(ruta_imagenLogin.getAbsolutePath());
		label_foto.setIcon(imagenLogin);
		label_foto.setBounds(75, 12, 124, 124);

		//diseño campos
		usuario.setBounds(55, 145, 80, 10);
		tf_usuario.setBounds(49, 161, 198, 20);
		contraseña.setBounds(49, 193, 100, 10);
		tf_contraseña.setBounds(49, 209, 198, 20);

		//diseño botones
		ingresar.setBounds(35, 241, 100, 28);
		ingresar.setBackground(Color.GREEN);
		salir.setBounds(147, 241, 100, 28);
		salir.setBackground(Color.RED);

		ingresar.addActionListener(eventoInicioSesion);
		salir.addActionListener(eventoSalir);

		getContentPane().add(usuario);
		getContentPane().add(contraseña);
		getContentPane().add(tf_usuario);
		getContentPane().add(tf_contraseña);
		getContentPane().add(ingresar);
		getContentPane().add(salir);
		getContentPane().add(label_foto);


	}

	/**************** EVENTOS *****************************/
	
	ActionListener eventoInicioSesion = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			// se valida el caso de las cuentas de Administrador
			if (ctrlLogin.validaCuentaAdmin(tf_usuario.getText(), String.valueOf(tf_contraseña.getPassword()))) {
				JOptionPane.showMessageDialog(null, "Iniciaste como ADMINISTRADOR");
				dispose();
			}
			// se valida el caso de las cuentas de usuario
			else {

				if (ctrlLogin.validaCuentaUsuario(tf_usuario.getText(), String.valueOf(tf_contraseña.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Iniciaste como USUARIO");
					dispose();
				}

				else {
					JOptionPane.showMessageDialog(null, "el usuario ó cuenta son incorrectos");
				}
			}

		}
	};

	ActionListener eventoSalir = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Cerrando Sistema");
			System.exit(0);

		}
	};
}