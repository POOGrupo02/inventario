package GuiPrincipal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GuisSecundarias.GuiControlStock;
import GuisSecundarias.GuiListaProductos;
import GuisSecundarias.GuiMovimientos;
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
import javax.swing.JButton;
import java.awt.Label;

public class GuiInventario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnIrMovimientos;
	private JButton btnIrRegistrarProducto;
	private JButton btnIrControlStock;
	private final JButton btnIrListarProductos = new JButton("");
	private final JLabel lblNewLabel_1_1_1_1 = new JLabel("Listar productos");
	private JButton btnIrVenta;
	private JLabel lblNewLabel;
	private final JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Compra");
	private final JButton btnIrCompra = new JButton("");
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
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Control de stock");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1_1.setBounds(72, 331, 216, 43);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Registrar producto");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(37, 79, 243, 43);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Movimientos");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(416, 331, 163, 43);
		contentPane.add(lblNewLabel_1);
		
		btnIrControlStock = new JButton("");
		btnIrControlStock.addActionListener(this);
		btnIrControlStock.setIcon(new ImageIcon(GuiInventario.class.getResource("/images/control_stock.jpg")));
		btnIrControlStock.setBounds(10, 375, 344, 200);
		contentPane.add(btnIrControlStock);
		
		btnIrRegistrarProducto = new JButton("");
		btnIrRegistrarProducto.addActionListener(this);
		btnIrRegistrarProducto.setIcon(new ImageIcon(GuiInventario.class.getResource("/images/registra_producto.png")));
		btnIrRegistrarProducto.setBounds(10, 120, 296, 200);
		contentPane.add(btnIrRegistrarProducto);
		
		btnIrMovimientos = new JButton("");
		btnIrMovimientos.addActionListener(this);
		btnIrMovimientos.setIcon(new ImageIcon(GuiInventario.class.getResource("/images/movimientos_productos.png")));
		btnIrMovimientos.setBounds(384, 375, 224, 200);
		contentPane.add(btnIrMovimientos);
		{
			btnIrListarProductos.addActionListener(this);
			btnIrListarProductos.setIcon(new ImageIcon(GuiInventario.class.getResource("/images/produc_list.png")));
			btnIrListarProductos.setBounds(395, 120, 198, 200);
			contentPane.add(btnIrListarProductos);
		}
		{
			lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
			lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1_1_1_1.setBounds(384, 79, 216, 43);
			contentPane.add(lblNewLabel_1_1_1_1);
		}
		
		btnIrVenta = new JButton("");
		btnIrVenta.setIcon(new ImageIcon(GuiInventario.class.getResource("/images/venta.png")));
		btnIrVenta.setBounds(645, 375, 224, 200);
		contentPane.add(btnIrVenta);
		
		lblNewLabel = new JLabel("Venta");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(708, 331, 78, 43);
		contentPane.add(lblNewLabel);
		{
			lblNewLabel_1_1_1_1_1.setForeground(Color.BLACK);
			lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1_1_1_1_1.setBounds(699, 79, 98, 43);
			contentPane.add(lblNewLabel_1_1_1_1_1);
		}
		{
			btnIrCompra.addActionListener(this);
			btnIrCompra.setIcon(new ImageIcon(GuiInventario.class.getResource("/images/compra.png")));
			btnIrCompra.setBounds(645, 120, 224, 200);
			contentPane.add(btnIrCompra);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIrCompra) {
			do_btnIrCompra_actionPerformed(e);
		}
		if (e.getSource() == btnIrListarProductos) {
			do_btnIrListarProductos_actionPerformed(e);
		}
		if (e.getSource() == btnIrControlStock) {
			do_btnIrControlStock_actionPerformed(e);
		}
		if (e.getSource() == btnIrRegistrarProducto) {
			do_btnIrRegistrarProducto_actionPerformed(e);
		}
		if (e.getSource() == btnIrMovimientos) {
			do_btnIrMovimientos_actionPerformed(e);
		}
	}
	protected void do_btnIrMovimientos_actionPerformed(ActionEvent e) {
		GuiMovimientos mov = new GuiMovimientos();
		mov.setVisible(true);
	}
	protected void do_btnIrRegistrarProducto_actionPerformed(ActionEvent e) {
		GuiProducto product = new GuiProducto();
		product.setVisible(true);
	}
	protected void do_btnIrControlStock_actionPerformed(ActionEvent e) {
		GuiControlStock conStk = new GuiControlStock();
		conStk.setVisible(true);
	}
	protected void do_btnIrListarProductos_actionPerformed(ActionEvent e) {
		GuiListaProductos lP = new GuiListaProductos();
		lP.setVisible(true);
	}
	protected void do_btnIrCompra_actionPerformed(ActionEvent e) {
	}
}
