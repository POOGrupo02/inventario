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
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

public class GuiProducto extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCod;
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
		txtCantidadXUnidad.setBounds(135, 274, 86, 20);
		txtCantidadXUnidad.setColumns(10);
		setModal(true);
		setTitle("Producto");
		setBounds(100, 100, 824, 614);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(25, 17, 46, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(25, 58, 63, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Stock");
		lblNewLabel_2.setBounds(24, 312, 63, 14);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setBounds(25, 83, 46, 14);
		contentPanel.add(lblNewLabel_3);

		txtCod = new JTextField();
		txtCod.setBounds(136, 14, 86, 20);
		contentPanel.add(txtCod);
		txtCod.setColumns(10);

		txtNom = new JTextField();
		txtNom.setBounds(136, 49, 153, 20);
		contentPanel.add(txtNom);
		txtNom.setColumns(10);

		txtStock = new JTextField();
		txtStock.setBounds(135, 309, 86, 20);
		contentPanel.add(txtStock);
		txtStock.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(136, 80, 86, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(25, 478, 89, 23);
		contentPanel.add(btnAgregar);
		{
			lblNewLabel_2_2 = new JLabel("Categoría:");
			lblNewLabel_2_2.setBounds(24, 245, 89, 14);
			contentPanel.add(lblNewLabel_2_2);
		}
		{
			cboCategoría = new JComboBox();
			cboCategoría.setModel(new DefaultComboBoxModel(new String[] {"Alimenticio", "Limpieza"}));
			cboCategoría.setBounds(135, 241, 96, 22);
			contentPanel.add(cboCategoría);
		}

		lblNewLabel_4 = new JLabel("Stock mínimo");
		lblNewLabel_4.setBounds(24, 352, 81, 14);
		contentPanel.add(lblNewLabel_4);
		{
			txtStockMin.setColumns(10);
			txtStockMin.setBounds(135, 349, 86, 20);
			contentPanel.add(txtStockMin);
		}
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(341, 13, 146, 23);
		contentPanel.add(btnLimpiar);
		{
			lblNewLabel_1_1.setBounds(24, 177, 102, 14);
			contentPanel.add(lblNewLabel_1_1);
		}
		{
			cboUnidadVenta.setModel(new DefaultComboBoxModel(new String[] {"Lata", "Paquete", "Botella"}));
			cboUnidadVenta.setBounds(135, 173, 117, 22);
			contentPanel.add(cboUnidadVenta);
		}
		{
			lblNewLabel_1_1_1.setBounds(24, 277, 102, 14);
			contentPanel.add(lblNewLabel_1_1_1);
		}
		{
			contentPanel.add(txtCantidadXUnidad);
		}
		{
			lblNewLabel_1_1_1_1.setBounds(24, 210, 102, 14);
			contentPanel.add(lblNewLabel_1_1_1_1);
		}
		
		cboUnidadMedida = new JComboBox();
		cboUnidadMedida.setModel(new DefaultComboBoxModel(new String[] {"Miligramo", "Gramo", "Kilogramo"}));
		cboUnidadMedida.setBounds(135, 206, 117, 22);
		contentPanel.add(cboUnidadMedida);
		{
			txtFechaFabricacion.setBounds(135, 380, 96, 20);
			contentPanel.add(txtFechaFabricacion);
		}
		{
			txtFechaVencimiento.setBounds(135, 411, 96, 20);
			contentPanel.add(txtFechaVencimiento);
		}
		
		lblNewLabel_5 = new JLabel("Fecha de fabricación");
		lblNewLabel_5.setBounds(24, 383, 102, 14);
		contentPanel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Fecha de vencimiento");
		lblNewLabel_6.setBounds(24, 414, 109, 14);
		contentPanel.add(lblNewLabel_6);
		
		lblNewLabel_1_2 = new JLabel("Marca:");
		lblNewLabel_1_2.setBounds(25, 112, 102, 14);
		contentPanel.add(lblNewLabel_1_2);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(136, 111, 86, 20);
		contentPanel.add(txtMarca);
		
		lblNewLabel_1_3 = new JLabel("Proveedor");
		lblNewLabel_1_3.setBounds(25, 137, 102, 14);
		contentPanel.add(lblNewLabel_1_3);
		
		cboProveedor = new JComboBox();
		cboProveedor.setModel(new DefaultComboBoxModel(new String[] {"A"}));
		cboProveedor.setBounds(135, 140, 117, 22);
		contentPanel.add(cboProveedor);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
	}

	private JLabel lblNewLabel_2_2;
	private JComboBox cboCategoría;
	private JLabel lblNewLabel_4;
	private final JTextField txtStockMin = new JTextField();
	private JButton btnLimpiar;
	private final JLabel lblNewLabel_1_1 = new JLabel("Unidad de venta:");
	private final JComboBox cboUnidadVenta = new JComboBox();
	private final JLabel lblNewLabel_1_1_1 = new JLabel("Cantidad por unidad:");
	private final JTextField txtCantidadXUnidad = new JTextField();
	private final JLabel lblNewLabel_1_1_1_1 = new JLabel("Unidad de medida:");
	private JComboBox cboUnidadMedida;
	private final JFormattedTextField txtFechaFabricacion = new JFormattedTextField();
	private final JFormattedTextField txtFechaVencimiento = new JFormattedTextField();
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_1_2;
	private JTextField txtMarca;
	private JLabel lblNewLabel_1_3;
	private JComboBox cboProveedor;
	Date fechaActual = new Date();

	private String leerCodigo() {
		return txtCod.getText();
	}

	private String leerNombre() {
		return txtNom.getText();
	}
	
	private String leerMarca() {
		return txtMarca.getText();
	}
	
	private String leerUnidadVenta() {
		return cboUnidadVenta.getSelectedItem().toString();
	}
	
	private String leerUnidadMedida() {
		return cboUnidadMedida.getSelectedItem().toString();
	}
	
	private String leerProveedor() {
		return cboProveedor.getSelectedItem().toString();
	}
	
	private Double leerCantidadXUnidad() {
		
		return Double.parseDouble(txtCantidadXUnidad.getText());
	}
	
	private Date leerFechaFabricacion() {
		return fechaActual;
	}
	
	private Date leerFechaVencimiento() {
		return fechaActual;
	}

	private int leerStock() {
		return Integer.parseInt(txtStock.getText());
	}

	private int leerStockMin() {
		return Integer.parseInt(txtStockMin.getText());
	}

	private String leerCategoria() {
		return cboCategoría.getSelectedItem().toString();
	}

	private double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
	
	

	private String Cabezal() {
		return "ID" + "\tNombre" + "\tPrecio" + "\tCategoría" + "\tStock";
	}
	
	private void limpiarCampos() {
		txtCod.setText("");
		txtNom.setText("");
		txtPrecio.setText("");
		txtStock.setText("");
		txtStockMin.setText("");
	}

	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		try {
			if (txtCod.getText().isBlank() || txtNom.getText().isBlank() || txtPrecio.getText().isBlank()
					|| txtStock.getText().isBlank() || txtStockMin.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos.");
				return;
			}
			if (leerPrecio() <= 0 || leerStock() < 0 || leerStockMin() < 0) {
				JOptionPane.showMessageDialog(this, "Los campos como precio, stock y stock mínimo no pueden ser negativos.");
				return;
			}

			Producto p = new Producto(
					leerCodigo(), 
					leerNombre(), 
					leerCategoria(), 
					leerMarca(), 
					leerProveedor(), 
					leerUnidadVenta(), 
					leerUnidadMedida(),
					leerPrecio(),
					leerCantidadXUnidad(),
					leerStock(),
					leerStockMin(),
					leerFechaFabricacion(),
					leerFechaVencimiento());

			if (pS.buscarPorId(leerCodigo()) != null) {
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

	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
		limpiarCampos();
	}
}
