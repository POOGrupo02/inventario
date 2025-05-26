package GuisSecundarias;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClasePadre.Producto;
import ClasesHijo.ProductSingleton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GuiProducto extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtNom;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JButton btnAgregar;
	private ProductSingleton pS = ProductSingleton.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiProducto dialog = new GuiProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiProducto() {
		setModal(true);
		setTitle("Producto");
		setBounds(100, 100, 656, 434);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnModificar = new JButton("Modificar por código");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(139, 267, 153, 23);
		contentPanel.add(btnModificar);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(25, 17, 46, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(25, 56, 63, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Stock");
		lblNewLabel_2.setBounds(25, 182, 63, 14);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setBounds(25, 98, 46, 14);
		contentPanel.add(lblNewLabel_3);

		txtID = new JTextField();
		txtID.setBounds(116, 11, 86, 20);
		contentPanel.add(txtID);
		txtID.setColumns(10);

		txtNom = new JTextField();
		txtNom.setBounds(116, 53, 153, 20);
		contentPanel.add(txtNom);
		txtNom.setColumns(10);

		txtStock = new JTextField();
		txtStock.setBounds(116, 179, 86, 20);
		contentPanel.add(txtStock);
		txtStock.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(116, 95, 86, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		btnEliminar = new JButton("Eliminar por código");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(311, 267, 146, 23);
		contentPanel.add(btnEliminar);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(25, 267, 89, 23);
		contentPanel.add(btnAgregar);
		{
			lblNewLabel_2_2 = new JLabel("Categoría:");
			lblNewLabel_2_2.setBounds(25, 222, 89, 14);
			contentPanel.add(lblNewLabel_2_2);
		}
		{
			cboCategoría = new JComboBox();
			cboCategoría.setModel(new DefaultComboBoxModel(new String[] { "Alimenticio", "Electrónico", "Limpieza" }));
			cboCategoría.setBounds(116, 218, 96, 22);
			contentPanel.add(cboCategoría);
		}

		lblNewLabel_4 = new JLabel("Stock mínimo");
		lblNewLabel_4.setBounds(25, 138, 81, 14);
		contentPanel.add(lblNewLabel_4);
		{
			txtStockMin.setColumns(10);
			txtStockMin.setBounds(116, 135, 86, 20);
			contentPanel.add(txtStockMin);
		}
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(311, 13, 146, 23);
		contentPanel.add(btnLimpiar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
	}

	private JLabel lblNewLabel_2_2;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JComboBox cboCategoría;
	private JLabel lblNewLabel_4;
	private final JTextField txtStockMin = new JTextField();
	private JButton btnLimpiar;

	private String LeerID() {
		return txtID.getText();
	}

	private String LeerNombre() {
		return txtNom.getText();
	}

	private int LeerStock() {
		return Integer.parseInt(txtStock.getText());
	}

	private int LeerStockMin() {
		return Integer.parseInt(txtStockMin.getText());
	}

	private String LeerCategoria() {
		return cboCategoría.getSelectedItem().toString();
	}

	private double LeerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}

	private String Cabezal() {
		return "ID" + "\tNombre" + "\tPrecio" + "\tCategoría" + "\tStock";
	}
	
	private void limpiarCampos() {
		txtID.setText("");
		txtNom.setText("");
		txtPrecio.setText("");
		txtStock.setText("");
		txtStockMin.setText("");
	}

	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		try {
			if (txtID.getText().isBlank() || txtNom.getText().isBlank() || txtPrecio.getText().isBlank()
					|| txtStock.getText().isBlank() || txtStockMin.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos.");
				return;
			}
			if (LeerPrecio() <= 0 || LeerStock() < 0 || LeerStockMin() < 0) {
				JOptionPane.showMessageDialog(this, "Los campos como precio, stock y stock mínimo no pueden ser negativos.");
				return;
			}

			Producto p = new Producto(LeerID(), LeerNombre(), LeerPrecio(), LeerCategoria(), LeerStock(),
					LeerStockMin());

			if (pS.buscarPorId(LeerID()) != null) {
				JOptionPane.showMessageDialog(this, "El código del producto ya existe");
				return;
			}
			pS.addProducto(p);
			JOptionPane.showMessageDialog(this, "El producto fue registrado con éxito.");
			limpiarCampos();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Error al registrar el producto, verifique los datos ingresados");
			// TODO: handle exception
		}
	}

	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		try {
			if (txtID.getText().isBlank() || txtNom.getText().isBlank() || txtPrecio.getText().isBlank()
					|| txtStock.getText().isBlank() || txtStockMin.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos.");
				return;
			}
			if (LeerPrecio() <= 0 || LeerStock() < 0 || LeerStockMin() < 0) {
				JOptionPane.showMessageDialog(this, "Los campos como precio, stock y stock mínimo no pueden ser negativos.");
				return;
			}
			Producto p = pS.buscarPorId(LeerID());
			if (p != null) {
				p.setNombre(LeerNombre());
				p.setPrecio(LeerPrecio());
				p.setCategoría(LeerCategoria());
				p.setStock(LeerStock());
				JOptionPane.showMessageDialog(this, "El producto fue modificado con éxito.");
				limpiarCampos();
			} else {
				JOptionPane.showMessageDialog(this, "El producto no existe");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Error al modificar el producto, verifique los datos ingresados");
			// TODO: handle exception
		}

	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		try {
			if (txtID.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo no puede estar vacío.");
				return;
			}
			Producto p = pS.buscarPorId(LeerID());
			if (p != null) {
				pS.eliminar(p);
				JOptionPane.showMessageDialog(this, "El producto fue eliminado con éxito.");
			} else {
				JOptionPane.showMessageDialog(this, "El producto no existe");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Error al eliminar el producto, verifique los datos ingresados.");
		}
	}

	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
		limpiarCampos();
	}
}
