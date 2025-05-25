package GuiPrincipal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GuisSecundarias.GuiProducto;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Label;

public class GuiInventario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem menu_Producto;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel2;
	private JLabel lblNewLabel3;
	private JLabel lblNewLabel3_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiInventario frame = new GuiInventario();
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
	public GuiInventario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menú Inventario");
		menuBar.add(mnNewMenu);
		
		menu_Producto = new JMenuItem("Producto");
		menu_Producto.addActionListener(this);
		mnNewMenu.add(menu_Producto);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("BIENVENIDO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(128, 11, 183, 43);
		contentPane.add(lblNewLabel);
		{
			lblNewLabel2 = new JLabel("AL CENTRO DE GESTIÓN");
			lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			lblNewLabel2.setBounds(85, 44, 272, 43);
			contentPane.add(lblNewLabel2);
		}
		{
			lblNewLabel3 = new JLabel("PARA CONTINUAR SELECIONA \"Menú Inventario\"");
			lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblNewLabel3.setBounds(10, 79, 400, 43);
			contentPane.add(lblNewLabel3);
		}
		
		lblNewLabel3_1 = new JLabel("");
		lblNewLabel3_1.setIcon(new ImageIcon(GuiInventario.class.getResource("/Imagen/Caja1.jpg")));
		lblNewLabel3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel3_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel3_1.setBounds(85, 119, 238, 134);
		contentPane.add(lblNewLabel3_1);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu_Producto) {
			do_Menu_Producto_actionPerformed(e);
		}
	}
	protected void do_Menu_Producto_actionPerformed(ActionEvent e) {
		GuiProducto p=new GuiProducto();
		p.setVisible(true);
	}
}
