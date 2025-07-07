package guissecundarias;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clasepadre.Producto;
import claseshijo.Cliente;
import claseshijo.Proveedor;
import mysql.ProveedorDAO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GuiProveedor extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnSalir;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtRuc;
	private JLabel lblNewLabel_2;
	private JTextField txtNomEmpre;
	private JTextField txtNomConta;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtApelliConta;
	private JLabel lblNewLabel_5;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtVia;
	private JLabel lblNewLabel_9;
	private JTextField txtNomVia;
	private JLabel lblNewLabel_10;
	private JTextField txtNumVia;
	private JLabel lblNewLabel_11;
	private JTextField txtReferencia;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable table;
	private ProveedorDAO pDAO = new ProveedorDAO();
	private ArrayList<Proveedor> proveedores = pDAO.readProveedores();
	private String[] columnas = { "RUC", "NOMBRE EMPRESA", "CONTACTO", "TELEFONO", "EMAIL", "DIRECCION", "CREATED_AT",
			"UPDATED_AT" };
	private final JLabel lblNewLabel_11_1 = new JLabel("(opcional)");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiProveedor dialog = new GuiProveedor();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiProveedor() {
		setModal(true);
		setBounds(100, 100, 931, 691);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		contentPanel.setLayout(null);
		{
			btnSalir = new JButton("SALIR");
			btnSalir.setBackground(Color.RED);
			btnSalir.setForeground(Color.WHITE);
			btnSalir.addActionListener(this);
			btnSalir.setBounds(816, 614, 89, 23);
			contentPanel.add(btnSalir);
		}
		{
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(GuiProveedor.class.getResource("/images/proveedor .jpg")));
			lblNewLabel.setBounds(238, 421, 239, 150);
			contentPanel.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("RUC");
			lblNewLabel_1.setBounds(10, 11, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtRuc = new JTextField();
			txtRuc.setBounds(10, 36, 86, 20);
			contentPanel.add(txtRuc);
			txtRuc.setColumns(10);
		}
		{
			lblNewLabel_2 = new JLabel("Nombre empresa");
			lblNewLabel_2.setBounds(10, 70, 110, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtNomEmpre = new JTextField();
			txtNomEmpre.setColumns(10);
			txtNomEmpre.setBounds(10, 95, 86, 20);
			contentPanel.add(txtNomEmpre);
		}
		{
			txtNomConta = new JTextField();
			txtNomConta.setColumns(10);
			txtNomConta.setBounds(10, 157, 86, 20);
			contentPanel.add(txtNomConta);
		}
		{
			lblNewLabel_3 = new JLabel("Nombre contacto");
			lblNewLabel_3.setBounds(10, 132, 110, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Apellido Contacto");
			lblNewLabel_4.setBounds(10, 194, 110, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			txtApelliConta = new JTextField();
			txtApelliConta.setColumns(10);
			txtApelliConta.setBounds(10, 223, 86, 20);
			contentPanel.add(txtApelliConta);
		}
		{
			lblNewLabel_5 = new JLabel("Telefono");
			lblNewLabel_5.setBounds(10, 257, 110, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(10, 288, 86, 20);
			contentPanel.add(txtTelefono);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(10, 347, 86, 20);
			contentPanel.add(txtEmail);
		}
		{
			lblNewLabel_6 = new JLabel("Email");
			lblNewLabel_6.setBounds(10, 322, 110, 14);
			contentPanel.add(lblNewLabel_6);
		}
		{
			lblNewLabel_7 = new JLabel("Dirección");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_7.setBounds(10, 378, 110, 14);
			contentPanel.add(lblNewLabel_7);
		}
		{
			lblNewLabel_8 = new JLabel("Via");
			lblNewLabel_8.setBounds(10, 397, 110, 14);
			contentPanel.add(lblNewLabel_8);
		}
		{
			txtVia = new JTextField();
			txtVia.setColumns(10);
			txtVia.setBounds(10, 421, 86, 20);
			contentPanel.add(txtVia);
		}
		{
			lblNewLabel_9 = new JLabel("Nombre de la vía");
			lblNewLabel_9.setBounds(10, 455, 110, 14);
			contentPanel.add(lblNewLabel_9);
		}
		{
			txtNomVia = new JTextField();
			txtNomVia.setColumns(10);
			txtNomVia.setBounds(10, 477, 86, 20);
			contentPanel.add(txtNomVia);
		}
		{
			lblNewLabel_10 = new JLabel("Número de la vía");
			lblNewLabel_10.setBounds(10, 508, 110, 14);
			contentPanel.add(lblNewLabel_10);
		}
		{
			txtNumVia = new JTextField();
			txtNumVia.setColumns(10);
			txtNumVia.setBounds(10, 533, 86, 20);
			contentPanel.add(txtNumVia);
		}
		{
			lblNewLabel_11 = new JLabel("Referencia");
			lblNewLabel_11.setBounds(10, 561, 110, 14);
			contentPanel.add(lblNewLabel_11);
		}
		{
			txtReferencia = new JTextField();
			txtReferencia.setColumns(10);
			txtReferencia.setBounds(10, 583, 86, 20);
			contentPanel.add(txtReferencia);
		}
		{
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(this);
			btnRegistrar.setBounds(10, 614, 89, 23);
			contentPanel.add(btnRegistrar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.setBounds(109, 614, 89, 23);
			contentPanel.add(btnModificar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(212, 614, 89, 23);
			contentPanel.add(btnEliminar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(150, 38, 740, 354);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setEnabled(false);
				scrollPane.setViewportView(table);
				{
					lblNewLabel_11_1.setBounds(109, 561, 66, 14);
					contentPanel.add(lblNewLabel_11_1);
				}
				showTable();
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
	}
	
	private void limpiarCampos() {
		txtRuc.setText("");
		txtNomEmpre.setText("");
		txtNomConta.setText("");
		txtApelliConta.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
		txtVia.setText("");
		txtNomVia.setText("");
		txtNumVia.setText("");
		txtReferencia.setText("");
	}

	private void showTable() {
		Object[][] datos = new Object[proveedores.size()][8];

		for (int i = 0; i < proveedores.size(); i++) {
			Proveedor p = proveedores.get(i);
			datos[i][0] = p.getRuc();
			datos[i][1] = p.getNombreEmpresa();
			datos[i][2] = p.getNombreContacto() + " " + p.getApellidoContacto();
			datos[i][3] = p.getTelefono();
			datos[i][4] = p.getEmail();
			datos[i][5] = p.getVia() + " " + p.getNombreVia() + " " + p.getNumeroVia() + ". " + p.getReferencia();
			datos[i][6] = p.getCreatedAt();
			datos[i][7] = p.getUpdatedAt();
		}

		table.setModel(new DefaultTableModel(datos, columnas));
	}

	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
	}

	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		try {
			if (txtRuc.getText().isBlank() || txtNomEmpre.getText().isBlank() || txtNomConta.getText().isBlank()
					|| txtApelliConta.getText().isBlank() || txtTelefono.getText().isBlank()
					|| txtEmail.getText().isBlank() || txtVia.getText().isBlank() || txtNomVia.getText().isBlank()
					|| txtNumVia.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Los campos requeridos no pueden estar vacíos.");
				return;
			}
			if (txtRuc.getText().length()!=11) {
				JOptionPane.showMessageDialog(this, "El RUC solo debe ser de 11 dígitos.");
				return;
			}
			if (pDAO.readProveedorByRuc(txtRuc.getText()) != null) {
				JOptionPane.showMessageDialog(this, "Este RUC ya se encuentra registrado.");
				return;
			}

			Proveedor p = new Proveedor();
			p.setRuc(txtRuc.getText());
			p.setNombreEmpresa(txtNomEmpre.getText());
			p.setNombreContacto(txtNomConta.getText());
			p.setApellidoContacto(txtApelliConta.getText());
			p.setTelefono(txtTelefono.getText());
			p.setEmail(txtEmail.getText());
			p.setVia(txtVia.getText());
			p.setNombreVia(txtNomVia.getText());
			p.setNumeroVia(txtNumVia.getText());
			p.setReferencia(txtReferencia.getText());

			Boolean isCreated = false;

			if (pDAO.exitsOnBd(txtRuc.getText())) {
				isCreated = pDAO.updateProveedor(p);
			} else {
				isCreated = pDAO.createProveedor(p);
			}
			
			if (isCreated) {
				JOptionPane.showMessageDialog(this, "El proveedor fue registrado con éxito.");
				limpiarCampos();
				proveedores = pDAO.readProveedores();
				showTable();
			} else
				JOptionPane.showMessageDialog(this, "Error al registrar el proveedor.");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados.");
		}
	}

	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		try {
			if (txtRuc.getText().isBlank() || txtNomEmpre.getText().isBlank() || txtNomConta.getText().isBlank()
					|| txtApelliConta.getText().isBlank() || txtTelefono.getText().isBlank()
					|| txtEmail.getText().isBlank() || txtVia.getText().isBlank() || txtNomVia.getText().isBlank()
					|| txtNumVia.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Los campos requeridos no pueden estar vacíos.");
				return;
			}
			if (txtRuc.getText().length()!=11) {
				JOptionPane.showMessageDialog(this, "El RUC solo debe ser de 11 dígitos.");
				return;
			}
			
			
			if(pDAO.readProveedorByRuc(txtRuc.getText()) == null) {
				JOptionPane.showMessageDialog(this, "Proveedor no encontrado.");
				return;
			}
			
			Proveedor p = new Proveedor();
			p.setRuc(txtRuc.getText());
			p.setNombreEmpresa(txtNomEmpre.getText());
			p.setNombreContacto(txtNomConta.getText());
			p.setApellidoContacto(txtApelliConta.getText());
			p.setTelefono(txtTelefono.getText());
			p.setEmail(txtEmail.getText());
			p.setVia(txtVia.getText());
			p.setNombreVia(txtNomVia.getText());
			p.setNumeroVia(txtNumVia.getText());
			p.setReferencia(txtReferencia.getText());
			
			Boolean isUpdated =pDAO.updateProveedor(p);
			if (isUpdated) {
				JOptionPane.showMessageDialog(this, "El proveedor fue modificado con éxito.");
				limpiarCampos();
				proveedores = pDAO.readProveedores();
				showTable();
			} else
				JOptionPane.showMessageDialog(this, "Error al modificar el proveedor.");
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados.");
		}
		
		
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		try {
			if(txtRuc.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo de RUC no puede estar vacío.");
				return;
			}
			if (txtRuc.getText().length()!=11) {
				JOptionPane.showMessageDialog(this, "El RUC solo debe ser de 11 dígitos.");
				return;
			}
			Proveedor proveDele = pDAO.readProveedorByRuc(txtRuc.getText());
			if(proveDele==null) {
				JOptionPane.showMessageDialog(this, "Proveedor no encontrado.");
				return;
			}
			
			Boolean isDeleted = pDAO.deleteProveedor(proveDele.getId());
			if (isDeleted) {
				JOptionPane.showMessageDialog(this, "El proveedor fue eliminado con éxito.");
				limpiarCampos();
				proveedores = pDAO.readProveedores();
				showTable();
			} else
				JOptionPane.showMessageDialog(this, "Error al eliminar el proveedor.");
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados.");
		}
	}
}
