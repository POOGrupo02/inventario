package guiprincipal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import guissecundarias.GuiEntrada;
import guissecundarias.GuiProducto;
import guissecundarias.GuiProveedor;
import guissecundarias.GuiSalida;

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
import javax.swing.JButton;
import java.awt.Label;

public class GuiInventario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel_1_1_1_1 = new JLabel("Productos");
	private final JButton btnProductos = new JButton("");
	private final JButton btnEntradas = new JButton("");
	private final JButton btnProveedores = new JButton("");
	private final JButton btnSalidas = new JButton("");
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1;
	private final JButton btnSalir = new JButton("SALIR");

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
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 923, 625);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
			lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1_1_1_1.setBounds(42, 24, 136, 43);
			contentPane.add(lblNewLabel_1_1_1_1);
		}
		{
			btnProductos.addActionListener(this);
			btnProductos.setIcon(new ImageIcon(GuiInventario.class.getResource("/images/produc_list.png")));
			btnProductos.setBounds(42, 78, 198, 200);
			contentPane.add(btnProductos);
		}
		btnEntradas.addActionListener(this);
		btnEntradas.setIcon(new ImageIcon(GuiInventario.class.getResource("/images/compra.png")));
		btnEntradas.setBounds(353, 78, 198, 200);

		contentPane.add(btnEntradas);
		btnProveedores.addActionListener(this);
		btnProveedores.setIcon(new ImageIcon(GuiInventario.class.getResource("/images/movimientos_productos.png")));
		btnProveedores.setBounds(52, 356, 198, 200);

		contentPane.add(btnProveedores);
		btnSalidas.addActionListener(this);
		btnSalidas.setIcon(new ImageIcon(GuiInventario.class.getResource("/images/control_stock.jpg")));
		btnSalidas.setBounds(350, 356, 198, 200);

		contentPane.add(btnSalidas);
		{
			lblNewLabel_1_1_1 = new JLabel("Entradas");
			lblNewLabel_1_1_1.setForeground(Color.BLACK);
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1_1_1.setBounds(353, 24, 136, 43);
			contentPane.add(lblNewLabel_1_1_1);
		}
		{
			lblNewLabel_1_1 = new JLabel("Proveedores");
			lblNewLabel_1_1.setForeground(Color.BLACK);
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1_1.setBounds(52, 302, 176, 43);
			contentPane.add(lblNewLabel_1_1);
		}
		{
			lblNewLabel_1 = new JLabel("Salidas");
			lblNewLabel_1.setForeground(Color.BLACK);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1.setBounds(353, 302, 136, 43);
			contentPane.add(lblNewLabel_1);
		}
		{
			btnSalir.addActionListener(this);
			btnSalir.setBounds(765, 536, 89, 23);
			contentPane.add(btnSalir);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnSalidas) {
			do_btnSalidas_actionPerformed(e);
		}
		if (e.getSource() == btnProveedores) {
			do_btnProveedores_actionPerformed(e);
		}
		if (e.getSource() == btnEntradas) {
			do_btnEntradas_actionPerformed(e);
		}
		if (e.getSource() == btnProductos) {
			do_btnProductos_actionPerformed(e);
		}
	}

	protected void do_btnProductos_actionPerformed(ActionEvent e) {
		// Registrar producto
		GuiProducto product = new GuiProducto();
		product.setVisible(true);

		// listar productos
		// GuiListaProductos lP = new GuiListaProductos();
	}

	protected void do_btnEntradas_actionPerformed(ActionEvent e) {
		GuiEntrada entrada=new GuiEntrada();
		entrada.setVisible(true);
	}

	protected void do_btnProveedores_actionPerformed(ActionEvent e) {
		GuiProveedor proveedor=new GuiProveedor();
		proveedor.setVisible(true);
	}

	protected void do_btnSalidas_actionPerformed(ActionEvent e) {
		GuiSalida salida=new GuiSalida();
		salida.setVisible(true);
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
	}
}
