package guissecundarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUISProducto extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnProductos;
	private JLabel lblNewLabel_1_1_1;
	private JButton btnProductos_1;
	private JButton btnSalir;
	private JLabel lblNewLabel_1_1;
	private JButton btnPresentación;
	private JLabel lblNewLabel_1;
	private JButton btnUnidadMedida;
	private JLabel lblNewLabel_1_2;
	private JButton btnProductoGeneral;
	private JLabel lblNewLabel_1_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUISProducto frame = new GUISProducto();
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
	public GUISProducto() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 915, 583);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnProductos = new JButton("");
			btnProductos.addActionListener(this);
			btnProductos.setIcon(new ImageIcon(GUISProducto.class.getResource("/images/registra_producto.png")));
			btnProductos.setBounds(26, 64, 198, 200);
			contentPane.add(btnProductos);
		}
		{
			lblNewLabel_1_1_1 = new JLabel("Registrar producto");
			lblNewLabel_1_1_1.setForeground(Color.BLACK);
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblNewLabel_1_1_1.setBounds(26, 28, 236, 31);
			contentPane.add(lblNewLabel_1_1_1);
		}
		{
			btnProductos_1 = new JButton("");
			btnProductos_1.addActionListener(this);
			btnProductos_1.setIcon(new ImageIcon(GUISProducto.class.getResource("/images/Marca (1).jpg")));
			btnProductos_1.setBounds(280, 64, 224, 200);
			contentPane.add(btnProductos_1);
		}
		{
			btnSalir = new JButton("SALIR");
			btnSalir.addActionListener(this);
			btnSalir.setBounds(763, 496, 89, 23);
			contentPane.add(btnSalir);
		}
		{
			lblNewLabel_1_1 = new JLabel("Marca del Producto");
			lblNewLabel_1_1.setForeground(Color.BLACK);
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblNewLabel_1_1.setBounds(291, 28, 236, 31);
			contentPane.add(lblNewLabel_1_1);
		}
		{
			btnPresentación = new JButton("");
			btnPresentación.addActionListener(this);
			btnPresentación.setIcon(new ImageIcon(GUISProducto.class.getResource("/images/presentacion (1).png")));
			btnPresentación.setBounds(578, 64, 198, 200);
			contentPane.add(btnPresentación);
		}
		{
			lblNewLabel_1 = new JLabel("Presentación del producto");
			lblNewLabel_1.setForeground(Color.BLACK);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblNewLabel_1.setBounds(568, 28, 273, 26);
			contentPane.add(lblNewLabel_1);
		}
		{
			btnUnidadMedida = new JButton("");
			btnUnidadMedida.addActionListener(this);
			btnUnidadMedida.setIcon(new ImageIcon(GUISProducto.class.getResource("/images/unidad medida (1).jpg")));
			btnUnidadMedida.setBounds(152, 311, 198, 200);
			contentPane.add(btnUnidadMedida);
		}
		{
			lblNewLabel_1_2 = new JLabel("Unidad de medida");
			lblNewLabel_1_2.setForeground(Color.BLACK);
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblNewLabel_1_2.setBounds(152, 281, 236, 31);
			contentPane.add(lblNewLabel_1_2);
		}
		{
			btnProductoGeneral = new JButton("");
			btnProductoGeneral.addActionListener(this);
			btnProductoGeneral.setIcon(new ImageIcon(GUISProducto.class.getResource("/images/ProductoGeneral (1).jpeg")));
			btnProductoGeneral.setBounds(435, 311, 198, 200);
			contentPane.add(btnProductoGeneral);
		}
		{
			lblNewLabel_1_3 = new JLabel("Producto general");
			lblNewLabel_1_3.setForeground(Color.BLACK);
			lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblNewLabel_1_3.setBounds(435, 281, 236, 31);
			contentPane.add(lblNewLabel_1_3);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProductoGeneral) {
			do_btnProductoGeneral_actionPerformed(e);
		}
		if (e.getSource() == btnUnidadMedida) {
			do_btnUnidadMedida_actionPerformed(e);
		}
		if (e.getSource() == btnPresentación) {
			do_btnPresentación_actionPerformed(e);
		}
		if (e.getSource() == btnProductos) {
			do_btnProductos_actionPerformed(e);
		}
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnProductos_1) {
			do_btnProductos_1_actionPerformed(e);
		}
	}
	protected void do_btnProductos_1_actionPerformed(ActionEvent e) {
		GuiMarca marca=new GuiMarca();
		marca.setVisible(true);
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_btnProductos_actionPerformed(ActionEvent e) {
		GuiProducto producto=new GuiProducto();
		producto.setVisible(true);
	}
	protected void do_btnPresentación_actionPerformed(ActionEvent e) {
		GuiPresentacion present=new GuiPresentacion();
		present.setVisible(true);
	}
	protected void do_btnUnidadMedida_actionPerformed(ActionEvent e) {
		GuiUniMedi unidMedi=new GuiUniMedi();
		unidMedi.setVisible(true);
	}
	protected void do_btnProductoGeneral_actionPerformed(ActionEvent e) {
		GuiProductoGeneral prodGeneral=new GuiProductoGeneral();
		prodGeneral.setVisible(true);
	}
}
