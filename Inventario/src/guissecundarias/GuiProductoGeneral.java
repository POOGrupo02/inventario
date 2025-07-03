package guissecundarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import claseshijo.FormaPago;
import claseshijo.ProductoGeneral;
import mysql.FormaPagoDAO;
import mysql.ProductoGeneralDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiProductoGeneral extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblProductoGeneral = new JLabel("Producto general");
	private final JTextField txtProdGen = new JTextField();
	private final JButton btnRegistrar = new JButton("Registrar");
	private final JLabel lblId = new JLabel("ID");
	private final JTextField txtId = new JTextField();
	private final JButton btnModificar = new JButton("Modificar");
	private final JTextField txtNewProdGen = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private ProductoGeneralDAO pGeDAO = new ProductoGeneralDAO();
	private ArrayList<ProductoGeneral> prodGenerales = pGeDAO.readProductosGenerales();
	private String[] columnas = { "ID", "NOMBRE", "CREATED_AT", "UPDATED_AT" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiProductoGeneral frame = new GuiProductoGeneral();
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
	public GuiProductoGeneral() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblProductoGeneral.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblProductoGeneral.setBounds(13, 53, 154, 24);
			contentPane.add(lblProductoGeneral);
			
			showTable();
		}
		{
			txtProdGen.setColumns(10);
			txtProdGen.setBounds(13, 88, 86, 20);
			contentPane.add(txtProdGen);
		}
		{
			btnRegistrar.addActionListener(this);
			btnRegistrar.setBounds(13, 119, 89, 23);
			contentPane.add(btnRegistrar);
		}
		{
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblId.setBounds(13, 153, 112, 24);
			contentPane.add(lblId);
		}
		{
			txtId.setColumns(10);
			txtId.setBounds(13, 185, 86, 20);
			contentPane.add(txtId);
		}
		{
			btnModificar.addActionListener(this);
			btnModificar.setBounds(10, 216, 89, 23);
			contentPane.add(btnModificar);
		}
		{
			txtNewProdGen.setColumns(10);
			txtNewProdGen.setBounds(112, 185, 86, 20);
			contentPane.add(txtNewProdGen);
		}
		{
			scrollPane.setBounds(252, 74, 608, 293);
			contentPane.add(scrollPane);
		}
		{
			scrollPane.setViewportView(table);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
	}
	
	private void showTable() {
		Object[][] datos = new Object[prodGenerales.size()][4];

		for (int i = 0; i < prodGenerales.size(); i++) {
			ProductoGeneral p = prodGenerales.get(i);
			datos[i][0] = p.getId();
			datos[i][1] = p.getName();
			datos[i][2] = p.getCreatedAt();
			datos[i][3] = p.getUpdatedAt();
		}

		table.setModel(new DefaultTableModel(datos, columnas));
	}
	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		try {

			if (txtProdGen.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo no puede estar vacío.");
				return;
			}

			ProductoGeneral pGe = new ProductoGeneral();
			pGe.setName(txtProdGen.getText().trim());

			Boolean isCreated = pGeDAO.createProductoGeneral(pGe);

			if (isCreated) {
				JOptionPane.showMessageDialog(this, "El producto general fue registrado con éxito.");
				txtProdGen.setText("");
				prodGenerales = pGeDAO.readProductosGenerales();
				showTable();
			} else
				JOptionPane.showMessageDialog(this, "Error al registrar el producto general.");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados.");
			// TODO: handle exception
		}
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		try {
			int id = Integer.parseInt(txtId.getText());
			if (txtNewProdGen.getText().isBlank() || txtId.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos.");
				return;
			}
			
			Boolean exits = false;
			for (int i = 0; i < prodGenerales.size(); i++) {
				if(prodGenerales.get(i).getId() == id){
					exits = true;
				}
			}
			
			if(!exits) {
				JOptionPane.showMessageDialog(this, "No existe un producto general con ese ID.");
				return;
			}

			ProductoGeneral pGe = new ProductoGeneral();
			pGe.setName(txtNewProdGen.getText().trim());
			pGe.setId(id);

			if (pGeDAO.updateProductoGeneral(pGe)) {
				JOptionPane.showMessageDialog(this, "Producto general actualizado.");
				txtNewProdGen.setText("");
				txtId.setText("");
				prodGenerales = pGeDAO.readProductosGenerales();
				showTable();
			}else {
				JOptionPane.showMessageDialog(this, "Hubo un problema al actualizar el producto general.");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados.");
		}
	}
}
