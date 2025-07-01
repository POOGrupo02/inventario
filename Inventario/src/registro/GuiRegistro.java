package registro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mysql.UsuarioDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiRegistro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtUsuario;
	private JPasswordField passContraseña;
	private JButton btnRegistrar;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiRegistro frame = new GuiRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Nuevo Usuario:");
			lblNewLabel.setBounds(10, 44, 127, 19);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Nueva Contraseña:");
			lblNewLabel_1.setBounds(10, 82, 127, 19);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setBounds(125, 43, 96, 20);
			contentPane.add(txtUsuario);
			txtUsuario.setColumns(10);
		}
		{
			passContraseña = new JPasswordField();
			passContraseña.setBounds(125, 81, 96, 20);
			contentPane.add(passContraseña);
		}
		{
			btnRegistrar = new JButton("REGISTRAR");
			btnRegistrar.setBounds(125, 133, 96, 23);
			contentPane.add(btnRegistrar);
		}
		{
			btnNewButton_1 = new JButton("SALIR");
			btnNewButton_1.addActionListener(this);
			btnNewButton_1.setBounds(10, 164, 89, 23);
			contentPane.add(btnNewButton_1);
		}
		btnRegistrar.addActionListener(e -> registrarUsuario());
		}
	
	
	

	private void registrarUsuario() {
		String usuario = txtUsuario.getText().trim();
	    String contrasena = new String(passContraseña.getPassword()).trim();

	    UsuarioDAO dao = new UsuarioDAO();

	    if (dao.existeUsuario(usuario)) {
	        JOptionPane.showMessageDialog(this, "El usuario ya existe. Usa otro nombre.");
	        return;
	    }

	    if (usuario.length() < 8) {
	        JOptionPane.showMessageDialog(this, "Usuario inválido. Debe tener al menos 8 caracteres.");
	        return;
	    }

	    if (contrasena.length() < 8) {
	        JOptionPane.showMessageDialog(this, "Contraseña no cumple requisitos. Debe tener al menos 8 caracteres.");
	        return;
	    }

	    boolean registrado = dao.registrarUsuario(usuario, contrasena);

	    if (registrado) {
	        JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!");
	       
	    } else {
	        JOptionPane.showMessageDialog(this, "Error al registrar. ¿El usuario ya existe?");
	    }
	
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		dispose();
	}
}



