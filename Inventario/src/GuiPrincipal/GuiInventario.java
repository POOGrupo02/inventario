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

public class GuiInventario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem menu_Producto;
	private JLabel lblNewLabel;

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
