package registro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import claseshijo.Singleton;
import guiprincipal.GuiInventario;
import mysql.UsuarioDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;

public class registrocolab extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtUsuario;
	private JPasswordField jpassClave;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private int intentos = 0;
    private final int MAX_INTENTOS = 3;
    private JButton btnNewButton_1;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrocolab frame = new registrocolab();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public registrocolab() {
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 776, 367);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("USUARIO:");
			lblNewLabel.setBounds(10, 110, 77, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("CONTRASEÑA:");
			lblNewLabel_1.setBounds(10, 135, 104, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setBounds(124, 105, 96, 17);
			contentPane.add(txtUsuario);
			txtUsuario.setColumns(10);
		}
		{
			jpassClave = new JPasswordField();
			jpassClave.setBounds(124, 133, 96, 17);
			contentPane.add(jpassClave);
		}
		{
			btnNewButton = new JButton("INICIO");
			btnNewButton.setBounds(273, 103, 89, 23);
			btnNewButton.addActionListener(this);
			contentPane.add(btnNewButton);
		}
		{
			lblNewLabel_2 = new JLabel("INICIO DE SESIÓN");
			lblNewLabel_2.setBounds(0, 80, 165, 14);
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPane.add(lblNewLabel_2);
		}
		{
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(273, 131, 89, 23);
		btnSalir.addActionListener(e -> dispose());
		contentPane.add(btnSalir);
		}
		{
			btnNewButton_1 = new JButton("CREAR CUENTA");
			btnNewButton_1.setBounds(171, 203, 157, 23);
			btnNewButton_1.addActionListener(this);
			contentPane.add(btnNewButton_1);
		}
		{
			lblNewLabel_3 = new JLabel("TIENDA DE ABBARROTES");
			lblNewLabel_3.setBounds(141, 21, 209, 20);
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.setBounds(407, 50, 343, 267);
			lblNewLabel_4.setIcon(new ImageIcon(registrocolab.class.getResource("/images/abarrotes.jpg")));
			contentPane.add(lblNewLabel_4);
		}
	}
		   

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String usuario = txtUsuario.getText().trim();
        String clavefinal = new String(jpassClave.getPassword()).trim();

        if (usuario.isEmpty() || clavefinal.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos.");
            return;
        }
        UsuarioDAO dao = new UsuarioDAO();
        int idUsuario = dao.validarUsuario(usuario, clavefinal);
        if (idUsuario!=0) {
            dispose();
            Singleton singleton = Singleton.getInstancia();
	    	singleton.setIdUsuario(idUsuario);
            JOptionPane.showMessageDialog(null, "Bienvenido al sistema", "Ingresaste", JOptionPane.INFORMATION_MESSAGE);
            GuiInventario gi = new GuiInventario();
            gi.setVisible(true);
            intentos = 0;
        } else {
            intentos++;
            if (intentos >= MAX_INTENTOS) {
                JOptionPane.showMessageDialog(this, "¡Sistema bloqueado! Has superado los " + MAX_INTENTOS + " intentos.", "Bloqueado", JOptionPane.ERROR_MESSAGE);
                txtUsuario.setEnabled(false);
                jpassClave.setEnabled(false);
                btnNewButton.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos. Intento " + intentos + " de " + MAX_INTENTOS, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		GuiRegistro reg = new GuiRegistro();
        reg.setVisible(true);
	}
}





