package guiprincipal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import guissecundarias.GuiProducto;

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
	private final JLabel Entradas = new JLabel("Entradas");
	private final JButton btnProductos = new JButton("");
	private final JButton btnEntradas = new JButton("");
	private final JButton btnProveedores = new JButton("");
	private final JButton btnSalidas = new JButton("");

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
		setBounds(100, 100, 923, 625);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_control_stock = new JLabel("Salidas");
		lbl_control_stock.setForeground(new Color(0, 0, 0));
		lbl_control_stock.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbl_control_stock.setBounds(383, 302, 99, 43);
		contentPane.add(lbl_control_stock);

		JLabel lbl_prove = new JLabel("Proveedores");
		lbl_prove.setForeground(new Color(0, 0, 0));
		lbl_prove.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbl_prove.setBounds(42, 302, 163, 43);
		contentPane.add(lbl_prove);
		{
			lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
			lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1_1_1_1.setBounds(42, 24, 136, 43);
			contentPane.add(lblNewLabel_1_1_1_1);
		}
		{
			Entradas.setForeground(Color.BLACK);
			Entradas.setFont(new Font("Tahoma", Font.BOLD, 25));
			Entradas.setBounds(350, 24, 118, 43);
			contentPane.add(Entradas);
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

		Entradas.setVisible(false);
		lbl_control_stock.setVisible(false);
		lbl_prove.setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
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
	}

	protected void do_btnProveedores_actionPerformed(ActionEvent e) {
	}

	protected void do_btnSalidas_actionPerformed(ActionEvent e) {
	}
}
