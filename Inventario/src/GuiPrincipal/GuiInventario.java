package GuiPrincipal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GuiInventario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		
		JMenuItem Menu_Agregar_Producto = new JMenuItem("Agregar producto");
		mnNewMenu.add(Menu_Agregar_Producto);
		
		JMenuItem Menu_Modificar_Producto = new JMenuItem("Modificar producto");
		mnNewMenu.add(Menu_Modificar_Producto);
		
		JMenuItem Menu_Eliminar_Producto = new JMenuItem("Eliminar producto");
		mnNewMenu.add(Menu_Eliminar_Producto);
		
		JMenuItem Menu_Ver_Inventario_Completo = new JMenuItem("Ver inventario completo");
		mnNewMenu.add(Menu_Ver_Inventario_Completo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
